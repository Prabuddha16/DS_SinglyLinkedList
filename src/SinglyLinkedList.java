public class SinglyLinkedList {
    //LinkedList class
        private Node head;

        //Node class
        private static class Node{
            private int data;
            private Node next;

            public Node(int data){
                this.data = data;
                this.next = null;
            }
        }

        public void display(){
            Node temp = head;
            while(temp != null){
                System.out.print(temp.data + "-->");
                temp=temp.next;
            }
            System.out.println("null");
        }

        public int length(){
            if(head == null){
                return 0;
            }
            int count =0;
            Node temp = head;
            while (temp != null){
                count++;
                temp = temp.next;
            }
            return count;
        }

        public void insertFirst(int value){
            Node node = new Node(value);
            node.next = head;
            head = node;
        }

        public void insertLast(int value){
            Node node = new Node(value);
            if(head == null){
                head = node;
                return;
            }
            Node temp = head;
            while (null != temp.next){
                temp = temp.next;
            }
            temp.next = node;
        }

        public void insert(int pos,int value){
            Node node = new Node(value);
            if(pos == 1){
                node.next = head;
                head = node;
            }else{
                Node prev = head;
                int count = 1;
                while (count < pos-1){
                    prev = prev.next;
                    count++;
                }
                Node curr = prev.next;
                prev.next = node;
                node.next = curr;
            }
        }

        public static void main(String[] args) {
            SinglyLinkedList sll = new SinglyLinkedList();

            sll.head = new Node(56);
            Node second = new Node(52);
            Node third = new Node(16);
            Node fourth = new Node(45);

            sll.head.next = second;
            second.next = third;
            third.next = fourth;

            System.out.println("* Traverse the Linked List");
            sll.display();
            System.out.println("* Size of Linked List = "+" "+ sll.length());
            System.out.println("* Insert value atFirst");
            sll.insertFirst(10);
            sll.display();
            System.out.println("* Insert value atLast");
            sll.insertLast(33);
            sll.display();
            System.out.println("Insert at given position");
            sll.insert(3,36);
            sll.display();
            System.out.println("* Updated size of linkedlist = "+" "+ sll.length());
        }
}

