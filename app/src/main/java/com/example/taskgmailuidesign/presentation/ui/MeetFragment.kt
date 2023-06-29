package com.example.taskgmailuidesign.presentation.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.taskgmailuidesign.databinding.FragmentMeetBinding


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class MeetFragment : Fragment() {
    private lateinit var binding: FragmentMeetBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentMeetBinding.inflate(inflater, container, false)
        return binding.root
    }


}