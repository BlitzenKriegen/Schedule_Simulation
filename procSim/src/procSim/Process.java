package procSim;
/**
 * The following is the implementation of the
 * "processes" within the scheduling simulator.
 * Processes contain cpu and io time, which decement
 * down by one as long as it stays within the processing
 * of the "cpu".
 * @author Kiril Sikov
 *
 */
public class Process {
    private int ioBurst;
    private int cpuBurst;

    public Process(int cpu, int io) {
        this.ioBurst = io;
        this.cpuBurst = cpu;
    }

    public int getIoBurst() {
        return ioBurst;
    }

    public void setIoBurst(int ioBurst) {
        this.ioBurst = ioBurst;
    }

    public int getCpuBurst() {
        return cpuBurst;
    }

    public void setCpuBurst(int cpuBurst) {
        this.cpuBurst = cpuBurst;
    }

    public void decrementCpu() {
        this.cpuBurst = this.cpuBurst -1;
    }

    public void decrementIO() {
        this.ioBurst = this.ioBurst - 1;
    }
}
