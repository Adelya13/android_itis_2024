package com.example.androiditis2024


import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.androiditis2024.AnimeRepository.anime
import com.example.androiditis2024.databinding.FirstActivityBinding

class FirstActivity: AppCompatActivity() {

    private var binding: FirstActivityBinding? = null

    @SuppressLint("QueryPermissionsNeeded")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.first_activity)

        binding = FirstActivityBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }

        binding?.let {
            it.rvAnime.adapter = AnimeAdapter(
                list = anime,
                glide = Glide.with(this)
            ) { anime ->
                it.root.showSnackBar(anime.name)

            }
            it.rvAnime.layoutManager = LinearLayoutManager(this)
        }
        setSupportActionBar(findViewById(R.id.base_toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

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