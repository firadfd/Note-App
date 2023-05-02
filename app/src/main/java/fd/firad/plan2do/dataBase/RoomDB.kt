package fd.firad.plan2do.dataBase

import androidx.room.Database
import androidx.room.RoomDatabase
import fd.firad.plan2do.models.Notes

@Database(entities = [Notes::class], version = 1, exportSchema = false)
abstract class RoomDB : RoomDatabase() {
    abstract fun myNotesDAO(): MyDAO
}