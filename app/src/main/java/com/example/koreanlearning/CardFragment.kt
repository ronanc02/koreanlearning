package com.example.koreanlearning

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Button
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.koreanlearning.adapter.ItemAdapter
import com.example.koreanlearning.data.Datasource
import com.example.koreanlearning.data.Json
import com.example.koreanlearning.databinding.FragmentCardBinding
import com.example.koreanlearning.databinding.FragmentSelectionBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

class CardFragment : Fragment() {

    private val viewModel: CardViewModel by viewModels()
    private var _binding: FragmentCardBinding? = null
    private val binding get() = _binding!!

    companion object {
        val LEVEL = "level"
    }

    private lateinit var level: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            level = it.getString(LEVEL).toString()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCardBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun updateWordOnScreen() {
        binding.textView.text = viewModel.koreanword
    }

}