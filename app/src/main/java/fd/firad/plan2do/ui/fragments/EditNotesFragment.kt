package fd.firad.plan2do.ui.fragments

import android.os.Build
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint
import fd.firad.plan2do.R
import fd.firad.plan2do.databinding.FragmentEditNotesBinding
import fd.firad.plan2do.models.Notes
import fd.firad.plan2do.viewmodel.NotesViewModel
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@AndroidEntryPoint
class EditNotesFragment : Fragment() {

    val notes by navArgs<EditNotesFragmentArgs>()
    private lateinit var binding: FragmentEditNotesBinding
    private var priority: String = "1"
    private val viewModel: NotesViewModel by viewModels()

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEditNotesBinding.inflate(inflater, container, false)
        setHasOptionsMenu(true)


        binding.edtUTitle.setText(notes.data.title)
        binding.edtUNotes.setText(notes.data.notes)
        priority = notes.data.priority

        when (notes.data.priority) {
            "1" -> {
                binding.pUGreen.setImageResource(R.drawable.done)
                binding.pUGreen.setImageResource(0)
                binding.pURed.setImageResource(0)
            }

            "2" -> {
                binding.pUYellow.setImageResource(R.drawable.done)
                binding.pUGreen.setImageResource(0)
                binding.pURed.setImageResource(0)
            }

            "3" -> {
                binding.pURed.setImageResource(R.drawable.done)
                binding.pUYellow.setImageResource(0)
                binding.pUGreen.setImageResource(0)
            }

        }

        binding.pUGreen.setOnClickListener {
            priority = "1"
            binding.pUGreen.setImageResource(R.drawable.done)
            binding.pUYellow.setImageResource(0)
            binding.pURed.setImageResource(0)

        }
        binding.pUYellow.setOnClickListener {
            priority = "2"
            binding.pUYellow.setImageResource(R.drawable.done)
            binding.pUGreen.setImageResource(0)
            binding.pURed.setImageResource(0)

        }
        binding.pURed.setOnClickListener {
            priority = "3"
            binding.pURed.setImageResource(R.drawable.done)
            binding.pUYellow.setImageResource(0)
            binding.pUGreen.setImageResource(0)

        }

        binding.btnUpdate.setOnClickListener {
            updateNote(it)
        }

        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun updateNote(it: View?) {
        val id = notes.data.id
        val title: String = binding.edtUTitle.text.toString()
        val notes: String = binding.edtUNotes.text.toString()
        val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
        val date = LocalDateTime.now().format(formatter)
        viewModel.updateNotes(Notes(id, title, notes, date.toString(), priority))
        Toast.makeText(requireContext(), "Note Update Successful", Toast.LENGTH_SHORT).show()
        if (it != null) {
            Navigation.findNavController(it)
                .navigate(R.id.action_editNotesFragment_to_homeFragment)
        }

    }

}