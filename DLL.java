public class DLL {
    private Node head;
    private Node tail;
    private int size;

    DLL() {
        this.size = 0;
    }

    private class Node {
        private int value;
        private Node next;
        private Node prev;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next, Node prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }

    public void insertAtFirst(int val) {

        Node newNode = new Node(val);
        newNode.next = head;
        newNode.prev = null;
        if (head != null) {
            head.prev = newNode;
        }
        head = newNode;
        size++;

    }

    public void insertLast(int val) {
        Node node = new Node(val);
        Node tmp = head;
        node.next = null;
        if (head == null) {
            node.prev = null;
            head = node;
            return;
        }

        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = node;
        node.prev = tmp;
        size++;
    }

    public void insertAfter(int after, int val) {
        Node node = new Node(val);
        Node prevNode = find(after);
        if (prevNode == null) System.out.println("doesn't exist");
        node.next = prevNode.next;
        prevNode.next = node;
        node.prev = prevNode;
        if (node.next != null) {
            node.next.prev = node;
        }


    }
    public void delete(int ind)
    {
        Node prev=get(ind-1);
        prev.next=prev.next.next;
        size--;
    }

    public Node find(int val) {
        Node node = head;
        while (node != null) {
            if (node.value == val) return node;
            node = node.next;
        }
        return null;

    }
    public Node get(int ind)
    {
        Node node=head;
        for(int i=0;i<ind;i++)
        {
            node=node.next;
        }
        return node;
    }

    public void display() {
        Node node = head;
        Node last = null;
        while (node != null) {
            System.out.print(node.value + " ->");
            last = node;
            node = node.next;
        }
        System.out.print("END");
        System.out.println("\nPrinting In Reverse");

        while (last != null) {
            System.out.print(last.value + " ->");

            last = last.prev;

        }
        System.out.print("START");
    }
}
