package com.example.recyclerview_axel_08

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    companion object{
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val superheroList = listOf<Superhero>(
            Superhero(
                R.drawable.merah,
                "Power Rangers Red",
                "Kekuatan Flamingo"
            ),
            Superhero(
                R.drawable.hitam,
                "Power Rangers Black",
                "Kekuatan Jerapah"
            ),
            Superhero(
                R.drawable.kuning,
                "Power Rangers Yellow",
                "Kekuatan Ikan Cupang"
            ),
            Superhero(
                R.drawable.pink,
                "Power Rangers",
                "Kekuatan Gagak"
            )
        )
        val recyclerView = findViewById<RecyclerView>(R.id.rv_hero)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = SuperheroAdapter(this, superheroList){
            val intent = Intent (this, DetailSuperheroActivity::class.java)
            intent.putExtra (INTENT_PARCELABLE,it)
            startActivity(intent)

        }
    }
}