/**
* Hello.java
* First program in Java example.
*/

//class declaration header
public class Hello{
  
  //main method header
  public static void main(String[] args){
    //will print the String Hello World to the screen
    System.out.println("Hello World!"); 
    System.out.println(arithmatic(23,10.3, "f"));
    System.out.println(23*10.3);
  }//closes main method
  
  public static double arithmatic(double x, double y, String s) {
     double number = -1;
     if (s == "s") {
         return x-y;
     }
     else if (s == "m") {
         return x*y;
     }
     else if (s == "d") {
         return x/y;
     }
     else if (s == "a") {
         return x+y;
     }
     System.out.println("ERROR");
         return number
  }

}//closes class
