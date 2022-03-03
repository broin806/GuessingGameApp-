package project.st01367734.broinson

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_medium_level_intro.*

class EasyLevelIntro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_easy_level_intro)

        btnStart.setOnClickListener {
            val intent = Intent(this, EasyLevel::class.java)
            startActivity(intent)
        }
    }
}
