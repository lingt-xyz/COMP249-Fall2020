public class MinHeap {
    private static final int FRONT = 1;
    private final Job[] Heap;
    private int size;
    private final int maxsize;

    public MinHeap(int maxsize) {
        this.maxsize = maxsize;
        size = 0;
        Heap = new Job[this.maxsize];
    }

    // Function to return the position of
    // the parent for the node currently
    // at pos
    private int parent(int pos) {
        return pos / 2;
    }

    // Function to return the position of the
    // left child for the node currently at pos
    private int leftChild(int pos) {
        return (2 * pos);
    }

    // Function to return the position of
    // the right child for the node currently
    // at pos
    private int rightChild(int pos) {
        return (2 * pos) + 1;
    }

    // Function that returns true if the passed
    // node is a leaf node
    private boolean isLeaf(int pos) {
        return pos >= (size / 2) && pos <= size;
    }

    // Function to swap two nodes of the heap
    private void swap(int fpos, int spos) {
        Job tmp;
        tmp = Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;
    }

    // Function to heapify the node at pos
    private void minHeapify(int pos) {

        // If the node is a non-leaf node and greater
        // than any of its child
        if (!isLeaf(pos)) {
            if (Heap[pos].getJobPriority() > Heap[leftChild(pos)].getJobPriority()
                    || Heap[pos].getJobPriority() > Heap[rightChild(pos)].getJobPriority()) {

                // Swap with the left child and heapify
                // the left child
                if (Heap[leftChild(pos)].getJobPriority() < Heap[rightChild(pos)].getJobPriority()) {
                    swap(pos, leftChild(pos));
                    minHeapify(leftChild(pos));
                }

                // Swap with the right child and heapify
                // the right child
                else {
                    swap(pos, rightChild(pos));
                    minHeapify(rightChild(pos));
                }
            }
        }
    }

    // Function to insert a node into the heap
    public void insert(Job job) {
        if (size >= maxsize) {
            return;
        }
        Heap[++size] = job;
        int current = size;

        while (Heap[current].getJobPriority() < Heap[parent(current)].getJobPriority()) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    // Function to print the contents of the heap
    public void print() {
        for (int i = 1; i <= size / 2; i++) {
            System.out.print(" PARENT : " + Heap[i]
                    + " LEFT CHILD : " + Heap[2 * i]
                    + " RIGHT CHILD :" + Heap[2 * i + 1]);
            System.out.println();
        }
    }

    // Function to build the min heap using
    // the minHeapify
    public void minHeap() {
        for (int pos = (size / 2); pos >= 1; pos--) {
            minHeapify(pos);
        }
    }

    // Function to remove and return the minimum
    // element from the heap
    public Job remove() {
        Job popped = Heap[FRONT];
        Heap[FRONT] = Heap[size--];
        minHeapify(FRONT);
        return popped;
    }
} 