package com.cookandroid.hackbun

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.google.zxing.BarcodeFormat
import com.google.zxing.common.BitMatrix
import com.google.zxing.qrcode.QRCodeWriter
import java.text.SimpleDateFormat

class MainActivity : AppCompatActivity() {
    lateinit var a: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        a = findViewById<ImageView>(R.id.qrcode)
        setTimerAndQRCode("201636010")
        findViewById<Button>(R.id.btnScan).setOnClickListener {

        }
    }

    fun setTimerAndQRCode(number: String) {


        Glide.with(this)
                .load(
                        QRCodeWriter().encode(
                                "m$number${SimpleDateFormat("yyyyMMddHHmmss").format(System.currentTimeMillis())}",
                                BarcodeFormat.QR_CODE,
                                400,
                                400
                        ).toBitmap()
                )
                .into(a)
    }

    fun BitMatrix.toBitmap(): Bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565).also {
        for (x in 0 until width) {
            for (y in 0 until height) {
                it.setPixel(
                        x, y, if (get(x, y)) {
                    Color.BLACK
                } else {
                    Color.WHITE
                }
                )
            }
        }
    }
}