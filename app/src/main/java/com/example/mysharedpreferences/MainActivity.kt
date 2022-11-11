package com.example.mysharedpreferences

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import com.example.mysharedpreferences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)
        setContentView(binding.root)
        val user = binding.user
        val pass = binding.pass


        val sharedPreferences:SharedPreferences = getSharedPreferences("myData",Context.MODE_PRIVATE)
        val username = sharedPreferences.getString("u", "None")
        val password = sharedPreferences.getString("p", "")
        user.setText(username)
        pass.setText(password)


        binding.login.setOnClickListener{
            val sharedPreferences:SharedPreferences = getSharedPreferences("myData", Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putString("u",user.text.toString())
            editor.putString("p", pass.text.toString())
            editor.apply()

            Toast.makeText(this, "Data Is Saved", Toast.LENGTH_SHORT).show()
        }

        binding.load.setOnClickListener{
            val sharedPreferences:SharedPreferences = getSharedPreferences("myData",Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()

            val username = sharedPreferences.getString("u", "None")
            val password = sharedPreferences.getString("p", "")
            user.setText(username)
            pass.setText(password)
        }

    }
}