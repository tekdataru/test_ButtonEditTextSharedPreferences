package ru.tekdata.test_buttonedittextsharedpreferences

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings.Global.putString
import ru.tekdata.test_buttonedittextsharedpreferences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val prefs = getSharedPreferences("tekdata_ru", Context.MODE_PRIVATE)


        prefs.getString("tekdata_manual_counter", "0")?.let { binding.editText.setText(it) }




        binding.buttonUp.setOnClickListener {
            val buf = binding.editText.text.toString().toInt() + 1
            binding.editText.setText(buf.toString())

            prefs.edit().apply {
                putString("tekdata_manual_counter", buf.toString())
                commit()
            }
        }

    }
}