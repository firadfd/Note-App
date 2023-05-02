package fd.firad.plan2do.ui.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialog
import fd.firad.plan2do.R
import fd.firad.plan2do.databinding.ItemNotesBinding
import fd.firad.plan2do.models.Notes
import fd.firad.plan2do.ui.fragments.HomeFragmentDirections
import fd.firad.plan2do.viewmodel.NotesViewModel

class NoteAdapter(
    private val context: Context,
    private val noteList: List<Notes>,
    private val viewModel: NotesViewModel
) :
    RecyclerView.Adapter<NoteAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(ItemNotesBinding.inflate(LayoutInflater.from(context), parent, false))
    }

    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data = noteList[position]
        holder.binding.apply {
            noteData = data
        }
        when (data.priority) {
            "1" -> holder.binding.priority.setBackgroundResource(R.drawable.green_dot)
            "2" -> holder.binding.priority.setBackgroundResource(R.drawable.yello_dot)
            "3" -> holder.binding.priority.setBackgroundResource(R.drawable.red_dot)
        }

        holder.binding.root.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToEditNotesFragment(data)
            Navigation.findNavController(it).navigate(action)
        }
        holder.binding.root.setOnLongClickListener {

            val bottomSheet: BottomSheetDialog = BottomSheetDialog(context)
            bottomSheet.setContentView(R.layout.dialogue)
            bottomSheet.show()

            val yesBtn = bottomSheet.findViewById<TextView>(R.id.dialogueYES)!!
            val noBtn = bottomSheet.findViewById<TextView>(R.id.dialogueNO)!!
            yesBtn.setOnClickListener {

                viewModel.deleteNotes(data.id!!)
                bottomSheet.dismiss()
                Toast.makeText(context, "Deleted", Toast.LENGTH_SHORT).show()

            }
            noBtn.setOnClickListener {
                bottomSheet.dismiss()
            }
            true
        }
/*
    ***************************text copy to clipboard******************
        holder.binding.mainCardId.setOnLongClickListener {
            val clipboardManager =
                context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clipData = ClipData.newPlainText("text", holder.binding.note.text.toString())
            clipboardManager.setPrimaryClip(clipData)
            Toast.makeText(holder.itemView.context, "Note Copied to Clipboard", Toast.LENGTH_SHORT)
                .show()
            true
        }
*/

    }

    override fun getItemCount(): Int {
        return noteList.size
    }

    class MyViewHolder(val binding: ItemNotesBinding) : RecyclerView.ViewHolder(binding.root)
}