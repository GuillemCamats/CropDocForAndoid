package com.example.cropdoc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import java.io.BufferedReader

class SelectTerrainActivity : AppCompatActivity() {
    lateinit var list :ListView
    lateinit var createTerrain: Button
    lateinit var selectTerrain: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_terrain)
        list = findViewById(R.id.terrainsList)
        createTerrain = findViewById(R.id.createTerrain)
        selectTerrain = findViewById(R.id.selectTerrain)
        val arrayAdapter: ArrayAdapter<*>
        val namesTerrains = arrayOf(Terrains.getTerrainsListNames())
        arrayAdapter = ArrayAdapter(this,
            android.R.layout.simple_list_item_1, namesTerrains)
        list.adapter = arrayAdapter

        list.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            // This is your listview's selected item
            val item = parent.getItemAtPosition(position) as Terrains
        }
    }// agafar el item i passarlo a la seguent activitat sigui, crear un nou terreno, o que hagi seleccional el terreno, i guardarho, i desde el nom s'hafegeix el marcador al terreny corresponent.

}