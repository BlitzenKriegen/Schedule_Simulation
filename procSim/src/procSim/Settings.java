// Enrik Rushiti & Kiril Sikov
package procSim;

public class Settings {
    private int maxProcesses;
    private int maxBurstTime;
    private int defaultBurst;

    public Settings() {
        this.maxProcesses = 0;
        this.maxBurstTime = 0;
        this.defaultBurst = 0;
    }

    public Settings(int maxProcesses, int maxBurstTime, int defaultBurst) {
        this.maxProcesses = maxProcesses;
        this.maxBurstTime = maxBurstTime;
        this.defaultBurst = defaultBurst;
    }

    public int getMaxProcesses() {
        return maxProcesses;
    }

    public void setMaxProcesses(int maxProcesses) {
        this.maxProcesses = maxProcesses;
    }

    public int getMaxBurstTime() {
        return maxBurstTime;
    }

    public void setMaxBurstTime(int maxBurstTime) {
        this.maxBurstTime = maxBurstTime;
    }

    public int getDefaultBurst() {
        return defaultBurst;
    }

    public void setDefaultBurst(int defaultBurst) {
        this.defaultBurst = defaultBurst;
    }
}
