public class LL {
    private Node head;
    private Node tail;
    private int size;

    public LL() {
        this.size = 0;
    }
    public void insertFirst(int val)
    {
        Node node=new Node(val);
        node.next=head;
        head=node;
        if(tail==null)
        {
            tail=head;
        }
        size++;
    }
    public void insertLast(int val)
    {
        if(tail==null)
        {
            insertFirst(val);
            return;
        }
        Node node=new Node(val);
        tail.next=node;
        tail=node;
        size++;
    }
    public void insertAtIndex(int ind,int val)
    {
        if(ind==0) {
            insertFirst(val);
            return;
        }
        if(ind==size)
        {
            insertLast(val);
            return;
        }

        Node temp=head;
        for(int i=1;i<ind;i++)
        {
            temp=temp.next;
        }
        Node node=new Node(val,temp.next);
        temp.next=node;
        size++;
    }
    public void deleteFirst()
    {
        head=head.next;
        if(head==null)
            tail=null;
        size--;
    }
    public void deleteLast()
    {
        if(size<=1)
        {
            deleteFirst();
            return;
        }
        Node secondLast=get(size-2);
        tail=secondLast;
        tail.next=null;

    }
    public void deleteAtIndex(int ind)
    {
        if(size==0)
            return;
        if(ind==0) {
            deleteFirst();
            return;
        }
        if(ind==size-1) {
            deleteLast();
            return;
        }
        Node prev=get(ind-1);
        prev.next=prev.next.next;
        size--;
    }
    public Node find(int val)
    {
        Node node=head;
        while(node!=null)
        {

            if(node.value==val)
                return node;
            node=node.next;
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
    public void display()
    {
        Node temp= head;
        while(temp!=null)
        {
            System.out.print(temp.value+"->");
            temp=temp.next;
        }
        System.out.print("END");

    }

    private class Node {
        private int value;
        private Node next;
        //constructor if no object is provided
        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

    }
}
