package com.example.gamecontroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.gamecontroller.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), controller.AndroidCallback {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        controller.Controller.subscribeCallback(this)
        controller.Controller.run()
        registerButtons()
        setContentView(binding.root)
    }

    private fun registerButtons() {
        binding.btnDown.setOnClickListener {
            controller.Controller.move(controller.Controller.DOWN)
        }
        binding.btnUp.setOnClickListener {
            controller.Controller.move(controller.Controller.UP)
        }
        binding.btnLeft.setOnClickListener {
            controller.Controller.move(controller.Controller.LEFT)
        }
        binding.btnRight.setOnClickListener {
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