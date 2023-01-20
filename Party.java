import java.io.*;
import java.util.*;

/**
  * @author Rohan Nambiar
  * party planner sorts guests from a list of companies such that no two guests from same company are at the same table
  * imports guest list from partyguests.txt
  * sorts with various functionalities to add people, check constraints on data, and read output from console
  * within a table, there are no constraints on where guests sit, so seats within 
*/

public class Party {
  // constants, but I didn't make them final in case we want to add functionality that involves editing them
  int tableCount = 10;
  int tableSize = 10;
  int maxGuests = tableCount*tableSize;
  int maxCompanySize = 10;

  // list of all the people
  public ArrayList<Person> people = new ArrayList<Person>();
  public Company[] companies;
  
  // public ArrayList<Person>[] tables = new ArrayList<Person>[tableCount];
  
  /*
    * populates the list of people from partyguest.txt, puts them in their companies, as well, and checks constraints
  */
  public void populate() {
    File guests = new File("partyguests.txt");
    try {
      Scanner s = new Scanner(guests);
      Scanner scan;
      int i = 0;
      while(s.hasNextLine()) {
        // System.out.println(i);
        scan = new Scanner(s.nextLine());
        scan.useDelimiter(",");
        int x = scan.nextInt(); // skip line
        people.add(new Person(scan.next(), scan.next(), scan.nextInt()-1, i));
        i++;
      }
    }
    catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }


    String[] d = {"Wal-Mart", "Kroger", "Amazon", "Lowes", "Best Western", "KMart", "Fusian", "Heinz", "Gucci", "Prada", "Nike", "Dodge", "Maseratti", "Razor", "AMD", "Razer"};

    companies = new Company[d.length]; // array of companies
    
    for(int i = 0; i<d.length; i++) {
      companies[i] = new Company(d[i]);
    }
    
    // File comps = new File("companies.txt");
    // System.out.println("hi"); //
    // try {
    //   Scanner s = new Scanner(comps);
    //   int x = 0;
    //   while(true) {
    //     if(s.nextLine().equals("done")) break;
    //     x++;
    //   }
    //   companies = new Company[x];
    //   s = new Scanner(comps);
    //   Scanner scan;
    //   for (int i=0; i<x; i++) {
    //     System.out.println(i); //
    //     scan = new Scanner(s.nextLine());
    //     scan.useDelimiter(",");
    //     x = scan.nextInt();
    //     companies[i] = new Company(scan.next());
    //   }
    // }
    // catch (FileNotFoundException e) {
    //   System.out.println("An error occurred.");
    //   e.printStackTrace();
    // }

    // check constraints
    for(Person p : people) {
      if(companies[p.company].employees.size()>=maxCompanySize) {
        System.out.println("Extra person from " + companies[p.company].name + " was cut; max " + maxCompanySize +  " guests per company.");
      }
      else {
        companies[p.company].employees.add(p);
      }
    }

    while(people.size()>maxGuests) {
      Person removed = people.get(people.size()-1);
      people.remove(people.size()-1);     companies[removed.company].employees.remove(companies[removed.company].employees.size()-1);
      System.out.println("Extra person from " + companies[removed.company].name + " was cut; max " + maxGuests +  " guests total.");
    }
    
  }

  /*
    * sorts into tables following the assignment requirements: no more than one person from each company at a table
  */
  public void sort() {
    int i = 0;
    for (Company c : companies) {
      for(int j = 0; j<c.employees.size(); j++) {
        Person temp = c.employees.get(j);
        c.employees.set(j, new Person(temp.name, temp.company, temp.index, i%tableCount + 1));
        people.set(i, c.employees.get(j));
        // tables[i].add(c.employees.get(j));
        i++;
      }
    }
  }

  /*
    * prints the whole list of guests
  */
  public void wholeRoster() {
    System.out.println("\nList of people:\n");
    System.out.println(people);
  }

  /*
    * prints guests by table
  */
  public void tableRoster() {
    System.out.println("\nList of tables:");
    for(int i = 1; i<=tableCount; i++) {
      System.out.println("\nTable " + i);
      for (Person p : people) {
        if(p.table==i) {
          System.out.println(p);
        } // close if
      } // close inner for
    } // close outer for
  } // close method

  /*
    * prints guests by company
  */
  public void companyRoster() {
    System.out.println("\nList of companies:");
    for(int i = 0; i<companies.length; i++) {
      System.out.println("\n" + companies[i].name);
      System.out.println(companies[i].employees);
    }
  }

  /*
    * lets user add guests as long as they want so long as constraints are followed
  */
  public void register() {
    while(true) {
      System.out.println("\nWould you like to register another guest? (no if not)");
      Scanner scan = new Scanner(System.in);
      if(scan.nextLine().contains("no")) {
        break;
      }
      System.out.println("Last name:");
      String l = scan.nextLine();
      System.out.println("First name:");
      String f = scan.nextLine();
      boolean ok = false;
      int c = 0;
      while(!ok) {
        System.out.println("Company name:");
        String comp = scan.nextLine();
        for(int i = 0; i<companies.length; i++) {
          if(companies[i].name.toLowerCase().equals(comp.toLowerCase())) {
            c = i;
            ok = true;
            break;
          }
        }
        if(!ok) {
          System.out.println("Please enter a valid company name.");
        }
      }
      Person n = new Person(l, f, c, people.size());
      if(people.size()<100) {
        if(companies[n.company].employees.size()<maxCompanySize) {
          people.add(n);
          companies[n.company].employees.add(n);
        }
        else {
          System.out.println(companies[n.company].name + " has too many people; max " + maxCompanySize +  " guests per company.");
        }
      }
      else {
        System.out.println("Too many people; max " + maxGuests +  " guests total.");
      } //close else
      
    } // close while
  } // close method

  /*
    * finds a person from a portion of their name inputted by the user
  */
  public void find() {
    System.out.println("\nSearch for a person. Name:");
    Scanner scan = new Scanner(System.in);
    String s = scan.nextLine();
    boolean found = false;
    for(Person p : people) {
      if(p.name.full().toLowerCase().contains(s.toLowerCase())) { // toLowerCase makes life easier for the user
        System.out.println(p);
        found = true;
      }
    }
    if(!found) {
      System.out.println("No results.");
    }
  }
}