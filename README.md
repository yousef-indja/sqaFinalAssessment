# 1. Scrum Sprint Backlog and Task Estimation <br>
### Tasks: <br>
Create java objects for Rubric, Criterion, Grade. <b>[1 Hour]</b><br>
Create Controller class that does the following: <b>[17 Hours]</b> 
- Create new Rubric <b>[1 Hour]</b>
- Add a Criterion to Rubric <b>[2 Hours]</b>
- Get a list of all Rubrics <b>[1 Hour]</b>
- Get specific Rubric by name <b>[2 Hours]</b>
- Create a new Grade <b>[1 Hour]</b>
- Add a score for a particular Criterion to Grade <b>[2 Hours]</b>
- Get all student grades associated to a rubric <b>[2 Hours]</b>
- Summary calculation for Rubric: <b>[3 Hours]</b>
  - Average <b>[1 Hour]</b>
  - Standard deviation <b>[1 Hour]</b>
  - Minimum and maximum score <b>[1 Hour]</b>
- Summary calculation for Criterion of Rubric: <b>[2 Hours]</b>
  - Average <b>[40 Mins]</b>
  - Standard deviation <b>[40 Mins]</b>
  - Minimum and maximum score <b>[40 Mins]</b>

<br>
These estimates were chosen based off prior experience of developing code to tackle similar problems, while also taking into consideration test-driven development, and the added time that comes with writing these tests.
<br>
<b>Velocity Metric</b><br>
Sprint velocity refers to teams analysing how much work they completed in previous sprints, and using that information to estimate how much work they can do in future sprints. This helps to better plan projects and predict how much work can be done in the next sprint, better calculate the amount of resources and effort needed, and help senior managmnet have a better idea of when to expect delivery of the product.<br>
<br>
There are two steps to calculating the velocity metric of a sprint, which are as follows:<br>
<br>
<b>Step 1:</b> Count how many user story points are completed in the previous sprints.<br>
For example, in sprint 1:

-  The team commited to finishing 4 user stories.
-  Each with 8 points per story for a total of 32 story points. 
-  However, the team only completed 3 of the 4 stories in the sprint.

In sprint 2:
- The team commited to 5 user stories.(including the 1 that was not completed in sprint 1)
- Each with 8 points per story for a total of 40 story points.
- However, the team only completed 4 of the stories.

In sprint 3:
- The team commited to 6 user stories.
- Each with 8 points per story for a total of 40 story points.
- However, the team only completed 4 of the stories.

<b>Step 2:</b> Calculate the average of completed story points.
The team must then add up the total story points that were completed from each sprint, then divide by the number of sprints.<br>
Sprint 1: 3 stories x 8 story points = 24<br>
Sprint 2: 4 stories x 8 story points = 32<br>
Sprint 2: 4 stories x 8 story points = 32<br>
Total = 96.<br>
Average sprint velocity is 88/3 = 27.<br>
<br>
The team can now base the amount of work to be done in future sprints on the average of 27 story points per sprint. While this is only an estimation, it provides a good starting point for teams to determine how much work can be done in each sprint.
<br>
# Unit Testing and Test Driven Developement<br>
In order to follow a test driven developemtn approach, I wrote my tests prior to writing my methods. This helped me focus on what each method is supposed to do. jUnit was used to write the tests. For example, the commit in which I added a method for creating a rubric (https://github.com/yousef-indja/sqaFinalAssessment/commit/389f1428a8167905b373bc1cefa54c02a7d2554a) there is a test case committed also. This test was written before the method in order to better follow a test driven approach.<br>
<br>
# Test Coverage Metric<br>
In order to verify that there is sufficent unit testing, I have chosen EclEmma, an Eclipse test coverage plug-in. I chose EclEmma as it comes pre-downloaded with the eclipse IDE, making it straight forward to use. 
<br>In order to run the tool, you must first ensure that it is up-to-date. This can be done by following these steps in Eclipse: 
<be>On the top menu press <b>Help</b>-><b>Eclipse Marketplace</b>
<br>From here you can search for EclEmma and install it. If it is pre-installed, click the *installed* button -> Press the <b>Update</b> button associated with EclEmma. If there is no <b>Update</b> button, and only an <b>Uninstall</b> button, your EclEmma plug-in is already up-to-date.
<br>Once EclEmma is up-to-date, right click on the project file in the package explorer on the left. Select <b>Coverage As</b>-><b>jUnit Test</b>
<br>You will then be shown the precentage coverage per class at the bottom of the screen.
<br>![firstRunOfTestCoverage](images/jUnitTestPrior2.png)
<br>In this first screenshot, you can see that in the StudentGrade class, the test coverage is only 49.3%, with methods such as the toString() not being tested.
<br>![secondRunOfTestCoverage](images/jUnitTestAfter.png)
<br>In this second screenshot, the test coverage for StudentGrade has gone up to 89%, as I added a test for the toString() method.
<br>This shows how a test coverage tool can help expose parts of your code that are not tested for, and help the developer by showing where exactly the tests are missing.