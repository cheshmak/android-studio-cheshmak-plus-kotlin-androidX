package com.cheshmak.cheshmakplussamplekotlin

import android.util.Log
import androidx.multidex.MultiDexApplication
import me.cheshmak.android.sdk.core.Cheshmak
import me.cheshmak.android.sdk.core.network.CheshmakCallback
import me.cheshmak.cheshmakplussdk.core.CheshmakPlus

class ApplicationClass : MultiDexApplication() {


    override fun onCreate() {

        super.onCreate()
        Log.e("----------", "MainActivity")

        Cheshmak.with(this@ApplicationClass)
        CheshmakPlus.with(this@ApplicationClass)
        Cheshmak.initTracker("7wIVoYj7zVV8GPlsq52oyg==", object : CheshmakCallback {
            override fun onCheshmakIdReceived(cheshmakID: String) {
                Log.e("----------", "CheshmakID = $cheshmakID")
            }
        })
        CheshmakPlus.setTestMode(true)
    }


}
