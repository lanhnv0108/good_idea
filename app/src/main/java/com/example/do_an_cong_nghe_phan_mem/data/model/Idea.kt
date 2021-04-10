package com.example.do_an_cong_nghe_phan_mem.data.model

import android.text.Editable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "idea_table")
data class Idea(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "description")
    val description: String,
    @ColumnInfo(name = "address")
    val address: String,
    @ColumnInfo(name = "amount")
    val amount: Int,
    @ColumnInfo(name = "timeStart")
    val timeStart: String,
    @ColumnInfo(name = "timmeEnd")
    val timeEnd: String,
    @ColumnInfo(name = "status")
    val status: Int = 0,
    @ColumnInfo(name = "approve")
    val statusApprove: Boolean = false,
    @ColumnInfo(name = "idCreator")
    val idCreator: String = "MC01",
)
