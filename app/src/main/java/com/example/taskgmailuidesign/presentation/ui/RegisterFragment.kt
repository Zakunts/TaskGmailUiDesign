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
import com.example.taskgmailuidesign.R
import com.example.taskgmailuidesign.databinding.FragmentLoginBinding
import com.example.taskgmailuidesign.databinding.FragmentRegisterBinding


class RegisterFragment : Fragment() {
    private lateinit var binding: FragmentRegisterBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        textDesign()
        initClickListener()
        return binding.root
    }

    private fun initClickListener() {
        with(binding){
            regNextBtn.setOnClickListener {
                findNavController().navigate(R.id.action_registerFragment_to_basicInformationFragment)
            }
        }
    }

    private fun textDesign() {
        with(binding.regTitle) {
            val spannableString = SpannableString(text).apply {
                setSpan(ForegroundColorSpan(androidx.core.content.ContextCompat.getColor(
                    requireContext(),
                    com.example.taskgmailuidesign.R.color.blue)),
                    0,
                    1,
                    0)
                setSpan(ForegroundColorSpan(androidx.core.content.ContextCompat.getColor(
                    requireContext(),
                    com.example.taskgmailuidesign.R.color.Red)),
                    1,
                    2,
                    0)
                setSpan(ForegroundColorSpan(androidx.core.content.ContextCompat.getColor(
                    requireContext(),
                    com.example.taskgmailuidesign.R.color.yellow)), 2, 3, 0)
                setSpan(ForegroundColorSpan(androidx.core.content.ContextCompat.getColor(
                    requireContext(),
                    com.example.taskgmailuidesign.R.color.blue)),
                    3,
                    4,
                    0)
                setSpan(ForegroundColorSpan(androidx.core.content.ContextCompat.getColor(
                    requireContext(),
                    com.example.taskgmailuidesign.R.color.green)), 4, 5, 0)
                setSpan(ForegroundColorSpan(androidx.core.content.ContextCompat.getColor(
                    requireContext(),
                    com.example.taskgmailuidesign.R.color.Red)),
                    5,
                    6,
                    0)
            }
            text = spannableString
        }
    }


}