# DataDrivenTestAutomationFramework

## Overview
DataDrivenTestAutomationFramework is a robust test automation framework designed for web application testing using Selenium WebDriver. The framework is structured to support data-driven testing and interaction with web elements, making it easy to maintain and extend.

## Features
- Data-Driven Testing: Utilize Excel files for input data.
- Reusable Components: Methods for common web interactions.
- Page Object Model: Organized structure for web elements and interactions.
- Configurable Properties: Easy configuration through `config.properties` file.

## Project Structure
- **`src/main/java/com/datadriven`**: Contains the main source code.
  - **`base`**: Contains base classes for the framework.
    - `BaseClass.java`: The base class for common functionalities.
  - **`pages`**: Contains page object classes.
    - `LoginPage.java`: Page object for the login page.
    - `RegisterPage.java`: Page object for the registration page.
  - **`utility`**: Contains utility classes.
    - `GenerateUniqueData.java`: Utility for generating unique data.
    - `ExcelUtility.java`: Utility for handling Excel files.

- **`src/test/java/com/datadriven/test`**: Contains test cases.
  - `LoginUserTestCase.java`: Test case for login functionality.
  - `RegisterUserTestCase.java`: Test case for registration functionality.

- **`src/test/resources`**: Contains resources for testing.
  - **`Configuration`**: Contains configuration files.
    - `config.properties`: Configuration properties for the tests.
  - **`TestData`**: Contains test data files.
    - `ApplicationTestData.xlsx`: Excel file with application test data.


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
