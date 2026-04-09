package com.app.qlct

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TransactionAdapter : RecyclerView.Adapter<TransactionAdapter.ViewHolder>() {

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
        // Tạm thời mock data giả để bạn nhìn thấy thao tác cuộn mượt mà
        when (position) {
            0 -> {
                holder.tvNote.text = "Ăn sáng phở bò"
                holder.tvDate.text = "Hôm nay • Ăn uống"
                holder.tvAmount.text = "- 50.000 đ"
                holder.tvAmount.setTextColor(Color.parseColor("#F44336"))
            }
            1 -> {
                holder.tvNote.text = "Lương tháng 3"
                holder.tvDate.text = "Hôm qua • Thu nhập"
                holder.tvAmount.text = "+ 15.000.000 đ"
                holder.tvAmount.setTextColor(Color.parseColor("#4CAF50"))
            }
            2 -> {
                holder.tvNote.text = "Đổ xăng"
                holder.tvDate.text = "Hôm kia • Đi lại"
                holder.tvAmount.text = "- 40.000 đ"
                holder.tvAmount.setTextColor(Color.parseColor("#F44336"))
            }
            3 -> {
                holder.tvNote.text = "Xem phim chiếu rạp"
                holder.tvDate.text = "10/04/2026 • Giải trí"
                holder.tvAmount.text = "- 120.000 đ"
                holder.tvAmount.setTextColor(Color.parseColor("#F44336"))
            }
            else -> {
                holder.tvNote.text = "Cà phê với bạn"
                holder.tvDate.text = "05/04/2026 • Ăn uống"
                holder.tvAmount.text = "- 65.000 đ"
                holder.tvAmount.setTextColor(Color.parseColor("#F44336"))
            }
        }
    }

    override fun getItemCount() = 5
}
