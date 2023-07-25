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

}
