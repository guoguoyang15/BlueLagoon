## Code Review

Reviewed by: Zhou Linsheng, u7630421

Reviewing code written by: Zhang Zhining, u7580614

Component: Task 6

### Comments
Q: What are the best features of this code?

A: I think Task 6 is very concise. The sparkling part is the double loop where a random number from 1 to 32 is given evenly
to 32 resources thus resources are distributed fairly to every stone circle.

Q: Is the code well-documented?

A: Yes. For every variable and every loop, there is a comment line illustrating what this variable means and
how the loops  works. Besides, space is suitable to show different level of codes.

Q: Does it follow Java code conventions (for example, are methods and variables properly named), and is the style consistent throughout?

A: Yes. In terms of variables, the first word starts with smaller case character and the second word starts with upper case character.

Q: Is the program decomposition (class and method structure) appropriate?

A: The algorithm is quite reasonable. First, he split statestring and extract stone circle string.
Second, create a integer array, like an index permutation array reorganizing the position strings.
Then according to permutation array, reorganize and assembly a new string for resources.

Q: If you suspect an error in the code, suggest a particular situation in which the program will not function correctly.

A: I think the biggest error lies in line 120. Sometimes there are 3 or even 4 players on board, although in test sets there are always 2 players. 
The substatements are not always 14, but sometimes 15 or 16. My advice is that an extra process of calculating the number of players on the board is necessary.