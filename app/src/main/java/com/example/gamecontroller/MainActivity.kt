package com.example.gamecontroller

import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.example.gamecontroller.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), controller.AndroidCallback {

    private lateinit var binding: ActivityMainBinding
    private val vibrator by lazy {
        getSystemService(
        Context.VIBRATOR_SERVICE) as Vibrator
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        controller.Controller.subscribeCallback(this)
        controller.Controller.run()
        registerButtons()
        setContentView(binding.root)
    }

    private fun vibrate(){
        vibrator.vibrate(
            VibrationEffect.createOneShot(
                50, VibrationEffect.DEFAULT_AMPLITUDE))
    }

    private fun registerButtons() {
        binding.btnDown.setOnClickListener {
            vibrate()
            controller.Controller.move(controller.Controller.DOWN)
        }
        binding.btnUp.setOnClickListener {
            vibrate()
            controller.Controller.move(controller.Controller.UP)
        }
        binding.btnLeft.setOnClickListener {
            vibrate()
            controller.Controller.move(controller.Controller.LEFT)
        }
        binding.btnRight.setOnClickListener {
            vibrate()
            controller.Controller.move(controller.Controller.RIGHT)
        }
    }

    override fun error(p0: String?) {
        Toast.makeText(baseContext, p0, Toast.LENGTH_LONG).show()
    }

    override fun ready() {
        Toast.makeText(baseContext, "READY", Toast.LENGTH_LONG).show()
    }

}