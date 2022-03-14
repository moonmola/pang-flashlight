package com.moonmola.pang_flashlight

import android.content.Context
import android.content.Intent
import android.hardware.camera2.CameraManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.moonmola.pang_flashlight.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.switchButton.setOnClickListener{
            binding.switchButton.isSelected = !binding.switchButton.isSelected
            cameraFlashOnOff(binding.switchButton.isSelected)
        }

    }

    private fun cameraFlashOnOff(isOn: Boolean) {
        val cameraManager = applicationContext.getSystemService(Context.CAMERA_SERVICE) as CameraManager
        val cameraId = cameraManager.cameraIdList[0]
        if (isOn) {
            cameraManager.setTorchMode(cameraId, true)
        } else {
            cameraManager.setTorchMode(cameraId, false)
        }
    }
}