# Java Snake Game

## Overview
This project implements the classic Snake game using Java and Swing. The game features a snake that grows as it eats apples, with increasing difficulty as the player's score increases.

## Features
- Classic Snake gameplay
- Increasing difficulty (speed) as the score grows
- Wrap-around screen edges (snake appears on the opposite side when it reaches a border)
- Score display
- Game over screen
- Controls using arrow keys or WASD

## Project Structure
The project consists of several Java classes:
- `Snake.java`: Contains the main method to launch the game
- `GameFrame.java`: Sets up the main game window
- `GamePanel.java`: Implements the game logic, rendering, and user input handling
- `MoveSnake.java`: Handles the movement logic for the snake
- `Move.java`: An abstract class for movement (currently unused)
- `Movable.java`: An interface for movable objects (currently unused)

## How to Compile and Run
1. Ensure you have Java Development Kit (JDK) installed on your system
2. Compile the Java files using the following command:
   ```
   javac snake/*.java
   ```
3. Run the compiled program:
   ```
   java snake.Snake
   ```

## Controls
- Use the arrow keys or WASD to control the snake's direction:
  - Up Arrow or W: Move Up
  - Down Arrow or S: Move Down
  - Left Arrow or A: Move Left
  - Right Arrow or D: Move Right

## Gameplay
1. The snake starts with a length of 4 units
2. Guide the snake to eat the red apples that appear on the screen
3. Each apple eaten increases the snake's length and the player's score
4. The game speed increases for every 10 apples eaten
5. Avoid colliding with the snake's own body
6. The game ends when the snake collides with itself
7. The snake can pass through the screen edges and appear on the opposite side

## Future Improvements
- Add a start menu and pause functionality
- Implement different difficulty levels
- Add obstacles or walls to increase challenge
- Include sound effects and background music
- Create a high score system
- Improve graphics and animations

## Contributing
Contributions to improve the project are welcome. Please feel free to fork the repository and submit pull requests.

## License
This project is open-source and available under the MIT License.
