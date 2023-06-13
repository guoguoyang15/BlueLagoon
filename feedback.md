---
mark: 15.325000000000001

section_marks:
  c1-checksum: 0.25
  c10-task-16-test: 0.5
  c11-task-16-gui: 0.5
  c12-task-17-test: 0.5
  c13-task-17-gui: 0.5
  c14-well-designed: 0.65
  c15-oo-features: 0.1
  c16-comments: 0.15
  c17-coding-style: 0.15
  c18-unit-tests: 0
  c19-exceptional: 0.4
  c2-compliance: 0.5
  c3-authorship: 0.75
  c4-git: 0.75
  c5-runs-from-jar: 0
  c6-task-3-4-6-7-8: 2
  c7-task-9-10-11-12-13: 3
  c8-task-14-basic-game: 3
  c9-task-15-full-game: 1.625
---

**Gameplay and UI:**
The GUI and menu screen have a visually appealing design, creating a pleasant user experience. The aesthetics of the game board are also impressive, contributing to the overall appeal of the game. Important game information, such as score details, player turns, and island values, are clearly indicated, allowing players to stay informed during gameplay. However, one area for improvement is the inputting of coordinates, which could be made more user-friendly. Implementing a drag and drop feature would have greatly enhanced the usability of the game.

**Design and Style:**
The decision to abstract the Move and Board classes was a commendable choice, as it helps in maintaining a well-structured codebase. However, there is room for improvement in the usage of the static keyword. Instead of utilizing public static type `method_name(Board b)` and calling it with `method_name(b);`, it would have been cleaner and more appropriate to employ public type `method_name()` within the Board class, called as `b.method_name()`. This alternative approach enhances code readability and adheres more closely to best practices.

Similarly, the Move class could have been better designed by representing a move in a structured manner and encapsulating it within the Move class. Methods like public static `Set<String> generateAllValidMoves(Board b)` in the Move class could have been placed in the Board class instead, using the signature public `Set<Move> generateAllValidMoves()`. This design choice promotes cleaner code organization and improves the overall coherence of the program.

**Other:**
A JAR file is not present, which would have been helpful for ease of marking + was part of the marking criteria. It is advisable to conduct more comprehensive testing to ensure code correctness and identify any potential issues. Additionally, incorporating additional comments in the code would have made it easier to understand and maintain. It is worth noting that paying attention to code readability, such as following consistent naming conventions and avoiding overly complex code structures, can significantly improve the overall quality of the codebase.



