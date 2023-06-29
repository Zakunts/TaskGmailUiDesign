package com.example.taskgmailuidesign.presentation.ui

import android.os.Bundle
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.taskgmailuidesign.R
import com.example.taskgmailuidesign.databinding.FragmentBasicInformationBinding
import com.example.taskgmailuidesign.databinding.FragmentRegisterBinding


class BasicInformationFragment : Fragment() {
    private lateinit var binding: FragmentBasicInformationBinding
    private var message: String? = null
    val months = arrayOf("January",
        "February",
        "March",
        "April",
        "May",
        "June",
        "July",
        "August",
        "September",
        "October",
        "November",
        "December")
    val days = Array(31) { (it + 1).toString() }
    val years = Array(100) { (it + 1920).toString() }
    val genders = arrayOf("Male", "Female", "Other")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentBasicInformationBinding.inflate(inflater, container, false)
        textDesign()
        selectBDay()

        return binding.root
    }

    private fun selectBDay() {
        val monthAdapter =
            ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, months)
        val dayAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, days)
        val yearAdapter =
            ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, years)
        val genderAdapter =
            ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, genders)
        with(binding) {
            spinnerMonth.adapter = monthAdapter
            spinnerDay.adapter = dayAdapter
            spinnerYear.adapter = yearAdapter
            spinnerGender.adapter = genderAdapter
            regNextBtn.setOnClickListener {
                val selectedMonth = spinnerMonth.selectedItem.toString()
                val selectedDay = spinnerDay.selectedItem.toString()
                val selectedYear = spinnerYear.selectedItem.toString()
                val selectedGender = spinnerGender.selectedItem.toString()
                message = "$selectedMonth $selectedDay, $selectedYear\nGender: $selectedGender"


            }.also {
                Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
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