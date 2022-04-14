package com.example.controlpanel.viewpager.fragment.ControlPanel.ChoosingMissionToCreate

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.controlpanel.R
import com.example.controlpanel.databinding.FragmentChoosingMissionToCreateBinding

class ChoosingMissionToCreateFragment : Fragment() {

    private var _binding: FragmentChoosingMissionToCreateBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentChoosingMissionToCreateBinding.inflate(inflater, container, false)

        binding.arealShootingButton.setOnClickListener{
            findNavController().navigate(R.id.action_choosingMissionToCreateFragment_to_createArealShootingFragment)
        }

        binding.mobileTowerButton.setOnClickListener{
            findNavController().navigate(R.id.action_choosingMissionToCreateFragment_to_createMobileTowerFragment)
        }

        binding.backButton.setOnClickListener{
            findNavController().navigate(R.id.action_choosingMissionToCreateFragment_to_missionListControlPanelFragment)
        }

        return binding.root
    }
}