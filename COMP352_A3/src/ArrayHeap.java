//----------------------------------------------------------------
// Assignment 3 
// Written by: Richard Nguyen 26992544 
// For COMP 352 Section H - Fall 2020
//----------------------------------------------------------------
import java.util.Arrays;

public class ArrayHeap{
	
	private Job [] jobArray;
	private int size;
	
	//------------
	// Constructor
	//------------
	public ArrayHeap(int input) {
		
		jobArray = new Job [input + 1];
		size = 0;
		jobArray[0] = new Job("Job_0", 0, 0, 0);
	}
	
	//--------------------------------------
	// Methods to get the respective indices 
	//--------------------------------------
	private int parentIndex(int index) {
		return index / 2;
	}
	private int leftChildIndex(int index) {
		return index * 2;
	}
	private int rightChildIndex(int index) {
		return index * 2 + 1;
	}
	
	//------------------------------------------------------
	// Check if element is a leaf/ external node in the tree
	//------------------------------------------------------
	private boolean isLeaf(int index) {
		if(index >= (size / 2) && index <= (size)) {
			return true;
		}
		return false;
	}
	
	//---------------------------------------------
	// Method to swap the object between 2 elements
	//---------------------------------------------
	private void swap(int fIndex, int sIndex) {
		
		Job temp = jobArray[fIndex];
		jobArray[fIndex] = jobArray[sIndex];
		jobArray[sIndex] = temp;
		
	}
	
	//---------------------------------------------
	// Method to sort the tree to abide by min-heap 
	//---------------------------------------------
	private void sort(int index) {
		
		if(!isLeaf(index)) {
			if(jobArray[index].getFinalPriority() > jobArray[leftChildIndex(index)].getFinalPriority() || jobArray[index].getFinalPriority() > jobArray[rightChildIndex(index)].getFinalPriority()) {
				
				if(jobArray[leftChildIndex(index)].getFinalPriority() < jobArray[rightChildIndex(index)].getFinalPriority()) {
					
					swap(index, leftChildIndex(index));
					sort(leftChildIndex(index));
					
				}
				else {
					
					swap(index, rightChildIndex(index));
					sort(rightChildIndex(index));
					
				}
			}
			else if(jobArray[index].getFinalPriority() == jobArray[leftChildIndex(index)].getFinalPriority() || jobArray[index].getFinalPriority() == jobArray[rightChildIndex(index)].getFinalPriority()) {
				
				if(jobArray[index].getEntryTime() > jobArray[leftChildIndex(index)].getEntryTime()) {
					
					swap(index, leftChildIndex(index));
					sort(leftChildIndex(index));
					
				}
				else if(jobArray[index].getEntryTime() > jobArray[rightChildIndex(index)].getEntryTime()){
					
					swap(index, rightChildIndex(index));
					sort(rightChildIndex(index));
					
				}
				
			}
			else if(jobArray[leftChildIndex(index)].getIsUrgent()) {
				
				swap(index, leftChildIndex(index));
				sort(leftChildIndex(index));
				
			}
			else if(jobArray[rightChildIndex(index)].getIsUrgent()) {
				
				swap(index, rightChildIndex(index));
				sort(rightChildIndex(index));
			}
		}
	}
	
	//----------------------------------
	// Method to add element to the heap
	//----------------------------------
	public void add(Job j) {
		
		 if(size == jobArray.length) {
			 expandCapacity();
		 }
		
		 jobArray[++size] = j;
		 int temp = size;
		 
		 while(jobArray[temp].getFinalPriority() < jobArray[parentIndex(temp)].getFinalPriority()) {
			 
			 swap(temp, parentIndex(temp));
			 temp = parentIndex(temp);
			 
		 }
		 
	}
	
	//-------------------------------------------------------------------------------------------------------------
	// Method to find the job with the earliest entry time and has not been worked on and change it's priority to 1
	//-------------------------------------------------------------------------------------------------------------
	public void prioritySwap() {
		
		Job firstEntry = jobArray[1];
		int index = 0;
		for(int i = 1; i <= size - 1; i++) {
			
			if(firstEntry.getEntryTime() > jobArray[i].getEntryTime() && jobArray[i].getJobLength() == jobArray[i].getCurrentJobLength()) {
				
				firstEntry = jobArray[i];
				index = i;
			}
			if(jobArray[i].getIsUrgent()) {
				
				jobArray[i].setIsUrgent();
				
			}
		}
		
		jobArray[index].setFinalPriority(1);
		jobArray[index].setIsUrgent();
		
		for(int position = (size / 2); position >= 1; position--) {
			sort(position);
		}
		
	}
	
	//----------------------------------------------------------------------
	// Method to shift a job to the back of the group with the same priority
	//----------------------------------------------------------------------
	public void shift() {
		
		for(int i = 1; i <= size - 1; i++) {
			
			if(!isLeaf(i)) {
				if(jobArray[i].getFinalPriority() == jobArray[leftChildIndex(i)].getFinalPriority()) {
					swap(i, leftChildIndex(i));
				}
				else if(jobArray[i].getFinalPriority() == jobArray[rightChildIndex(i)].getFinalPriority()){
					swap(i, rightChildIndex(i));
				}
				else {
					break;
				}
			}
			else {
				break;
			}
		}
	}
	
	//----------------------------------------------------------------------------------------------------------
	// If the array becomes full, method creates a new array with a larger capacity and copies the elements over
	//----------------------------------------------------------------------------------------------------------
	private void expandCapacity() {
		int newCapacity = jobArray.length + 1;
		jobArray = Arrays.copyOf(jobArray, newCapacity);
	}
	
	//------------------------------------------
	// Method to retrieve object from an element
	//------------------------------------------
	public Job get(int index) {
		if(index <= 0 || index > size) {
			throw new IndexOutOfBoundsException("Index value is out of bounds");
		}
		
		return jobArray[index];
			
	}
	
	//-----------------------------------
	// Remove lead element from the array
	//-----------------------------------
	public void remove() {

		jobArray[1] = jobArray[size];
		size--;
		if(size != 0) {
			sort(1);
		}

	}
	
	//------------------------
	// Check if array is empty
	//------------------------
	public boolean isEmpty() {
		
		if(size == 0) {
			return true;
		}
		else
			return false;
	}
	
	public int getSize() {
		return size;
	}
	//------------------------
	// Print contents of array
	//------------------------
	public void showContents() {
		
		System.out.println("Contents of Arraylist: ");
		for(int i = 1; i <= size - 1; i++) {
			System.out.println(jobArray[i]);
		}
		System.out.println("End of List");
		
	}
}
