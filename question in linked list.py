class Node:
    def __init__(self, val):
        self.val = val
        self.next = None  

class LinkedList:
    def __init__(self):
        self.head = None  

    def addToTail(self, value):
        new_node = Node(value)
        if not self.head: 
            self.head = new_node
            return
        temp = self.head
        while temp.next:
            temp = temp.next
        temp.next = new_node 

    def printList(self):
        temp = self.head
        while temp:
            print(temp.val, end=" -> ")
            temp = temp.next
        print("None")

    def mergeLists(self, secondList):
        if not self.head: 
            self.head = secondList.head
            return        
        temp = self.head
        while temp.next:
            temp = temp.next
        temp.next = secondList.head

list1 = LinkedList()
list1.addToTail(1)
list1.addToTail(2)
list1.addToTail(3)

list2 = LinkedList()
list2.addToTail(4)
list2.addToTail(5)
list2.addToTail(6)
list1.mergeLists(list2)
list1.printList()
