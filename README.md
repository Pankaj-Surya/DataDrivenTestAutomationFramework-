# DataDrivenTestAutomationFramework

## Overview
DataDrivenTestAutomationFramework is a robust test automation framework designed for web application testing using Selenium WebDriver. The framework is structured to support data-driven testing and interaction with web elements, making it easy to maintain and extend.

## Features
- Data-Driven Testing: Utilize Excel files for input data.
- Reusable Components: Methods for common web interactions.
- Page Object Model: Organized structure for web elements and interactions.
- Configurable Properties: Easy configuration through `config.properties` file.

## Project Structure
DataDrivenTestAutomationFramework/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/
│   │           └── datadriven/
│   │               ├── base/
│   │               │   └── BaseClass.java
│   │               ├── pages/
│   │               │   ├── LoginPage.java
│   │               │   └── RegisterPage.java
│   │               └── utility/
│   │                   ├── GenerateUniqueData.java
│   │                   └── ExcelUtility.java
│   └── test/
│       └── java/
│           └── com/
│               └── datadriven/
│                   └── test/
│                       ├── LoginUserTestCase.java
│                       └── RegisterUserTestCase.java
└── src/
    └── test/
        └── resources/
            ├── Configuration/
            │   └── config.properties
            └── TestData/
                └── ApplicationTestData.xlsx

## Getting Started

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Apache Maven
- Selenium WebDriver
- Apache POI (for Excel interaction)
- ChromeDriver

### Installation

1. Clone the repository:
   ```sh
   git clone https://github.com/yourusername/DataDrivenTestAutomationFramework.git
   cd DataDrivenTestAutomationFramework
