package com.example.do_an_cong_nghe_phan_mem.ui.admin.detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.do_an_cong_nghe_phan_mem.data.model.Idea
import com.example.do_an_cong_nghe_phan_mem.data.soucre.local.database.UserDatabase
import com.example.do_an_cong_nghe_phan_mem.data.soucre.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailAdminViewModel(application: Application) : AndroidViewModel(application) {

    var getIdea: LiveData<Idea>? = null
    private var repository: Repository

    init {
        val userDatabase = UserDatabase.getDatabase(application).goodIdeaDao()
        repository = Repository(userDatabase)
    }

    fun getAllIdea(id: Int?) {
        getIdea = id?.let { repository.getIdeaById(it) }
    }

    fun updateApprove(approve: Int?) {
        viewModelScope.launch(Dispatchers.IO) {
            approve?.let { repository.updateApprove(it) }
        }
    }
}