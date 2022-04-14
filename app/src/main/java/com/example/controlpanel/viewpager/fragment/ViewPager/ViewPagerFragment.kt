package com.example.controlpanel.viewpager.fragment.ViewPager

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.controlpanel.viewpager.fragment.ControlPanel.ControlPanelFragment
import com.example.controlpanel.viewpager.fragment.MainPage.MainPageFragment
import com.example.controlpanel.databinding.FragmentViewPagerBinding
import com.example.controlpanel.viewpager.adapter.ViewPagerAdapter

//Фрагмент для соединения главного экрана и панели упаравления

class ViewPagerFragment : Fragment() {

    private var _binding: FragmentViewPagerBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentViewPagerBinding.inflate(inflater, container, false)

        val fragmentList = arrayListOf<Fragment>(
            MainPageFragment(),
            ControlPanelFragment(),
        )

        val adapter = ViewPagerAdapter(
            fragmentList,
            requireActivity().supportFragmentManager,
            lifecycle
        )

        binding.viewPagerFragment.adapter = adapter

        return binding.root
    }
}