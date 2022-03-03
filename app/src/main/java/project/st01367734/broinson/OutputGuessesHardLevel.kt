package project.st01367734.broinson

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_output_guesses.*
import java.io.*

class OutputGuessesHardLevel : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_output_guesses_hard_mode)


        //Appends all the information inputted and outputs the results on this activity
        var fileInputStream: FileInputStream? = null
        fileInputStream = openFileInput("HardMode_guesses.txt") //directs to this specific activty and sends all the data
        var inputStreamReader: InputStreamReader = InputStreamReader(fileInputStream) //reads inputstreamreader
        val bufferedReader: BufferedReader = BufferedReader(inputStreamReader) //reads bufferedreader

        val stringBuilder: StringBuilder = StringBuilder()
        var text: String? = null

        while ({ text = bufferedReader.readLine(); text }() != null) {

            //appends the texxt from the stringBuilder
            stringBuilder.append(text)

        }

        //last, it combines all information leading it to construct in this textview
        textView10.setText(stringBuilder.toString()).toString()


        //clearing all details both on the result page and the txt file
        btnClear2.setOnClickListener {
            try {
                val file = File(applicationContext.filesDir, "HardMode_guesses.txt")
                FileOutputStream(file, false).bufferedWriter().use { writer ->

                    //set all properties to its default values
                    writer.write("")
                    finish();
                  //  overridePendingTransition(0, 0);
                    startActivity(intent);
                }

            } catch (e: FileNotFoundException) { //catch exceptions
                e.printStackTrace()
            } catch (e: Exception) {
                e.printStackTrace()
            }

        }
    }
}

