import java.io.*;
import java.util.*;

class Main {
  public static void main(String[] args) {
    Party party = new Party();
    party.populate();
    party.register();
    party.sort();
    party.wholeRoster();
    party.tableRoster();
    party.companyRoster();
    while(true) {
      party.find();
    }
  }
}

class Party {
  int tableCount = 10;
  int tableSize = 10;
  int maxGuests = tableCount*tableSize; 
  int maxCompanySize = 10;
  public ArrayList<Person> people = new ArrayList<Person>();
  public Company[] companies;
  // public ArrayList<Person>[] tables = new ArrayList<Person>[tableCount];
  

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
        int x = scan.nextInt();
        people.add(new Person(scan.next(), scan.next(), scan.nextInt()-1, i));
        i++;
      }
    }
    catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }


    String[] d = {"Wal-Mart", "Kroger", "Amazon", "Lowes", "Best Western", "KMart", "Fusian", "Heinz", "Gucci", "Prada", "Nike", "Dodge", "Maseratti", "Razor", "AMD", "Razer"};

    companies = new Company[d.length];
    
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
      people.remove(people.size()-1);
    companies[removed.company].employees.remove(companies[removed.company].employees.size()-1);
      System.out.println("Extra person from " + companies[removed.company].name + " was cut; max " + maxGuests +  " guests total.");
    }
    
  }
  
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

  public void wholeRoster() {
    System.out.println("\nList of people:\n");
    System.out.println(people);
  }

  public void tableRoster() {
    System.out.println("\nList of tables:");
    for(int i = 1; i<=tableCount; i++) {
      System.out.println("\nTable " + i);
      for (Person p : people) {
        if(p.table==i) {
          System.out.println(p);
        }
      }
    }
  }

  public void companyRoster() {
    System.out.println("\nList of companies:");
    for(int i = 0; i<companies.length; i++) {
      System.out.println("\n" + companies[i].name);
      System.out.println(companies[i].employees);
    }
  }

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
        System.out.println("Please enter a valid company name.");
      }
      Person n = new Person(l, f, c, people.size());
      if(people.size()<100) {
        if(companies[n.company].employees.size()<maxCompanySize) {
          people.add(n);
        }
        else {
          System.out.println(companies[n.company].name + " has too many people; max " + maxCompanySize +  " guests per company.");
        }
      }
      else {
        System.out.println("Too many people; max " + maxGuests +  " guests total.");
      }
      
      
    }
  }

  public void find() {
    System.out.println("\nSearch for a person. Name:");
    Scanner scan = new Scanner(System.in);
    String s = scan.nextLine();
    boolean found = false;
    for(Person p : people) {
      if(p.name.full().toLowerCase().contains(s.toLowerCase())) {
        System.out.println(p);
        found = true;
      }
    }
    if(!found) {
      System.out.println("No results.");
    }
  }
}

class Company {
  // static final int maxCompanySize = 10;

  public String name;
  
  ArrayList<Person> employees;

  public Company(String name) {
    this.name = name;
    employees = new ArrayList<Person>();
  }
  
  // public boolean tooBig() {
  //   if(employees.size()>maxCompanySize) {
  //     return true;
  //   }
  //   return false;
  // }
}

class Person {
  Name name;
  int table;
  int company;
  int index;
  
  public Person(String last, String first, int company, int index) {
    this.name = new Name(last, first);
    this.company = company;
    this.index = index;
  }

  public Person(Name name, int company, int index, int table) {
    this.name = name;
    this.company = company;
    this.index = index;
    this.table = table;
  }

  String[] d = {"Wal-Mart", "Kroger", "Amazon", "Lowes", "Best Western", "KMart", "Fusian", "Heinz", "Gucci", "Prada", "Nike", "Dodge", "Maseratti", "Razor", "AMD", "Razer"};
  
  public String toString() {
    return name.full() + " - " + d[company] + " - Table " + table;
  }
}

class Name {
  public String last;
  public String first;

  public Name(String last, String first) {
    this.last = last;
    this.first = first;
  }
  
  public String full() {
    return first + " " + last;
  }
}