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