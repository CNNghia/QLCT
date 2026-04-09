package com.app.qlct

import android.os.Bundle
import android.graphics.Color
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // Ném giao diện (XML Phase 3) thay vì code Compose cũ
        setContentView(R.layout.fragment_dashboard)

        // Mock dữ liệu thẻ Tổng Thu
        val incomeCard = findViewById<View>(R.id.cardIncome)
        val titleIncome = incomeCard.findViewById<TextView>(R.id.tvStatTitle)
        val amountIncome = incomeCard.findViewById<TextView>(R.id.tvStatAmount)
        titleIncome.text = "Tổng Thu"
        amountIncome.text = "+ 15.000.000 đ"
        val tvTotalBalance = findViewById<TextView>(R.id.tvTotalBalance)
        tvTotalBalance.text = "14.725.000 đ"


        // Mock dữ liệu thẻ Tổng Chi
        val expenseCard = findViewById<View>(R.id.cardExpense)
        val titleExpense = expenseCard.findViewById<TextView>(R.id.tvStatTitle)
        val amountExpense = expenseCard.findViewById<TextView>(R.id.tvStatAmount)
        titleExpense.text = "Tổng Chi"
        amountExpense.text = "- 275.000 đ"
        amountExpense.setTextColor(android.graphics.Color.parseColor("#F44336")) // Đổi màu đỏ

        // Sét up Adapter cho Danh sách cuộn Giao dịch (RecyclerView)
        val rvTransactions = findViewById<RecyclerView>(R.id.rvTransactions)
        rvTransactions.layoutManager = LinearLayoutManager(this)
        rvTransactions.adapter = TransactionAdapter()
    }
}