package com.woody.activityresultcallbackutil

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.woody.activityresultcallbackutil.core.BaseActivity
import com.woody.activityresultcallbackutil.databinding.ActivityMain2Binding

class Main2Activity : BaseActivity() {
    companion object {
        const val REQUEST_CODE = 9000
        const val KEY_RESULT_TEXT = "key_result_text"
    }

    private lateinit var binding : ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main2)

        binding.sendResult.setOnClickListener() {
            val resultText = binding.resultEditText.text.toString()
            val dataIntent = Intent()
            dataIntent.putExtra(KEY_RESULT_TEXT, resultText)
            setResult(Activity.RESULT_OK, dataIntent)
            finish()
        }

    }
}
