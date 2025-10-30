package com.example.mvvm_demo.model
//This UserRepository is getting the data from the API or Database in real time application
class UserRepository {
    suspend fun fetchUserData(): UserData {
        //This is Mock Api , we can replace with the Api to get the data.
        // Simulate fetching user data
        delay(2000) // Simulate a delay
        return UserData("John Doe", 30)
    }
}