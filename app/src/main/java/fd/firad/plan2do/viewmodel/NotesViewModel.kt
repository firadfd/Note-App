package fd.firad.plan2do.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import fd.firad.plan2do.dataBase.RoomDB
import fd.firad.plan2do.models.Notes
import fd.firad.plan2do.repository.NotesRepository
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(private val repository: NotesRepository) : ViewModel() {

    fun addNotes(notes: Notes) {
        repository.insertNotes(notes)
    }

    fun getHighNotes(): LiveData<List<Notes>> = repository.getHighNotes()

    fun getMediumNotes(): LiveData<List<Notes>> = repository.getMediumNotes()

    fun getLowNotes(): LiveData<List<Notes>> = repository.getLowNotes()

    fun deleteNotes(id: Int) {
        repository.deleteNotes(id)
    }

    fun updateNotes(notes: Notes) {
        repository.updateNotes(notes)
    }

    fun getNotes(): LiveData<List<Notes>> = repository.getAllNotes()

}