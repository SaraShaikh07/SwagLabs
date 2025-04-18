
Swaglabs Automation Test Suite

This project contains an automated test suite for [SauceDemo](https://www.saucedemo.com/v1/) using Selenium WebDriver, Java, TestNG + POM, and ExtentReports.

---

 📂 Project Structure

```
saucedemo-automation/
├── src/
│   ├── test/
│   │   ├── java/
│   │   │   ├── tests/
│   │   │   │   └── SauceDemoTest.java
│   │   │   ├── objectpages/
│   │   │   │   ├── LoginPage.java
│   │   │   │   ├── HomePage.java
│   │   │   │   ├── CartPage.java
│   │   │   │   └── CheckoutPage.java
│   │   │   └── utils/
│   │   │       ├── ExcelUtils.java
│   │   │       └── ExtentReportManager.java
├── testng.xml
├── pom.xml
└── README.md
```

---

Test Scenarios

1.Homepage Load Verification After Login
- Objective: Ensure homepage loads successfully after valid login.
- Action: Login using valid credentials and assert homepage title.
- Approach: Data-driven testing for multiple credential sets.

2.Home Page (Product Filtering)(Low to High Price)
- Objective: Validate sorting by "Price: Low to High".
- Action: Apply filter and extract product names.
- Verification: Print product list in sorted order.

3.Cart Operations
- Objective: Test cart functionalities.
- Action: Add a product to the cart from the filtered list.
- Verification: Assert cart contains the selected product.

4.Checkout Process
- Objective: Complete the purchase process.
- Action: Fill checkout form, complete purchase.
- Verification: Assert confirmation message appears.

---

 Environment Setup Instructions

1. Install Java JDK (17 or later).
2. Install Maven and set up environment variables.
3. Install Chrome Browser.
4. Clone this repository:
bash
git clone https://github.com/SaraShaikh07/SwagLabs

5. Open the project in Intalia or Eclipse.
6. Run the test suite with:
bash
mvn clean test

7. Test reports are generated under `/test-output` folder.

---

Test Reporting

 Automated Reports with ExtentReports
Each test execution generates a detailed HTML report:
- Test Names & Status (Pass/Fail)
- Screenshot on Failure
- Time Stamps

You can find the reports at: `test-output/ExtentReports/or Default Suite`

---

Tech Stack

- Language: Java
- Framework: Selenium WebDriver + TestNG + POM
- Reporting: ExtentReports
- Build Tool: Maven
- Browser: Chrome (via WebDriver)

---

Author

- Name: QA Automation Engineer
- GitHub: [SaraShaikh07]

---

Notes

- Use Swaglabs's default credentials: `standard_user / secret_sauce`
- Ensure stable internet connection for WebDriver to access SawagLabs site.
