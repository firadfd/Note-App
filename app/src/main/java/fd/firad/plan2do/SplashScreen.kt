package fd.firad.plan2do

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.databinding.DataBindingUtil
import fd.firad.plan2do.databinding.ActivitySplashScreenBinding

class SplashScreen : AppCompatActivity() {
    private lateinit var binding: ActivitySplashScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this@SplashScreen, R.layout.activity_splash_screen)
        supportActionBar?.hide()

        Handler(Looper.getMainLooper()).postDelayed(Runnable {
            startActivity(Intent(this@SplashScreen, MainActivity::class.java))
            finish()
        }, 2000)
    }
}