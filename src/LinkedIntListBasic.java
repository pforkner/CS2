public class LinkedIntListBasic {
    Node front;

    // private inner class
    private class Node {
        int data;
        Node next;
    }

    public void add(int n) {
        Node newNode = new Node();
        newNode.data = n;
        if (front == null) {
            front = newNode;
        } else {
            Node current = front;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // index must be less than size - 1
    public void add(int index, int n) {
        Node newNode = new Node();
        newNode.data = n;
        if (index == 0) {
            newNode.next = front;
            front = newNode;
        } else {
            Node current = front;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    public void remove(int index) {
        if (index == 0) {
            front = front.next;
        } else {
            Node current = front;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
        }
    }

    public String toString() {
        if (front == null) return "[]";
        String result = "[";
        Node current = front;
        while (current.next != null) {
            result += current.data + ", ";
            current = current.next;
        }
        result += current.data + "]";
        return result;
    }
}
