package com.example.androiditis2024

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.androiditis2024.databinding.FirstActivityBinding

class FirstActivity: AppCompatActivity() {

    private var binding: FirstActivityBinding? = null

    @SuppressLint("QueryPermissionsNeeded")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = FirstActivityBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }

        val controller = (supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment).navController



        binding?.run {

            bottomNav.setupWithNavController(controller)

//            bottomNav.setOnItemSelectedListener {
//                when(it.itemId) {
//                    R.id.home -> {
//                        navigateTo(HomeFragment())
//                        true
//                    }
//                    R.id.profile -> {
//                        navigateTo(ProfileFragment())
//                        true
//                    }
//                    R.id.settings -> {
//                        navigateTo(ProfileFragment())
//                        true
//                    }
//                    else -> false
//                }
//            }
//            bottomNav.selectedItemId = R.id.home
        }
    }


    private fun navigateTo(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment, fragment.javaClass.name)
            .commit()
    }

}