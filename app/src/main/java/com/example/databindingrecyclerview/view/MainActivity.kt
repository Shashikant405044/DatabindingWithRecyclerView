package com.example.databindingrecyclerview.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.databindingrecyclerview.R
import com.example.databindingrecyclerview.adapter.DataModelAdapter
import com.example.databindingrecyclerview.databinding.ActivityMainBinding
import com.example.databindingrecyclerview.factory.MainViewModelFactory
import com.example.databindingrecyclerview.model.DataModel
import com.example.databindingrecyclerview.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
  private var viewManager = LinearLayoutManager(this)
  private lateinit var binding: ActivityMainBinding
   private lateinit var mainViewModel: MainViewModel
   private lateinit var mainViewModelFactory: MainViewModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        mainViewModelFactory = MainViewModelFactory()
        mainViewModel = ViewModelProvider(this,mainViewModelFactory)[MainViewModel::class.java]
        binding.button.setOnClickListener( View.OnClickListener {

            dataInsert()
        })
        initializeAdapter()
    }

    private fun initializeAdapter() {

        binding.titleRecyclerView.layoutManager = viewManager
        observerData()
    }

    private fun observerData() {
        mainViewModel.firstData.observe(this, Observer {

            binding.titleRecyclerView.adapter = DataModelAdapter(it,mainViewModel,this)
        })
    }

    private fun dataInsert() {
        val titleData = binding.editTextTextPersonName2.text.toString()
        if (titleData.isNullOrBlank())
        { Toast.makeText(this, "Enter The Values", Toast.LENGTH_SHORT).show()
        }

        else{
            val dataModel = DataModel(titleData)
            mainViewModel.add(dataModel)
            binding.editTextTextPersonName2.text.clear()
            binding.titleRecyclerView.adapter?.notifyDataSetChanged()
        }
    }
}