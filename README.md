# Bowling-Automation-Challenge

A Bowling game calculator developed using Java originally in Intellij IDE

**Conditions used while calculating the score:**
- A gutter game (20 times 0 pin) should score 0
- An all one game (20 times 1 pin) should score 20
- A spare followed by a 3 should score 16
- A strike followed by a 3 and a 4 should score 24
- The perfect game (12 times 10) should score 300

**Rules:**
- The game consists of 10 frames as shown above.
- In each frame the player has two opportunities to knock down 10 pins.
- The score for the frame is the total number of pins knocked down, plus bonuses for strikes and spares.
- In the tenth frame a player who rolls a spare or strike is allowed to roll the extra balls to complete the frame. However no more than three balls can be rolled in tenth frame.


**Things to know:**
- The code takes user input
- While providing the input make sure to give numbers from 0 to 10 for each round in every frame.
- Also make sure the sum of 2 rounds in each frame is not greater than 10
- If 10 is given as input for round 1 of any frame. **Round 2 gets automatically skipped** since its a Strike.


**An Example for user input score:**  
![bowling](https://github.com/AnkushGurudath/Bowling-Automation-Challenge/assets/34859758/7ff7bc7b-fa08-4a86-a391-631180551181)
