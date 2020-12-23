package com.woody.activityresultcallbackutil

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.woody.activityresultcallbackutil.core.BaseActivity
import com.woody.activityresultcallbackutil.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // button click
        binding.requestButton.setOnClickListener {
            // #1. observer 등록 및 intent 실행
            val intent = Intent(this, Main2Activity::class.java)
            activityResultHelper.addActResultObserver(intent, Main2Activity.REQUEST_CODE) { resultCode, data ->
                // #2 activity 결과 확인
                // BaseActivity 의 onActivityResult 에서 받은 결과를
                // ActivityResultHelper 를 통해 여기서 받게 됨
                if (resultCode == Activity.RESULT_OK && data != null) {
                    val resultText = data.getStringExtra(Main2Activity.KEY_RESULT_TEXT)
                    binding.resultText.text = resultText
                }
            }
        }
    }
}
