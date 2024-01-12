package com.udemy.triviaapp.repository

import android.util.Log
import com.udemy.triviaapp.data.DataOrException
import com.udemy.triviaapp.model.QuestionItem
import com.udemy.triviaapp.network.QuestionApi
import javax.inject.Inject

public class QuestionRepository @Inject constructor(
    private val api:QuestionApi) {

    private val dataOrException =
        DataOrException<ArrayList<QuestionItem>,Boolean,Exception>()

    suspend fun getAllQuestions(): DataOrException<ArrayList<QuestionItem>, Boolean, Exception>{
        try {
            dataOrException.loading = true
            dataOrException.data = api.getAllQuestions()
            if(dataOrException.data.toString().isNotEmpty()) dataOrException.loading = false
        } catch (exception: Exception) {
            dataOrException.e = exception
            Log.d("Exc","getAllQuestions: ${dataOrException.e!!.localizedMessage}")
        }
        return dataOrException
    }

}