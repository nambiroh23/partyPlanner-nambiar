/**
  * @author Rohan Nambiar
  * class Person includes name, table # (originally null when we run the program), company (as an int), and index (place in ArrayList)
*/

public class Person {
  Name name;
  int table;
  int company;
  int index;

  /*
    * constructor to be used when populating
  */
  public Person(String last, String first, int company, int index) {
    this.name = new Name(last, first);
    this.company = company;
    this.index = index;
  }

  /*
    * constructor to be used when sorting into tables
  */
  public Person(Name name, int company, int index, int table) {
    this.name = name;
    this.company = company;
    this.index = index;
    this.table = table;
  }

  // list of companies
  String[] d = {"Wal-Mart", "Kroger", "Amazon", "Lowes", "Best Western", "KMart", "Fusian", "Heinz", "Gucci", "Prada", "Nike", "Dodge", "Maseratti", "Razor", "AMD", "Razer"};

  /*
    * for printing purposes
  */
  public String toString() {
    return name.full() + " - " + d[company] + " - Table " + table;
  }
}