package com.app.qlct

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TransactionAdapter(private val filterType: String? = null) : RecyclerView.Adapter<TransactionAdapter.ViewHolder>() {

    // Tạo bộ khung dữ liệu ảo (Mock Data) chuẩn xác và phong phú hơn
    data class MockTx(val note: String, val date: String, val amountStr: String, val isIncome: Boolean)

    private val allData = listOf(
        MockTx("Ăn sáng phở bò", "Hôm nay • Ăn uống", "- 50.000 đ", false),
        MockTx("Lương tháng 3", "Hôm qua • Thu nhập", "+ 15.000.000 đ", true),
        MockTx("Lì xì năm mới", "Tuần trước • Tiền thưởng", "+ 500.000 đ", true),
        MockTx("Đổ xăng", "Hôm kia • Đi lại", "- 40.000 đ", false),
        MockTx("Xem phim chiếu rạp", "10/04/2026 • Giải trí", "- 120.000 đ", false),
        MockTx("Thanh lý đồ cũ", "08/04/2026 • Bán hàng", "+ 1.500.000 đ", true),
        MockTx("Cà phê với bạn", "05/04/2026 • Ăn uống", "- 65.000 đ", false),
        MockTx("Thưởng vượt năng suất", "01/04/2026 • Thu nhập", "+ 8.000.000 đ", true)
    )

    // Bộ Lọc Siêu Tốc: Dựa vào Tín hiệu truyền vào để lấy mảng dữ liệu tương ứng
    private val displayList = when (filterType) {
        "INCOME" -> allData.filter { it.isIncome }
        "EXPENSE" -> allData.filter { !it.isIncome }
        else -> allData // Nếu = null hoặc "ALL" thì hiện toàn bộ
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvNote: TextView = view.findViewById(R.id.tvTransactionNote)
        val tvDate: TextView = view.findViewById(R.id.tvTransactionDate)
        val tvAmount: TextView = view.findViewById(R.id.tvTransactionAmount)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_transaction, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = displayList[position]
        
        holder.tvNote.text = item.note
        holder.tvDate.text = item.date
        holder.tvAmount.text = item.amountStr
        
        // Đổi màu Xanh cho Thu và Đỏ cho Chi
        if (item.isIncome) {
            holder.tvAmount.setTextColor(Color.parseColor("#4CAF50"))
        } else {
            holder.tvAmount.setTextColor(Color.parseColor("#F44336"))
        }
    }

    override fun getItemCount() = displayList.size
}
