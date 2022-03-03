package project.st01367734.broinson

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_easy_level.*
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        //implement button click to add info to SQLite database file
        btnAddToDb.setOnClickListener {

            if (etName.text.toString() == "" && etQuantity.text.toString() == "") {
                Toast.makeText(this, "Enter name and password please", Toast.LENGTH_LONG).show()
            } else if (etName.text.toString() == "") {
                Toast.makeText(this, "Enter name please", Toast.LENGTH_LONG).show()
            } else if (etQuantity.text.toString() == "") {
                Toast.makeText(this, "Enter password please", Toast.LENGTH_LONG).show()
            }


            //create an instance for MyDBOpenHelper
            val dbHandler = MyDBOpenHelper(this, null)

            // create an instance of product we want to add
            val user = Product(etName.text.toString(), etQuantity.text.toString())


            // insert the new row to the table
            dbHandler.addName(user)

            Toast.makeText(
                this, etName.text.toString() + " with password " + etQuantity.text.toString() +
                        " added to DB ", Toast.LENGTH_LONG
            ).show()

            // clear both edit fields
            etName.setText("")
            etQuantity.setText("")
        }

        //implement button click to show data from SQLite  database
        btnShowDatafromDb.setOnClickListener {
            // clear data output fields
            tvDataBaseContent1.setText("")
            tvDataBaseContent2.setText("")

            // create an instance of DBOpenHelper
            val dbHandler = MyDBOpenHelper(this, null)

            // call a query to get data from database
            val cursor = dbHandler.getAllName()


            cursor!!.moveToFirst()
            //append text output with product name
            tvDataBaseContent1.append(
                (cursor.getString(
                    cursor.getColumnIndex(MyDBOpenHelper.COLUMN_NAME1)
                ))
            )

            tvDataBaseContent1.append("\n")
            // append text output with product quantity
            tvDataBaseContent2.append(
                (cursor.getString(
                    cursor.getColumnIndex(MyDBOpenHelper.COLUMN_NAME2)
                ))
            )

            tvDataBaseContent2.append("\n")
            //looping inside query result returned by cursor
            while (cursor.moveToNext()) {
                //add product name
                tvDataBaseContent1.append(
                    cursor.getString(
                        cursor.getColumnIndex(MyDBOpenHelper.COLUMN_NAME1)
                    )
                )
                tvDataBaseContent1.append("\n")
                // add product quantity
                tvDataBaseContent2.append(
                    cursor.getString(
                        cursor.getColumnIndex(MyDBOpenHelper.COLUMN_NAME2)
                    )
                )
                tvDataBaseContent2.append("\n")
            }
            cursor.close()
        }

        //Search button properties
        btn_Search.setOnClickListener {

            // clear data output fields
            tvDataBaseContent1.setText("")
            tvDataBaseContent2.setText("")

            //create an instance for MyDBOpenHelper
            val dbHandler = MyDBOpenHelper(this, null)

            //appending instance in cursor variable containing
            val cursor = dbHandler.searchProduct(etName.text.toString())

            //testing the errors while appending the coloumns
            try {
                cursor!!.moveToFirst()

                //add product name
                tvDataBaseContent1.append((cursor.getString(cursor.getColumnIndex(MyDBOpenHelper.COLUMN_NAME1))))
                tvDataBaseContent1.append("\n")

                // add product quantity
                tvDataBaseContent2.append((cursor.getString(cursor.getColumnIndex(MyDBOpenHelper.COLUMN_NAME2))))
                tvDataBaseContent2.append("\n")

                //looping inside query result returned by cursor
                while (cursor.moveToNext()) {

                    //add product name
                    tvDataBaseContent1.append((cursor.getString(cursor.getColumnIndex(MyDBOpenHelper.COLUMN_NAME1))))
                    tvDataBaseContent1.append("\n")

                    // add product quantity
                    tvDataBaseContent2.append((cursor.getString(cursor.getColumnIndex(MyDBOpenHelper.COLUMN_NAME2))))
                    tvDataBaseContent2.append("\n")
                }

            } catch (e: Exception) { //catching error according to code within try catch
                Toast.makeText(this, "Not found!", Toast.LENGTH_LONG).show()
            }
        }
        mainActivity.setOnClickListener {
            val newIntent = Intent(this, MainActivity::class.java)
            startActivity(newIntent)
        }

    }
}

