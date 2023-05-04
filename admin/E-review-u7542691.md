## Code Review

Reviewed by: Quoc Thai Le (Tyler), u7542691

Reviewing code written by: Zhou Linsheng, u7630421

Component: Main method 'isMoveValid' and helper method 'isPosInIndex'

### Comments 

● Objective: The code is mostly in the scope of the project as it verifies whether a given move is valid, but it also 
prints the stateString and moveString, a functionality that is never needed in this project.

● Functionality:

- It appears to do what it is intended to do, although it also does some extraneous things.

- Printing the stateString and the moveString are functionalities not required of this method, and may make the method 
unnecessarily slower to run. 

- It appears to address all edge cases and there are no bugs that I can detect.

● Tests: There are already tests for method 'isMoveValid' given by the lecturer, but it uses some helper methods that 
are untested; and so, there should be some consideration in writing some tests for them. For example, 'spotType' and 
'occupiedByPlayer', and 'isPosInIndex' could have some tests written for it.

● Complexity: There are a number of redundancies, particularly in the if loops found between lines 339 and 379 in the 
BlueLagoon class, and so the code could be condensed.

● Good Names: Variable and object names are excellent across the board and clearly indicate what they represent.

● Comments: Comments do a great job at stating what each component of the overall method contributes to the task, and 
the thought process behind certain choices. There are some minor spelling mistakes in the comments, but they do not 
obstruct the communication of the comment's ideas.

● Conformity and Style: Aside from the aforementioned redundancies, the vertical blank spacing in the code is somewhat 
inconsistent. For positives, the 100-column "limit" is followed and comments are in appropriate positions.


