package com.example.controlpanel.viewpager.fragment.ControlPanel.update.UpdateArealShooting

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
import androidx.navigation.fragment.navArgs
import com.example.controlpanel.R
import com.example.controlpanel.data.model.typeMission.ArealShooting.ArealShooting
import com.example.controlpanel.data.viewmodel.ArealShootingViewModel
import com.example.controlpanel.databinding.FragmentUpdateArealShootingBinding

class UpdateArealShootingFragment : Fragment() {

    private var _binding: FragmentUpdateArealShootingBinding? = null
    private val binding get() = _binding!!

    private lateinit var mArealShootingViewModel: ArealShootingViewModel

    private val args by navArgs<UpdateArealShootingFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentUpdateArealShootingBinding.inflate(inflater, container, false)

        mArealShootingViewModel = ViewModelProvider(this).get(ArealShootingViewModel::class.java)

        binding.speedEditText.setText(args.currentArealShooting.speed.toString())
        binding.roundingEditText.setText(args.currentArealShooting.rounding.toString())
        binding.resolutionEditText.setText(args.currentArealShooting.resolution.toString())
        binding.heightEditText.setText(args.currentArealShooting.height.toString())
        binding.longitudinalOverlapEditText.setText(args.currentArealShooting.longitudinalOverlap.toString())
        binding.shootingStepEditText.setText(args.currentArealShooting.shootingStep.toString())
        binding.transverseOverlapEditText.setText(args.currentArealShooting.transverseOverlap.toString())
        binding.tackStepEditText.setText(args.currentArealShooting.tackStep.toString())
        binding.missionNameEditText.setText(args.currentArealShooting.name)

        //Saving button
        binding.addButton.setOnClickListener{
            updateData()
        }

        //Navigation buttons
        binding.backButton.setOnClickListener{
            findNavController().navigate(R.id.action_updateArealShootingFragment_to_missionListControlPanelFragment)
        }
        binding.closeButton.setOnClickListener{
            findNavController().navigate(R.id.action_updateArealShootingFragment_to_missionListControlPanelFragment)
        }

        return binding.root
    }

    private fun updateData() {
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
            val arealShooting = ArealShooting(args.currentArealShooting.id,
                "ArealShooting",
                args.currentArealShooting.isLocal,
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

            mArealShootingViewModel.updateArealShooting(arealShooting)
            Toast.makeText(requireContext(), "Площадная съемка обновлена", Toast.LENGTH_SHORT).show()
            //Navigate back
            findNavController().navigate(R.id.action_updateArealShootingFragment_to_missionListControlPanelFragment)
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