# Selenium Java TestNG Automation Framework

[![Java](https://img.shields.io/badge/Java-21-orange)](https://www.oracle.com/java/)
[![Maven](https://img.shields.io/badge/Maven-3.9.11-blue)](https://maven.apache.org/)
[![Selenium](https://img.shields.io/badge/Selenium-WebDriver-green)](https://www.selenium.dev/)
[![TestNG](https://img.shields.io/badge/TestNG-7.8.0-lightgrey)](https://testng.org/)


A **modular and maintainable automation framework** for web application testing using **Selenium WebDriver, Java, TestNG, and Maven**. This framework supports **cross-browser testing, headless execution**, and integrates **utility classes** for Excel, CSV, JSON handling, logging, and reporting.  

This project is part of my **QA Automation Portfolio** and was built independently to demonstrate real-world automation framework design.


---

## 🚀 Tech Stack

- **Java 21**  
- **Selenium WebDriver**  
- **TestNG**  
- **Maven** (for build management and dependency handling)  
- **ExtentReports** (for test reporting)  
- **LambdaTest** (optional cross-browser cloud testing)
- GitHub Actions (CI execution)

---

## 📁 Project Structure
automationtask/
│
├── src/
│ ├── main/
│ │ └── resources/ # Resource files
│ └── test/
│ └── java/com/
│ ├── constants/ # Browser and environment constants
│ ├── dataprovider/ # TestNG DataProviders
│ ├── listeners/ # Retry and TestNG listeners
│ ├── pages/ # Page Object classes
│ ├── pojo/ # POJO classes for data handling
│ ├── tests/ # Test classes
│ └── utility/ # Utility classes (CSV, Excel, JSON, Logger, etc.)
│
├── testNG.xml # TestNG suite configuration
├── pom.xml # Maven project configuration
├── README.md # Project documentation
└── .gitignore # Files/folders to exclude from Git


---

## ⚡ Features

- Cross-browser testing (Chrome, Firefox, Edge)  
- Headless execution for CI/CD pipelines  
- Modular Page Object Model (POM) structure  
- Retry failed tests automatically using **TestNG listeners**  
- Utility support for:
  - Excel, CSV, JSON reading/writing  
  - Logging  
  - Extent report generation  
- Supports environment-specific configuration via `Env.java`
-  CI execution using GitHub Actions

---

## 🛠️ How to Run Tests

Clone the repository:

# Clone the repository
git clone https://github.com/shivanianand2602-star/selenium-java-testng-automation-framework.git
cd selenium-java-testng-automation-framework

# Run tests
mvn clean test -Dbrowser=chrome -DisHeadless=true -DisLambdaTest=false


**Parameters:**
browser → Specify browser (chrome, firefox, edge)
isHeadless → Run tests in headless mode (true/false)
isLambdaTest → Execute tests on LambdaTest cloud (true/false)

📈 **Reports**
Test reports are generated in test-output folder
Extent reports are generated in report.html

📌 **Notes**
Java 21 or higher is recommended
Maven is used for dependency management
.gitignore prevents IDE-specific and system files from being committed


💼 **Portfolio Info**
This project demonstrates:
- Strong understanding of Selenium WebDriver automation
- Proficiency in Java, TestNG, Maven
- Writing reusable, maintainable test frameworks
- Ability to integrate reporting and utilities
- Practical application of QA automation best practices



