package com.my.testing.slider

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.my.imageslider.R
import com.my.imageslider.SliderViewAdapter


class SliderAdapter(val context: Context) : SliderViewAdapter<SliderAdapter.SliderAdapterVH>() {
    private var sliderList:List<SliderItem> = ArrayList()

    class SliderAdapterVH(itemView: View?) : SliderViewAdapter.ViewHolder(itemView) {
         var imageViewBackground:ImageView = itemView!!.findViewById(R.id.iv_auto_image_slider)
         var textViewDescription:TextView = itemView!!.findViewById(R.id.tv_auto_image_slider)
         var imageGifContainer:ImageView = itemView!!.findViewById(R.id.iv_gif_container)
    }

    override fun getCount(): Int {
        return sliderList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?): SliderAdapterVH {
        val view = LayoutInflater.from(parent!!.context).inflate(R.layout.image_slider_layout_item,parent,false)
        return SliderAdapterVH(view)
    }

    override fun onBindViewHolder(viewHolder: SliderAdapterVH?, position: Int) {
        val sliderItem = sliderList[position]

        viewHolder!!.textViewDescription.text = sliderItem.description
        viewHolder!!.textViewDescription.textSize = 16f
        viewHolder!!.textViewDescription.setTextColor(Color.WHITE)
        Glide.with(viewHolder.itemView)
            .load(sliderItem.imageUrl)
            .fitCenter()
            .into(viewHolder.imageViewBackground)
    }

    fun setSliderItems(list: List<SliderItem>) {
        sliderList=list
       notifyDataSetChanged()
    }

}