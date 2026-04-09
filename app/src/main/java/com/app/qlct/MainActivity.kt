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
import com.google.android.material.button.MaterialButtonToggleGroup

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

        // Bắt sự kiện icon góc phải trên cùng Dashboard -> Phóng qua màn hình VÍ
        val btnOpenWallet = findViewById<View>(R.id.btnOpenWallet)
        btnOpenWallet.setOnClickListener {
            val intent = android.content.Intent(this, WalletActivity::class.java)
            startActivity(intent)
        }

        // Bắt sự kiện chữ "XEM TẤT CẢ" -> Mở Màn hình Danh sách Giao Dịch
        val tvViewAll = findViewById<TextView>(R.id.tvViewAll)
        tvViewAll.setOnClickListener {
            val intent = android.content.Intent(this, TransactionsActivity::class.java)
            startActivity(intent)
        }

        // Mock dữ liệu thẻ Tổng Chi
        val expenseCard = findViewById<View>(R.id.cardExpense)
        val titleExpense = expenseCard.findViewById<TextView>(R.id.tvStatTitle)
        val amountExpense = expenseCard.findViewById<TextView>(R.id.tvStatAmount)
        titleExpense.text = "Tổng Chi"
        amountExpense.text = "- 275.000 đ"
        amountExpense.setTextColor(Color.parseColor("#F44336")) // Đổi màu đỏ

        // Sét up chức năng Bấm Vào Card chui sang Màn Chi Tiết
        incomeCard.setOnClickListener {
            val intent = android.content.Intent(this, TransactionsActivity::class.java)
            intent.putExtra("TYPE", "INCOME")
            startActivity(intent)
        }
        expenseCard.setOnClickListener {
            val intent = android.content.Intent(this, TransactionsActivity::class.java)
            intent.putExtra("TYPE", "EXPENSE")
            startActivity(intent)
        }

        // Bắt sự kiện Gạt Nút TỔNG / THU / CHI trên Biểu đồ
        val toggleChart = findViewById<MaterialButtonToggleGroup>(R.id.toggleChartType)
        toggleChart.addOnButtonCheckedListener { group, checkedId, isChecked ->
            if (isChecked) {
                when (checkedId) {
                    R.id.btnChartTotal -> setupPieChartTotal()
                    R.id.btnChartIncome -> setupPieChartIncome()
                    R.id.btnChartExpense -> setupPieChartExpense()
                }
            }
        }

        // Mặc định lúc vừa vào app thì vẽ biểu đồ TỔNG
        setupPieChartTotal()

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

    private fun setupPieChartExpense() {
        val pieChart = findViewById<PieChart>(R.id.pieChart)

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
        pieChart.description.isEnabled = false
        pieChart.isDrawHoleEnabled = true
        pieChart.holeRadius = 50f
        pieChart.setTransparentCircleAlpha(0)
        pieChart.centerText = "Chi Tiêu\n- 275.000 đ"
        pieChart.setCenterTextSize(14f)
        pieChart.setCenterTextColor(Color.parseColor("#F44336"))
        pieChart.legend.isEnabled = false
        
        pieChart.animateY(800)
    }

    private fun setupPieChartIncome() {
        val pieChart = findViewById<PieChart>(R.id.pieChart)

        val entries = ArrayList<PieEntry>()
        entries.add(PieEntry(5000000f, "Lương"))
        entries.add(PieEntry(500000f, "Lì xì"))
        entries.add(PieEntry(1500000f, "Bán đồ cũ"))
        entries.add(PieEntry(8000000f, "Thưởng dự án"))

        val dataSet = PieDataSet(entries, "")
        dataSet.colors = listOf(
            Color.parseColor("#4CAF50"), // Xanh lá
            Color.parseColor("#8BC34A"), // Xanh mạ
            Color.parseColor("#CDDC39"), // Vàng chanh
            Color.parseColor("#009688")  // Xanh ngọc
        )
        dataSet.valueTextSize = 12f
        dataSet.valueTextColor = Color.WHITE

        pieChart.data = PieData(dataSet)
        pieChart.description.isEnabled = false
        pieChart.isDrawHoleEnabled = true
        pieChart.holeRadius = 50f
        pieChart.setTransparentCircleAlpha(0)
        pieChart.centerText = "Tổng Thu\n+ 15.000.000 đ"
        pieChart.setCenterTextSize(14f)
        pieChart.setCenterTextColor(Color.parseColor("#4CAF50"))
        pieChart.legend.isEnabled = false
        
        pieChart.animateY(800)
    }

    private fun setupPieChartTotal() {
        val pieChart = findViewById<PieChart>(R.id.pieChart)

        val entries = ArrayList<PieEntry>()
        // Thu 15tr, Chi 275k (để tỷ lệ biểu đồ khỏi bị đè nếu vẽ thật, tạm coi Thu là miếng bự, Chi là miếng nhỏ xíu)
        entries.add(PieEntry(15000000f, "Tổng Thu"))
        entries.add(PieEntry(275000f, "Tổng Chi"))

        val dataSet = PieDataSet(entries, "")
        dataSet.colors = listOf(
            Color.parseColor("#4CAF50"), // Xanh lá mơn mởn (Thu)
            Color.parseColor("#F44336")  // Đỏ rực rỡ (Chi)
        )
        dataSet.valueTextSize = 14f
        dataSet.valueTextColor = Color.WHITE

        pieChart.data = PieData(dataSet)
        pieChart.description.isEnabled = false
        pieChart.isDrawHoleEnabled = true
        pieChart.holeRadius = 50f
        pieChart.setTransparentCircleAlpha(0)
        pieChart.centerText = "Số Dư\n+ 14.725.000 đ"
        pieChart.setCenterTextSize(14f)
        pieChart.setCenterTextColor(Color.parseColor("#757575"))
        pieChart.legend.isEnabled = false
        
        pieChart.animateY(800)
    }
}