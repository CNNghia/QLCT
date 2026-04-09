package com.app.qlct

import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class AddTransactionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_transaction) // Nhúng file Layout chúng ta vừa thiết kế

        // Xử lý nút Đóng Giao dịch
        val btnClose = findViewById<ImageView>(R.id.btnClose)
        btnClose.setOnClickListener {
            finish()
        }

        // Xử lý nút LƯU
        val btnSave = findViewById<MaterialButton>(R.id.btnSave)
        btnSave.setOnClickListener {
            // Hiện chiêu trò một cái hình thông báo mờ mờ ở dưới (Toast)
            Toast.makeText(this, "Đã lưu vào CSDL (Mock)!!!", Toast.LENGTH_SHORT).show()
            finish() // Tự động đóng màn hình sau khi lưu
        }
    }
}
