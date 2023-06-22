<!-- ⚠️ This README has been generated from the file(s) "blueprint.md" ⚠️-->
[![-----------------------------------------------------](https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/aqua.png)](#ipms)

# ➤ IPMS

IPMS (Internship and Placement Management System) is an Android application developed for the college training and placement office. It facilitates communication between students and the T&P department by sharing data related to upcoming placement drives and internship opportunities. The application also includes forms required during the internship process and provides notifications to users.


[![-----------------------------------------------------](https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/colored.png)](#table-of-contents)

## ➤ Table of Contents

- [Features](#features)
- [Dependencies](#dependencies)
- [Installation](#installation)
- [License](#license)


[![-----------------------------------------------------](https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/colored.png)](#features)

## ➤ Features

- Upcoming Placement Drives: Students can access information about upcoming placement drives, including details such as company name, date, and eligibility criteria.
- Internship Opportunities: The application provides students with internship opportunities and related information, such as company details and required skills.
- Internship Forms: Students can access and fill out forms required during the internship process, such as the internship agreement form.
- Notifications: The app sends notifications to students about important updates and announcements from the training and placement office.


[![-----------------------------------------------------](https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/colored.png)](#dependencies)

## ➤ Dependencies

To build and run the IPMS Android application, the following dependencies are required:

- Android Studio
- Java
- XML
- PHP
- XAMPP server with PHPMyAdmin

Ensure that you have Android Studio and XAMPP installed on your system before proceeding with the installation.


[![-----------------------------------------------------](https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/colored.png)](#installation)

## ➤ Installation

To set up the IPMS application locally, follow these steps:

1. Clone the IPMS repository:

   ```bash
   git clone https://github.com/your-username/IPMS.git
    ```

2.  Open the project in Android Studio:
    - Launch Android Studio.
    - Select "Open an Existing Project" and navigate to the cloned IPMS project directory.
    - Click "OK" to open the project.

3.  Set up the backend:
    - Clone the IPMS backend repository from : `https://github.com/shoaib749/IPMS_Script`
    - Follow the instructions provided in the backend repository's readme file to set up the PHP scripts and  database using XAMPP with PHPMyAdmin.

4.  Update the API endpoints:
    - In the IPMS Android project, locate the file where API endpoints are defined (usually named APIEndpoints.java or similar).
    - Replace the default API endpoint URLs with the URLs of your locally hosted PHP scripts.

5.  Build and run the application:
    - Connect an Android device or start an Android emulator.
    - Click the "Run" button in Android Studio to build and launch the IPMS application on the device/emulator.

6.  Explore the application:
    - Use the IPMS app to access upcoming placement drives, internship opportunities, fill out forms, and receive notifications.


[![-----------------------------------------------------](https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/colored.png)](#license)

## ➤ License

This project is licensed under the MIT License. Feel free to modify and distribute it as per your needs.

Please note that the backend repository provided in the readme should be referred to for specific installation instructions related to the backend scripts and database setup.

Please make sure to replace the placeholder URLs and commands with the appropriate information specific to your project.
