public class LinkedList {
    class Node {
        Pet pet;
        Node next;

        public Node(Pet pet, Node next) {
            this.pet = pet;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "pet=" + pet +
                    ", next=" + next +
                    '}';
        }
    }

    Node head;
    int size;

    void insert(Pet p) {
        size++;
        Node node = new Node(p.clone(), null);
        if (head == null) {
            head = node;
        } else {
            if (head.pet.weight > node.pet.weight){
                node.next = head;
                head = node;
            }else{
                Node currentNode = head;
                Node nextNode = head.next;
                while (nextNode != null && nextNode.pet.weight < node.pet.weight) {
                    currentNode = nextNode;
                    nextNode = nextNode.next;
                }
                currentNode.next = node;
                node.next = nextNode;
            }
        }
    }

    void remove(Pet p){
        Node node = new Node(p.clone(), null);
        if (head != null && head.pet.equals(node.pet)){
            size--;
            head = head.next;
        }else{
            Node currentNode = head;
            Node nextNode = head.next;
            while(nextNode != null){
                if (nextNode.pet.equals(node.pet)){
                    size--;
                    currentNode.next = nextNode.next;
                    break;
                }
                currentNode = nextNode;
                nextNode = nextNode.next;
            }
        }
    }

    @Override
    public String toString() {
        Node currentNode = head;
        StringBuilder sb = new StringBuilder();
        while(currentNode != null){
            sb.append(currentNode.pet.toString() + "->");
            currentNode = currentNode.next;
        }
        sb.append("null");
        return "LinkedList{" +
                "nodes=" + sb +
                ", size=" + size +
                '}';
    }
}
