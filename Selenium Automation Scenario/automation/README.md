## This project is an automation framework 
Designed to automate the process of logging into Amazon Egypt (https://www.amazon.eg/), browsing video games, applying filters, adding products to the cart, and performing checkout. The framework uses Selenium WebDriver, TestNG, and Maven for efficient test execution and dependency management.

## Project Overview
This automation test case involves the following key steps:

## Automation Steps: 
Login to Amazon Egypt: Log in with email and password.
Navigate to Video Games Section: Open the "Video Games" section and apply filters for "Free Shipping" and "New" items.
Sort Products by Price: Sort the video games by price from high to low.
Add Items to Cart: Add items below 15,000 EGP to the shopping cart.
Verify Cart: Ensure that all products are correctly added to the cart.
Checkout: Add shipping address and choose cash on delivery as the payment method.
Verify Total: Ensure that the total amount of items in the cart is correct, including any shipping fees.

## Tools and Versions
The following tools and libraries are used in this project:

1. Java Development Kit (JDK)
Version: JDK 11 (or later)
Description: Java is the core language used for automation scripting in this project. You need to have JDK installed for compiling and running the Selenium tests.
2. Apache Maven
Version: 3.6.0 or later
Description: Maven is used for managing dependencies and building the project. It simplifies project setup by automatically handling library dependencies.
3. Selenium WebDriver
Version: 4.1.0
Description: Selenium WebDriver is used for automating browser actions such as clicking, entering text, selecting dropdowns, and verifying elements.
4. WebDriverManager
Version: 5.0.3
Description: WebDriverManager is used to automatically manage browser driver binaries, such as ChromeDriver or GeckoDriver, so you don't have to manually download them.
5. TestNG
Version: 7.4.0
Description: TestNG is a popular testing framework used to define test cases, manage test execution, and generate reports. It allows you to group tests, run tests in parallel, and provides detailed test execution logs.
6. Log4j2
Version: 2.14.1
Description: Log4j2 is a logging framework that helps track and log events in the automation script for debugging and analysis