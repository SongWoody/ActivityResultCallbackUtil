package com.woody.activityresultcallbackutil.core

import android.annotation.SuppressLint
import android.content.Intent
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.woody.activityresultcallbackutil.Main2Activity

@SuppressLint("Registered")
open class BaseActivity : AppCompatActivity() {
    val activityResultHelper: ActivityResultHelper by lazy {
        ActivityResultHelper(this)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val resultText = data!!.getStringExtra(Main2Activity.KEY_RESULT_TEXT)
        activityResultHelper.notifyActResultObserver(requestCode, resultCode, data)
    }
}