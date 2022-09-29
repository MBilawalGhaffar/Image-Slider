package com.my.imageslider

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.my.imageslider.IndicatorView.animation.type.IndicatorAnimationType
import com.my.testing.slider.SliderAdapter
import com.my.testing.slider.SliderItem

class MainActivity : AppCompatActivity() {
    private lateinit var sliderView: SliderView
    private lateinit var adapter: SliderAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter=SliderAdapter(this)
        sliderView=findViewById(R.id.imageSlider)
        sliderView.setSliderAdapter(adapter)
        sliderView.setIndicatorAnimation(IndicatorAnimationType.DROP)
        //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION)
        sliderView.autoCycleDirection = SliderView.AUTO_CYCLE_DIRECTION_RIGHT
        sliderView.indicatorSelectedColor = Color.WHITE
        sliderView.indicatorUnselectedColor = Color.GRAY
        sliderView.scrollTimeInSec = 3
        sliderView.isAutoCycle = true
        sliderView.startAutoCycle()
        sliderView.setOnIndicatorClickListener {
            Log.i("GGG",
                "onIndicatorClicked: " + sliderView.currentPagePosition)
        }
        val list : List<SliderItem> = listOf(
            SliderItem("Image 1","https://images.pexels.com/photos/398154/pexels-photo-398154.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load"),
            SliderItem("Image 2","https://images.pexels.com/photos/415590/pexels-photo-415590.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load"),
            SliderItem("Image 3","https://images.pexels.com/photos/2246803/pexels-photo-2246803.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load"),
            SliderItem("Image 4","https://images.pexels.com/photos/2830460/pexels-photo-2830460.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load"),
            SliderItem("Image 4","https://images.pexels.com/photos/2246803/pexels-photo-2246803.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load")

        )
        adapter.setSliderItems(list)
    }
}