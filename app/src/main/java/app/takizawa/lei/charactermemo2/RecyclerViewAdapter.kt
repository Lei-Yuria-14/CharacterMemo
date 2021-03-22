package app.takizawa.lei.charactermemo2

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.core.content.contentValuesOf
import androidx.recyclerview.widget.RecyclerView
import io.realm.OrderedRealmCollection
import kotlinx.android.synthetic.main.item_character_data_cell.view.*

class RecyclerViewAdapter(private val context: Context,
                          private var characterDataList: OrderedRealmCollection<CharacterData>?,
                          private val autoUpdate: Boolean): RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_character_data_cell, parent, false)

        view.setOnClickListener(ItemClickListener())

        return ViewHolder(view)
    }

    override fun getItemCount(): Int = characterDataList?.size ?: 0

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val characterData: CharacterData = characterDataList?.get(position) ?:return
        holder.charaImage.setImageResource(characterData.characterImageResource)
        holder.charaNameTextView.text = characterData.name
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val charaImage: ImageView = view.findViewById(R.id.characterImageView)
        val charaNameTextView: TextView = view.findViewById(R.id.characterNameTextView)
    }

    inner class ItemClickListener: View.OnClickListener {
        override fun onClick(view: View) {
            val characterNameTextView = view.findViewById<TextView>(R.id.characterNameTextView)

            val context = view.context
            val intent = Intent(context, ReMemoActivity::class.java)
            intent.putExtra("NAME", characterNameTextView.text)
            context.startActivity(intent)
        }
    }

}