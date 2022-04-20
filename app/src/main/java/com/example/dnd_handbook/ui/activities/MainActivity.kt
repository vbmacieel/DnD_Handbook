package com.example.dnd_handbook.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.dnd_handbook.R
import com.example.dnd_handbook.ui.fragments.MainFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initMainFragment()
    }

    private fun initMainFragment() {
        val mainFragment = MainFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.flFragment, mainFragment)
            .commit()
    }
}