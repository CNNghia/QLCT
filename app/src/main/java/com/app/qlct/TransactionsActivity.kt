package com.app.qlct

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class TransactionsActivity : AppCompatActivity() {

    private var currentMonth = 4
    private var currentYear = 2026

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transactions)

        // Phím Back trên thanh công cụ
        val toolbar = findViewById<Toolbar>(R.id.toolbarTx)
        toolbar.setNavigationIcon(android.R.drawable.ic_menu_revert)
        toolbar.setNavigationOnClickListener { finish() }

        // Tóm tắt tiền (Header)
        val layoutSummaryIn = findViewById<View>(R.id.layoutSummaryIn)
        val layoutSummaryOut = findViewById<View>(R.id.layoutSummaryOut)

        // Nhận dữ liệu truyền từ màn hình chính qua để Quyết định hiển thị Thông tin gì
        val txType = intent.getStringExtra("TYPE")
        if (txType == "INCOME") {
            toolbar.title = "CHI TIẾT THU NHẬP"
            toolbar.setTitleTextColor(android.graphics.Color.parseColor("#4CAF50"))
            layoutSummaryOut.visibility = View.GONE  // Ẩn cột Tiền Ra
        } else if (txType == "EXPENSE") {
            toolbar.title = "CHI TIẾT CHI TIÊU"
            toolbar.setTitleTextColor(android.graphics.Color.parseColor("#F44336"))
            layoutSummaryIn.visibility = View.GONE   // Ẩn cột Tiền Vào
        }

        // Tìm 3 trạng thái UX
        val layoutLoading = findViewById<View>(R.id.layoutLoading)
        val layoutEmpty = findViewById<View>(R.id.layoutEmpty)
        val rvTransactions = findViewById<RecyclerView>(R.id.rvAllTransactions)

        rvTransactions.layoutManager = LinearLayoutManager(this)
        rvTransactions.adapter = TransactionAdapter(txType) // Truyền biến Tín Hiệu vào để Adapter nó Lọc

        // Bắt sự kiện Khi người dùng Lùi Tháng, Tiến Tháng
        val btnPrevMonth = findViewById<ImageView>(R.id.btnPrevMonth)
        val btnNextMonth = findViewById<ImageView>(R.id.btnNextMonth)
        val tvCurrentMonth = findViewById<TextView>(R.id.tvCurrentMonth)
        
        // Hiển thị lần đầu
        updateMonthText(tvCurrentMonth)
        
        btnPrevMonth.setOnClickListener {
            currentMonth--
            if (currentMonth < 1) {
                currentMonth = 12
                currentYear--
            }
            updateMonthText(tvCurrentMonth)
            simulateLoadingData()
        }

        btnNextMonth.setOnClickListener {
            currentMonth++
            if (currentMonth > 12) {
                currentMonth = 1
                currentYear++
            }
            updateMonthText(tvCurrentMonth)
            simulateLoadingData()
        }

        // Bắt sự kiện Nhấn Kính Lúp (Search)
        val fabFilter = findViewById<View>(R.id.fabFilter)
        fabFilter.setOnClickListener {
            Toast.makeText(this, "Tính năng tìm kiếm sẽ do Team Backend phụ trách ghép API!", Toast.LENGTH_SHORT).show()
        }

        // Bật màn hình Loading lần đầu tiên
        simulateLoadingData()
    }

    // Hàm dùng chung cho các thao tác Đợi dữ liệu
    private fun simulateLoadingData() {
        val layoutLoading = findViewById<View>(R.id.layoutLoading)
        val layoutEmpty = findViewById<View>(R.id.layoutEmpty)
        val rvTransactions = findViewById<RecyclerView>(R.id.rvAllTransactions)

        // Bật khung Xương lên, giấu list đi
        layoutLoading.visibility = View.VISIBLE
        layoutEmpty.visibility = View.GONE
        rvTransactions.visibility = View.GONE

        Handler(Looper.getMainLooper()).postDelayed({
            // Xong thì tắt Xương đi, hiện list lên
            layoutLoading.visibility = View.GONE
            rvTransactions.visibility = View.VISIBLE
        }, 1500) // Thời gian đợi là 1.5 giây
    }

    private fun updateMonthText(tv: TextView) {
        val monthStr = if (currentMonth < 10) "0$currentMonth" else "$currentMonth"
        tv.text = "Tháng $monthStr, $currentYear"
    }
}
