package com.app.qlct

import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.button.MaterialButtonToggleGroup

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

        val toggleTransactionType = findViewById<MaterialButtonToggleGroup>(R.id.toggleTransactionType)
        val btnSelectCategory = findViewById<LinearLayout>(R.id.btnSelectCategory)
        val tvCategoryName = findViewById<TextView>(R.id.tvCategoryName)
        val ivCategoryIcon = findViewById<ImageView>(R.id.ivCategoryIcon)
        
        btnSelectCategory.setOnClickListener {
            // Kiểm tra xem đang ở Tab THU NHẬP hay CHI TIÊU
            val isIncome = toggleTransactionType.checkedButtonId == R.id.btnTypeIncome
            
            // Bộ dữ liệu tự tương ứng với Loại giao dịch (Y hệt Momo)
            val categories = if (isIncome) {
                arrayOf("Lương", "Nhận tiền từ Cty", "Gia đình trợ cấp", "Bán hàng online", "Tiền Lì Xì")
            } else {
                arrayOf("Ăn uống (Cơm sườn, Phở...)", "Shopping", "Giải trí", "Đổ xăng", "Hóa đơn điện nước")
            }
            
            val builder = AlertDialog.Builder(this)
            builder.setTitle(if (isIncome) "Chọn danh mục thu" else "Chọn danh mục chi")
            builder.setItems(categories) { dialog, which ->
                tvCategoryName.text = categories[which]
                // Đổi tự động icon màu Xanh cho Thu, Đỏ cho Chi để tạo WOW Effect
                val colorHex = if (isIncome) "#4CAF50" else "#F44336"
                ivCategoryIcon.backgroundTintList = android.content.res.ColorStateList.valueOf(android.graphics.Color.parseColor(colorHex))
            }
            builder.show()
        }

        val btnSelectWallet = findViewById<LinearLayout>(R.id.btnSelectWallet)
        val tvWalletName = findViewById<TextView>(R.id.tvWalletName)
        btnSelectWallet.setOnClickListener {
            val wallets = arrayOf("Ví Tiền Mặt", "Thẻ Tín Dụng VISA", "Tài Khoản Sacombank", "Ví MoMo", "ShopeePay")
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Chọn ví nguồn/đích")
            builder.setItems(wallets) { dialog, which ->
                tvWalletName.text = wallets[which]
            }
            builder.show()
        }
    }
}
