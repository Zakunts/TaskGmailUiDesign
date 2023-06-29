package com.example.taskgmailuidesign.presentation.ui

import android.os.Bundle
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.taskgmailuidesign.R
import com.example.taskgmailuidesign.databinding.FragmentLoginWelcomeBinding


class LoginWelcomeFragment : Fragment() {
    private lateinit var binding: FragmentLoginWelcomeBinding
    val args: LoginWelcomeFragmentArgs by navArgs()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val email = args.email//hetagayum araj ghnalu hamar
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentLoginWelcomeBinding.inflate(inflater, container, false)
        initClickListener()
        textDesign()
        return binding.root
    }

    private fun initClickListener() {
        with(binding) {
            loginNextBtn.setOnClickListener {
                findNavController().navigate(R.id.action_loginWelcomeFragment_to_homeFragment)
            }
            forgotPassword.setOnClickListener {
            }


        }
    }

    //karox enq naev code chkrknel
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