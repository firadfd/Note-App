package fd.firad.plan2do.repository

import androidx.lifecycle.LiveData
import fd.firad.plan2do.dataBase.MyDAO
import fd.firad.plan2do.models.Notes
import javax.inject.Inject

class NotesRepository @Inject constructor (private val dao: MyDAO) {

    fun getAllNotes(): LiveData<List<Notes>> = dao.getNote()

    fun getHighNotes(): LiveData<List<Notes>> = dao.getHighNote()

    fun getMediumNotes(): LiveData<List<Notes>> = dao.getMediumNote()

    fun getLowNotes(): LiveData<List<Notes>> = dao.getLowNote()

    fun insertNotes(notes: Notes) {
        dao.insert(notes)
    }

    fun deleteNotes(id: Int) {
        dao.deleteNote(id)
    }

    fun updateNotes(notes: Notes) {
        dao.updateNote(notes)
    }
}