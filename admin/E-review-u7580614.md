## Code Review

Reviewed by: Zhang Zhining (Nick), u7580614

Reviewing code written by: Quoc Thai Le (Tyler), u7542691

Component: Task 3,Main method isStateStringWellFormed

### Comments
Q: What are the best features of this code?
A: I think the best feature is the use of JAVA regular expressions, which cleverly match the strings required by the question and greatly reduce the workload

Q: Is the code well-documented?
A: Yes, there are easy to understand comments for each loop, and the code is neatly laid out
Q: Does it follow Java code conventions (for example, are methods and variables properly named), and is the style
consistent throughout?

A: This code follows the for loop statement uniformly, and the collation calls are sensible and easy to understand. task3 as a whole is about regular expression checksum strings, and only the variable string array parts[ ] appears, with no additional methods. For the purposes of this paragraph it is compliant
Q: Is the program decomposition (class and method structure) appropriate?

A: This algorithm is quite reasonable. First, he splits the status string, divides it into the newly created string array parts[ ], and then uses regular expressions to check the strings one by one to determine if they are compliant
Q: If you suspect an error in the code, suggest a particular situation in which the program will not function correctly.
A: I don't think there are any obvious errors in the code and it will work in any case. However, there is a design redundancy at the beginning of the code, i.e. a new shape-number to determine if the code segment is compliant num=0, and if it is not num=-1, the whole traversal is done and then another determination is made and if num=-1 then return false
In fact, there is no need to go to such trouble, because this will result in the system traversing the entire string once every time, regardless of the length of the string, so you can add else {return false } to the end of each for loop traversal
