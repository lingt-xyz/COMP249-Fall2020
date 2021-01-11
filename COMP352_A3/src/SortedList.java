//----------------------------------------------------------------
// Assignment 3 
// Written by: Richard Nguyen 26992544 
// For COMP 352 Section H - Fall 2020
//----------------------------------------------------------------
import java.util.Arrays;

public class SortedList{
	
	private Node head;
	private int size;
	
	//--------------------
	// Default Constructor
	//--------------------
	public SortedList() {
		head = null;
		size = 0;
	}
	
	//------------------------------
	// Method to add element to list
	//------------------------------
	public void add (Job j) {
		
		Node n = new Node(j, head);
		head = n;
		n = null;
		size++;
		sort();
	}
	
	//-----------------------------------------
	// Method to sort list in order of priority
	//-----------------------------------------
	public void sort() {
		
		Node temp = null;
		boolean isSorted = false;
		
		while(!isSorted) {
			
			temp = head;
			
			isSorted = true;
			
			while(temp != null && temp.next != null) {
				if(temp.getJob().getFinalPriority() > temp.next.getJob().getFinalPriority()) {
				
					Job placeholder = temp.next.getJob();
					temp.next.setJob(temp.getJob());
					temp.setJob(placeholder);
					temp = temp.next;
					isSorted = false;
				} else if(temp.getJob().getFinalPriority() == temp.next.getJob().getFinalPriority()){
					if(temp.getJob().getEntryTime() > temp.next.getJob().getEntryTime()) {
						Job placeholder = temp.next.getJob();
						temp.next.setJob(temp.getJob());
						temp.setJob(placeholder);
						temp = temp.next;
						isSorted = false;	
					} else if(temp.next.getJob().getIsUrgent()) {
						Job placeholder = temp.next.getJob();
						temp.next.setJob(temp.getJob());
						temp.setJob(placeholder);
						temp = temp.next;
						isSorted = false;
					} else {
						temp = temp.next;
					}
				} else {
					temp = temp.next;

				}
			}
		}

	}
	
	//----------------------------------------------------------------------
	// Method to shift a job to the back of the group with the same priority
	//----------------------------------------------------------------------
	public void shift() {
		Node temp = head;
		
		while(temp != null && temp.next != null) {
			
			if(temp.getJob().getFinalPriority() == temp.next.getJob().getFinalPriority()) {
				
				Job placeholder = temp.next.getJob();
				temp.next.setJob(temp.getJob());
				temp.setJob(placeholder);
				temp = temp.next;
			}
			else {
				break;
			}
			
		}
	}
	
	//-----------------------------------------------------
	// Method to remove the element at the head of the list
	//-----------------------------------------------------
	public void remove() {
		
		head = head.next;
		size--;
		
	}
	
	//-------------------------------------------------------------------------------------------------------------
	// Method to find the job with the earliest entry time and has not been worked on and change it's priority to 1
	//-------------------------------------------------------------------------------------------------------------
	public void prioritySwap() {
		if (head == null){
			return;
		}
		Node position = head;
		Node temp = position;
		
		while(position != null && position.next != null) {
			
			if(temp.getJob().getEntryTime() > position.next.getJob().getEntryTime() && position.next.getJob().getJobLength() == position.next.getJob().getCurrentJobLength()) {
				
				temp = position.next;
				
			}
			if(position.getJob().getIsUrgent()) {
				
				position.getJob().setIsUrgent();
				
			}
			position = position.next;
			
		}

		temp.getJob().setFinalPriority(1);
		temp.getJob().setIsUrgent();
		sort();

	}
	
	//-------------------------------------
	// Method to print contents of the list
	//-------------------------------------
	public void showContents() {
		
		Node temp = head;
		int count = 0;
		if(temp == null) {
			
			System.out.println("There's nothing to display");
			
		}
		else {
			
			while(count < size) {
				
				System.out.print("[" + temp.getJob().toString() + "] --> ");
				temp = temp.next;
				count++;

			}
			System.out.println("End of List");
			System.out.println();
		}

	}
	
	//-------------------------------------
	// Method to check if the list is empty
	//-------------------------------------
	public boolean isEmpty() {
		
		if(size == 0) {
			return true;
		}
		else
			return false;
		
	}
	
	//--------------------------------------------------------
	// Method to return the job object at the head of the list
	//--------------------------------------------------------
	public Job getFirst() {
		return head.getJob();
	}

	public Job getSecond() {
		return head.next.getJob();

	}
	
	public int getSize() {
		return size;
	}
	//-----------------------------------------------------------------------------
	// Internal class for the Node objects that link to each other to make the list
	//-----------------------------------------------------------------------------
	private class Node{
		
		private Job job;
		private Node next;
		
		//-------------
		// Constructors
		//-------------
		public Node() {
			
			job = null;
			next = null;
			
		}
		
		public Node(Job j, Node n) {
			
			job = j;
			next = n;
		}
		
		//--------------------------
		// Setter and getter methods
		//--------------------------
		public Job getJob() {
			
			return job;
			
		}
		public Node getNode() {
			
			return next;
			
		}
		public void setJob(Job j) {
			
			job = j;
		}
		
	}
}
