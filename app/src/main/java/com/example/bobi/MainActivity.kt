package com.example.bobi

import android.content.DialogInterface
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar

private const val REQUEST_IMAGE_CAPTURE = 100 //valor qualquer

class MainActivity : AppCompatActivity() {

    private var untilFinished = 10000L
    private lateinit var timer: CountDownTimer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //findViewById<Button>(R.id.button).setOnClickListener{ //ao cliclar no buttao chama a nossa Activity/Page
            //openPhoneCamera()
            //openDetailsActivity()
            //openAlertDialog()
            //openSnackBar(it)

        //}
    }

    override fun onResume() {
        startCountDownTimer(untilFinished)
        super.onResume()

    }

    override fun onPause() {
        super.onPause()
        timer.cancel()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) { //este metodo e chamada apos o startActivty result
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK){
            val imageBitmap = data?.extras?.get("data") as Bitmap
            findViewById<ImageView>(R.id.imageView3).setImageBitmap(imageBitmap)
        }
        super.onActivityResult(requestCode, resultCode, data)
    }

    private fun openPhoneCamera(){
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE) //usar camera do telemovel
        startActivityForResult(intent, REQUEST_IMAGE_CAPTURE)
    }

    private fun openDetailsActivity(){
        val intent = Intent(this,DetailsActivity::class.java)
        startActivity(intent)
    }

    private fun startCountDownTimer(time :Long){
        timer = object: CountDownTimer(time, 10000){

            override fun onTick(millisUntilFinished: Long) {
                untilFinished = millisUntilFinished
                findViewById<TextView>(R.id.countdown).text = "Seconds remaining: ${millisUntilFinished/1000}"
            }

            override fun onFinish() {
                findViewById<TextView>(R.id.countdown).text = "Done!"
            }
        }
        timer.start()
    }

    private fun openAlertDialog(){
        val alertDialog = AlertDialog.Builder(this)
        alertDialog.setTitle("Bobi")
        alertDialog.setMessage("Mas que caes tao bonitos")
        alertDialog.setPositiveButton("Yes", DialogInterface.OnClickListener {
            dialogInterface, i ->  dialogInterface.dismiss()
        })
        alertDialog.setNegativeButton("Cancel",DialogInterface.OnClickListener{
            dialogInterface, i ->  dialogInterface.cancel()
        })
        alertDialog.create().show()
    }

    fun openSnackBar(view: View){
        val snackbar = Snackbar.make(view, "Que caes bonitos",1000)
        snackbar.show()
    }


}