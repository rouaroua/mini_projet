package rmi;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIServer {
    public static void main(String[] args) {
        try {
            TaskService taskService = new TaskServiceImpl();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("TaskService", taskService);
            System.out.println("RMI Server is running...");
        } catch (Exception e) {
            System.err.println("RMI Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}