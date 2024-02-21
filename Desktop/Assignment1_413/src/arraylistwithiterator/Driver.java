/*************************************************
 File: Assignment1_413
 By: Antonio Gonzalez
 Date: 02/21/2023

 *************************************************/

package arraylistwithiterator;

import java.util.*;
/**
 A driver that demonstrates the revised class ArrayListWithIterator.
 */
public class Driver {


    public static void main (String args[]) {

        System.out.println("Create a list: ");

        Myllist<String> myList = new Myllist<>();
        // Populating the list with string objects
        myList.add(" A\n");
        myList.add("B\n");
        myList.add("C\n");
        myList.add("D\n");

        // Printing the contents of the list
        Iterator<String> iterator = myList.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println("-----------");


        Iterator it = myList.getIterator();
        System.out.println("Execute the iterator's next() again:");
        try {
            it.next();		   // Should throw an error
            System.out.println("Oops... No exception");
        } catch (NoSuchElementException e) {
            System.out.println("NoSuchElementException was thrown as expected!");
        } // end catch

        System.out.println("\nBegin iteration again:");
        it = myList.getIterator();
        System.out.println("next() returns " + it.next() + " (should be A)");

        System.out.println("remove() should remove A");
        it.remove();

        System.out.println("next() returns " + it.next() + " (should be B)");
        System.out.println("next() returns " + it.next() + " (should be C)");

        System.out.println("remove() should remove C");
        it.remove();
        System.out.println();

        System.out.println("List state after all adds and removes");
        //displayList(myList);

        System.out.println("\nExecute the iterator's remove() again:");
        try {
            it.remove();		   // Should throw an error
            System.out.println("Oops... No exception");
        } catch (IllegalStateException e) {
            System.out.println("IllegalStateException was thrown as expected!");
        } // end catch

        //displayList(myList);
    } // end main

    public static void displayList(ListWithIteratorInterface<String> aList) {
        System.out.println("The list contains " + aList.getLength() +
                " string(s) running through iterator, as follows:");

        Iterator<String> it = aList.getIterator();

        while(it.hasNext()) {
            System.out.println(it.next());
        }
    }
} // end Driver
