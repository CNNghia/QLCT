package com.app.qlct

import android.os.Bundle
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

        // Chúng ta có thể tận dụng lại cái Adapter tuyệt vời tôi đã tạo ở Phase Dashboard
        // Nó có chung giao diện, nhưng ở màn hình này không gian thoải mái và liệt kê rất nhiều
        val rvTransactions = findViewById<RecyclerView>(R.id.rvAllTransactions)
        rvTransactions.layoutManager = LinearLayoutManager(this)
        rvTransactions.adapter = TransactionAdapter()
    }
}
