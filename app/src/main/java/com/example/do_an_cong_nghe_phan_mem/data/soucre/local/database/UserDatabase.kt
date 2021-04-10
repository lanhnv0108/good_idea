package com.example.do_an_cong_nghe_phan_mem.data.soucre.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.do_an_cong_nghe_phan_mem.data.model.Idea
import com.example.do_an_cong_nghe_phan_mem.data.soucre.local.dao.GoodIdeaDao

@Database(entities = [Idea::class], version = 1, exportSchema = false)
abstract class UserDatabase : RoomDatabase() {

    abstract fun goodIdeaDao(): GoodIdeaDao

    companion object {
        private var INSTANCE: UserDatabase? = null

        fun getDatabase(context: Context): UserDatabase {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context,
                    UserDatabase::class.java,
                    "db_goodIdea"
                ).build()
            }
        }
    }
}
