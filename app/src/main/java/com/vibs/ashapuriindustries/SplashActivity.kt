package com.vibs.ashapuriindustries

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.shreejipackaging.utils.LibFile
import com.vibs.ashapuriindustries.ui.login.LoginActivity
import kotlinx.android.synthetic.main.activity_splash.*


/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
class SplashActivity : AppCompatActivity() {

    private val mHidePart2Runnable = Runnable {
        // Delayed removal of status and navigation bar

        // Note that some of these constants are new as of API 16 (Jelly Bean)
        // and API 19 (KitKat). It is safe to use them, as they are inlined
        // at compile-time and do nothing on earlier devices.
        fullscreen_content.systemUiVisibility =
            View.SYSTEM_UI_FLAG_LOW_PROFILE or
                    View.SYSTEM_UI_FLAG_FULLSCREEN or
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
                    View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY or
                    View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or
                    View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
    }

    @SuppressLint("DefaultLocale")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_splash)

        /*Thread.UncaughtExceptionHandler { t, e ->
            Process.killProcess(Process.myPid())
            exitProcess(0)
        }*/

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        // Hide UI first
        supportActionBar?.hide()

        Handler().postDelayed(Runnable {
            if (LibFile.getInstance(this@SplashActivity).getString(LibFile.KEY_TOKEN, "")
                    .isNullOrEmpty()
            ) {
                startActivity(
                    Intent(this@SplashActivity, LoginActivity::class.java).apply {
                        flags =
                            Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    })
            } else {
                startActivity(
                    Intent(this@SplashActivity, MainActivity::class.java).apply {
                        flags =
                            Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    })
            }
        }, 2000)
    }
}
