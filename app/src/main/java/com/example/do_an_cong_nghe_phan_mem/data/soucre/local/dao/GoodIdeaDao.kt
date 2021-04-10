package com.example.do_an_cong_nghe_phan_mem.data.soucre.local.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.do_an_cong_nghe_phan_mem.data.model.Idea

@Dao
interface GoodIdeaDao {

    @Insert
    suspend fun createIdea(idea: Idea)

    @Query("SELECT * FROM idea_table WHERE approve = 0")
    fun getAllIdeaByApprove(): LiveData<List<Idea>>

    @Query("SELECT * FROM idea_table WHERE id = :id")
    fun getAllIdeaById(id: Int): LiveData<Idea>

    @Query("SELECT * FROM idea_table")
    fun getAllIdea(): LiveData<List<Idea>>

    @Query("SELECT * FROM idea_table WHERE approve = :st")
    fun getAllByStatus(st: Int): LiveData<List<Idea>>

    @Delete
    fun cancelIdea(idea: Idea)

    @Update
    fun approveIdea(idea: Idea)

    @Query("DELETE FROM idea_table")
    fun deleteAll()
}