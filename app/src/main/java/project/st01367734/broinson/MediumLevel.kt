package project.st01367734.broinson

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_easy_level.*
import kotlinx.android.synthetic.main.activity_medium_level.*
import kotlinx.android.synthetic.main.activity_medium_level.btnNext
import kotlinx.android.synthetic.main.activity_medium_level.btnSubmit
import kotlinx.android.synthetic.main.activity_medium_level.editTextNumber
import java.io.File
import java.io.FileNotFoundException
import java.io.FileOutputStream

class MediumLevel : AppCompatActivity() {
    //Declare variables
    var randomnumber = (1..55).random()
    var chances = 5
    private var listofguesses = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_medium_level)

        //Next button will be invisible when this activity is opened
        btnNext.visibility = View.INVISIBLE;


        //Upon submit button click
        btnSubmit.setOnClickListener {

            //which ever number entered by user will not be equal to the random number and chances is less then or equal to the chances given.
            while (editTextNumber.text.toString().toInt() != randomnumber && chances <= chances) {

                if (editTextNumber.text.toString().toInt().equals(randomnumber)) {//if guessing number is equal to random number
                    Toast.makeText(
                        this,
                        "Congrats the Number was " + randomnumber + "!" +
                                "Click on the next button to go next page.", Toast.LENGTH_LONG).show()
                    //set field to empty string
                    editTextNumber.text.toString() == ""


                    //creating variable to append the data
                    val data = listofguesses

                    //creating the txt files to store guesses
                    val fileMediumMode = File(applicationContext.filesDir, "MediumMode_guesses.txt")
                    val file2 = File(applicationContext.filesDir, "PastGuesses.txt")

                    //constructing the file in a way to append the data to it.
                    try {
                        FileOutputStream(fileMediumMode, true).bufferedWriter().use { writer ->
                            writer.append(
                                "                                                                     guesses:" + "$listofguesses           " + "      " +
                                        "                                                                           right number: " + " [ " + randomnumber + " ] "
                            )
                        }

                        //constructing second file and append the data to it.
                        FileOutputStream(file2, true).bufferedWriter().use { writer ->

                            writer.append( //writing the statment
                                "\n\n\nMEDIUM MODE\n" +
                                        "guesses:" + "$listofguesses\n right number: " + " [ " + randomnumber + " ]"
                            )
                        }

                    } catch (e: FileNotFoundException) { //catch exceptions
                        e.printStackTrace()
                    } catch (e: Exception) {//catch exceptions
                        e.printStackTrace()
                    }

                    btnSubmit.visibility = View.INVISIBLE //set submit button to invisible
                    btnNext.visibility = View.VISIBLE //set next button the invisible
                    break;


                    //checking if the user has entered nothing into the field or it is blank
                } else if (editTextNumber.text.toString().isEmpty()) {
                    Toast.makeText(this, "Submit a guess please", Toast.LENGTH_SHORT).show()
                    break;

                    //if the chance exceed to the # of chances given
                } else if (chances < 1) {
                    Toast.makeText(
                        this, "This round is over! The guessing number was " + randomnumber + "! " +
                                "Click on the button to go to the next page.", Toast.LENGTH_LONG).show()




                    editTextNumber.text.toString() == "" //is empty


                    //creating the txt files to store guesses
                    val data = listofguesses
                    val fileMediumMode = File(applicationContext.filesDir, "MediumMode_guesses.txt")
                    val file2 = File(applicationContext.filesDir, "PastGuesses.txt")

                    try {

                        //constructing the file in a way to append the data to it.
                        FileOutputStream(fileMediumMode, true).bufferedWriter().use { writer ->
                            writer.append(
                                "                                                                     guesses:" + "$listofguesses           " + "      " +
                                        "                                                                           right number: " + " [ " + randomnumber + " ] "
                            )
                        }

                        FileOutputStream(file2, true).bufferedWriter().use { writer ->

                            writer.append(
                                "\n\n\nMEDIUM MODE\n" +
                                        "guesses:" + "$listofguesses\n right number: " + " [ " + randomnumber + " ]"
                            )
                        }
                    } catch (e: FileNotFoundException) { //catch exception
                        e.printStackTrace()
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                    btnSubmit.visibility = View.INVISIBLE
                    btnNext.visibility = View.VISIBLE;
                    break;

                    //if the guessing number is greater than the randomnumber
                } else if (editTextNumber.text.toString().toInt() > randomnumber) {
                    chances--;
                    Toast.makeText(
                        this,
                        "Number is too big. Try another number." +
                                " you have " + chances + "chances left.",
                        Toast.LENGTH_LONG
                    ).show()
                    editTextNumber.text.toString() == ""

                    //append each guess the user inputs
                    listofguesses += " " + "[ " + editTextNumber.text.toString().toInt() + " ]"
                    break;

                    //if the guessing number is lower then the random number
                } else if (editTextNumber.text.toString().toInt() < randomnumber) {
                    chances--;
                    Toast.makeText(
                        this,
                        "Number is too small. Try another number. " +
                                "you have " + chances + "chances left.",
                        Toast.LENGTH_LONG
                    ).show()
                    editTextNumber.text.toString() == ""

                    //append each guess the user inputs
                    listofguesses += "  " + "[ " + editTextNumber.text.toString().toInt() + " ]"

                    break;
                }

            }
        }



        btnNext.setOnClickListener {//goes to the next activity demonstrated
            val newIntent = Intent(this, OutputGuessesMediumLevel::class.java)
            startActivity(newIntent)
        }
    }
}








