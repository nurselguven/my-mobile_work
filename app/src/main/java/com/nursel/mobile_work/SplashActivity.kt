package com.nursel.mobile_work

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        checkConnection()
    }

    private fun checkConnection() {
       val manager = applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        val networkInfo = manager.activeNetworkInfo

        if (null !=networkInfo){
            if (networkInfo.type== ConnectivityManager.TYPE_WIFI){
                Toast.makeText(this, "Wifi connected",Toast.LENGTH_SHORT)

            }else if (networkInfo.type == ConnectivityManager.TYPE_MOBILE){
                Toast.makeText(this, "Mobile Data Connected",Toast.LENGTH_SHORT)
            }
        }else
        {
            val dialog =Dialog(this)
            dialog.setContentView(R.layout.alert_dialog)
            dialog.setCanceledOnTouchOutside(false)

            dialog.window!!.setLayout(WindowManager.LayoutParams.WRAP_CONTENT,WindowManager.LayoutParams.WRAP_CONTENT)

            dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))


            dialog.show()
        }

    }
}