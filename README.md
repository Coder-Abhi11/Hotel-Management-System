# 🏨 Hotel Management System

A desktop-based **Hotel Management System** built using **Core Java (Swing GUI)** and **MySQL**.
This application helps hotel staff manage day-to-day operations such as room booking, customer management, check-in/check-out, and billing.

---

## ✨ Features

* 🔐 User Authentication (Admin/Receptionist)
* 🧾 Customer Management
* 🚪 Room Management
* 📅 Booking & Check-In
* 🧳 Check-Out & Billing
* 📊 Reports & Listings

---

## 🛠 Tech Stack

**Backend:** Java (Core Java, OOP)
**GUI:** Java Swing, AWT
**Database:** MySQL + JDBC
**Tools/IDE:** NetBeans / IntelliJ / Eclipse, MySQL Workbench

---

## 📁 Project Structure

```
Hotel-Management-System/
├── Hotel Management System/
│   ├── src/
│   │   └── <your.package.name>/
│   │       ├── Main.java
│   │       ├── Login.java
│   │       ├── Dashboard.java
│   │       ├── AddCustomer.java
│   │       ├── RoomManagement.java
│   │       ├── Booking.java
│   │       ├── Checkout.java
│   │       ├── DbConnection.java
│   └── ... IDE build files
├── sql/
│   └── hotel_management.sql
└── README.md
```

---

## Database Tables Overview

### users

| id | username | password | role |

### rooms

| room_id | type | price | status | floor |

### customers

| cust_id | name | phone | email | id_proof |

### bookings

| booking_id | cust_id | room_id | checkin_date | checkout_date | status |

### payments (optional)

| payment_id | booking_id | amount | date | method |

---

## ⚙️ Setup Instructions

1. Clone the repository

```
git clone https://github.com/Coder-Abhi11/Hotel-Management-System.git
```

2. Import project into IDE
3. Create MySQL DB `hotel_management`
4. Update `DbConnection.java` with DB credentials
5. Run `Main.java` / `Login.java`

---

## 🚀 Future Enhancements

* Export invoices/report as PDF
* Online reservation system
* Email/SMS alerts
* Advanced search filters

---

## 👤 Author

**Kumar Abhishek**
GitHub ➝ @Coder-Abhi11

---

> A complete Swing + JDBC project for learning real-world hotel operations automation
