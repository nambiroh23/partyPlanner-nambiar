/**
  * @author Rohan Nambiar
  * class Name has first, last, a constructor, and a method that outputs full name
*/
class Name {

  /**
    * last name
  */
  public String last;
  /**
    * first name
  */
  public String first;

  /**
    * constructor
  */
  public Name(String last, String first) {
    this.last = last;
    this.first = first;
  }
  
  public String full() {
    return first + " " + last;
  }
}