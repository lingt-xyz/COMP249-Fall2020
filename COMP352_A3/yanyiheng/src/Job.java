public class Job {
    private String jobName; // the name of that process/job.
    private int jobLength; // the needed CPU cycles for this job to terminate.
    private int currentJobLength; // remaining length of the job at any given time.
    private int jobPriority; // the initial priority of this job.
    private int finalPriority; // the final priority of the job at termination time.
    private long entryTime = 0; // the time this job entered the priority queue.
    private long endTime = 0; // indicating when this job finally terminated.
    private long waitTime = 0; // the total amount of wait time a process had to incur from the time it entered the queue until it terminates.

    public Job(String jobName, int jobLength, int currentJobLength, int jobPriority, int finalPriority) {
        this.jobName = jobName;
        this.jobLength = jobLength;
        this.currentJobLength = currentJobLength;
        this.jobPriority = jobPriority;
        this.finalPriority = finalPriority;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public int getJobLength() {
        return jobLength;
    }

    public void setJobLength(int jobLength) {
        this.jobLength = jobLength;
    }

    public int getCurrentJobLength() {
        return currentJobLength;
    }

    public void setCurrentJobLength(int currentJobLength) {
        this.currentJobLength = currentJobLength;
    }

    public int getJobPriority() {
        return jobPriority;
    }

    public void setJobPriority(int jobPriority) {
        this.jobPriority = jobPriority;
    }

    public int getFinalPriority() {
        return finalPriority;
    }

    public void setFinalPriority(int finalPriority) {
        this.finalPriority = finalPriority;
    }

    public long getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(long entryTime) {
        this.entryTime = entryTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public long getWaitTime() {
        return waitTime;
    }

    public void setWaitTime(long waitTime) {
        this.waitTime = waitTime;
    }

    @Override
    public String toString() {
        return "Job{" +
                "jobName='" + jobName + '\'' +
                ", jobLength=" + jobLength +
                ", currentJobLength=" + currentJobLength +
                ", jobPriority=" + jobPriority +
                ", finalPriority=" + finalPriority +
                ", entryTime=" + entryTime +
                ", endTime=" + endTime +
                ", waitTime=" + waitTime +
                '}';
    }

    public void excecuteJob() {
        System.out.println("Now executing " + jobName +
                ". Job Length: " + jobLength +
                "; Current remaning length: " + currentJobLength +
                "; Initial priority: " + jobPriority +
                "; Current priority: " + finalPriority);
    }

    public void cycleDown() {
        currentJobLength--;
    }

    public void terminate(long current_time) {
        endTime = entryTime + current_time;
        waitTime = endTime - entryTime - jobLength;
    }
}
