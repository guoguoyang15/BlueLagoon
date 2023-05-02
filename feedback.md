---
mark: 2.95

section_marks:
  c1-compliance: 0.25
  c2-git: 0.25
  c3-task-3-4-6-7-8: 2.5
  c4-task-5-viewer: 0.0
  c5-exceptional: 0.2

deductions:
  - name: |-
      compliance
    weight: 0.25
---

**Git, Code Quality and Readability**

The main thing we are looking for in this section is you are committing regularly and that you
are using appropriate git commit messages. Try to be a bit more descriptive in the next deliverables
but for this one you guys got full marks!

**Design (Use of OOP + appropriate data structures)**

There was no use of object-oriented programming in this submission that I could see (all the tasks were done using static methods). This is a problem since one of the core learning outcomes of this course is to be able to use OOP effectively.

One thing you could try to improve your mark for next submission is to see what functionality you can abstract out of the BlueLagoon class. For instance see if you can use the board class you created previously. You could have a constructor that takes a stateString as input (if the state string is valid) and have a toString method that decodes the board back into a string. Could you create a 'Move' class too? How could you use this in conjunction with the board class?

Also, some rough style tips: 
1. Look to see how you can simplify your condition statements. For instance, 
```
if (booleanCondition) {
  return true;
} else {
  return false;
 }
```
Can be simplified to just ```return booleanCondition;```.
2. Look to see how you can reduce your method sizes. This is not a hard and fast rule but if you have a method over a 100 lines long or have a depth more than 3-4, chances are there is something implement poorly. Longer more complex code like this greatly increases the chance of errors slipping into your code. Using a more object-oriented approach (see design section) would usually fix this though.
3. Try not to repeat code. If you are using the same section of logic multiple times try to see how this can be abstracted out, i.e. see if you can create a helper method to handle the functionality and call that instead. Again for this one, once you use OOP it becomes a lot easier to do this.

**UI**

I don't think your viewer works for the inputs I gave it. Since the GUI is an extremely important part of the assignment I would strongly recommend finishing this task of quickly. The solutions for lab 6 have been posted so if you are stuck on any of the javafx details then I would recommend having a look at that.

**Overall + Tips for next deliverables**

- Try to abstract some of your functionality out of the BlueLagoon class 
- Finish off your UI
- Try to make your code a little nicer. I have given some style tips above but sensible variable names and descriptive comments are also good too.
- Check to make sure you are passing your compliance tests! You guys lost marks for this

Feel free to come to me in the lab to ask for any questions about anything!



