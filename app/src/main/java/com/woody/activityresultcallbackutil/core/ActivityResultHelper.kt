package com.woody.activityresultcallbackutil.core

import android.content.Intent
import android.util.SparseArray
import androidx.appcompat.app.AppCompatActivity

/**
 * Activity 의 onActivityResult 를 간단하게 사용하기 위해 생성
 */
typealias activityResultCallback = (resultCode: Int, data: Intent?) -> Unit

class ActivityResultHelper(private val mContext: AppCompatActivity) {
    private val mActResultNotifications =
        SparseArray<activityResultCallback>()


    fun notifyActResultObserver(
        requestCode: Int,
        resultCode: Int,
        data: Intent?
    ) {
        mActResultNotifications[requestCode]?.let {
            it(resultCode, data)
            mActResultNotifications.delete(requestCode)
        }
    }

    /**
     * observer 추가 및 startActivityForResult 실행
     */
    fun addActResultObserver(
        intent: Intent,
        requestCode: Int,
        atcResultObserver: activityResultCallback
    ) {
        mActResultNotifications.append(requestCode, atcResultObserver)
        mContext.startActivityForResult(intent, requestCode)
    }
}