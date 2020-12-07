package com.cheshmak.cheshmakplussamplekotlin

import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import me.cheshmak.cheshmakplussdk.advertise.*

class MainActivity : AppCompatActivity() {

    private var cheshmakInterstitialAd: CheshmakInterstitialAd? = null
    private var cheshmakRewardedAd: CheshmakRewardedAd? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cheshmakBannerAd = findViewById<CheshmakBannerAd>(R.id.cheshmak_banner)
        cheshmakBannerAd.setCallback(object : BannerCallback {
            override fun onAdLoaded() {
                Log.d("banner", "onAdLoaded")
            }

            override fun onAdOpened() {
                Log.d("banner", "onAdOpened")
            }

            override fun onAdFailedToLoad() {
                Log.d("banner", "onAdFailedToLoad")
            }

            override fun onAdClosed() {
                Log.d("banner", "onAdClosed")
            }
        })

        cheshmakInterstitialAd = CheshmakInterstitialAd(this, object : InterstitialCallback {
            override fun onAdLoaded() {
                Log.d("Interstitial", "onAdLoaded")
            }

            override fun onAdOpened() {
                Log.d("Interstitial", "onAdOpened")
            }

            override fun onAdFailedToLoad() {
                Log.d("Interstitial", "onAdFailedToLoad")
            }

            override fun onAdClosed() {
                Log.d("Interstitial", "onAdClosed")
            }

        })

        cheshmakRewardedAd = CheshmakRewardedAd(this, object : RewardedCallback {
            override fun onRewardedVideoAdLoaded() {
                Log.d("Rewarded", "onRewardedVideoAdLoaded")
            }

            override fun onRewardedVideoAdOpened() {
                Log.d("Rewarded", "onRewardedVideoAdOpened")
            }

            override fun onRewardedVideoAdFailedToLoad() {
                Log.d("Rewarded", "onRewardedVideoAdFailedToLoad")
            }

            override fun onRewarded() {
                Log.d("Rewarded", "onRewarded")
            }

            override fun onRewardedVideoAdClosed() {
                Log.d("Rewarded", "onRewardedVideoAdClosed")
            }
        })

        val intres = findViewById<Button>(R.id.interstitial)

        intres.setOnClickListener {
            if (cheshmakInterstitialAd!!.isLoaded!!) {
                cheshmakInterstitialAd!!.show()
            }
        }

        val rw = findViewById<Button>(R.id.rewarded)

        rw.setOnClickListener {
            if (cheshmakRewardedAd!!.isLoaded!!) {
                cheshmakRewardedAd!!.show()
            }
        }

        val adContainer: ViewGroup = findViewById(R.id.nativeAdContainer)
        val cheshmakNativeBannerAd =
            CheshmakNativeBannerAd(this@MainActivity,
                adContainer, R.layout.ad_unified, object : NativeBannerCallback {
                    override fun onAdLoaded() {
                        Log.d("native banner", "onAdLoaded")
                    }

                    override fun onAdOpened() {
                        Log.d("native banner", "onAdOpened")
                    }

                    override fun onAdFailedToLoad() {
                        Log.d("native banner", "onAdFailedToLoad")
                    }

                    override fun onAdClosed() {
                        Log.d("native banner", "onAdClosed")
                    }
                })
    }
}
