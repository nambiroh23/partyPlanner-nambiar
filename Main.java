/**
  * @author Rohan Nambiar
  * Main java file
*/

class Main {
  public static void main(String[] args) {
    Party party = new Party();
    party.populate();
    party.register();
    party.sort();
    party.wholeRoster();
    party.tableRoster();
    party.companyRoster();
    while(true) { // at the end, let them keep searching for people as they want
      party.find();
    }
  }
}