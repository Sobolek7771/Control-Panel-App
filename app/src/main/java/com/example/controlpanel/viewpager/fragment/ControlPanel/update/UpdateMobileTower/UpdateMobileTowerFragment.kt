package com.example.controlpanel.viewpager.fragment.ControlPanel.update.UpdateMobileTower

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
import com.example.controlpanel.data.model.typeMission.MobileTower.MobileTower
import com.example.controlpanel.data.viewmodel.MobileTowerViewModel
import com.example.controlpanel.databinding.FragmentUpdateMobileTowerBinding

class UpdateMobileTowerFragment : Fragment() {
    private var _binding: FragmentUpdateMobileTowerBinding? = null
    private val binding get() = _binding!!

    private lateinit var mMobileTowerViewModel: MobileTowerViewModel

    private val args by navArgs<UpdateMobileTowerFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentUpdateMobileTowerBinding.inflate(inflater, container, false)

        mMobileTowerViewModel = ViewModelProvider(this).get(MobileTowerViewModel::class.java)

        binding.speedEditText.setText(args.currentMobileTower.speed.toString())
        binding.roundingEditText.setText(args.currentMobileTower.rounding.toString())
        binding.radiusEditText.setText(args.currentMobileTower.radius.toString())
        binding.shootingPointsNumberEditText.setText(args.currentMobileTower.shootingPointsNumber.toString())
        binding.heightEditText.setText(args.currentMobileTower.height.toString())
        binding.tiltAngleEditText.setText(args.currentMobileTower.tiltAngle.toString())
        binding.missionNameEditText.setText(args.currentMobileTower.name)

        //Saving button
        binding.addButton.setOnClickListener{
            updateData()
        }

        //Navigation buttons
        binding.backButton.setOnClickListener{
            findNavController().navigate(R.id.action_updateMobileTowerFragment_to_missionListControlPanelFragment)
        }
        binding.closeButton.setOnClickListener{
            findNavController().navigate(R.id.action_updateMobileTowerFragment_to_missionListControlPanelFragment)
        }

        return binding.root
    }

    private fun updateData(){
        val speed = binding.speedEditText.text
        val rounding = binding.roundingEditText.text
        val radius = binding.radiusEditText.text
        val shootingPointsNumber = binding.shootingPointsNumberEditText.text
        val height = binding.heightEditText.text
        val titleAngle = binding.tiltAngleEditText.text
        val missionName = binding.missionNameEditText.text.toString()

        if (inputCheck(speed, rounding, radius, shootingPointsNumber, height, titleAngle, missionName)) {

            val updateMobileTower = MobileTower(args.currentMobileTower.id,
                "MobileTower",
                Integer.parseInt(speed.toString()),
                Integer.parseInt(rounding.toString()),
                Integer.parseInt(radius.toString()),
                Integer.parseInt(shootingPointsNumber.toString()),
                Integer.parseInt(height.toString()),
                Integer.parseInt(titleAngle.toString()),
                missionName,
                "Кодинское/Тагариенское",
                "12.04.2022",
                54,
                43,
                23)

            mMobileTowerViewModel.updateMobileTower(updateMobileTower)
            Toast.makeText(requireContext(), "Мобильная вышка обновлена", Toast.LENGTH_SHORT).show()
            //Navigate back
            findNavController().navigate(R.id.action_updateMobileTowerFragment_to_missionListControlPanelFragment)
        }else{
            Toast.makeText(requireContext(), "Заполните все поля", Toast.LENGTH_SHORT).show()
        }

    }

    private fun inputCheck(
        speed: Editable,
        rounding: Editable,
        radius: Editable,
        shootingPointsNumber: Editable,
        height: Editable,
        titleAngle: Editable,
        missionName: String
    ): Boolean {
        return (!speed.isEmpty() &&
                !rounding.isEmpty() &&
                !radius.isEmpty() &&
                !shootingPointsNumber.isEmpty() &&
                !height.isEmpty() &&
                !titleAngle.isEmpty() &&
                !TextUtils.isEmpty(missionName))
    }
}