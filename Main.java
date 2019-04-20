import java.lang.*;
import java.util.*;

public class MyClass {
    static int liftFloor = 3;
    static int personFloor = 0;
    static int personAim = 0;
    
    public static void main(String args[]) {
        boolean firstGo = true;
        Scanner input = new Scanner(System.in);
        
        while(true)
        {
            System.out.println("Enter 'exit' to go your way,\nor anything else to continue wasting your time");
            if (input.next().equals("exit")) break;
            else {
                
                if (firstGo) {
                    
                    System.out.println("Where are you?");
                    personFloor = input.nextInt();
                    personFloor = personFloor > 0 ? (personFloor < 15 ? personFloor : 14) : 1;
                    
                    System.out.println("Where are you going to?");
                    personAim = input.nextInt();
                    personAim = personAim > 0 ? (personAim < 15 ? personAim : 14) : 1;
                    
                    firstGo = false;
                    
                }
                else {
                    
                    System.out.println("Lift: " + liftFloor + " floor");
                    System.out.println("You: " + personFloor + " floor\n");
                    
                    System.out.println("Where do you want to go?");
                    personAim = input.nextInt();
                    personAim = personAim > 0 ? (personAim < 15 ? personAim : 14) : 1;
                    System.out.println();
                
                }
                
                if (liftFloor != personFloor) liftMove(personFloor);
                
                liftMove(personAim);
                
                personFloor = personAim;
                
            }
            
        }
    }
    
    static void waitSeconds(int seconds) {
        long startTime = System.currentTimeMillis();
        long wait = seconds % 6;
        
        while (System.currentTimeMillis() - startTime < wait * 1000) {}
    }
    
    static void liftMove(int aim) {
        
        if (liftFloor == aim) {
            System.out.println("Lift is already on the " + aim + " floor!");
            return;
        }
        else {
            String vector;
            int vec;
            boolean moving = true;
            
            if (liftFloor < aim) {vector = "up"; vec = 1;}
            else {vector = "down"; vec = -1;}
            
            for (; moving; liftFloor += vec) {
                
                System.out.println("Floor: " + liftFloor);
                
                if(liftFloor != aim) {
                    System.out.println("Lift goes " + vector + "...\n");
                    waitSeconds(4);
                }
                else {
                    liftOpen();
                    moving = false;
                    liftFloor -= vec;
                }
            }
            
        }
        
    }
    
    static void liftOpen() {
        
        System.out.println("Doors are opening...");
        waitSeconds(3);
        
        System.out.println("Waiting for the passangers...");
        waitSeconds(5);
        
        System.out.println("Doors are closing...\n");
        waitSeconds(3);
    }
}
