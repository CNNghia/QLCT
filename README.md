# 💰 Expense Manager App

<p align="center">
  <b>Ứng dụng quản lý thu chi cá nhân trên Android</b><br>
  Theo dõi dòng tiền • Phân tích tài chính • Trực quan & dễ dùng
</p>

---

## 📌 Giới thiệu

**Expense Manager App** là ứng dụng di động giúp người dùng:

- Quản lý thu chi cá nhân
- Theo dõi dòng tiền hằng ngày
- Phân tích tài chính qua biểu đồ

Ứng dụng hướng tới sự **đơn giản – trực quan – hiệu quả**.

---

## 🚀 Tính năng chính

### 💸 Quản lý giao dịch
- Thêm / sửa / xóa giao dịch
- Phân biệt thu nhập & chi tiêu
- Hiển thị danh sách realtime

### 🏷️ Phân loại dữ liệu
- Danh mục: Ăn uống, đi lại, giải trí...
- Dễ dàng lọc & thống kê

### 👛 Quản lý ví
- Tạo nhiều ví (tiền mặt, ngân hàng...)
- Theo dõi số dư chính xác

### 📊 Thống kê & báo cáo
- Tổng thu / chi theo:
  - Ngày
  - Tháng
- Biểu đồ:
  - Tròn (Pie Chart)
  - Cột (Bar Chart)

### 🔍 Tìm kiếm & lọc
- Theo ghi chú
- Theo danh mục
- Theo thời gian

### 🔐 Lưu trữ cục bộ
- Sử dụng Room Database (SQLite)
- Dữ liệu lưu trên thiết bị → bảo mật

---

## 🏗️ Kiến trúc hệ thống

Dự án sử dụng:

> **MVVM + Clean Architecture**

### 📌 Data Flow

### 📦 Ưu điểm

- Dễ bảo trì
- Tách biệt logic
- Dễ test
- Mở rộng tốt

---

## 🧰 Công nghệ sử dụng

| Thành phần | Công nghệ |
|----------|--------|
| Ngôn ngữ | Kotlin |
| IDE | Android Studio |
| Database | Room (SQLite) |
| UI | XML + Material Design |
| Architecture | MVVM |
| Async | LiveData / Flow |

---

## 📂 Cấu trúc thư mục
```bash
app/
├── data/
├── domain/
├── presentation/
├── utils/
└── res/layout/
```

---

## 👨‍💻 Phân công nhiệm vụ

| Thành viên | Feature | Mô tả |
|----------|--------|------|
| Nghĩa | Data & Wallet | Database, Room, Repository, màn hình ví |
| Anh | Transaction | CRUD giao dịch, validate |
| Đức | UI & Dashboard | Thiết kế giao diện |
| Thịnh | Report & Logic | Thống kê, biểu đồ |
| Đạt | Integration & QA | Search, Filter, test |

---

## 🔄 Quy trình phát triển

### 📍 Phase 1
- Setup project
- Database
- UI mock

### 📍 Phase 2
- CRUD Transaction
- CRUD Wallet

### 📍 Phase 3
- Thống kê
- Biểu đồ

### 📍 Phase 4
- Integration
- Testing
- Hoàn thiện

---

## 🌿 Git Workflow

### 🔀 Branch
feature/nghia-wallet

feature/anh-transaction

feature/duc-dashboard

feature/thinh-report

feature/dat-integration

### 📌 Quy tắc

- ❌ Không push trực tiếp vào `main`
- ✅ Luôn pull trước khi code
- ✅ Dùng Pull Request

### 📝 Commit chuẩn
feat: add transaction screen 

fix: crash when insert data 

refactor: clean repository


---

## 🎯 Quy ước code

### ❌ Cấm

- UI gọi trực tiếp DAO
- Viết logic trong Activity / Fragment

### ✅ Bắt buộc

- Dùng Repository pattern
- ViewModel làm trung gian

---

## ⚙️ Cài đặt & chạy

### 1. Clone project
https://github.com/CNNghia/QLCT.git

### 2. Mở project

- Android Studio

### 3. Chạy app

- Emulator
- Hoặc thiết bị thật

---


---

## 🔥 Hướng phát triển thêm

- 🔐 Login (Firebase)
- ☁️ Đồng bộ cloud
- 🌍 Đa ngôn ngữ (i18n)
- 📤 Export Excel / PDF
- 📉 AI gợi ý chi tiêu

---

## 📄 License

MIT License

---

## ⭐ Đóng góp

Nếu bạn muốn đóng góp:

1. Fork repo
2. Tạo branch mới
3. Commit code
4. Tạo Pull Request

---

## ❤️ Ghi chú

Dự án phục vụ mục đích học tập và phát triển kỹ năng:

- Android
- Clean Architecture
- Teamwork Git

---

