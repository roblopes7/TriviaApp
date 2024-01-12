package com.udemy.triviaapp.components

import android.util.Log
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import com.udemy.triviaapp.screens.QuestionsViewModel

@Composable
fun Questions(viewModel: QuestionsViewModel) {
    val questions = viewModel.data.value.data?.toMutableList()
    if(viewModel.data.value.loading == true){
        CircularProgressIndicator()
        Log.d("LOADING", "Questions loading...")
    } else {
        questions?.forEach{
                questionItem -> Log.d("QUESTION", "Questions: ${questionItem.question}")
        }
    }
}