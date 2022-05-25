package oak.codingprepration.java8.Programs;

public class ReverseNumber 
{
	
	public static void main(String args[]) {
	        int number = 166;
	        System.out.println("Reverse of number: " + number + " is " + reverse(number));  
	   
	    }
	public static int reverse(int number){
        int reverse = 0;
        int remainder = 0;
        do{
            remainder = number%10;
            reverse = reverse*10 + remainder;
            number = number/10;
         
        }while(number > 0);
     
        return reverse;
    }

}
