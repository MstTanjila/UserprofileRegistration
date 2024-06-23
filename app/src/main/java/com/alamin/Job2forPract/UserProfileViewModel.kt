package com.alamin.Job2forPract

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserProfileViewModel(application: Application):AndroidViewModel(application) {
    private val repository:UserProfileRepository
    init {
        val userProfileDao=UserDatabase.getDatabase(application).userProfileDao()
        repository= UserProfileRepository(userProfileDao)
    }
    fun getUserProfiles():LiveData<List<UserProfile>>{
        return repository.getUserProfiles()
    }
    fun insertuserProfile(userProfile: UserProfile){
        viewModelScope.launch ( Dispatchers.IO ){
            repository.insert((userProfile))
        }
    }
    fun updatetuserProfile(userProfile: UserProfile){
        viewModelScope.launch ( Dispatchers.IO ){
            repository.update((userProfile))
        }
    }
    fun deleteuserProfile(userProfile: UserProfile){
        viewModelScope.launch ( Dispatchers.IO ){
            repository.delete((userProfile))
        }
    }
}