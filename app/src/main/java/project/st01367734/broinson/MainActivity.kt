package project.st01367734.broinson


/*
-Broinson Jeyarajah N01367734
- Final Project Mobile Programming
 */


import android.app.ProgressDialog.show
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.Toast
import androidx.core.view.get
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File
import java.io.FileNotFoundException
import java.io.FileOutputStream

//represents the mainactivity variable
private const val TAG = "MainActivity"



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        Log.i(TAG, "OnCreate() was called")



        //Upon checkbox
        checkBox2.setOnClickListener {

            //creating variables to store the information into fields
            val userName = UserName.text.toString()
            val password = editTextTextPassword.text.toString()
            val fileOutputStream: FileOutputStream


            if (checkBox2.isChecked) {    //when checkbox is true, following different outcomes and checking fields
                if (editTextTextPassword.text.toString().isEmpty() && UserName.text.toString()
                        .isEmpty()
                ) {
                    Toast.makeText(this, "Enter in your UserName and Password", Toast.LENGTH_SHORT)
                        .show()

                } else if (editTextTextPassword.text.toString().isEmpty()) {
                    Toast.makeText(this, "Enter in your Password", Toast.LENGTH_SHORT).show()


                } else if (UserName.text.toString().isEmpty()) {
                    Toast.makeText(this, "Enter in your UserName", Toast.LENGTH_SHORT)
                        .show()

                } else { //process of storing the data
                    try {
                        fileOutputStream = openFileOutput(userName, Context.MODE_PRIVATE) //username as the file name
                        fileOutputStream.write(password.toByteArray()) //password in file
                    } catch (e: FileNotFoundException) {//catching all outcomes and errors
                        e.printStackTrace()
                    } catch (e: FileAlreadyExistsException) {

                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                    Toast.makeText(this, "Success login!", Toast.LENGTH_SHORT).show()

                }
            }
        }
        btnLogin.setOnClickListener {//Upon login button click  and going through different outcomes and results for fields

            if (editTextTextPassword.text.toString().isEmpty() && UserName.text.toString()
                    .isEmpty()
            ) {
                textView3.text = "null"
                Toast.makeText(this, "Blank UserName and Password", Toast.LENGTH_SHORT).show()
            } else if (editTextTextPassword.text.toString().isEmpty()) {
                // ErrorMessage3.visibility = View.VISIBLE;

                textView3.text = "null"
                Toast.makeText(this, "Blank Password", Toast.LENGTH_SHORT).show()

            } //else {
            //ErrorMessage3.visibility = View.INVISIBLE;
            //}

            else if (UserName.text.toString().isEmpty()) {
                // ErrorMessage2.visibility = View.VISIBLE;
                textView3.text = "null"
                Toast.makeText(this, "Blank UserName", Toast.LENGTH_SHORT).show()

            } //else {
            // ErrorMessage2.visibility = View.INVISIBLE;
            // }

            if (UserName.text.toString().isNotEmpty()) {
                textView3.text = "temp textview: " + UserName.text.toString()
            }


            if (editTextTextPassword.text.toString().isNotEmpty()) {
                textView3.text = "temp textview: " + editTextTextPassword.text.toString()
            }

            if (UserName.text.toString().isNotEmpty() && editTextTextPassword.text.toString()
                    .isNotEmpty()
            ) {
                textView3.text =
                    "temp textview: " + UserName.text.toString() + " and " + editTextTextPassword.text.toString()
                val username = UserName.text.toString()


                //going to the next page with the variable assigned
                val intent = Intent(this, WelcomePage::class.java)
                intent.putExtra("UserName:", username)


                startActivity(intent)
            }
        }

        btnClear.setOnClickListener { //clearing all respective fields and error messages
            UserName.setText("")
            editTextTextPassword.setText("")
            //ErrorMessage2.visibility = View.INVISIBLE;
            //ErrorMessage3.visibility = View.INVISIBLE;
            checkBox2.isChecked = false;
            textView3.text = "null"
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





