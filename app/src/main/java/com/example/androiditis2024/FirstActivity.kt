package com.example.androiditis2024


import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.androiditis2024.AnimeRepository.baseItems
import com.example.androiditis2024.databinding.FirstActivityBinding

class FirstActivity: AppCompatActivity() {

    private var binding: FirstActivityBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.first_activity)

        binding = FirstActivityBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }


        binding?.let {
            val dividerItemDecoration = DividerItemDecoration(this, RecyclerView.VERTICAL)
            val spaceDecorator = SpaceItemDecorator(this, 8f)

            it.swipeRefresh.setOnRefreshListener {
//                onRefresh()
            }

            it.rvAnime.adapter = AnimeAdapter(
                list = baseItems,
                glide = Glide.with(this)
            ) { anime ->
                it.root.showSnackBar((anime as BaseItemModel.AnimeUiModel).name)
            }.also {
                it.setHasStableIds(true)
            }



            it.rvAnime.addItemDecoration(dividerItemDecoration)
            it.rvAnime.addItemDecoration(spaceDecorator)
            it.rvAnime.layoutManager = LinearLayoutManager(this)
        }
        setSupportActionBar(findViewById(R.id.base_toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }

    private fun onRefresh() {
        //refresh
        binding?.swipeRefresh?.isRefreshing = false
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.new_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean  =
        when (item.itemId) {
            R.id.action_edit -> {
                Log.e("AppBar", "action_edit")
                true
            }
            R.id.action_save -> {
                Log.e("AppBar", "action_save")

                true
            }
            R.id.action_settings -> {
                Log.e("AppBar", "action_settings")
                true
            }

            android.R.id.home -> {
                onBackPressedDispatcher.onBackPressed()
                true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }
}