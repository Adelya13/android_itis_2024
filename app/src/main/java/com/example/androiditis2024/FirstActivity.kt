package com.example.androiditis2024


import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.androiditis2024.databinding.FirstActivityBinding

class FirstActivity: AppCompatActivity() {

    private var binding: FirstActivityBinding? = null

    private val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        if (it.resultCode == Activity.RESULT_OK) {
            it.data?.extras?.let {

            }
        }
    }

    private val permissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) {isGranted: Boolean ->
        if (isGranted) {

        } else {

        }

    }

    private val mPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) {
        val isCameraGranted = it[Manifest.permission.CAMERA]
        if (isCameraGranted == true) {

        } else {

        }

    }



    @SuppressLint("QueryPermissionsNeeded")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.first_activity)

        binding = FirstActivityBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }

        launcher.launch(Intent(this, SecondActivity::class.java))
        permissionLauncher.launch(Manifest.permission.CAMERA)

//        startActivityForResult(
//            Intent(this, SecondActivity::class.java),
//            REQUEST_CODE
//        )
    }
//
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        when (resultCode){
//            REQUEST_CODE -> {
//
//            }
//
//        }
//        super.onActivityResult(requestCode, resultCode, data)
//    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

    companion object{
        private const val REQUEST_CODE = 111
    }
}