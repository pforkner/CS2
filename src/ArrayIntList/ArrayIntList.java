package ArrayIntList;
public class ArrayIntList {
    private static final int DEFAULT_CAPACITY = 5;
    private int[] elementData;
    private int size;

    public ArrayIntList() {
        this.elementData = new int[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    public void add(int element) {
        ensureCapacity(size + 1);
        elementData[size] = element;
        size++;
    }

    public void add(int index, int element) {
        ensureCapacity(size + 1);
        // [2, 7, 1, 8, 2, 8]
        // add(1, 3)
        // [2,  3,  7,    1,    8,    2,   8]
        for (int i = size; i > index; i--) {
            elementData[i] = elementData[i - 1];
        }
        elementData[index] = element;
        size++;
    }

    public int get(int index) {
        return elementData[index];
    }

    public void remove(int index) {
        for (int i = index; i < size - 1; i++) {
            elementData[i] = elementData[i + 1];
        }
        size--;
    }

    public void clear() {
        size = 0;
    }

    public String toString() {
        if (size == 0) return "[]";
        String result = "[";
        for (int i = 0; i < size - 1; i++) {
            result += elementData[i] + ", ";
        }
        result += elementData[size - 1] + "]";
        return result;
    }

    public void ensureCapacity(int capacity) {
        if (capacity > elementData.length) {
            int newCapacity = elementData.length*2 + 1;
            if (newCapacity < capacity) {
                newCapacity = capacity;
            }
            int[] newArray = new int[newCapacity];
            for (int i = 0; i < elementData.length; i++) {
                newArray[i] = elementData[i];
            }
            elementData = newArray;
        }
    }

    public void mergeFrom(ArrayIntList other) {
        ensureCapacity(size + other.size);
        int j = 0; // counter for other
        for (int i = 0; i < size && j < other.size(); i++) {
            if (elementData[i] > other.elementData[j]) {
                // shift elementData over
                for (int k = size; k > i; k--) {
                    elementData[k] = elementData[k - 1];
                }
                // insert from other
                elementData[i] = other.elementData[j];
                // increment j
                j++;
                // increment size
                size++;
            }
        }
        // if there's still some left in other, copy it over
        if (j < other.size) {
            for (int k = j; k < other.size(); k++) {
                elementData[size] = other.get(k);
                size++;
            }
        }
    }

    public void mergeFrom2(ArrayIntList a) {
        ensureCapacity(this.size + a.size);
        int i = 0, j = 0;
        while (i < this.size && j < a.size) {
            if (a.get(j) < this.get(i)) {
                this.add(i, a.get(j)); // add(index, element) not allowed on test so should shift over using for loop, see add() above
                i++;
                j++;
                size++;
            } else {
                i++;
            }
        }
        if (j != a.size - 1) {
            while (j < a.size) {
                this.add(a.get(j));
                j++;
            }
        }
    }

    public void stutter() {
        ensureCapacity(2*size);
        for (int i = 2*size - 1; i > 0; i -= 2) {
            elementData[i] = elementData[i/2];
            elementData[i - 1] = elementData[i/2];
        }
        size *= 2;
    }

    public void stutter2() {
        ensureCapacity(size*2);
        for (int i = size - 1; i >= 0; i -= 1) {
            elementData[i*2 + 1] = elementData[i];
            elementData[i*2] = elementData[i];
        }
        size *= 2;
    }

}
