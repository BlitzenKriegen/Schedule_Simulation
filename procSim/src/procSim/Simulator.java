package procSim;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Simulator {

    public static void main(String[] args) {
        /*Settings usrRules = getSettings();*/
        Settings usrRules = new Settings(12,10,10,5,5);
        List<Process> listOfProc = createProcList(usrRules);
        System.out.println("Here!");
    }

    private static List<Process> createProcList(Settings usrRules) {
        List<Process> ls = new ArrayList<>();
        Process proc = new Process();
        for (int i = 0; i < usrRules.getMaxProc(); i++) {
            proc = createProc(usrRules.getMaxCpu(),usrRules.getMaxIO());
            ls.add(proc);
        }
        return ls;
    }

    @SuppressWarnings("unused")
    private static Settings getSettings() {
        Settings usrinp = new Settings();
        Scanner inp = new Scanner(System.in);

        System.out.println("What is the maximum processes in the Simulation?");
        usrinp.setMaxProc(inp.nextInt());

        System.out.println("What is the maximum CPU time for a process?");
        usrinp.setMaxCpu(inp.nextInt());

        System.out.println("What is the maximum IO time for a process?");
        usrinp.setMaxIO(inp.nextInt());

        System.out.println("What is the default CPU burst time in the Simulation?");
        usrinp.setCpuBurst(inp.nextInt());

        System.out.println("What is the default IO burst time in the Simulation?");
        usrinp.setIoBurst(inp.nextInt());

        inp.close();
        return usrinp;
    }

    /*
    Process tst = createProc(max);*/

    public static Process createProc(int cpuMax,int ioMax) {
        int cpuTime = new Random().nextInt(cpuMax) + 1; //between 1 and 10
        int ioTime = new Random().nextInt(ioMax) + 1;
        Process proc = new Process(cpuTime,ioTime);
        return proc;
    }
}
