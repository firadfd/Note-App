package fd.firad.plan2do.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import fd.firad.plan2do.R
import fd.firad.plan2do.databinding.FragmentHomeBinding
import fd.firad.plan2do.ui.adapter.NoteAdapter
import fd.firad.plan2do.viewmodel.NotesViewModel


@AndroidEntryPoint
class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    private val viewModel: NotesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        viewModel.getNotes().observe(viewLifecycleOwner) { noteList ->
            binding.rclAllNotes.apply {
                layoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
                adapter = NoteAdapter(requireContext(), noteList, viewModel)
            }
        }

        binding.btnAdd.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(R.id.action_homeFragment_to_createNoteFragment)
        }


        binding.filter.setOnClickListener {
            viewModel.getNotes().observe(viewLifecycleOwner) { noteList ->
                binding.rclAllNotes.apply {
                    layoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
                    adapter = NoteAdapter(requireContext(), noteList, viewModel)
                }
            }
        }

        binding.fHigh.setOnClickListener {

            viewModel.getHighNotes().observe(viewLifecycleOwner) { noteList ->
                binding.rclAllNotes.apply {
                    layoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
                    adapter = NoteAdapter(requireContext(), noteList, viewModel)
                }
            }
        }

        binding.fMedium.setOnClickListener {

            viewModel.getMediumNotes().observe(viewLifecycleOwner) { noteList ->
                binding.rclAllNotes.apply {
                    layoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
                    adapter = NoteAdapter(requireContext(), noteList, viewModel)
                }
            }
        }
        binding.fLow.setOnClickListener {

            viewModel.getLowNotes().observe(viewLifecycleOwner) { noteList ->
                binding.rclAllNotes.apply {
                    layoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
                    adapter = NoteAdapter(requireContext(), noteList, viewModel)
                }
            }
        }



        return binding.root

    }


}