package rmi;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class TaskServiceImpl extends UnicastRemoteObject implements TaskService {
    private List<String> tasks;

    protected TaskServiceImpl() throws RemoteException {
        tasks = new ArrayList<>();
    }

    @Override
    public void addTask(String task) throws RemoteException {
        tasks.add(task);
    }

    @Override
    public void removeTask(String task) throws RemoteException {
        tasks.remove(task);
    }

    @Override
    public List<String> getTasks() throws RemoteException {
        return tasks;
    }
}