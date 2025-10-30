package com.example.mvvm_demo.viewmodel

import android.R.attr.data
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvm_demo.model.UserData
import com.example.mvvm_demo.model.UserRepository
import kotlinx.coroutines.launch
//From this ViewModel we are calling the repository method and getting the data and setting it to LiveData
class HomeViewModel : ViewModel() {
    val userRepository : UserRepository = UserRepository()
    private val _userData = MutableLiveData<UserData>()
    val userData: LiveData<UserData> = _userData

    private val _isLoading = MutableLiveData<Boolean>(false)
    val isLoading: LiveData<Boolean> = _isLoading

    fun getUserData() {
        _isLoading.postValue(true)
        viewModelScope.launch {
            // Simulate fetching user data from repository
            val userResult = userRepository.fetchUserData()
            _userData.postValue(userResult)
            _isLoading.postValue(false)
        }

    }



}