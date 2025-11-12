package com.daftarmahasiswa.app

object MahasiswaRepository {
    private val mahasiswas = ArrayList<Mahasiswa>()

    fun getAllMahasiswas(): List<Mahasiswa> {
        return mahasiswas
    }

    fun addMahasiswa(mahasiswa: Mahasiswa) {
        mahasiswas.add(mahasiswa)
    }
}
