package com.example.controlpanel.viewpager.fragment.ControlPanel.MissionList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.controlpanel.R
import com.example.controlpanel.data.viewmodel.ArealShootingViewModel
import com.example.controlpanel.data.viewmodel.MobileTowerViewModel
import com.example.controlpanel.databinding.FragmentMissionListControlPanelBinding

class MissionListFragment : Fragment() {
    private var _binding: FragmentMissionListControlPanelBinding? = null
    private val binding get() = _binding!!

    private lateinit var mMobileTowerViewModel: MobileTowerViewModel
    private lateinit var mArealShootingViewModel: ArealShootingViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMissionListControlPanelBinding.inflate(inflater, container, false)

        //RecyclerView
        val adapter = MissionListAdapter()
        val recyclerView = binding.recyclerview
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        //MobileTowerViewMode
        mMobileTowerViewModel = ViewModelProvider(this).get(MobileTowerViewModel::class.java)
        mMobileTowerViewModel.readAllData.observe(viewLifecycleOwner, Observer { mobileTower->
            adapter.setData(mobileTower)
        })

        //ArealShootingViewMode
        mArealShootingViewModel = ViewModelProvider(this).get(ArealShootingViewModel::class.java)
        mArealShootingViewModel.readAllData.observe(viewLifecycleOwner, Observer { arealShooting->
            adapter.setData(arealShooting)
        })

        //Add button
        binding.addMissionButton.setOnClickListener {
            findNavController().navigate(R.id.action_missionListControlPanelFragment_to_choosingMissionToCreateFragment)
        }

        binding.searchButton.setOnClickListener{
            if (binding.searchEditText.visibility == View.GONE){
                binding.searchEditText.visibility = View.VISIBLE
                binding.searchButton.setBackgroundResource(R.drawable.submenu_selected)
            }else{
                binding.searchEditText.visibility = View.GONE
                binding.searchButton.setBackgroundResource(R.drawable.submenu_normal)
            }
        }

        return binding.root
    }
}

