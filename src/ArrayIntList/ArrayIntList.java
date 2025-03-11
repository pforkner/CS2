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

    }
}
