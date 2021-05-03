package com.diargegaj.horoscopeinfo.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.diargegaj.horoscopeinfo.R
import com.diargegaj.horoscopeinfo.adapter.SignsTitleAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        val adapter = SignsTitleAdapter()
        adapter.setSigns(getAllSigns())

        signsRecyclerView.layoutManager = GridLayoutManager(this, 2)
        signsRecyclerView.adapter = adapter
    }

    private fun getAllSigns(): List<String> {
        val signsNames = mutableListOf<String>()

        signsNames.add("Aries")
        signsNames.add("Taurus")
        signsNames.add("Gemini")
        signsNames.add("Cancer")
        signsNames.add("Leo")
        signsNames.add("Virgo")
        signsNames.add("Libra")
        signsNames.add("Scorpio")
        signsNames.add("Sagittarius")
        signsNames.add("Capricorn")
        signsNames.add("Aquarius")
        signsNames.add("Pisces")

        return signsNames
    }
}