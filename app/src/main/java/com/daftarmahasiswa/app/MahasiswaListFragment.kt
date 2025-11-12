package com.daftarmahasiswa.app

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MahasiswaListFragment : Fragment(R.layout.fragment_mahasiswa_list) {

    private lateinit var rvMahasiswas: RecyclerView
    private lateinit var mahasiswaAdapter: MahasiswaAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        rvMahasiswas = view.findViewById(R.id.rv_mahasiswas)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        val allMahasiswas = MahasiswaRepository.getAllMahasiswas()

        mahasiswaAdapter = MahasiswaAdapter(allMahasiswas) { mahasiswa ->
            val intent = Intent(activity, MahasiswaDetailActivity::class.java).apply {
                putExtra("EXTRA_KELAS", mahasiswa.kelas)
                putExtra("EXTRA_NAMA", mahasiswa.nama)
                putExtra("EXTRA_JENIS_KELAMIN", mahasiswa.jenisKelamin)
            }
            startActivity(intent)
        }

        rvMahasiswas.layoutManager = LinearLayoutManager(activity)
        rvMahasiswas.adapter = mahasiswaAdapter
    }

    override fun onResume() {
        super.onResume()
        if(::mahasiswaAdapter.isInitialized) {
          mahasiswaAdapter.notifyDataSetChanged()
        }
    }
}