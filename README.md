# Summoner Buddy  

## Authors  
- [Jason Hao](https://github.com/jhao5)
- [Kha Le](https://github.com/kha-act)
- [Boyuan Dong](https://github.com/DBRYAN350)
- [Jack Li](https://github.com/jackspedicey312)
- [Patricia Watanabe](https://github.com/pwatana)
---

## Summary  
This project is a companion app for _League of Legends_ players and provides detailed game data and 
statistics using the Riot API. This application was design to help players track their progress, 
improve their gameplay, analyze match performance features like player profiles, match history,
and champion mastery.  
---
## Table of Contents  
1. [Features](#features)
2. [Installation Instructions](#installation-instructions)
3. [Usage Guide](#usage-guide)
4. [License](#license)
5. [Feedback](#feedback-and-discussions-)
6. [Contributing](#contributing)
7. [Code of Conduct](#code-of-conduct)
---
## Features  

**Feature Overview**  
Our application provides features that provides insights into League of Legends gameplay:  
- Player Profile (Overview Summoner Data):  
Provides player details like rank, summoner level, and account stats with the summoner ID and icon.
- Match History:  
Provides information about the five most recent matches including Kills, Deaths, Assists and match outcome. 
- Champion Mastery:  
Evaluates performance for specific champions played by calculating the mastery points using performance metrics
such as Damage Dealt to opponent champions.
- Friends:  
Track friends played with in the most recent matches with the game outcomes.
- Fun Facts:  
Provides player's fun facts including total play time, wins, losses kills, deaths, oldest played unix and so on.
- Riot API Real-Time Data Fetching  
Uses Riot API to fetch data directly from the League of Legends's servers.

Here is an example code for Player Profile (overview) feature:
1. Add your Riot API key to the API_KEY variable in the RiotAPIProfileDataAccess class.
2. Execute the OverviewUseCase
---
## Installation Instructions  
To set up and the run Summoner Buddy, one person needs to clone the repository first:

### **Step1: Clone the Repository**  
Begin by cloning the project repository from GitHub to your local development environment:  
``` 
    git clone https://github.com/jackspedicey312/OP.GG.git  
```
This will create a local copy of the codebase.  


### **Step 2: Register for a Riot API Key**  
The application uses the Riot Games API for fetching player and match data. To acquire API key:
1. Visit the [Riot Developer Portal](https://developer.riotgames.com/)
2. Sign up for an account or log in if you already have one.
3. Navigate to the API Keys section.
4. Generate Development API Key. Note that development keys expire after 24 hours, so you will need to regenerate them
if necessary.  

### **Step 3: Add the API Key to the project**  
1. Open the project in your preferred IDE  (e.g., IntelliJ).
2. Locate any RiotAPIDataAccess class in the data_access package (e.g., RiotAPIUserDataAccess).
3. Replace the placeholder API_KEY with your actual API key:
   public class RiotAPIDataAccess {
   private static final String API_KEY = "your_api_key_here";
   }
4. Save your changes and your key is now securely added!  

### **Step 4: Install Project Dependencies**  
The application may rely on external libraries to function. To make sure all dependencies are properly installed, follow
these steps:
1. Open the pom.xml (Maven) file in the root directory.
2. Use the terminal or IDE to install the dependencies:
   ```
   mvn install
3. Your dependencies are now downloaded in the project! 

### **Step 5: Build and Run the Project**
1. Compile the codebase:
    In IntelliJ: Click Build > Build Project.
    In the terminal (for Maven)
    ```
   mvn compile
   
2. Run the project:
    Locate RiotMain.java in the app main/java/app folder.
    Run the main method to start the application.
    You should now be able to navigate through the application from the main menu or login interface.

### **Step 6: Verify Functionality**  

To test the main features:
- Log in using a summoner's name and region.
- View the player profile, match history, champion mastery and other stats and pages.
To troubleshoot any errors:
- Double check that your API key is active.
- Check network connectivity to Riot's servers.

**Important Notes:**  
Please consider that the Riot's development API keys are temporary. Always verify the key's validity if requests fail.
And please make sure that you are connected to the internet to fetch real-time data from the Riot API.

---
## License  
Please refer to the LICENSE file for details about usage permissions and restrictions. The software is licensed under 
the MIT License, allowing developers to use, modify, and distribute the software freely, provided that the original 
copyright notice is retained. Note that the software is provided 'as-is' without any warranties.

---
## Feedback and Discussions  
We are excited to hear your feedback and suggestions to make our League of Legends analytics application better! This 
repository is the official space for public feedback discussions related to all aspects of the project, including 
features, design, performance, and documentation.

Your input is valuable to us, and we aim to foster productive and collaborative conversations. If you have ideas or 
concerns, this is the place to share them with the community, including the developers of the project.

### How to provide Feedback  
- We encourage you to create a new discussion in the Discussion Tab to suggest features, report bugs, or share other 
feedback. 
- You don’t need to have a solution for the problem you're addressing; we value all constructive discussions. 
- Before creating a new discussion, please search through existing issues to check if your suggestion has already been 
raised. If so, feel free to contribute additional details or reactions to signal your support instead of creating a 
duplicate issue.  

### Disclaimer  
Please note that any forward-looking statements or development plans shared in this repository are subject to change. 
These discussion are not guarantees or commitments to deliver specific features by a particular date.
Thank you for helping us improve the project and creating a better experience for all users!
---
## Contributing  
We're excited to welcome contributions to our League of Legends analytics app! Whether you’re fixing bugs, adding new 
features, improving documentation, or sharing feedback, your contributions help make this project better for everyone.

### How to Contribute
1. Fork the Repository
    Click the "Fork" button on the top-right of the repository to create your own copy.
2. Clone Your Fork
    Clone your fork to your local machine using:
    ```
   git clone https://github.com/YOUR_USERNAME/OP.GG.git
3. Create a Branch
    Create a new branch to isolate your changes:
    ```
   git checkout -b feature-or-bugfix-name
4. Make Your Changes
    Fix a bug, implement a feature, or improve the documentation. Please ensure your code follows the project's style 
    guide. 
5. Test Your Changes
    Run the tests provided to ensure your changes don't break existing functionality. If you're adding new features,
    write tests to cover them.
6. Submit Pull Request
    Push you changes to your forked repository:
    ```
   git push origin feature-or-bugfix-name 
    ```
   Open a pull request from your branch to the main branch of this repository. Include a clear and descriptive title,
    and provide details about the changes made.

### Discussion for Bugs, Features, and Feedback  
If you encounter a bug, please start a new discussion using the "Discussion" tab in this repository. Please include the 
following in your post under the appropriate category:
- **Bug Reports:** Describe the issue clearly, steps to reproduce, and include screenshots or error messages if
applicable.
- **Feature Requests:** Share your idea, explain why it's valuable, and provide details on how it could work.
- **General Feedback:** Let us know how we're doing or suggest improvements.

### Guidelines  
- Follow our [Code of Conduct] to maintain a welcoming collaborative environment,
- Check out existing discussions before creating a new one to avoid duplicates.
- Ensure your pull request passes all tests before submission.

### Recognition
All contributors will be recognized in the "Contributors" section of our README. Your efforts help us build a better
tools for League of Legends players and analysts-thank you for your contributions!

## Code of Conduct
We are committed to fostering a welcoming and inclusive community. Please be respectful of others, and ensure that your
contributions align with our guidelines. Harassment, discrimination, or any form of misconduct will not be tolerated.
