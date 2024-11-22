Installation
Prerequisites
Java Development Kit (JDK) 8 or higher
Android Studio or IntelliJ IDEA
Gradle Build Tool
MariaDB or SQLite (for database)
Steps to Install
Clone the repository:
bash
Copy code
git clone https://github.com/your-username/jumbled-words-game.git
cd jumbled-words-game
Open the project in your preferred IDE (e.g., Android Studio).
Build the project:
bash
Copy code
./gradlew build
Set up the database:
Import the database/initialize.sql script into your MariaDB/SQLite setup.
Run the app on an emulator or Android device.
Usage
Start the game by tapping the Play button.
Rearrange the jumbled words into the correct order.
Use the microphone button for voice input.
Progress through levels to increase the difficulty.
Check the Leaderboard to see how you rank against other players.
API Endpoints (Mock)
GET /api/sentences

Returns a list of jumbled sentences for a specific difficulty level.
POST /api/scores

Submits the player’s score to the leaderboard.



# table creation:
CREATE TABLE scores (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    username TEXT NOT NULL,
    score INTEGER NOT NULL,
    timestamp DATETIME DEFAULT CURRENT_TIMESTAMP
);


JDBC connection:

// Add JDBC dependency in gradle
implementation 'org.mariadb.jdbc:mariadb-java-client:3.0.0'

// Sample JDBC logic
Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/game", "user", "password");
PreparedStatement stmt = conn.prepareStatement("INSERT INTO scores (username, score) VALUES (?, ?)");
stmt.setString(1, "Student");
stmt.setInt(2, score);
stmt.executeUpdate();
