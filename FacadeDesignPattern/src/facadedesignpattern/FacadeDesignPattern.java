package facadedesignpattern;

public class FacadeDesignPattern {
    
    //Do all the complicated stuff here while at the client side just call startComputer() to use
    public static void startComputer(){
        StartCPU cpu = new StartCPU();
        StartScreen screen = new StartScreen();
        
        cpu.startCPU();
        screen.startScreen();
        
        System.out.println("Preparing Computer...");
    }
    
}
