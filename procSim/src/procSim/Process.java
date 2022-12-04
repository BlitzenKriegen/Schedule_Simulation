// Enrik Rushiti & Kiril Sikov
package procSim;
/**
 * The following is the implementation of the
 * "processes" within the scheduling simulator.
 * Processes contain burst time, which decrement
 * down by one as long as it stays within the processing
 * of the "cpu".
 * @author Kiril Sikov
 *
 */
public class Process {
    private int burstTime;
    private int pid;
    private int priority;
    private int waitingTime;
    private int turnaroundTime;

    public Process(int burst, int pid, int priority) {
        this.burstTime = burst;
        this.pid = pid;
        this.priority = priority;
        this.waitingTime = 0;
        this.turnaroundTime = 0;
    }

    public Process() {
        this.burstTime = 0;
        this.pid = 0;
        this.priority = 0;
        this.waitingTime = 0;
        this.turnaroundTime = 0;
    }

    public void decrementBurstTime() {
        this.cpuBurst = this.cpuBurst -1;
    }

    public int getBurstTime() {
        return burstTime;
    }

    public void setBurstTime(int burstTime) {
        this.burstTime = burstTime;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getWaitingTime() {
        return waitingTime;
    }

    public void setWaitingTime(int waitingTime) {
        this.waitingTime = waitingTime;
    }

    public int getTurnaroundTime() {
        return turnaroundTime;
    }

    public void setTurnaroundTime(int turnaroundTime) {
        this.turnaroundTime = turnaroundTime;
    }
}
