package com.galaxy.cropdoc

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.cropdoc.R
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (SharedApp.prefs.name.toString() != "def_val"){
           parseToObj()
        }

        val buttonClick = findViewById<Button>(R.id.fotoCrop)
        buttonClick.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
        val buttonClick2 = findViewById<Button>(R.id.connectLg)
        buttonClick2.setOnClickListener {
            val intent = Intent(this, MainActivity3::class.java)
            startActivity(intent)
        }
        val sendkmls = findViewById<Button>(R.id.kmlsIni)
        sendkmls.setOnClickListener {
            val intent = Intent(this, TerrainToKml::class.java)
            startActivity(intent)
        }
        val about = findViewById<Button>(R.id.about)
        about.setOnClickListener {
            val intent = Intent(this, About::class.java)
            startActivity(intent)
        }
        val demos = findViewById<Button>(R.id.demosKml)
        demos.setOnClickListener {
            val intent = Intent(this, DemosActivity::class.java)
            startActivity(intent)
        }
    }

    private fun parseToObj(){
        val objects = SharedApp.prefs.name.toString()
        val list: List<Terrains> = Gson().fromJson(objects, Array<Terrains>::class.java).toList()
        for(elem in list){
            Terrains.terrainsList.add(elem)
        }
    }


}