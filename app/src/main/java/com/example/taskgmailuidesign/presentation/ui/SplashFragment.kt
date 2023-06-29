package com.example.taskgmailuidesign.presentation.ui

import android.animation.ObjectAnimator
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.getColor
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.taskgmailuidesign.R
import com.example.taskgmailuidesign.databinding.FragmentSplashBinding
import com.example.taskgmailuidesign.presentation.viewModel.SplashViewMode
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashFragment : Fragment() {
    private lateinit var binding: FragmentSplashBinding
    private val viewModel by viewModel<SplashViewMode>()
    private var colorRed: Int? = null
    private var colorGreen: Int? = null
    private var colorBlue: Int? = null
    private var colorYellow: Int? = null
    private lateinit var animator: ObjectAnimator
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentSplashBinding.inflate(inflater, container, false)
        initViewModel()
        progressBar()
        return binding.root
    }

    private fun progressBar() {
        animator = ObjectAnimator.ofInt(binding.progressBar, "progress", 100)
        animator.duration = 2000
        animator.start()
        colorRed = getColor(requireContext(), R.color.Red)
        colorGreen = getColor(requireContext(), R.color.green)
        colorBlue = getColor(requireContext(), R.color.blue)
        colorYellow = getColor(requireContext(), R.color.yellow)

        animator.addUpdateListener { animation ->
            val progress = animation.animatedValue as Int
            with(binding) {
                when (progress) {
                    in 0..25 -> progressBar.progressDrawable.colorFilter = PorterDuffColorFilter(
                        colorRed!!,//:?
                        PorterDuff.Mode.SRC_IN
                    )
                    in 26..50 -> progressBar.progressDrawable.colorFilter = PorterDuffColorFilter(
                        colorGreen!!,
                        PorterDuff.Mode.SRC_IN
                    )
                    in 51..75 -> progressBar.progressDrawable.colorFilter = PorterDuffColorFilter(
                        colorBlue!!,
                        PorterDuff.Mode.SRC_IN
                    )
                    in 76..100 -> progressBar.progressDrawable.colorFilter =
                        PorterDuffColorFilter(
                            colorYellow!!,
                            PorterDuff.Mode.SRC_IN
                        )
                    else -> progressBar.progressDrawable.clearColorFilter()
                }
            }

        }
    }


    private fun initViewModel() {
        lifecycleScope.launch {
            viewModel.autoLogin.collect {
                if (it) {
                    Handler(Looper.getMainLooper()).postDelayed({

                        findNavController().navigate(R.id.action_splashFragment_to_homeFragment)
                    }, 2000)
                } else {

                    Handler(Looper.getMainLooper()).postDelayed({
                        findNavController().navigate(R.id.action_splashFragment_to_loginFragment)
                    }, 2000)

                }
            }
        }
    }
}