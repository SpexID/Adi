package com.example.adi

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rv_list_tour: RecyclerView
    private var list = ArrayList<item>()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv_list_tour = findViewById(R.id.rv_list)
        rv_list_tour.setHasFixedSize(true)

        list.addAll(listTours)
        showRecylerview()
    }

    private val listTours: ArrayList<item>
        get() {
            val dataTitle = resources.getStringArray(R.array.data_name)
            val datadesk = resources.getStringArray(R.array.data_description)
            val dataimage = resources.obtainTypedArray(R.array.data_photo)
            val datalist = ArrayList<item>()

            for (i in dataTitle.indices){
                val tour = item(
                    dataTitle[i],
                    datadesk[i],
                    dataimage.getResourceId(i, -1)
                )
                datalist.add(tour)
            }
            return datalist
        }
    fun showRecylerview(){
        rv_list_tour.layoutManager = LinearLayoutManager(this)
        rv_list_tour.adapter=itemadapter(list)
    }
}