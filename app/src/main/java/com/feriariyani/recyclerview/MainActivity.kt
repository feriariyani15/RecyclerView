package com.feriariyani.recyclerview

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.feriariyani.recyclerview.adapter.AdapterTeamBola
import com.feriariyani.recyclerview.databinding.ActivityMainBinding
import com.feriariyani.recyclerview.model.Pemain

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listPemain = ArrayList<Pemain>()
        listPemain.add(Pemain("Pratama Arhan Alif Rifai",R.drawable.arhan, "Bek kiri", "1,7m", "Blora", "21 Desember 2001"))
        listPemain.add(Pemain("Asnawi Mangkualam",R.drawable.asnawi, "Gelandang/Bek Kanan", "1,75m", "Makassar", "04 Oktober 1999"))
        listPemain.add(Pemain("Alfeandra Dewangga Santosa",R.drawable.alfeandra, "Bek Kanan", "1,77m", "Semarang", "28 Juni 2001"))
        listPemain.add(Pemain("Kanu Helmiawan",R.drawable.kanu,"Gelandang", "1,76m", "Jakarta", "27 April 2001"))

        binding.list.adapter = AdapterTeamBola( this,listPemain, object : AdapterTeamBola.OnClickListener {
            override fun detailData(item: Pemain?) {
                Dialog(this@MainActivity).apply{
                    requestWindowFeature(Window.FEATURE_NO_TITLE)
                    setCancelable(true)
                    setContentView(R.layout.detail_data_pemain)

                    val image = this.findViewById<ImageView>(R.id.image_pemain)
                    val nama = this.findViewById<TextView>(R.id.txt_namapemain)
                    val posisi = this.findViewById<TextView>(R.id.txt_posisi)
                    val tinggi = this.findViewById<TextView>(R.id.txt_tinggibadan)
                    val tempatlahir = this.findViewById<TextView>(R.id.txt_tempatlahir)
                    val tgllahir = this.findViewById<TextView>(R.id.txt_tanggallahir)
                    val btn = this.findViewById<Button>(R.id.btnClose)

                    image.setImageResource(item?.foto ?:0)
                    nama.text = "${item?.nama}"
                    posisi.text = "${item?.posisi}"
                    tinggi.text ="${item?.tinggi}"
                    tempatlahir.text ="${item?.tempatlahir}"
                    tgllahir.text = "${item?.tgllahir}"

                    btn.setOnClickListener {
                        this.dismiss()
                    }

                }.show()
            }

        })

    }
}