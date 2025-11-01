import java.util.LinkedList;

class MyLinkedList {
    LinkedList<Integer> list;

    public MyLinkedList() {
        list = new LinkedList<>();
    }

    // Get the value of the index-th node in the linked list.
    public int get(int index) {
        if (index < 0 || index >= list.size()) {
            return -1; // return -1 if index is invalid
        }
        return list.get(index);
    }

    // Add a node of value val before the first element of the linked list.
    public void addAtHead(int val) {
        list.addFirst(val);
    }

    // Append a node of value val at the last element of the linked list.
    public void addAtTail(int val) {
        list.addLast(val);
    }

    // Add a node of value val before the index-th node.
    public void addAtIndex(int index, int val) {
        if (index < 0 || index > list.size()) {
            return; // do nothing if index invalid
        }
        list.add(index, val);
    }

    // Delete the index-th node in the linked list, if the index is valid.
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= list.size()) {
            return; // do nothing if index invalid
        }
        list.remove(index);
    }
}
