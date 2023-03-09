public class CLL {
    private Node head;
    private Node tail;
    private int size;

    public CLL() {
        this.size = 0;
    }

    private  class Node{
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
    public void insert(int val)
    {
        Node node =new Node(val);
        if(head==null)
        {
           head=node;
           tail=node;
           return;
        }
        tail.next=node;
        node.next=head;
        tail=node;
    }
    public void display()
    {
        Node node=head;
        if((head!=null)){
            do {
                System.out.print(node.value + " ->");
                node = node.next;
            } while (node != head);
        }
    }
}
