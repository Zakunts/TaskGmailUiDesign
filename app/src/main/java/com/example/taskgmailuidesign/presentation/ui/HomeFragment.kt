package com.example.taskgmailuidesign.presentation.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.core.view.GravityCompat
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.taskgmailuidesign.R
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.taskgmailuidesign.databinding.FragmentHomeBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class HomeFragment : Fragment(),NavigationView.OnNavigationItemSelectedListener {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var navController: NavController
    private lateinit var appBarConf: AppBarConfiguration
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        initClickLitener()
//        configurations()
//        navControl()

        return binding.root
    }

    private fun initClickLitener() {
        with(binding) {
            menuIcon.setOnClickListener {
                drawerLayout.openDrawer(GravityCompat.START)
            }
            fab.setOnClickListener {
                findNavController().navigate(R.id.action_homeFragment_to_composeFragment)
            }
        }
    }

//    private fun navControl() {
//        navController =binding.fragmentContainerView
//        setupActionBarWithNavController(navController, appBarConf)
//        this.binding.bottomNavigationView.setupWithNavController(navController)
//    }
//
//    private fun configurations() {
//        appBarConf = AppBarConfiguration(setOf(R.id.homeFragment2,
//            R.id.meetFragment2))
//    }
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.primary -> {
                //nav open page
                return true
            }
            R.id.social -> {
                //nav open page
                return true
            }
            // Handle other navigation items here
        }
        return false
    }


}