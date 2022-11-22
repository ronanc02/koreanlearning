package com.example.koreanlearning

import android.os.Bundle
import android.view.*
import androidx.core.content.ContextCompat
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.koreanlearning.adapter.ItemAdapter
import com.example.koreanlearning.data.DataSelection
import com.example.koreanlearning.databinding.FragmentSelectionBinding
import com.example.koreanlearning.viewmodels.LoginViewModel
import com.example.koreanlearning.viewmodels.LoginViewModelFactory

class SelectionFragment() : androidx.fragment.app.Fragment() {

    private var _binding: FragmentSelectionBinding? = null
    private val binding get() = _binding!!
    private val viewModel: LoginViewModel by activityViewModels {
        LoginViewModelFactory(
            (activity?.application as LoginApplication).database.loginDao()
        )
    }

    private var fragmentname: String = "SelectionFragment"

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView = binding.rwSelection
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
        val dataMain = context?.let { DataSelection(it).loadCategories() }
        recyclerView.layoutManager = GridLayoutManager(context, 1)
//        recyclerView.adapter = dataMain?.let { context?.let { it1 -> ItemAdapter(it1, it, viewModel.fullLogin()) } }
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
}