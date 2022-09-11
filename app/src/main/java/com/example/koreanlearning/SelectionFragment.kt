package com.example.koreanlearning

import android.os.Bundle
import android.view.*
import androidx.core.content.ContextCompat
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.koreanlearning.adapter.ItemAdapter
import com.example.koreanlearning.data.DataMain
import com.example.koreanlearning.data.Json
import com.example.koreanlearning.databinding.FragmentSelectionBinding

class SelectionFragment : androidx.fragment.app.Fragment() {

    private var _binding: FragmentSelectionBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSelectionBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    private lateinit var recyclerView: RecyclerView
    private var isLinearLayoutManager = true
    val action = SelectionFragmentDirections.actionSelectionFragmentToCardFragment("beginner")

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView = binding.recyclerView
//        button.setOnClickListener() {
//            view.findNavController().navigate(action)
//        }
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
//        val json = context?.let { Json(it).parseJson() }
        val dataMain = context?.let { DataMain(it).loadAffirmations() }
        recyclerView.layoutManager = GridLayoutManager(context, 2)
        recyclerView.adapter = dataMain?.let { context?.let { it1 -> ItemAdapter(it1, it) } }
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
}