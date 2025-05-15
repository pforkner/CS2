public class ArrayIntList {
    private static final int DEFAULT_CAPACITY = 5;
    private int[] elementData;
    private int size;

    public ArrayIntList() {
        elementData = new int[DEFAULT_CAPACITY];
        size = 0;
    }

    // pre : capacity >= 0
    // post: constructs an empty list with the given capacity
    private ArrayIntList(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Capacity must be at least 0: " + capacity);
        }
        elementData = new int[capacity];
    }

    // for creating test cases more easily
    public ArrayIntList(int... elements) {
        this(Math.max(DEFAULT_CAPACITY, elements.length * 2));
        for (int n : elements) {
            add(n);
        }
    }


    public void add(int value) {
        add(size, value);
//        ensureCapacity(size + 1);
//        elementData[size] = value;
//        size++;
    }

    public void add(int index, int value) {
        ensureCapacity(size + 1);
        // shift to the right by one
        for (int i = size; i > index; i--) {
            elementData[i] = elementData[i - 1];
        }
        // insert the new value
        elementData[index] = value;
        size++;
    }

    public void remove(int index) {
        //  0  1  2  3  4  5
        // [3, 1, 4, 1, 5, 9]
        for (int i = index; i < size - 1; i++) {
            elementData[i] = elementData[i + 1];
        }
        size--;
    }

    public void clear() {
        size = 0;
    }

    public int get(int index) {
        return elementData[index];
    }

    public int indexOf(int value) {
        for (int i = 0; i < size; i++) {
            if (elementData[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public void ensureCapacity(int capacity) {
        if (capacity >= elementData.length) {
            int[] newArray = new int[size * 2 + 1];
            for (int i = 0; i < elementData.length; i++) {
                newArray[i] = elementData[i];
            }
            elementData = newArray;
        }
    }

    public int size() {
        return size;
    }

    public String toString() {
        if (size == 0) {
            return "[]";
        }
        String result = "[";
        for (int i = 0; i < size - 1; i++) {
            result += elementData[i] + ", ";
        }
        result += elementData[size - 1] + "]";
        return result;
    }

    public void removeAll1(int n) {
        for (int i = 0; i < size; i++) {
            if (elementData[i] == n) {
                remove(i);
                i--;
            }
        }
    }

    public void removeAll(int n) {
        for (int i = size - 1; i >= 0; i--) {
            if (elementData[i] == n) {
                remove(i);
            }
        }
    }
    
    public int longestSortedSequence1() {
        int longest = 0;
        int currentCount = 1;
        for (int i = 0; i < size - 1; i++) {
            if (elementData[i + 1] > elementData[i]) {
                currentCount++;
                if (currentCount > longest) {
                    longest = currentCount;
                }
            } else {
                currentCount = 1;
            }
        }
        return longest;
    }
}
