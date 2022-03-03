package project.st01367734.broinson



import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.os.FileObserver.DELETE
import java.nio.channels.AsynchronousFileChannel.open
import java.sql.SQLClientInfoException


class MyDBOpenHelper (
    context: Context?,
    // name: String?,
    factory: SQLiteDatabase.CursorFactory?
    //  version: Int
) : SQLiteOpenHelper(context, name, factory, version) {

    companion object {
        private val version = 1
        private val name = "MyName.db"
        val TABLE_NAME = "products"
        val COLUMN_ID = "_id"
        val COLUMN_NAME1 = "prodname"
        val COLUMN_NAME2 = "quantity"
    }

    override fun onCreate(db: SQLiteDatabase?) {

        val CREATE_PRODUCTS_TABLE = ("CREATE TABLE " +
                TABLE_NAME + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY," +
                COLUMN_NAME1 + " TEXT," +
                COLUMN_NAME2 + " TEXT" + ")")

        db?.execSQL(CREATE_PRODUCTS_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db?.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME)
        onCreate(db)
    }

    // Insert the new row to the table
    fun addName(name: Product) {
        val values = ContentValues()
        values.put(COLUMN_NAME1, name.prodName)
        values.put(COLUMN_NAME2, name.quantity)
        val db = this.writableDatabase
        db.insert(TABLE_NAME, null, values)
        db.close()
    }

    // get all records from table
    fun getAllName(): Cursor? {
        val db = this.readableDatabase
        return db.rawQuery("SELECT * FROM $TABLE_NAME", null)
    }

    //finding existing product from table
    fun searchProduct(productname: String): Cursor? {
        val db = this.writableDatabase
        return db.rawQuery("SELECT * FROM $TABLE_NAME WHERE $COLUMN_NAME1 = \"$productname\"", null)
    }


    //delete existing product from table
    fun deleteProduct(_id: Int) {
        val db = this.writableDatabase
        db.delete(TABLE_NAME, "_id=$_id", null)

    }
}


