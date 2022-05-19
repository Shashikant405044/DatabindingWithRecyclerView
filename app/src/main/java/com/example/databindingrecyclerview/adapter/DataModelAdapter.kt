package com.example.databindingrecyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.databindingrecyclerview.databinding.TitleListBinding
import com.example.databindingrecyclerview.model.DataModel
import com.example.databindingrecyclerview.viewmodel.MainViewModel

class DataModelAdapter(private var mllist : List<DataModel>,
                       val mainViewModel: MainViewModel, val context: Context)
    : RecyclerView.Adapter<DataModelAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var binding = TitleListBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.modelItem = mllist[position]
    }

    override fun getItemCount(): Int {
       return mllist.size
    }


    class MyViewHolder( var binding: TitleListBinding) : RecyclerView.ViewHolder(binding.root) {


    }
}