package com.example.androiditis2024


import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.androiditis2024.databinding.FirstActivityBinding

class FirstActivity: AppCompatActivity() {

    private var binding: FirstActivityBinding? = null
    var value = 0

    @SuppressLint("QueryPermissionsNeeded")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.first_activity)

        binding = FirstActivityBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }

        savedInstanceState?.let{
            value = it.getInt(VALUE_ARGS)
            Log.e("ACTIVITY_VALUE", value.toString())
            binding?.tvValue?.text = value.toString()
        }


        binding?.let{
            with(it){
                button1.setOnClickListener{
                    value++
                    tvValue.text = value.toString()
                }
                button2.setOnClickListener{
                   SecondActivity.start(this@FirstActivity, value)
                }
                button3.setOnClickListener{
                    val webIntent = Uri.parse("https://www.android.com").let { webpage ->
                            Intent(Intent.ACTION_VIEW, webpage)
                    }

                    val chooserIntent = Intent.createChooser(
                        webIntent,
                        "Chooser"
                    )

                    if (intent.resolveActivity(packageManager) != null) {
                        startActivity(chooserIntent)
                    }
                }
            }
        }

        Log.e("ACTIVITY_123","onCreate")


    }



    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(VALUE_ARGS, value)
    }

    override fun onStart() {
        super.onStart()
        Log.e("ACTIVITY_123","onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.e("ACTIVITY_123","onResume")

    }

    override fun onPause() {
        super.onPause()
        Log.e("ACTIVITY_123","onPause")

    }

    override fun onStop() {
        super.onStop()
        Log.e("ACTIVITY_123","onStop")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("ACTIVITY_123","onDestroy")

    }

    companion object {
         const val VALUE_ARGS = "VALUE_ARG"
    }

}