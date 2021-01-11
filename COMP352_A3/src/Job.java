//----------------------------------------------------------------
// Assignment 3 
// Written by: Richard Nguyen 26992544 
// For COMP 352 Section H - Fall 2020
//----------------------------------------------------------------

public class Job {
	
	private String jobName;
	private int jobLength;
	private int currentJobLength;
	private int jobPriority;
	private int finalPriority;
	private long entryTime;
	private long endTime;
	private long waitTime;
	private boolean isUrgent;
	
	//--------------------
	// Default Constructor
	//--------------------
	public Job() {
		
		jobName = "";
		jobLength = 0;
		currentJobLength = 0;
		jobPriority = 0;
		isUrgent = false;
		
	}
	
	//----------------------
	// Parameter Constructor
	//----------------------
	public Job(String name, int index, int length, int priority) {
		
		jobName = name;
		jobLength = length;
		currentJobLength = length;
		entryTime = index;
		jobPriority = priority;
		finalPriority = priority;
		isUrgent = false;
	}
	
	//----------------------
	// Deep-Copy Constructor
	//----------------------
	public Job (Job copy) {
		
		this(copy.getJobName(), (int) copy.getEntryTime(), copy.getJobLength(), copy.getJobPriority());
		
	}
	
	//--------------------------
	// Setter and Getter Methods
	//--------------------------
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
	public void setWaitTime(long input) {
		waitTime = input;
	}
	
	public boolean getIsUrgent() {
		return isUrgent;
	}
	public void setIsUrgent() {
		isUrgent = !isUrgent;
	}
	
	//--------------------------
	// Overriden toString method
	//--------------------------
	public String toString() {
		return getJobName() + ", len:" + getJobLength() + "," + getCurrentJobLength() + ", p:" + getJobPriority() + "," + getFinalPriority() + ", t:" + getEntryTime();
	}
}
