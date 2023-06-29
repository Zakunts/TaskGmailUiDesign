package com.example.taskgmailuidesign.presentation.ui

import android.os.Bundle
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.taskgmailuidesign.R
import com.example.taskgmailuidesign.databinding.FragmentLoginBinding
import com.example.taskgmailuidesign.presentation.viewModel.LoginViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private val viewModel by viewModel<LoginViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        textDesign()
        initClickListener()
        viewModelCall()
        return binding.root
    }

    private fun viewModelCall() {
        lifecycleScope.launchWhenStarted {
            viewModel.errorLiveData.collect {
                Toast.makeText(requireContext(), "$it", Toast.LENGTH_SHORT).show()
            }
        }
        lifecycleScope.launchWhenStarted {
            viewModel.userLiveData.collect {
                navigateToWelcomeFragment(binding.edMail.text.toString())
            }
        }
    }



    private fun initClickListener() {
        with(binding) {

            loginNextBtn.setOnClickListener {
                if (binding.edMail.text?.trim()
                        .isNullOrEmpty()

                ) {
                    Toast.makeText(requireContext(), "Please fill in all fields", Toast.LENGTH_LONG)


                } else {
                    sendData()
                }

            }
            loginCreateAccount.setOnClickListener {
                findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
            }
            loginLearnMore.setOnClickListener { //code }
            }


        }


    }

    private fun navigateToWelcomeFragment(email: String) {
        val action = LoginFragmentDirections.actionLoginFragmentToLoginWelcomeFragment(email)
        findNavController().navigate(action)
    }

    private fun sendData() {
//          //viewModel
//          LoginUser(
//                    binding.edMail.text.toString(),
//                    ""
//                )

    }
    private fun textDesign() {
        with(binding.loginTitle) {
            val spannableString = SpannableString(text).apply {
                setSpan(ForegroundColorSpan(ContextCompat.getColor(requireContext(), R.color.blue)),
                    0,
                    1,
                    0)
                setSpan(ForegroundColorSpan(ContextCompat.getColor(requireContext(), R.color.Red)),
                    1,
                    2,
                    0)
                setSpan(ForegroundColorSpan(ContextCompat.getColor(requireContext(),
                    R.color.yellow)), 2, 3, 0)
                setSpan(ForegroundColorSpan(ContextCompat.getColor(requireContext(), R.color.blue)),
                    3,
                    4,
                    0)
                setSpan(ForegroundColorSpan(ContextCompat.getColor(requireContext(),
                    R.color.green)), 4, 5, 0)
                setSpan(ForegroundColorSpan(ContextCompat.getColor(requireContext(), R.color.Red)),
                    5,
                    6,
                    0)
            }
            text = spannableString
        }
    }
}