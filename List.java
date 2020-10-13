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

    public String toString() {
        String result = "[ ";
        if (this.begin == null) {
            return null;
        }
        else {
            Item iter = this.begin;
            while (iter.hasNext()) {
                result += iter.toString() + ", ";
                iter = iter.getNext();
            }
            result += iter.toString();
        }
        result += " ]";
        return result;
    }

    public Item indexAt(int index) {

        if ((index <= this.counter - 1 ) && (index >=0)) {
            Item iter = this.begin;
            for (int i=0; i <index; ++i) {
                iter = iter.getNext();
            }
            return iter;
        }
        return null;
    }

    public void swap(int firstPos, int secondPos) {
        if (firstPos > secondPos) {
            int a;
            a = firstPos;
            firstPos = secondPos;
            secondPos = a;
        }
        Item predFirst = indexAt(firstPos - 1);
        Item predSecond = indexAt(secondPos - 1);
        Item first = indexAt(firstPos);
        Item second = indexAt(secondPos);
        Item postFirst = indexAt(firstPos + 1);
        Item postSecond = indexAt(secondPos + 1);
        if ((firstPos >= 0) && (firstPos <= counter - 1) && (secondPos >= 0) && (secondPos <= counter - 1) && (firstPos != secondPos)) {
            if (predFirst == null) {
                if (secondPos - firstPos == 1) {
                    this.begin = second;
                    second.setNext(first);
                    first.setNext(postSecond);
                } else {
                    this.begin = second;
                    second.setNext(postFirst);
                    predSecond.setNext(first);
                    first.setNext(postSecond);
                }
            } else {
                if (secondPos - firstPos == 1) {
                    predFirst.setNext(second);
                    second.setNext(first);
                    first.setNext(postSecond);
                } else {
                    predFirst.setNext(second);
                    second.setNext(postFirst);
                    predSecond.setNext(first);
                    first.setNext(postSecond);
                }
            }
        }
    }
}
