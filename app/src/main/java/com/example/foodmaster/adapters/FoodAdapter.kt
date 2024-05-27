package com.example.foodmaster.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.foodmaster.FoodPageActivity
import com.example.foodmaster.R
import com.example.foodmaster.models.Food

class FoodAdapter(private var dishes: List<Food>, private var context: Context): RecyclerView.Adapter<FoodAdapter.MyViewHolder>() {

    class MyViewHolder(view: View): RecyclerView.ViewHolder(view){
        val image: ImageView = view.findViewById(R.id.foodImage)
        val title: TextView = view.findViewById(R.id.foodTitle)
        val anons: TextView = view.findViewById(R.id.foodAnons)
        val btn: Button = view.findViewById(R.id.foodBtn)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.category_item, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dishes.count()
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val imageId = context.resources.getIdentifier(
            dishes[position].image,
            "drawable",
            context.packageName
        )

        holder.title.text = dishes[position].title
        holder.anons.text = dishes[position].anons
        holder.image.setImageResource(imageId)

        holder.btn.setOnClickListener{
            val intent = Intent(context, FoodPageActivity::class.java)

            intent.putExtra("foodImage",imageId)
            intent.putExtra("foodTitle",dishes[position].title)
            intent.putExtra("foodText",dishes[position].text)


            context.startActivity(intent)
        }
    }

}