package com.fapna.tasktobedone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fapna.tasktobedone.databinding.ActivityMainBinding
import com.fapna.tasktobedone.model.SearchResponse
import kotlinx.coroutines.flow.catch

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_main)
        lifecycleScope.launchWhenStarted {
            viewModel.fetchFilms()
                .catch {
                    Log.e("Error", "Error")
                }
                .collect {
                    processResponse(it)
                }
        }
    }

    private fun processResponse(response: SearchResponse?) {
        if (response != null
            && !response.Search.isNullOrEmpty()
        ) {
            val adapter = FilmAdapter(response.Search)
            val rv = findViewById<RecyclerView>(R.id.film_list)
            rv.layoutManager = GridLayoutManager(this, 1, GridLayoutManager.VERTICAL, false)
            rv.layoutDirection = View.LAYOUT_DIRECTION_RTL
            rv.adapter = adapter
        }
    }
}