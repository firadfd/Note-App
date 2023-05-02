package fd.firad.plan2do.ui.fragments

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import dagger.hilt.android.AndroidEntryPoint
import fd.firad.plan2do.R
import fd.firad.plan2do.databinding.FragmentCreateNoteBinding
import fd.firad.plan2do.models.Notes
import fd.firad.plan2do.viewmodel.NotesViewModel
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*


@AndroidEntryPoint
class CreateNoteFragment : Fragment() {
    private lateinit var binding: FragmentCreateNoteBinding
    private var priority: String = "1"
    private val viewModel: NotesViewModel by viewModels()

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCreateNoteBinding.inflate(inflater, container, false)


        binding.btnDone.setOnClickListener {
            createNote(it)
        }

        binding.pGreen.setOnClickListener {
            priority = "1"
            binding.pGreen.setImageResource(R.drawable.done)
            binding.pYellow.setImageResource(0)
            binding.pRed.setImageResource(0)

        }
        binding.pYellow.setOnClickListener {
            priority = "2"
            binding.pYellow.setImageResource(R.drawable.done)
            binding.pGreen.setImageResource(0)
            binding.pRed.setImageResource(0)

        }
        binding.pRed.setOnClickListener {
            priority = "3"
            binding.pRed.setImageResource(R.drawable.done)
            binding.pYellow.setImageResource(0)
            binding.pGreen.setImageResource(0)

        }




        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun createNote(it: View) {
        val title: String = binding.edtTitle.text.toString()
        val notes: String = binding.edtNotes.text.toString()
        val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
        val date = LocalDateTime.now().format(formatter)
        viewModel.addNotes(Notes(null, title, notes, date.toString(), priority))
        Toast.makeText(requireContext(), "Note Create Successful", Toast.LENGTH_SHORT).show()
        Navigation.findNavController(it).navigate(R.id.action_createNoteFragment_to_homeFragment)


    }
}