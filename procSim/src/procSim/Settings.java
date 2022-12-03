package procSim;

public class Settings {
    private int maxProc;
    private int maxCpu;
    private int maxIO;
    private int cpuBurst;
    private int ioBurst;

    public Settings() {
        this.maxProc = 0;
        this.maxCpu = 0;
        this.maxIO = 0;
        this.cpuBurst = 0;
        this.ioBurst = 0;
    }

    public Settings(int proc, int mxCpu, int mxIO, int cpuB, int IOB) {
        this.maxProc = proc;
        this.maxCpu = mxCpu;
        this.maxIO = mxIO;
        this.cpuBurst = cpuB;
        this.ioBurst = IOB;
    }

    public int getMaxProc() {
        return maxProc;
    }
    public void setMaxProc(int maxProc) {
        this.maxProc = maxProc;
    }
    public int getMaxCpu() {
        return maxCpu;
    }
    public void setMaxCpu(int maxCpu) {
        this.maxCpu = maxCpu;
    }
    public int getMaxIO() {
        return maxIO;
    }
    public void setMaxIO(int maxIO) {
        this.maxIO = maxIO;
    }
    public int getCpuBurst() {
        return cpuBurst;
    }
    public void setCpuBurst(int cpuBurst) {
        this.cpuBurst = cpuBurst;
    }
    public int getIoBurst() {
        return ioBurst;
    }
    public void setIoBurst(int ioBurst) {
        this.ioBurst = ioBurst;
    }
}
