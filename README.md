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

I created an ArrayList of all guests, an array of Companies, each with a list of emplyees, and iterated through all of the people, using the iterator mod the table count to assign tables.

I added fuinctionality to register guests as many times as desired (as long as we follow the given constraints), print the roster in different desirable formats, and easily search for guests using a portion of their name.

Photos of it running; start from the bottom because it won't let me change the order for some reason.

<img width="749" alt="Screen Shot 2023-01-20 at 11 41 56 AM" src="https://user-images.githubusercontent.com/77296224/213754656-dbfec651-65f0-4ba0-a672-9b05e79270ff.png">
<img width="787" alt="Screen Shot 2023-01-20 at 11 41 49 AM" src="https://user-images.githubusercontent.com/77296224/213754661-6583c9f6-8863-4eda-bd51-4622db13edd4.png">
<img width="784" alt="Screen Shot 2023-01-20 at 11 41 41 AM" src="https://user-images.githubusercontent.com/77296224/213754663-105c6d91-1c76-4a4f-8cd4-e7f03e1311ef.png">
<img width="724" alt="Screen Shot 2023-01-20 at 11 41 25 AM" src="https://user-images.githubusercontent.com/77296224/213754666-330683e0-79aa-4d5b-831f-4c05c8853a00.png">
<img width="776" alt="Screen Shot 2023-01-20 at 11 41 17 AM" src="https://user-images.githubusercontent.com/77296224/213754667-8b4c5819-8567-4534-8eb2-f2b945ca5638.png">
<img width="772" alt="Screen Shot 2023-01-20 at 11 41 06 AM" src="https://user-images.githubusercontent.com/77296224/213754669-bebfe745-4af3-4777-9357-48ddd2cba3b2.png">
<img width="782" alt="Screen Shot 2023-01-20 at 11 40 50 AM" src="https://user-images.githubusercontent.com/77296224/213754672-d827489c-fd64-4b51-b582-2cd32498a7b2.png">
<img width="786" alt="Screen Shot 2023-01-20 at 11 40 34 AM" src="https://user-images.githubusercontent.com/77296224/213754676-545de508-4da0-4341-b65c-eaa624824b96.png">
