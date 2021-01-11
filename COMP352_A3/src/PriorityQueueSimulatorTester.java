//----------------------------------------------------------------
// Assignment 3 
// Written by: Richard Nguyen 26992544 
// For COMP 352 Section H - Fall 2020
//----------------------------------------------------------------

import java.io.FileWriter;
import java.io.IOException;

public class PriorityQueueSimulatorTester {

    public static void main(String[] args) {

        //-----------------------------------------------------
        // Create job objects and insert them into input arrays
        //-----------------------------------------------------
        int maxNumberOfJobs = 32;
        Job[] jobsInputArray = new Job[maxNumberOfJobs];
        ArrayHeap heap = new ArrayHeap(maxNumberOfJobs);
        SortedList list = new SortedList();

        for (int i = 1; i <= maxNumberOfJobs; i++) {
            int jobLength = (int) (Math.random() * 70 + 1);
            int priority = (int) (Math.random() * 40 + 1);
            int jobLabel = i;
            String name = "Job_" + jobLabel;
            jobsInputArray[i - 1] = new Job(name, jobLabel, jobLength, priority);
            jobsInputArray[i - 1] = new Job(name, jobLabel, jobLength, 1);
        }

        //-----------------------------
        // Begin processing Sorted List
        //-----------------------------
        long waitingTimeSum = 0;
        int timer = 0;
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < maxNumberOfJobs; i++) {
            timer++;
            list.add(new Job(jobsInputArray[i]));
        }

        int count = 0;
        int priorityChanges = 0;

        while (!(list.isEmpty())) {

            timer++;
            System.out.println("Now Executing: " + list.getFirst().toString());
            list.getFirst().setCurrentJobLength(list.getFirst().getCurrentJobLength() - 1);

            if (list.getFirst().getCurrentJobLength() <= 0) {
                list.getFirst().setWaitTime((timer - list.getFirst().getEntryTime() - list.getFirst().getJobLength()));
                waitingTimeSum = waitingTimeSum + list.getFirst().getWaitTime();
                list.remove();
                System.out.println("Jobs remaining: " + list.getSize());
                count++;
            } else {
                list.shift();
                System.out.println("Now shifting: " + list.getFirst().toString());
            }
            if (count == 30) {
                System.out.println("Now swapping -------: ");
                list.getFirst().setEntryTime(2);
                list.getSecond().setEntryTime(1);
                list.showContents();
                list.prioritySwap();
                count = 0;
                priorityChanges++;
            }
        }
        long endTime = System.currentTimeMillis();

        //---------------------------
        // Print results to text file
        //---------------------------
        try {
            FileWriter writer = new FileWriter("SimulatorPerformanceResults.txt", true);
            writer.write("---------------------------------------------------------------------------\n");
            writer.write("Sorted List Results:\n");
            writer.write("Current system time (cycles): " + timer + "\n");
            writer.write("Total Number of jobs executed: " + maxNumberOfJobs + "\n");
            writer.write("Average process waiting time: " + (waitingTimeSum / maxNumberOfJobs) + "\n");
            writer.write("Total number of priority changes: " + priorityChanges + "\n");
            writer.write("Actual system time needed to execute all jobs: " + (endTime - startTime) + " ms \n");
            writer.write("---------------------------------------------------------------------------\n");

            writer.close();
        } catch (IOException e) {

        }

        //----------------
        // Reset Variables
        //----------------
        timer = 0;
        count = 0;
        priorityChanges = 0;
        waitingTimeSum = 0;

        //----------------------
        // Begin processing heap
        //----------------------
        startTime = System.currentTimeMillis();

//		for(int i = 0; i < maxNumberOfJobs; i++) {
//			
//			timer++;
//			heap.add(new Job(jobsInputArray[i]));
//			
//		}
//		
//		while(!(heap.isEmpty())) {
//			
//			timer++;
//			//System.out.println("Now Executing: " + heap.get(1).toString());
//			heap.get(1).setCurrentJobLength(heap.get(1).getCurrentJobLength() - 1);
//			
//			if(heap.get(1).getCurrentJobLength() <= 0){
//				heap.get(1).setWaitTime((timer - heap.get(1).getEntryTime() - heap.get(1).getJobLength()));
//				waitingTimeSum = waitingTimeSum + heap.get(1).getWaitTime();
//				heap.remove();
//				System.out.println("Jobs remaining: " + heap.getSize());
//				count++;
//			}
//			else {
//				heap.shift();
//			}
//			if(count == 30) {
//				heap.prioritySwap();
//				count = 0;
//				priorityChanges++;
//			}
//		}
//		
//		endTime = System.currentTimeMillis();
//		
//		//---------------------------
//		// Print results to text file
//		//---------------------------
//		try {
//			FileWriter writer = new FileWriter("SimulatorPerformanceResults.txt", true);
//			writer.write("---------------------------------------------------------------------------\n");
//			writer.write("Arraylist Heap Results:\n");
//			writer.write("Current system time (cycles): " + timer + "\n");
//			writer.write("Total Number of jobs executed: " + maxNumberOfJobs + "\n");
//			writer.write("Average process waiting time: " + (waitingTimeSum / maxNumberOfJobs) + "\n");
//			writer.write("Total number of priority changes: " + priorityChanges + "\n");
//			writer.write("Actual system time needed to execute all jobs: " + (endTime - startTime) + " ms \n");
//			writer.write("---------------------------------------------------------------------------\n");
//			
//			writer.close();
//		}
//		catch(IOException e) {
//			
//		}

        System.out.println("Done");
    }

}
