package com.example.controlpanel.viewpager.fragment.ControlPanel.MissionList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.navigation.fragment.findNavController
import com.example.controlpanel.R
import com.example.controlpanel.databinding.FragmentMissionListControlPanelBinding

class MissionListControlPanelFragment : Fragment() {

    private var _binding: FragmentMissionListControlPanelBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMissionListControlPanelBinding.inflate(inflater, container, false)

        binding.addMissionButton.setOnClickListener {
            findNavController().navigate(R.id.action_missionListControlPanelFragment_to_choosingMissionToCreateFragment)
        }

        return binding.root
    }
}

