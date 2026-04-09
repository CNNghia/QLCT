package com.app.qlct

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class TransactionsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transactions)

        // Phím Back trên thanh công cụ
        val toolbar = findViewById<Toolbar>(R.id.toolbarTx)
        toolbar.setNavigationIcon(android.R.drawable.ic_menu_revert)
        toolbar.setNavigationOnClickListener { finish() }

        // Nhận dữ liệu truyền từ màn hình chính qua để Quyết định hiển thị Thông tin gì
        val txType = intent.getStringExtra("TYPE")
        if (txType == "INCOME") {
            toolbar.title = "CHI TIẾT THU NHẬP"
            toolbar.setTitleTextColor(android.graphics.Color.parseColor("#4CAF50"))
        } else if (txType == "EXPENSE") {
            toolbar.title = "CHI TIẾT CHI TIÊU"
            toolbar.setTitleTextColor(android.graphics.Color.parseColor("#F44336"))
        }

        // Tìm 3 trạng thái UX
        val layoutLoading = findViewById<View>(R.id.layoutLoading)
        val layoutEmpty = findViewById<View>(R.id.layoutEmpty)
        val rvTransactions = findViewById<RecyclerView>(R.id.rvAllTransactions)

        rvTransactions.layoutManager = LinearLayoutManager(this)
        rvTransactions.adapter = TransactionAdapter()

        // Bật màn hình Loading khi mới mở
        layoutLoading.visibility = View.VISIBLE
        layoutEmpty.visibility = View.GONE
        rvTransactions.visibility = View.GONE

        // Giả lập hệ thống đang cực khổ đi lấy dữ liệu mất 2 giây mới xong
        Handler(Looper.getMainLooper()).postDelayed({
            // Hết 2 giây -> Giấu bộ xương lóng lánh (Loading) đi
            layoutLoading.visibility = View.GONE

            // Khúc này DEV Logic sau này sẽ viết lệnh gọi từ Database
            // Ở đây tôi set hasData = false để ép nó bắn ra Màn Hình Trống (Empty State) cho bạn test UI
            val hasData = true 

            if (hasData) {
                rvTransactions.visibility = View.VISIBLE
            } else {
                layoutEmpty.visibility = View.VISIBLE
            }
        }, 2000)
    }
}
