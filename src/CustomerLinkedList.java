public class CustomerLinkedList<Customer> {
    int size;
    CustomerNode<Customer> head, tail;

    CustomerLinkedList(){
        size = 0;
        head = null;
        tail = null;
    }

    public void addFirst(Customer c){
        CustomerNode<Customer> newNode = new CustomerNode<Customer>(c);
        newNode.next = head;
        head = newNode;
        size++;
        if (tail == null){
            tail = head;
        }

    }

}
