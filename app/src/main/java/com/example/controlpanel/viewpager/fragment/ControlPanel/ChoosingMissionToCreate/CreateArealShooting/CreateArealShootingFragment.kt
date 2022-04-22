package com.example.controlpanel.viewpager.fragment.ControlPanel.ChoosingMissionToCreate.CreateArealShooting

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.controlpanel.R
import com.example.controlpanel.data.model.typeMission.ArealShooting.ArealShooting
import com.example.controlpanel.data.viewmodel.ArealShootingViewModel
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
        val speed = binding.speedEditText.text
        val rounding = binding.roundingEditText.text
        val resolution = binding.resolutionEditText.text
        val height = binding.heightEditText.text
        val longitudinalOverlap = binding.longitudinalOverlapEditText.text
        val shootingStep = binding.shootingStepEditText.text
        val transverseOverlap = binding.transverseOverlapEditText.text
        val tackStep = binding.tackStepEditText.text
        val missionName = binding.missionNameEditText.text.toString()

        if (inputCheck(speed, rounding, resolution, height, longitudinalOverlap, shootingStep, transverseOverlap, tackStep, missionName)){
            //Create ArealShooting
            val arealShooting = ArealShooting(0,
                "ArealShooting",
                Integer.parseInt(speed.toString()),
                Integer.parseInt(rounding.toString()),
                Integer.parseInt(resolution.toString()),
                Integer.parseInt(height.toString()),
                Integer.parseInt(longitudinalOverlap.toString()),
                Integer.parseInt(shootingStep.toString()),
                Integer.parseInt(transverseOverlap.toString()),
                Integer.parseInt(tackStep.toString()),
                missionName,
                "Кодинское/Тагариенское",
                "12.04.2022",
                54,
                43,
                23,
            )

            mArealShootingViewModel.addArealShooting(arealShooting)
            Toast.makeText(requireContext(), "Площадная съемка создана", Toast.LENGTH_SHORT).show()
            //Navigate back
            findNavController().navigate(R.id.action_createArealShootingFragment_to_missionListControlPanelFragment)
        }else{
            Toast.makeText(requireContext(), "Заполните все поля", Toast.LENGTH_SHORT).show()
        }
    }

    private fun inputCheck(speed: Editable,
        rounding: Editable,
        resolution: Editable,
        height: Editable,
        longitudinalOverlap: Editable,
        shootingStep: Editable,
        transverseOverlap: Editable,
        tackStep: Editable,
        missionName: String
    ): Boolean {
        return (!speed.isEmpty() &&
                !rounding.isEmpty() &&
                !resolution.isEmpty() &&
                !height.isEmpty() &&
                !longitudinalOverlap.isEmpty() &&
                !shootingStep.isEmpty() &&
                !transverseOverlap.isEmpty() &&
                !tackStep.isEmpty() &&
                !TextUtils.isEmpty(missionName))
    }
}