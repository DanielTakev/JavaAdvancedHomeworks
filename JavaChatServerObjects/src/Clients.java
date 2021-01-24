import java.io.*;
import java.util.*;

class Clients{
    private ArrayList<PrintWriter>  printWriters;

    public Clients() {
        printWriters = new ArrayList<>(10);
    }

    public synchronized void addC(PrintWriter p){
        printWriters.add(p);
    }

    public synchronized void rmvC(PrintWriter p){
        printWriters.remove(p);
    }

    public synchronized void sendClient(String s){
        Iterator<PrintWriter> iterator = printWriters.iterator();
        while(iterator.hasNext()) {
            PrintWriter printWriter = iterator.next();
            printWriter.println(s);
        }
    }
    public synchronized int numberOfClients() {
        return printWriters.size();
    }
}