package com.example.rickandmortyapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rickandmortyapp.adapter.ResultsAdapter
import com.example.rickandmortyapp.api.Api
import com.example.rickandmortyapp.api.Repository
import com.example.rickandmortyapp.api.ResultModel
import com.example.rickandmortyapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var binding: ActivityMainBinding? = null
    lateinit var adapter: ResultsAdapter
    var characterList = mutableListOf<ResultModel>()

    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this, MainViewModelFactory(Repository(Api.apiService)))
            .get(MainViewModel::class.java)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding?.root)

        viewModel.charactersLiveData.observe(this, { list ->

            characterList.addAll(list)
            adapter.notifyDataSetChanged()

        })

        setUp(binding!!)


    }

    override fun onResume() {
        super.onResume()

    }


    private fun setUp(binding: ActivityMainBinding) {


        adapter = ResultsAdapter(characterList)
        binding.charctersRecycleView.layoutManager = LinearLayoutManager(this)
        binding.charctersRecycleView.adapter = adapter


    }
}