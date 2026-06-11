public class LinkedList1 {
    private Node first;
    private Node last;

    public void add(Node node) {
        if (this.first == null) {
            this.first = node;
            this.last = node;
        } else {
            node.setPrev(this.last);
            this.last.setNext(node);
            this.last = node;
        }
    }

    @Override
    public String toString() {
        Node head = this.first;
        String s = "[";
        while (head != null) {
            s += head.getName() + ",";
            head = head.getNext();
        }
        s = s.substring(0, s.length() - 1) + "]";
        return s;
    }

    public static class Node {
        private String name;
        private Node next;
        private Node prev;

        public Node(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

        public void setNext(Node node) {
            this.next = node;
        }

        public void setPrev(Node node) {
            this.prev = node;
        }

        public Node getNext() {
            return this.next;
        }
        
        @Override
        public String toString() {
            return this.name;
        }
    }

    public Node getFirst() {
        return this.first;
    }

    public Node getLast() {
        return this.last;
    }

    public static void main(String[] args) {
        LinkedList1 l1 = new LinkedList1();
        l1.add(new Node("John"));
        l1.add(new Node("Peter"));
        l1.add(new Node("Sally"));
        System.out.println(l1);  // Prints: [John,Peter,Sally]
        System.out.println(l1.getFirst());  // Prints: John
    }
}