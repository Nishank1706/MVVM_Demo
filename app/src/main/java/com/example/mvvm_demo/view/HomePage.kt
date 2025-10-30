package com.example.mvvm_demo.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.mvvm_demo.viewmodel.HomeViewModel
import androidx.compose.runtime.livedata.observeAsState

// From this UI we are calling getUserData method of ViewModel and observing the LiveData to show the data on UI
@Composable
fun HomePage(modifier: Modifier = Modifier,viewModel: HomeViewModel) {
    val userData = viewModel.userData.observeAsState()
    val isLoading = viewModel.isLoading.observeAsState()
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick ={
            viewModel.getUserData()
        }) {
            Text(text = "Get Data")
        }
        if (isLoading.value == true) {
            CircularProgressIndicator()
        }else{
            //Initially there is no value in the userData LiveData so we are using below null check
            userData.value?.name?.let {
                Text(text = "Name: $it")
            }
            userData.value?.age?.let {
                Text(text = "Age: $it")
            }

        }

    }
}
