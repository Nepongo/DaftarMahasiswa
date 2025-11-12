package com.daftarmahasiswa.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.RadioButton
import android.widget.Toast

class AddMahasiswaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_mahasiswa)

        val etKelas: EditText = findViewById(R.id.et_kelas)
        val etNama: EditText = findViewById(R.id.et_nama)
        val rgJenisKelamin: RadioGroup = findViewById(R.id.rg_jenis_kelamin)
        val btnSave: Button = findViewById(R.id.btn_save)

        btnSave.setOnClickListener {
            val kelas = etKelas.text.toString()
            val nama = etNama.text.toString()

            val selectedGenderId = rgJenisKelamin.checkedRadioButtonId

            if (kelas.isBlank() || nama.isBlank() || selectedGenderId == -1) {
                Toast.makeText(this, "Kelas, nama, dan jenis kelamin harus diisi", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val selectedRadioButton: RadioButton = findViewById(selectedGenderId)
            val jenisKelamin = selectedRadioButton.text.toString()

            val newMahasiswa = Mahasiswa(kelas, nama, jenisKelamin)
            MahasiswaRepository.addMahasiswa(newMahasiswa)

            finish()
        }
    }
}
