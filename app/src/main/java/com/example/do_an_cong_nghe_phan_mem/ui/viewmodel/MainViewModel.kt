package com.example.do_an_cong_nghe_phan_mem.ui.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.example.do_an_cong_nghe_phan_mem.data.model.Idea
import com.example.do_an_cong_nghe_phan_mem.data.soucre.local.database.UserDatabase
import com.example.do_an_cong_nghe_phan_mem.data.soucre.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {

    var getAllIdea: LiveData<List<Idea>>? = null
    private var repository: Repository

    init {
        val userDatabase = UserDatabase.getDatabase(application).goodIdeaDao()
        repository = Repository(userDatabase)
    }

    fun getAllIdea(approve: Int) {
        getAllIdea = repository.getAllIdeaByApprove(approve)
    }

    fun createIdea(idea: Idea) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.createIdea(idea)
        }
    }

    fun deleteAll() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAll()
        }
    }

    fun getIdeaByApprove(approve: Int) {
        repository.getAllIdeaByApprove(approve)
    }
}
