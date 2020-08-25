package com.woody.activityresultcallbackutil

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.woody.activityresultcallbackutil.core.BaseActivity
import com.woody.activityresultcallbackutil.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.requestButton.setOnClickListener {
            val intent = Intent(this, Main2Activity::class.java)
            activityResultHelper.addActResultObserver(intent, Main2Activity.REQUEST_CODE) { resultCode, data ->
                if (resultCode == Activity.RESULT_OK && data != null) {
                    val resultText = data.getStringExtra(Main2Activity.KEY_RESULT_TEXT)
                    binding.resultText.text = resultText
                }
            }
        }
    }
}