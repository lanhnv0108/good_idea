package com.example.do_an_cong_nghe_phan_mem.data.soucre.repository

import com.example.do_an_cong_nghe_phan_mem.data.model.Idea
import com.example.do_an_cong_nghe_phan_mem.data.soucre.local.dao.GoodIdeaDao

class Repository(private val goodIdeaDao: GoodIdeaDao) {

    fun getAllIdea() = goodIdeaDao.getAllIdea()

    fun getAllIdeaByApprove(approve: Int) = goodIdeaDao.getAllIdeaByApprove(approve)

    fun getIdeaById(id: Int) = goodIdeaDao.getAllIdeaById(id)

    suspend fun createIdea(idea: Idea) {
        goodIdeaDao.createIdea(idea)
    }

    suspend fun updateApprove(approve: Int) {
        goodIdeaDao.updateApprove(approve)
    }

    fun approveIdea(idea: Idea) {
        goodIdeaDao.approveIdea(idea)
    }

    fun cancelIdea(idea: Idea) {
        goodIdeaDao.cancelIdea(idea)
    }

    suspend fun deleteAll() {
        goodIdeaDao.deleteAll()
    }

}