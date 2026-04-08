💰 Expense Manager App
Expense Manager App là ứng dụng di động giúp người dùng quản lý thu chi cá nhân, theo dõi dòng tiền và phân tích tài chính hiệu quả.  
Ứng dụng cung cấp các công cụ ghi chép giao dịch nhanh chóng, trực quan và dễ sử dụng.
---
🚀 Tính năng chính
💸 Quản lý giao dịch
Thêm / sửa / xóa khoản thu & chi
Hiển thị danh sách realtime
🏷️ Phân loại dữ liệu
Gắn nhãn: Ăn uống, đi lại, giải trí
👛 Quản lý ví
CRUD ví tiền
Hiển thị số dư thực tế
📊 Thống kê & Báo cáo
Tổng thu / chi
Biểu đồ tròn & cột theo ngày / tháng
🔍 Tìm kiếm & Lọc
Theo ghi chú
Theo danh mục
Theo thời gian
🔐 Lưu trữ cục bộ
Sử dụng Room Database (SQLite)
Dữ liệu lưu trực tiếp trên thiết bị
---
🏗️ Kiến trúc & Công nghệ
Dự án sử dụng mô hình:
> **MVVM + Clean Architecture**
🧰 Công nghệ sử dụng
Thành phần	Công nghệ
Ngôn ngữ	Kotlin
IDE	Android Studio
Database	Room (SQLite)
UI	XML + Material Design
Data Flow	UI → ViewModel → Repository → DAO → Database
---
📂 Cấu trúc thư mục
```
app/
├── data/           
├── domain/         
├── presentation/   
├── utils/          
└── res/layout/     
```
---
👨‍💻 Phân công nhiệm vụ (Final)
Thành viên	Feature	Nhiệm vụ
Nghĩa	Data & Wallet	Thiết kế DB, Room, Repository, màn hình Wallet
Anh	Transaction	CRUD giao dịch, validate dữ liệu, realtime
Đức	UI & Dashboard	Thiết kế UI, layout XML
Thịnh	Report & Logic	Tính toán, thống kê, biểu đồ
Đạt	Integration & QA	Search, Filter, Navigation, test & fix bug
---
🔄 Quy trình phát triển
Phase 1: Setup + UI mock
Phase 2: CRUD
Phase 3: Thống kê
Phase 4: Test & Release
---
🌿 Git Workflow
Tạo branch: feature/<ten>
Không push trực tiếp main
Commit chuẩn:
feat: add feature
fix: bug fix
---
🎯 Quy ước Code
❌ Không gọi DAO trong UI
✅ Dùng Repository + ViewModel
---
feature/nghia-wallet
feature/anh-transaction
feature/duc-dashboard
feature/thinh-report
feature/dat-integration
---
⚙️ Cài đặt & chạy
```
git clone https://github.com/your-repo/expense-manager.git
```
Mở Android Studio
Sync Gradle
Run app
---
📄 License
MIT License
