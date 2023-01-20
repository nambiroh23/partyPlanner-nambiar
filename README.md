# partyPlanner-nambiar
AP CSA project

Assignment:
Create a data set of attendees, using an external file, built from the data below (and allow manual entries)
Your program should:
* Load users from external file (.csv or .txt will work fine)
  * As file i/o is not part of the AP Subset - please use the W3Schoolsl resource for File i/o in java only - you should NOT be lifting code to solve your program.
* check there are no more than 10 people attending from any company (variable?)
* check there are no more than 100 people in attendance (10 ppl/table, 10 tables) (variable or calculation from other variables - remember no magic numbers)
* check there is no more than 1 person from any company at each table
* permit users to 'register' to attend (in addition to the file import) <<however, limit of 100 attendees and 10 people/company..
* Place people at the tables
* Create functionality (methods) to
  * enroll or register a person
  * check user amounts (10/tablemax, 100 max total, etc)
  * place users at table
  * print 'rosters' by table
  * print rosters by company
  * Add getter functionality to 'find' a person and report what table they are at
