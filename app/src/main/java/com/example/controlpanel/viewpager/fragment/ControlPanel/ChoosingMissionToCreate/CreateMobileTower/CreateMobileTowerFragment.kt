package com.example.controlpanel.viewpager.fragment.ControlPanel.ChoosingMissionToCreate.CreateMobileTower

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
import com.example.controlpanel.data.model.typeMission.MobileTower.MobileTower
import com.example.controlpanel.data.viewmodel.MobileTowerViewModel
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
        val speed = binding.speedEditText.text
        val rounding = binding.roundingEditText.text
        val radius = binding.radiusEditText.text
        val shootingPointsNumber = binding.shootingPointsNumberEditText.text
        val height = binding.heightEditText.text
        val titleAngle = binding.tiltAngleEditText.text
        val missionName = binding.missionNameEditText.text.toString()

        if (inputCheck(speed, rounding, radius, shootingPointsNumber, height, titleAngle, missionName)) {
            //Create MobileTower
            val mobileTower = MobileTower(0,
                "MobileTower",
                true,
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

            mMobileTowerViewModel.addMobileTower(mobileTower)
                Toast.makeText(requireContext(), "Мобильная вышка создана", Toast.LENGTH_SHORT).show()
                //Navigate back
                findNavController().navigate(R.id.action_createMobileTowerFragment_to_missionListControlPanelFragment)
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
