package com.max.idea;

public class List {
    class Item {
        private int value;
        private Item next;

        public Item(int value) {
            this.value = value;
            this.next = null;
        }

        public boolean hasNext() {
            if (this.next != null) {
                return true;
            }
            else {
                return false;
            }
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Item getNext() {
            return next;
        }

        public void setNext(Item next) {
            this.next = next;
        }

        public String toString() {
            return Long.toString(this.value);
        }
    }

    private Item begin;
    private long counter;

    public List() {
        this.begin = null;
        this.counter = 0;
    }

    public long getCounter() {
        return counter;
    }

    public void add(int value) {
        Item item = new Item(value);
        if (this.begin == null) {
            this.begin = item;
        }
        else {
            end().setNext(item);
        }
        this.counter++;
    }

    public Item end() {
        if (this.begin == null) {
            return null;
        }
        Item iter = this.begin;
        while (iter.hasNext()) {
            iter = iter.getNext();
        }
        return iter;
    }
}
