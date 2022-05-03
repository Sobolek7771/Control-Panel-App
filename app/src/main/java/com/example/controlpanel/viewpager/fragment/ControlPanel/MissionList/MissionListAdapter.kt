package com.example.controlpanel.viewpager.fragment.ControlPanel.MissionList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.controlpanel.R
import com.example.controlpanel.data.model.typeMission.ArealShooting.ArealShooting
import com.example.controlpanel.data.model.typeMission.MobileTower.MobileTower
import com.example.controlpanel.databinding.MissionItemBinding

class MissionListAdapter: RecyclerView.Adapter<MissionListAdapter.ViewHolder>() {


    var missionList = mutableListOf<Any>()
    private var previousExpandedPosition = -1
    private var mExpandedPosition = -1

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val binding = MissionItemBinding.bind(itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.mission_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //Draw objects
        val currentItem = missionList[position]
        if (currentItem is MobileTower){
            holder.binding.iconView.setImageResource(R.drawable.ic_mobile_tower)
            holder.binding.missionNameView.text = currentItem.name
            holder.binding.addressView.text = currentItem.address
            holder.binding.dateTextView.text = currentItem.creationDate
        }else if (currentItem is ArealShooting){
            holder.binding.iconView.setImageResource(R.drawable.ic_areal_shooting)
            holder.binding.missionNameView.text = currentItem.name
            holder.binding.addressView.text = currentItem.address
            holder.binding.dateTextView.text = currentItem.creationDate
        }

        //Expand function
        val isExpanded = (position==mExpandedPosition)
        //Expand group
        holder.binding.popOutMenuGroup.visibility = if(isExpanded){View.VISIBLE}else{View.GONE}
        //Expand button
        holder.binding.expandButton.setImageResource( if (isExpanded){ R.drawable.ic_expand_open }else{ R.drawable.ic_expand_closed })
        if (isExpanded) previousExpandedPosition = position

        holder.binding.expandButton.setOnClickListener{
            if ( isExpanded){ mExpandedPosition = -1 }else{ mExpandedPosition = position }
            notifyItemChanged(previousExpandedPosition)
            notifyItemChanged(position)
        }



        //Edit button
        holder.binding.editButton.setOnClickListener{
            if (currentItem is MobileTower){
                val action = MissionListFragmentDirections.actionMissionListControlPanelFragmentToUpdateMobileTowerFragment(currentItem)
                holder.itemView.findNavController().navigate(action)
            }else if(currentItem is ArealShooting){
                val action = MissionListFragmentDirections.actionMissionListControlPanelFragmentToUpdateArealShootingFragment(currentItem)
                holder.itemView.findNavController().navigate(action)
            }
        }

        //SeekBar
        holder.binding.seekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                when (p1){
                    0 -> holder.binding.toShowTextView.text = "все точки"
                    1 -> holder.binding.toShowTextView.text = "ключевые точки"
                    2 -> holder.binding.toShowTextView.text = "старт"
                    3 -> holder.binding.toShowTextView.text = "финиш"
                }
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }
        })
    }

    override fun getItemCount(): Int {
        return missionList.size
    }

    fun setData(mission: List<Any>){
        this.missionList.addAll(mission)
        notifyDataSetChanged()
    }
}