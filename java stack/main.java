public class main {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        
        // Inserting elements
        list.insertAtBeginning(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        list.insertAtPosition(15, 2);

        // Traversing forward
        System.out.println("Forward Traversal:");
        list.traverseForward();

        // Traversing backward
        System.out.println("\nBackward Traversal:");
        list.traverseBackward();

        // Deleting elements
        list.deleteAtBeginning();
        list.deleteAtEnd();
        list.delete(2);

        // Traversing forward after deletions
        System.out.println("\nForward Traversal after deletions:");
        list.traverseForward();
    }
}
    
