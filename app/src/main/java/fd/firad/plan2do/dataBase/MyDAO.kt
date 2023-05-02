package fd.firad.plan2do.dataBase

import androidx.lifecycle.LiveData
import androidx.room.*
import fd.firad.plan2do.models.Notes

@Dao
interface MyDAO {


    @Query("SELECT * FROM notes WHERE pinned=3")
    fun getHighNote(): LiveData<List<Notes>>

    @Query("SELECT * FROM notes WHERE pinned=2")
    fun getMediumNote(): LiveData<List<Notes>>

    @Query("SELECT * FROM notes WHERE pinned=1")
    fun getLowNote(): LiveData<List<Notes>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(notes: Notes)

    @Query("SELECT * FROM notes ORDER BY id DESC")
    fun getNote(): LiveData<List<Notes>>

    @Query("DELETE FROM notes WHERE ID = :id")
    fun deleteNote(id: Int)

    @Update
    fun updateNote(notes: Notes)
}