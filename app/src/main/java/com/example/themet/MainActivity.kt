package com.example.themet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.example.themet.databinding.ActivityMainBinding
import com.example.themet.models.Department
import com.example.themet.models.Departments
import com.example.themet.network.RetrofitSingleton
import com.example.themet.presentation.explore.ExploreFragment
import com.example.themet.presentation.home.HomeFragment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val TAG = "MainActivity"
    private val exploreFragment = ExploreFragment()
    private val homeFragment = HomeFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        replaceFragment(exploreFragment)
        controlBottomNav()
    }

    private fun controlBottomNav() {
        binding.bottomNavigatinView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.exploreFragment -> replaceFragment(exploreFragment)
                R.id.homeFragment -> replaceFragment(homeFragment)
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        if (fragment != null) {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, fragment)
            transaction.commit()
        }
    }


}