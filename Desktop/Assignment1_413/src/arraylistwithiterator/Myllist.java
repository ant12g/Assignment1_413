/*************************************************
 File: Assignment1_413
 By: Antonio Gonzalez
 Date: 02/21/2023

 *************************************************/
package arraylistwithiterator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Myllist<E> implements Iterable<E> {
    private Node<E> head;
    private int size;

    public Myllist() {
        this.head = null;
        this.size = 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedListIterator();
    }

    public Iterator getIterator() {
        return new LinkedListIterator();
    }

    public int getLength() {
        return size;
    }

    private static class Node<E> {
        private E data;
        private Node<E> next;

        public Node(E data) {
            this.data = data;
            this.next = null;
        }
    }

    public void add(E element) {
        Node<E> newNode = new Node<>(element);
        if (head == null) {
            head = newNode;
        } else {
            Node<E> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void printList() {
        Node<E> current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void clear() {
        head = null;
        size = 0;
    }

    private class LinkedListIterator implements Iterator<E> {
        private Node<E> current;
        private Node<E> previous;
        private boolean removeAllowed;

        public LinkedListIterator() {
            this.current = head;
            this.previous = null;
            this.removeAllowed = false;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E data = current.data;
            previous = current;
            current = current.next;
            removeAllowed = true;
            return data;
        }

        @Override
        public void remove() {
            if (!removeAllowed) {
                throw new IllegalStateException("remove() can only be called once after next()");
            }
            if (previous == null) {
                throw new IllegalStateException("Cannot call remove() before calling next()");
            }
            if (previous == head) {
                head = current;
            } else {
                previous.next = current;
            }
            size--;
            removeAllowed = false;
        }
    }
}








//public class Myllist<E> implements Iterable<E> {
//    private Node<E> head;
//    private int size;
//
////    @Override
////    public boolean hasNext() {
////        return false;
////    }
////
////    @Override
////    public Object next() {
////        return null;
////    }
//
//    @Override
//    public Iterator<E> iterator() {
//        return new LinkedListIterator ();
//    }
//
//    private static class Node<E> {
//        private E data;
//        private Node<E> next;
//
//        public Node(E data) {
//            this.data = data;
//            this.next = null;
//        }
//    }
//
//    public void MyLList() {
//        this.head = null;
//        this.size = 0;
//    }
//
//    public void add(E element) {
//        Node<E> newNode = new Node<>(element);
//        if (head == null) {
//            head = newNode;
//        } else {
//            Node<E> current = head;
//            while (current.next != null) {
//                current = current.next;
//            }
//            current.next = newNode;
//        }
//        size++;
//    }
//
//    public int size() {
//        return size;
//    }
//
//    public boolean isEmpty() {
//        return size == 0;
//    }
//
//    public void printList() {
//        Node<E> current = head;
//        while (current != null) {
//            System.out.print(current.data + " ");
//            current = current.next;
//        }
//        System.out.println();
//    }
//
//    public void clear() {
//        head = null;
//        size = 0;
//    }
//
//    // Method to get the iterator for this instance
//    public Iterator<E> getIterator() {
//        return new LinkedListIterator();
//    }
//
//    private class LinkedListIterator implements Iterator<E> {
//        private Node<E> current;
//
//        public LinkedListIterator() {
//            this.current = head;
//        }
//
//        @Override
//        public boolean hasNext() {
//            return current != null;
//        }
//
//        @Override
//        public E next() {
//            if (!hasNext()) {
//                throw new NoSuchElementException();
//            }
//            E data = current.data;
//            current = current.next;
//            return data;
//        }
////        @Override
////        public Iterator<E> iterator() {
////            return new LinkedListIterator();
////        }
//    }
//}
