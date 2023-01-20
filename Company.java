import java.io.*;
import java.util.*;

/**
  * @author Rohan Nambiar
  * class Company has name and an ArrayList of employees
*/

public class Company {
  // static final int maxCompanySize = 10;

  public String name;
  
  ArrayList<Person> employees;

  /*
    * constructor
  */
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