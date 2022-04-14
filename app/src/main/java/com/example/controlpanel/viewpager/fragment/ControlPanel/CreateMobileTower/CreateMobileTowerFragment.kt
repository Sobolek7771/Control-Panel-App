package com.example.controlpanel.viewpager.fragment.ControlPanel.CreateMobileTower

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.controlpanel.R
import com.example.controlpanel.data.model.MobileTower.MobileTower
import com.example.controlpanel.data.viewmodel.MobileTower.MobileTowerViewModel
import com.example.controlpanel.databinding.FragmentCreateMobileTowerBinding

class CreateMobileTowerFragment : Fragment() {
    private var _binding: FragmentCreateMobileTowerBinding? = null
    private val binding get() = _binding!!

    private lateinit var mMobileTowerViewModel: MobileTowerViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentCreateMobileTowerBinding.inflate(inflater, container, false)

        //navigation buttons
        binding.backButton.setOnClickListener{
            findNavController().navigate(R.id.action_createMobileTowerFragment_to_choosingMissionToCreateFragment)
        }
        binding.closeButton.setOnClickListener {
            findNavController().navigate(R.id.action_createMobileTowerFragment_to_choosingMissionToCreateFragment)
        }

        mMobileTowerViewModel = ViewModelProvider(this).get(MobileTowerViewModel::class.java)

        binding.addButton.setOnClickListener{
            insertDataToDatabase()
        }

        return binding.root
    }

    private fun insertDataToDatabase() {
        val speed = Integer.parseInt(binding.speedEditText.text.toString())
        val rounding = Integer.parseInt(binding.roundedEditText.text.toString())
        val radius = Integer.parseInt(binding.radiusEditText.text.toString())
        val shootingPointsNumber = Integer.parseInt(binding.shootingPointsNumberEditText.text.toString())
        val height = Integer.parseInt(binding.heightEditText.text.toString())
        val titleAngle = Integer.parseInt(binding.tiltAngleEditText.text.toString())
        val missionName = binding.missionNameEditText.text.toString()

        val mobileTower = MobileTower(0, speed, rounding, radius, shootingPointsNumber, height, titleAngle, missionName)

        mMobileTowerViewModel.addMobileTower(mobileTower)
        Toast.makeText(requireContext(), "Миссия создана", Toast.LENGTH_SHORT).show()
        //Navigate back
        findNavController().navigate(R.id.action_createMobileTowerFragment_to_missionListControlPanelFragment)
    }
}