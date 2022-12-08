package com.example.tms_quiz.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.tms_quiz.R
import com.example.tms_quiz.databinding.FragmentQuestionBinding
import com.example.tms_quiz.viewmodels.QuizViewModel


class QuestionFragment : Fragment() {
    private var _binding: FragmentQuestionBinding? = null

    // This property is only valid between onCreateView and
// onDestroyView.
    private val binding get() = _binding!!

    lateinit var viewModel: QuizViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = (activity as MainActivity).viewModel
        _binding = FragmentQuestionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.nextButton.setOnClickListener {
            viewModel.cn.value = viewModel.cn.value!! + 1
            // findNavController().navigate(R.id.action_questionFragment_to_quizResultFragment)

        }

        viewModel.cn.observe(requireActivity()) { number ->
            binding.currentTextView.text = number.toString()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}