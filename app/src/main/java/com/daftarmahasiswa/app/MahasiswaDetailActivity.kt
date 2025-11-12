package com.daftarmahasiswa.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MahasiswaDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mahasiswa_detail)

        val tvKelas: TextView = findViewById(R.id.tv_detail_kelas)
        val tvNama: TextView = findViewById(R.id.tv_detail_nama)
        val tvJenisKelamin: TextView = findViewById(R.id.tv_detail_jenis_kelamin)

        val kelas = intent.getStringExtra("EXTRA_KELAS")
        val nama = intent.getStringExtra("EXTRA_NAMA")
        val jenisKelamin = intent.getStringExtra("EXTRA_JENIS_KELAMIN")

        tvKelas.text = kelas
        tvNama.text = nama
        tvJenisKelamin.text = "Jenis Kelamin: $jenisKelamin"
    }
}
