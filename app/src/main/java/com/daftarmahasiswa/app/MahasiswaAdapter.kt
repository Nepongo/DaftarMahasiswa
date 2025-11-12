package com.daftarmahasiswa.app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MahasiswaAdapter(
    private val mahasiswas: List<Mahasiswa>,
    private val onMahasiswaClicked: (Mahasiswa) -> Unit 
) : RecyclerView.Adapter<MahasiswaAdapter.MahasiswaViewHolder>() {

    class MahasiswaViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val kelasTextView: TextView = view.findViewById(R.id.tv_item_kelas)
        val namaTextView: TextView = view.findViewById(R.id.tv_item_nama)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MahasiswaViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_mahasiswa, parent, false)
        return MahasiswaViewHolder(view)
    }

    override fun getItemCount(): Int = mahasiswas.size

    override fun onBindViewHolder(holder: MahasiswaViewHolder, position: Int) {
        val mahasiswa = mahasiswas[position]
        holder.kelasTextView.text = mahasiswa.kelas
        holder.namaTextView.text = mahasiswa.nama

        holder.itemView.setOnClickListener {
            onMahasiswaClicked(mahasiswa)
        }
    }
}