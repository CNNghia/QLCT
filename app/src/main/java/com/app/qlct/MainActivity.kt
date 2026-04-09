package com.app.qlct

import android.os.Bundle
import android.graphics.Color
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry

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
        amountExpense.setTextColor(Color.parseColor("#F44336")) // Đổi màu đỏ

        // Sét up Pie Chart (Biểu đồ) chuẩn Fast Budget
        setupPieChart()

        // Sét up Adapter cho Danh sách cuộn Giao dịch (RecyclerView)
        val rvTransactions = findViewById<RecyclerView>(R.id.rvTransactions)
        rvTransactions.layoutManager = LinearLayoutManager(this)
        rvTransactions.adapter = TransactionAdapter()

        // Bắt sự kiện bấm Nút FAB Nổi góc phải -> Mở Màn hình nhập
        val fab = findViewById<View>(R.id.fabAddTransaction)
        fab.setOnClickListener {
            val intent = android.content.Intent(this, AddTransactionActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setupPieChart() {
        val pieChart = findViewById<PieChart>(R.id.pieChart)

        // Tạo dữ liệu giả: Chi tiêu theo danh mục
        val entries = ArrayList<PieEntry>()
        entries.add(PieEntry(120000f, "Giải trí"))
        entries.add(PieEntry(50000f, "Ăn uống"))
        entries.add(PieEntry(40000f, "Đi lại"))
        entries.add(PieEntry(65000f, "Cafe"))

        val dataSet = PieDataSet(entries, "")
        dataSet.colors = listOf(
            Color.parseColor("#FF9800"), // Cam
            Color.parseColor("#E91E63"), // Hồng
            Color.parseColor("#2196F3"), // Xanh dương
            Color.parseColor("#9C27B0")  // Tím
        )
        dataSet.valueTextSize = 12f
        dataSet.valueTextColor = Color.WHITE

        pieChart.data = PieData(dataSet)

        // Donut chart style
        pieChart.description.isEnabled = false
        pieChart.isDrawHoleEnabled = true
        pieChart.holeRadius = 50f
        pieChart.setTransparentCircleAlpha(0)
        pieChart.centerText = "Tháng này\n- 275.000 đ"
        pieChart.setCenterTextSize(14f)
        pieChart.setCenterTextColor(Color.parseColor("#757575"))
        pieChart.legend.isEnabled = false
        
        pieChart.animateY(1000)
    }
}