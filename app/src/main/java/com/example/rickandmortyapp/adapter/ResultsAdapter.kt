package com.example.rickandmortyapp.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.rickandmortyapp.api.ResultModel
import com.example.rickandmortyapp.databinding.CharacterItemLayoutBinding

class ResultsAdapter(val charcterlist: List<ResultModel>):RecyclerView.Adapter<ResultsAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: CharacterItemLayoutBinding):RecyclerView.ViewHolder(binding.root){

        fun bind(resultModel: ResultModel){
            binding.characterImageView.load(resultModel.image)
            binding.nameTextView.text = resultModel.name
            binding.speciesTextView.text = resultModel.species
            binding.statusTextView.text = resultModel.status


            when(resultModel.status){
                "Alive" -> binding.statusTextView.setTextColor(Color.parseColor("#32CD32"))
                "Alive "-> binding.statusTextView.setTextColor(Color.parseColor("#00FF00"))
                "Dead" -> binding.statusTextView.setTextColor(Color.parseColor("#FF0000"))
                else ->{
                    binding.statusTextView.setTextColor(Color.parseColor("#FF8C00"))
                }
            }

            when(resultModel.species){
                "Human" -> binding.speciesTextView.setTextColor(Color.parseColor("#0000FF"))
                else->{
                    binding.speciesTextView.setTextColor(Color.parseColor("#008000"))
                }
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            CharacterItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bind(charcterlist[position])
    }

    override fun getItemCount(): Int {
        return charcterlist.size
    }
}