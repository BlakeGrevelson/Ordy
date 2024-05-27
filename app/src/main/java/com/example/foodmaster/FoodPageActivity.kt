package com.example.foodmaster

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class FoodPageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_page)

        val image: ImageView = findViewById(R.id.foodPageImage)
        val title: TextView = findViewById(R.id.foodPageTitle)
        val text: TextView = findViewById(R.id.foodPageText)

        image.setImageResource(intent.getIntExtra("foodImage", 0))
        title.text = intent.getStringExtra("foodTitle")
        text.text = intent.getStringExtra("foodText")


    }
}