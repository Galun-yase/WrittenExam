package LeetcodeAndOffer.Leetcode;

public class LC641 {
    public static void main(String[] args) {
        int i = (-1) % 4;
        System.out.println(i);
    }

    class MyCircularDeque {

        int[] array;
        int capacity;
        int front;
        int rear;

        public MyCircularDeque(int k) {
            capacity = k + 1;
            array = new int[capacity];
            front = 0;
            rear = 0;
        }

        public boolean insertFront(int value) {
            if (isFull()) return false;

            front = (front - 1 + capacity) % capacity;
            array[front] = value;
            return true;
        }

        public boolean insertLast(int value) {
            if (isFull()) return false;

            array[rear] = value;
            rear = (rear + 1) % capacity;
            return true;
        }

        public boolean deleteFront() {
            if (isEmpty()) return false;

            front = (front + 1) % capacity;
            return true;
        }

        public boolean deleteLast() {
            if (isEmpty()) return false;
            rear = (rear - 1 + capacity) % capacity;
            return true;
        }

        public int getFront() {
            if (isEmpty()) return -1;
            return array[front];
        }

        public int getRear() {
            if (isEmpty()) return -1;
            return array[(rear - 1 + capacity) % capacity];
        }

        public boolean isEmpty() {
            return front == rear;
        }

        public boolean isFull() {
            return (rear + 1) % capacity == front;
        }
    }

    class MyCircularDeque2 {

        int[] queue;
        int cap;
        int size;
        int front;
        int last;

        public MyCircularDeque2(int k) {
            queue = new int[k + 1];
            cap = k;
            size = 0;
            front = 0;
            last = 0;
        }

        public boolean insertFront(int value) {
            if (size >= cap) return false;

            front++;
            front = front % cap;

            queue[front] = value;
            size++;

            return true;
        }

        public boolean insertLast(int value) {
            if (size >= cap) return false;

            queue[last] = value;
            size++;

            last = cap + last - 1;
            last = last % cap;

            return true;
        }

        public boolean deleteFront() {
            if (size <= 0) return false;

            queue[front] = 0;
            size--;

            front = cap + front - 1;
            front = front % cap;
            return true;
        }

        public boolean deleteLast() {
            if (size <= 0) return false;

            last++;
            last = last % cap;

            queue[last] = 0;
            size--;

            return true;
        }

        public int getFront() {
            if (size == 0) return -1;
            return queue[front];
        }

        public int getRear() {
            if (size == 0) return -1;
            return queue[(last + 1) % cap];
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == cap;
        }
    }

}
