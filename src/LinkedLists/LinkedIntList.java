package LinkedLists;// Class LinkedLists.LinkedIntList can be used to store a list of integers.

public class LinkedIntList {
    private ListNode front;  // first value in the list

    // post: constructs an empty list
    public LinkedIntList() {
        front = null;
    }

    // post: returns the current number of elements in the list
    public int size() {
        int count = 0;
        ListNode current = front;
        while (current != null) {
            current = current.next;
            count++;
        }
        return count;
    }

    // pre : 0 <= index < size()
    // post: returns the integer at the given index in the list
    public int get(int index) {
        return nodeAt(index).data;
    }

    // post: creates a comma-separated, bracketed version of the list
    public String toString() {
        if (front == null) {
            return "[]";
        } else {
            String result = "[" + front.data;
            ListNode current = front.next;
            while (current != null) {
                result += ", " + current.data;
                current = current.next;
            }
            result += "]";
            return result;
        }
    }

    // post : returns the position of the first occurrence of the given
    //        value (-1 if not found)
    public int indexOf(int value) {
        int index = 0;
        ListNode current = front;
        while (current !=  null) {
            if (current.data == value) {
                return index;
            }
            index++;
            current = current.next;
        }
        return -1;
    }

    // post: appends the given value to the end of the list
    public void add(int value) {
        if (front == null) {
            front = new ListNode(value);
        } else {
            ListNode current = front;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new ListNode(value);
        }
    }

    // pre: 0 <= index <= size()
    // post: inserts the given value at the given index
    public void add(int index, int value) {
        if (index == 0) {
            front = new ListNode(value, front);
        } else {
            ListNode current = nodeAt(index - 1);
            current.next = new ListNode(value, current.next);
        }
    }

    // pre : 0 <= index < size()
    // post: removes value at the given index
    public void remove(int index) {
        if (index == 0) {
            front = front.next;
        } else {
            ListNode current = nodeAt(index - 1);
            current.next = current.next.next;
        }
    }

    // pre : 0 <= i < size()
    // post: returns a reference to the node at the given index
    private ListNode nodeAt(int index) {
        ListNode current = front;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    // YOUR CODE GOES HERE
    public boolean equals2(LinkedIntList other) {
        if (size() != other.size()) {
            return false;
        }
        ListNode current = front;
        ListNode otherCurrent = other.front;
        while (current != null && otherCurrent != null) {
            if (current.data != otherCurrent.data) {
                return false;
            }
            current = current.next;
            otherCurrent = otherCurrent.next;
        }
        // if we made it this far, they must be equal
        return true;
    }

    public void removeAll(int target) {
        if (front != null) {
            ListNode current = front;
            while (current.next != null) {
                if (current.next.data == target) {
                    current.next = current.next.next;
                } else {
                    current = current.next;
                }
            }
            if (front.data == target) {
                front = front.next;
            }
        }
    }

    public void switchPairs() {
        if(front != null && front.next != null) {
            // swap the first two nodes
            ListNode temp = front.next;
            front.next = front.next.next;
            temp.next = front;
            front = temp;
            ListNode current = front.next;
            while (current.next != null && current.next.next != null) {
                temp = current.next;
                current.next = current.next.next;
                temp.next = current.next.next;
                current.next.next = temp;
                current = temp;
            }
        }
    }

    public void removeDuplicates() {
        if (front != null) {
            ListNode current = front;
            while (current != null && current.next != null) {
                if (current.data == current.next.data) {
                    current.next = current.next.next;
                } else {
                    current = current.next;
                }
            }
        }
    }

    public void mergeFrom(LinkedIntList other) {
        if (front == null) { // if this list is empty, just add the other list
            front = other.front;
            other.front = null;
        } else if (other.front == null) {
            // do nothing
        } else {
            // handle the front of the list separately
            while (other.front != null && other.front.data < front.data) {
                ListNode temp = front;
                front = other.front;
                other.front = other.front.next;
                front.next = temp;
            }
            /* optimized front of the list
            if (other.front.data < front.data) {
                // skip forward to the point of insertion
                ListNode otherCurrent = other.front;
                while (otherCurrent.next != null && otherCurrent.next.data < front.data) {
                    otherCurrent = otherCurrent.next;
                }
                ListNode temp = front;
                front = other.front;
                other.front = otherCurrent.next;
                otherCurrent.next = temp;
            }


             */
            // handle the middle of the list
            ListNode current = front;
            while (current.next != null && other.front != null) {
                if (other.front.data < current.next.data) {
                    ListNode temp = current.next;
                    current.next = other.front;
                    other.front = other.front.next;
                    current.next.next = temp;
                    current = current.next;
                } else {
                    current = current.next;
                }
            }
            // handle whatever's left of the other list
//            while (other.front != null) {
//                current.next = other.front;
//                other.front = other.front.next;
//            }
            current.next = other.front;
            other.front = null;
        }


    }
}

