package com.example.controlpanel.viewpager.fragment.ControlPanel.CreateArealShooting

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.controlpanel.R
import com.example.controlpanel.data.model.ArealShooting.ArealShooting
import com.example.controlpanel.data.viewmodel.ArealShooting.ArealShootingViewModel
import com.example.controlpanel.databinding.FragmentCreateArealShootingBinding

class CreateArealShootingFragment : Fragment() {
    private var _binding: FragmentCreateArealShootingBinding? = null
    private val binding get() = _binding!!

    private lateinit var mArealShootingViewModel: ArealShootingViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentCreateArealShootingBinding.inflate(inflater, container, false)

        //navigation buttons
        binding.backButton.setOnClickListener{
            findNavController().navigate(R.id.action_createArealShootingFragment_to_choosingMissionToCreateFragment)
        }
        binding.closeButton.setOnClickListener {
            findNavController().navigate(R.id.action_createArealShootingFragment_to_choosingMissionToCreateFragment)
        }

        mArealShootingViewModel = ViewModelProvider(this).get(ArealShootingViewModel::class.java)

        binding.addButton.setOnClickListener{
            insertDataToDatabase()
        }

        return binding.root
    }

    private fun insertDataToDatabase() {
        val speed = Integer.parseInt(binding.speedEditText.text.toString())
        val rounding = Integer.parseInt(binding.roundedEditText.text.toString())
        val resolution = Integer.parseInt(binding.resolutionEditText.text.toString())
        val height = Integer.parseInt(binding.heightEditText.text.toString())
        val longitudinalOverlap = Integer.parseInt(binding.longitudinalOverlapEditText.text.toString())
        val shootingStep = Integer.parseInt(binding.shootingStepEditText.text.toString())
        val transverseOverlap = Integer.parseInt(binding.transverseOverlapEditText.text.toString())
        val tackStep = Integer.parseInt(binding.tackStepEditText.text.toString())
        val missionName = binding.missionNameEditText.text.toString()

        val arealShooting = ArealShooting(0, speed, rounding, resolution, height, longitudinalOverlap, shootingStep, transverseOverlap, tackStep, missionName)

        mArealShootingViewModel.addArealShooting(arealShooting)
        Toast.makeText(requireContext(), "Миссия создана", Toast.LENGTH_SHORT).show()
        //Navigate back
        findNavController().navigate(R.id.action_createArealShootingFragment_to_missionListControlPanelFragment)
    }
}