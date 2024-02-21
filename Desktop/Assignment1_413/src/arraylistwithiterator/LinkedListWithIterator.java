/*************************************************
 File: Assignment1_413
 By: Antonio Gonzalez
 Date: 02/21/2023

 *************************************************/
package arraylistwithiterator;

/**
 A class that implements the ADT list by using a resizable array.
 The list has an iterator. The class extends AList.

 @author Frank M. Carrano
 @version 5.0
 */
import java.util.Iterator;
import java.util.NoSuchElementException;



    public class LinkedListWithIterator<E> extends AList<E>  implements ListWithIteratorInterface<E>
    {
        public LinkedListWithIterator()
        {
            super();
        } // end default constructor

        public LinkedListWithIterator(int initialCapacity)
        {
            super();
        } // end constructor

        public Iterator<E> getIterator()
        {
            return new IteratorForArrayList();
        } // end getIterator

        public Iterator<E> iterator()
        {
            return getIterator();
        } // end iterator

        @Override
        public void add(E newEntry) {

        }

        @Override
        public boolean add(int newPosition, E newEntry) {

            return false;
        }

        @Override
        public Comparable remove(int givenPosition) {
            return null;
        }

        @Override
        public void clear() {

        }

        @Override
        public E replace(int givenPosition, E newEntry) {
            return null;
        }

        @Override
        public Comparable getEntry(int givenPosition) {
            return null;
        }

        @Override
        public Comparable[] toArray() {
            return null;
        }

        @Override
        public boolean contains(E anEntry) {
            return false;
        }

        @Override
        public int getLength() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        private class IteratorForArrayList implements Iterator<E>
        {
            private int     nextPosition;  // Position of next entry in the iteration
            private boolean wasNextCalled; // Needed by remove

            private IteratorForArrayList()
            {
                nextPosition = 1;
                wasNextCalled = false;
            } // end default constructor

            public boolean hasNext()
            {
                return nextPosition <= getLength();
            }

            public E next()
            {
                if (hasNext())
                {
                    wasNextCalled = true;
                    E nextEntry = (E) getEntry(nextPosition);
                    nextPosition++; // Advance iterator

                    return nextEntry;
                } // end if
                else
                    throw new NoSuchElementException("Illegal call to next();" +
                            "iterator is after end of list.");
            } // end next

            public void remove()
            {
                if (wasNextCalled)
                {
                    // nextPosition was incremented by the call to next, so it
                    // is 1 more than the position number of the entry to be removed
                    nextPosition--;  // Index of next entry in iteration
                    LinkedListWithIterator.this.remove(nextPosition);
                    wasNextCalled = false;	// Reset flag
                } // end if
                else
                    throw new IllegalStateException("Illegal call to remove(); " +
                            "next() was not called.");
            }
        }
}
