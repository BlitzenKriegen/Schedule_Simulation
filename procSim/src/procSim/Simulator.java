// Enrik Rushiti & Kiril Sikov
package procSim;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Simulator {

    // use this for round robin when we get to it
    private int timeQuantum = 4;

    public static void main(String[] args) {
        /*Settings usrRules = getSettings();*/
        Settings usrRules = new Settings(3, 10, 5);
        List<Process> listOfProc = createProcList(usrRules);
        System.out.println("Running FCFS:");
        FCFS(listOfProc);

    }

    private static List<Process> createProcList(Settings usrRules) {
        List<Process> ls = new ArrayList<>();
        Process proc = new Process();
        for (int i = 0; i < usrRules.getMaxProc(); i++) {
            proc = createProc(usrRules.getMaxBurstTime());
            proc.setPid(i + 1);
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

        System.out.println("What is the default burst time in the Simulation?");
        usrinp.setDefaultBurst(inp.nextInt());

        inp.close();
        return usrinp;
    }

    /*
    Process tst = createProc(max);*/

    public static Process createProc(int maxBurstTime) {
        int burstTime = new Random().nextInt(maxBurstTime) + 1; //between 1 and 10
        Process proc = new Process(burstTime);
        return proc;
    }


    /* First Come First Serve Scheduling Algorithm
     *  - Processes are executed in the order they arrive in the ready queue
     * 
    */
    public static void FCFS(List<Process> listOfProcesses) {
        for (int = 0; i < listOfProcesses.size(); i++) {
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

        // Print out the results
        for (Process p : listOfProcesses) {
            System.out.println("Process " + p.getPid() + " waiting time: " + p.getWaitingTime() + " turnaround time: " + p.getTurnaroundTime());
        }
    }

}



