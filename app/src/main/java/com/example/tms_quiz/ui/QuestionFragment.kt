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
        setupObservers()
        setupViews()

    }

    private fun setupViews() {
        binding.prevButton.setOnClickListener {
            viewModel.saveUserAnswer()
            viewModel.loadPreviousQuestion()

        }
        binding.allTextView.text = viewModel.getQuestionsAmount().toString()
        viewModel.loadCurrentQuestion()

        binding.radios.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.firstAnswerRadioButton -> {
                    viewModel.userAnswer = 1

                }
                R.id.secondAnswerRadioButton -> {
                    viewModel.userAnswer = 2

                }
                R.id.thirdAnswerRadioButton -> {
                    viewModel.userAnswer = 3

                }
                R.id.fourthAnswerRadioButton -> {
                    viewModel.userAnswer = 4

                }
            }
        }
    }

    private fun setupObservers() {
        viewModel.currentQuestionId.observe(viewLifecycleOwner) { questionNumber ->

            binding.prevButton.isEnabled = questionNumber != 0
            if (questionNumber == viewModel.getQuestionsAmount() - 1) {
                binding.nextButton.text = "Finish"
                binding.nextButton.setOnClickListener {
                    findNavController().navigate(R.id.action_questionFragment_to_quizResultFragment)
                }
            } else {
                binding.nextButton.text = "Next"
                binding.nextButton.setOnClickListener {
                    viewModel.saveUserAnswer()
                    viewModel.loadNextQuestion()

                }
            }
            binding.currentTextView.text = (questionNumber + 1).toString()
            setupAnswers(questionNumber)
            loadUserAnswerIfExistQuestion(questionNumber)
        }
        viewModel.currentQuestion.observe(viewLifecycleOwner) { question ->
            binding.questionTextView.text = question
            loadUserAnswerIfExistQuestion(viewModel.currentQuestionId.value!!)
        }
    }

    private fun loadUserAnswerIfExistQuestion(questionNumber: Int) {
        when (viewModel.userAnswers[questionNumber]) {
            1 -> {
                binding.radios.check(R.id.firstAnswerRadioButton)
                viewModel.userAnswer = 1
            }
            2 -> {
                binding.radios.check(R.id.secondAnswerRadioButton)
                viewModel.userAnswer = 2
            }
            3 -> {
                binding.radios.check(R.id.thirdAnswerRadioButton)
                viewModel.userAnswer = 3
            }
            4 -> {
                binding.radios.check(R.id.fourthAnswerRadioButton)
                viewModel.userAnswer = 4
            }
            else -> {
                binding.radios.clearCheck()
                viewModel.userAnswer = -1
            }

        }
    }

    private fun setupAnswers(questionNumber: Int) {
        val answers = viewModel.loadAnswers(questionNumber)
        binding.firstAnswerRadioButton.text = answers[0]
        binding.secondAnswerRadioButton.text = answers[1]
        binding.thirdAnswerRadioButton.text = answers[2]
        binding.fourthAnswerRadioButton.text = answers[3]

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}