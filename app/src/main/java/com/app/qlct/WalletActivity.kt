package com.app.qlct

import android.os.Bundle
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class WalletActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wallet)

        // Setup Toolbar back button
        val toolbar = findViewById<Toolbar>(R.id.toolbarWallet)
        toolbar.setNavigationIcon(android.R.drawable.ic_menu_revert) // Icon quay lại
        toolbar.setNavigationOnClickListener { finish() } // Bấm quay lại về Trang chủ

        // Setup Nút thả nổi
        val fab = findViewById<View>(R.id.fabAddWallet)
        fab.setOnClickListener {
            Toast.makeText(this, "Chuẩn bị làm Màn hình Thêm Ví", Toast.LENGTH_SHORT).show()
        }

        // Đổ dữ liệu giả vào các Ví cho chân thật
        val rvWallets = findViewById<RecyclerView>(R.id.rvWallets)
        rvWallets.layoutManager = LinearLayoutManager(this)
        rvWallets.adapter = WalletAdapter()
    }

    // Adapter siêu tốc để vẽ danh sách các loại Ví
    inner class WalletAdapter : RecyclerView.Adapter<WalletAdapter.WalletViewHolder>() {
        
        inner class WalletViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val bgCard = view.findViewById<View>(R.id.bgCardLayout)
            val tvName = view.findViewById<TextView>(R.id.tvWalletName)
            val tvBalance = view.findViewById<TextView>(R.id.tvWalletBalance)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WalletViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_wallet, parent, false)
            return WalletViewHolder(view)
        }

        override fun onBindViewHolder(holder: WalletViewHolder, position: Int) {
            when (position) {
                0 -> {
                    holder.tvName.text = "Ví Tiền Mặt"
                    holder.tvBalance.text = "2.500.000 đ"
                    holder.bgCard.setBackgroundColor(Color.parseColor("#4CAF50")) // Xanh lá tươi
                }
                1 -> {
                    holder.tvName.text = "Thẻ Tín Dụng (MOMO)"
                    holder.tvBalance.text = "- 3.200.000 đ"
                    holder.bgCard.setBackgroundColor(Color.parseColor("#E91E63")) // Hồng nổi bật
                }
                else -> {
                    holder.tvName.text = "Tài khoản TPBank"
                    holder.tvBalance.text = "15.425.000 đ"
                    holder.bgCard.setBackgroundColor(Color.parseColor("#673AB7")) // Tím quý tộc
                }
            }
        }

        override fun getItemCount() = 3
    }
}
