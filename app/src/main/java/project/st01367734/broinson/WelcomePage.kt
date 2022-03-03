package project.st01367734.broinson

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_welcome_page.*

//represents the secondactivty variable
private const val TAG = "SecondActivity"


class WelcomePage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome_page)



        Log.i(TAG, "OnCreate() was called")


        //getting the intent object(username)
        val intent = getIntent()
        val username = intent.getStringExtra("UserName:")

        //outputting the name into a textview
        textView.text =
            "         Welcome to the guessing game, " + username + "!\n\n                 There are 3 different levels. \n                Click the level you wish to play. \n                             good luck!";


        //go to the respective activity
        btnEasy.setOnClickListener {
            val intent = Intent(this, EasyLevelIntro::class.java)
            startActivity(intent)
        }
        //go to the respective activity
        btnMedium.setOnClickListener {
            val intent = Intent(this, MediumLevelIntro::class.java)
            startActivity(intent)
        }
        //go to the respective activity
        btnHard.setOnClickListener {
            val intent = Intent(this, HardLevelIntro::class.java)
            startActivity(intent)
        }


    }

    //methods for rotations
    override fun onPause() {
        super.onPause();
        Log.i(TAG, "OnPause() was called")
    }

    override fun onStop() {
        super.onStop();
        Log.i(TAG, "OnStop() was called")
    }

    override fun onResume() {
        super.onResume();
        Log.i(TAG, "OnResume() was called")
    }
}

