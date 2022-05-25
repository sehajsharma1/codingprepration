package oak.codingprepration.java8.Programs;

public class Factorial {
	
	public static void main(String args[]) {
	     
	      //finding factorial of a number in Java using recursion - Example
	      System.out.println("factorial of 5 using recursion in Java is: " + factorial(5));
	     
	    }
	public static int factorial(int number){      
        //base case
        if(number == 0){
            return 1;
        }
        return number*factorial(number -1); //is this tail-recursion?
    }
	
}
