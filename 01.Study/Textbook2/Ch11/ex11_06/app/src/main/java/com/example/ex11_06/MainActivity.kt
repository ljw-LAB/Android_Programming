package com.example.ex11_06

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import com.example.ex11_06.databinding.ActiveDrawerBinding

class MainActivity : AppCompatActivity() {
    lateinit var toggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.active_drawer)

        val binding = ActiveDrawerBinding.inflate(layoutInflater)
        toggle = ActionBarDrawerToggle(this, binding.drawer, R.string.app_name, R.string.appbar_scrolling_view_behavior)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toggle.syncState()
        setContentView(binding.root)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item))
        {
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}