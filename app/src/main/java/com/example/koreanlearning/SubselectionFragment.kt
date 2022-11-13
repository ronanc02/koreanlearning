package com.example.koreanlearning

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.koreanlearning.databinding.FragmentSubselectionBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

class SubselectionFragment : Fragment() {

    private val viewModel: CardViewModel by viewModels()
    private var _binding: FragmentSubselectionBinding? = null
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
        _binding = FragmentSubselectionBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        updateWordOnScreen()
        showDialog()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun updateWordOnScreen() {
//        binding.textView.text = viewModel.koreanword
        binding.textView.text = level
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