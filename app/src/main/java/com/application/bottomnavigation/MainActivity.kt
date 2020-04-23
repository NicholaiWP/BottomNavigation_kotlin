package com.application.bottomnavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    lateinit var homeFragment: HomeFragment
    lateinit var favouriteFragment: FavouriteFragment
    lateinit var profileFragment: ProfileFragment
    lateinit var settingsFragment: SettingsFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigation: BottomNavigationView = findViewById(R.id.btm_nav)

        performTransaction(homeFragment, "home")

        bottomNavigation.setOnNavigationItemSelectedListener {item ->
            when (item.itemId){

               R.id.home -> {
                    homeFragment = HomeFragment()
                   performTransaction(homeFragment, "home")
               }

                R.id.favourite -> {
                    favouriteFragment = FavouriteFragment()
                    performTransaction(favouriteFragment, "favourite")
                }

                R.id.profile -> {
                    profileFragment = ProfileFragment()
                    performTransaction(profileFragment, "profile")
                }

                R.id.settings -> {
                    settingsFragment = SettingsFragment()
                    performTransaction(settingsFragment, "settings")
                }
            }
            true
        }
    }

    private fun performTransaction(fragment:Fragment, backStackString:String){
        supportFragmentManager.beginTransaction().replace(R.id.frame_layout, fragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .addToBackStack(backStackString)
            .commit()
    }
}
