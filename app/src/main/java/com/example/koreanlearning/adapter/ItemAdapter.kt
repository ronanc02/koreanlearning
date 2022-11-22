package com.example.koreanlearning.adapter

import android.content.Context
import android.content.Intent
import android.provider.Settings.Global.getString
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat.startActivity
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.koreanlearning.*
import com.example.koreanlearning.database.login.Login
import com.example.koreanlearning.model.Section
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.coroutines.NonDisposableHandle.parent

/**
 * Adapter for the [RecyclerView] in [MainActivity]. Displays [Section] data object.
 */
class ItemAdapter(
    private val context: Context,
    private val dataset: List<Section>,
    private val fragmentname: String
) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder.
    // Each data item is just an Affirmation object.

    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.item_title)
        val imageView: ImageView = view.findViewById(R.id.item_image)
    }

    /**
     * Create new views (invoked by the layout manager)
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        // create a new view
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)

        return ItemViewHolder(adapterLayout)
    }

    /**
     * Replace the contents of a view (invoked by the layout manager)
     */
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
/*        val item2 = logindata[1]
        holder.textView.text = item2.username
*/
        holder.textView.text = item.stringResourceId
        holder.imageView.setImageResource(item.imageResourceId)

        when (fragmentname) {
            "SelectionFragment" -> {
                val action =
                    SelectionFragmentDirections.actionSelectionFragmentToSubselectionFragment(
                        item.stringResourceId
                    )
                holder.imageView.setOnClickListener() {
                    it.findNavController().navigate(action)
                }
            }
            "SubselectionFragment" -> {
                val action =
                    SubselectionFragmentDirections.actionSubselectionFragmentToAboutKoreaFragment(
                        item.stringResourceId
                    )
                holder.imageView.setOnClickListener() {
                    it.findNavController().navigate(action)
                }
            }
            else -> {
//                val intent = Intent(context, AboutKoreaActivity::class.java)
//                context.startActivity(intent)
                }
            }
        }

    /**
     * Return the size of your dataset (invoked by the layout manager)
     */
    override fun getItemCount() = dataset.size
}
