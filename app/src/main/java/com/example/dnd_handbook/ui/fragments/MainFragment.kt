package com.example.dnd_handbook.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.dnd_handbook.R
import com.example.dnd_handbook.databinding.MainFragmentBinding
import com.example.dnd_handbook.ui.fragments.categories.ClassFragment
import com.example.dnd_handbook.ui.fragments.categories.EquipmentFragment
import com.example.dnd_handbook.ui.fragments.categories.MonsterFragment
import com.example.dnd_handbook.ui.fragments.categories.SpellsFragment

class MainFragment: Fragment(R.layout.main_fragment) {

    private lateinit var binding: MainFragmentBinding
    private lateinit var fragment: BaseFragment

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = MainFragmentBinding.inflate(inflater, container, false)
        setClickBtnMonster()
        setClickBtnClass()
        setClickBtnEquipment()
        setClickBtnSpells()
        return binding.root
    }

    private fun setClickBtnMonster() {
        binding.btnMonsterFragment.setOnClickListener {
            fragment = MonsterFragment()
            changeFragment(fragment)
        }
    }

    private fun setClickBtnSpells() {
        binding.btnSpellsFragment.setOnClickListener {
            fragment = SpellsFragment()
            changeFragment(fragment)
        }
    }

    private fun setClickBtnClass() {
        binding.btnClassFragment.setOnClickListener {
            fragment = ClassFragment()
            changeFragment(fragment)
        }
    }

    private fun setClickBtnEquipment() {
        binding.btnEquipmentFragment.setOnClickListener {
            fragment = EquipmentFragment()
            changeFragment(fragment)
        }
    }

    private fun changeFragment(fragment: Fragment) {
        parentFragmentManager.beginTransaction()
            .replace(R.id.flFragment, fragment)
            .addToBackStack("fragment")
            .commit()
    }
}