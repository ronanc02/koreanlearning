package com.example.koreanlearning

import android.os.Bundle
import android.view.*
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.koreanlearning.adapter.ItemAdapter
import com.example.koreanlearning.data.DataSelection
import com.example.koreanlearning.databinding.FragmentSubselectionBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

class SubselectionFragment : Fragment() {

    private var _binding: FragmentSubselectionBinding? = null
    private val binding get() = _binding!!

    private var fragmentname: String = "SubselectionFragment"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSubselectionBinding.inflate(inflater, container, false)
        return binding.root
    }

    private lateinit var recyclerView: RecyclerView
    private var isLinearLayoutManager = true

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView = binding.rwSubselection
        implementLayout()
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_main, menu)

        val layoutButton = menu.findItem(R.id.action_settings)
        setIcon(layoutButton)
    }

    private fun implementLayout() {
        val dataMain = context?.let { DataSelection(it).loadSections() }
        recyclerView.layoutManager = GridLayoutManager(context, 1)
        recyclerView.adapter = dataMain?.let { context?.let { it1 -> ItemAdapter(it1, it, fragmentname) } }

        recyclerView.setHasFixedSize(true)
    }

    private fun setIcon(menuItem: MenuItem?) {
        if (menuItem == null)
            return

        menuItem.icon = ContextCompat.getDrawable(this.requireContext(), R.drawable.ic_grid_layout)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> {
                setIcon(item)
                return true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun showDialog() {
        MaterialAlertDialogBuilder(requireContext())
            .setTitle(getString(R.string.congratulations))
            .setMessage("You did it !")
            .setCancelable(true)
            .setNegativeButton("exit") {_, _ ->
                //exitgame()
            }
            .setPositiveButton("more") {_, _ ->
                //restartgame()
            }
            .show()
    }
}