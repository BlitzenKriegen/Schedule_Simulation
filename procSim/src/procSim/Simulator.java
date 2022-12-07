// Enrik Rushiti & Kiril Sikov

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Collections;

public class Simulator {

    // use this for round robin when we get to it
    // private int timeQuantum = 4;

    public static void main(String[] args) {
        /* Settings usrRules = getSettings(); */
        Settings usrRules = new Settings(5, 10);
        List<Process> listOfProcesses = createProcList(usrRules);
        
        // user menu to choose which algorithm to run
        
        
        System.out.println("Running Prio:");
        Priority(listOfProcesses);

        double averageWaitingTime = 0;
        int numOfProcesses = listOfProcesses.size();

        // Print out the results
        for (Process p : listOfProcesses) {
            System.out.println("Process " + p.getPid() + " - burst time: " + p.getBurstTime() + ", waiting time: "
                    + p.getWaitingTime() + ", turnaround time: " + p.getTurnaroundTime() + ", priority: " + p.getPriority());
            System.out.println("----------------------------------------");
            averageWaitingTime += p.getWaitingTime();
        }

        System.out.println("Average waiting time: " + (averageWaitingTime / numOfProcesses) + "ms");
    }

    private static List<Process> createProcList(Settings usrRules) {
        List<Process> ls = new ArrayList<>();
        Process proc = new Process();

        ArrayList priorities = new ArrayList<>();
        // fill up the priorities array with to match number of processes
        for (int j = 0; j < usrRules.getMaxProcesses(); j++) {
            priorities.add(j + 1);
        }

        // shuffle the priorities array so each process has a random priority
        Collections.shuffle(priorities);

        for (int i = 0; i < usrRules.getMaxProcesses(); i++) {
            proc = createProc(usrRules.getMaxBurstTime());
            proc.setPid(i + 1);
            proc.setPriority((int) priorities.get(i));

            ls.add(proc);
        }

        return ls;
    }

    @SuppressWarnings("unused")
    private static Settings getSettings() {
        Settings usrinp = new Settings();
        Scanner inp = new Scanner(System.in);

        System.out.println("What is the maximum processes in the Simulation?");
        usrinp.setMaxProcesses(inp.nextInt());

        System.out.println("What is the maximum burst time for a process?");
        usrinp.setMaxBurstTime(inp.nextInt());

        inp.close();
        return usrinp;
    }

    // generate a random process with a random burst time
    public static Process createProc(int maxBurstTime) {
        int burstTime = new Random().nextInt(maxBurstTime) + 1; // between 1 and 10
        Process proc = new Process(burstTime);
        return proc;
    }

    /*
     * First Come First Serve Scheduling Algorithm
     * - Processes are executed in the order they arrive in the ready queue
     */
    public static void FCFS(List<Process> listOfProcesses) {
        for (int i = 0; i < listOfProcesses.size(); i++) {
            Process currentProc = listOfProcesses.get(i);

            // For processes with a pid > 1
            if (i != 0) {
                Process prevProc = listOfProcesses.get(i - 1);
                currentProc.setWaitingTime(prevProc.getWaitingTime() + prevProc.getBurstTime());
                currentProc.setTurnaroundTime(currentProc.getWaitingTime() + currentProc.getBurstTime());
            }
            // For the first process
            else {
                currentProc.setWaitingTime(0);
                currentProc.setTurnaroundTime(currentProc.getBurstTime());
            }
        }
    }

    /*
     * Shortest Job First Scheduling Algorithm
     * - Processes are executed in order of their burst time
     */
    public static void SJF(List<Process> listOfProcesses) {
        // Sort the list of processes by burst time
        Collections.sort(listOfProcesses, new BurstTimeComparator());

        for (int i = 0; i < listOfProcesses.size(); i++) {
            Process currentProc = listOfProcesses.get(i);

            // For processes with a pid > 1
            if (i != 0) {
                Process prevProc = listOfProcesses.get(i - 1);
                currentProc.setWaitingTime(prevProc.getWaitingTime() + prevProc.getBurstTime());
                currentProc.setTurnaroundTime(currentProc.getWaitingTime() + currentProc.getBurstTime());
            }
            // For the first process
            else {
                currentProc.setWaitingTime(0);
                currentProc.setTurnaroundTime(currentProc.getBurstTime());
            }
        }         
    }

    /*
     * Priority Scheduling Algorithm
     * - Processes are executed in order of their priority
     */
    public static void Priority(List<Process> listOfProcesses) {
        // Sort the list of processes by priority
        Collections.sort(listOfProcesses, new PriorityComparator());

        for (int i = 0; i < listOfProcesses.size(); i++) {
            Process currentProc = listOfProcesses.get(i);

            // For processes with a pid > 1
            if (i != 0) {
                Process prevProc = listOfProcesses.get(i - 1);
                currentProc.setWaitingTime(prevProc.getWaitingTime() + prevProc.getBurstTime());
                currentProc.setTurnaroundTime(currentProc.getWaitingTime() + currentProc.getBurstTime());
            }
            // For the first process
            else {
                currentProc.setWaitingTime(0);
                currentProc.setTurnaroundTime(currentProc.getBurstTime());
            }
        }
    }
}
