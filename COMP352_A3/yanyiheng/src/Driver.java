public class Driver {
    public static void main(String[] args) {
        System.out.println("The Min Heap is ");
        MinHeap minHeap = new MinHeap(1000000);
        Job job1 = new Job("job1", 20, 20, 2, 2);
        Job job2 = new Job("job2", 20, 20, 3, 2);
        Job job3 = new Job("job3", 20, 20, 4, 2);
        Job job4 = new Job("job4", 20, 20, 5, 2);
        Job job5 = new Job("job5", 20, 20, 6, 2);
        Job job6 = new Job("job6", 20, 20, 7, 2);
        Job job7 = new Job("job7", 20, 20, 8, 2);
        Job job8 = new Job("job8", 20, 20, 9, 2);
        Job job9 = new Job("job9", 20, 20, 10, 2);
        Job job10 = new Job("job10", 20, 20, 11, 2);
        Job job11 = new Job("job11", 20, 20, 12, 2);

        minHeap.insert(job1);
        minHeap.insert(job2);
        minHeap.insert(job3);
        minHeap.insert(job4);
        minHeap.insert(job5);
        minHeap.insert(job6);
        minHeap.insert(job7);
        minHeap.insert(job8);
        minHeap.insert(job9);
        minHeap.insert(job10);
        minHeap.insert(job11);

        //minHeap.remove();

        minHeap.print();
        System.out.println("The Min val is " + minHeap.remove());
    }
}
