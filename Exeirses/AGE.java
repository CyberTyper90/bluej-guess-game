import java.util.Scanner;
/**
 * Write a description of class AGE here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class AGE
{
    public static void main(String [] args){
        
        Scanner keyboard = new Scanner (System.in);
        
        System.out.println("How old are you?");
        int age = keyboard.nextInt();
        
    if(age< 18 ){
       System.out.println("Too yount for the club");
       System.out.println("How much  you will you bribe me to get in?");
       int bribe  = keyboard .nextInt();
        if(bribe >= 20 ){
            System.out.println("You may enter");
            
        }else{
            System.out.println("Go home you scoundrel");
            
        } 
            
    }else{
        System.out.println("You may entel");
        
    }
    
}
}
