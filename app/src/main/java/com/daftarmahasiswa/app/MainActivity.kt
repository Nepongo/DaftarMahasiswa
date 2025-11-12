package com.daftarmahasiswa.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import android.content.Intent

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNav: BottomNavigationView = findViewById(R.id.bottom_navigation)
        val fab: FloatingActionButton = findViewById(R.id.fab_add_note)

        // 1. Muat Fragment default
        loadFragment(MahasiswaListFragment())

        // 2. Tangani klik BottomNav
        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_mahasiswa -> {
                    loadFragment(MahasiswaListFragment())
                    true
                }
                else -> false
            }
        }

        // 3. Tangani klik FAB
        fab.setOnClickListener {
            val intent = Intent(this, AddMahasiswaActivity::class.java)
            startActivity(intent)
        }
    }

    // Fungsi helper untuk memuat Fragment
    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}