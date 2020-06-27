package academy.pocu.comp2500.assignment2;
import academy.pocu.comp2500.assignment2.registry.Registry;
public class Program {
    public static void main(String[] args) {
	    // write your code here
        Registry registry = new Registry();
        App app = new App(registry);
        registry.validate();
    }
}
