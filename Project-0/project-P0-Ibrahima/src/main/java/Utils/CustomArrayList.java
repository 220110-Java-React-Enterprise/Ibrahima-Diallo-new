
package Utils;

import java.util.Iterator;

/**
 * A fairly simple ArrayList implementation extending custom list interface.
 * Default size is 2, grows by size * 2 when needed.
 * When an element is added or removed at an index other elements are not re-arranged.
 *
 * @param <E>
 */
public class CustomArrayList<E> implements CustomListInterface<E>, Iterable<E> {

    private Object[] array;
    private int size;
    private int maxSize;

    /**
     * Default constructor, creates an empty underlying array with maxSize 2
     */
    public CustomArrayList() {
        maxSize = 2;
        size = 0;
        array = new Object[maxSize];
    }

    /**
     * Sized constructor, creates an empty object with maxSize size
     * @param size the initial size of the underlying array
     */
    public CustomArrayList(int size) {
        maxSize = size;
        size = 0;
        array = new Object[size];
    }

    /**
     * Element list constructor, takes in variable number of objects and creates an underlying
     * array large enough to fit them.
     * @param e
     */
    public CustomArrayList(E ...e) {             // fixed
        maxSize = size = e.length;
        array = new Object[size];

        for (int i = 0; i < size; ++i) {
            array[i] = e[i];
        }
    }

    /**
     * Adds an object to the underlying array after all previously added objects.
     * If array needs to grow, it invokes grow method.
     * @param o object to be added
     */
    @Override
    public void add(Object o) {              // fixed
        //Implement this method
        // NOTE: if size >= maxSize we need to grow array
        //don't forget to check if we need to grow, and if so, call growArray();
        //we don't need to loop here, we only need to add the one element to the end of the array

        //so basically just check if we need to grow and then do array[size++] = o;
        if(size >= maxSize){
            growArray();
        }
        array[size++] = o;
    }

    /**
     * Adds object at specified index, advancing the size of the underlying array. This will
     * require us to shift all later elements further down the index order
     * @param index index location where object will be inserted
     * @param e element to be inserted
     * @throws IndexOutOfBoundsException
     */
    @Override
    public void add(E e, int index) throws IndexOutOfBoundsException {
        //Implement this method
        //don't forget to check and see if we need to grow the array.
        //don't forget to size++;

        if(size >= maxSize) {                 // fixed
            growArray();
        }
        try{

            for (int i = size - 1; i > index; i--) { // shifting
                array[i] = array[i-1];
            }
            array[index] = e;

//            i++; This will increment AFTER the statement resolves
//            ++i; This will increment BEFORE the statement resolves
//            int x = 5;
//            System.out.println(x++); //we would get 5
//            System.out.println(++x); //we would get 6


        }catch (IndexOutOfBoundsException iobe){
            System.out.println(iobe);
        }
        size++;
    }

    /**
     * gets the object located at supplied index
     * @param index index of object to get
     * @return object located at index
     * @throws IndexOutOfBoundsException
     */
    @Override
    public E get(int index) throws IndexOutOfBoundsException{         // fixed
        //Implement this method
        try{
            return (E) array[index];

        }catch (IndexOutOfBoundsException iobe){
            System.out.println(iobe);
        }
        return null;
    }

    /**
     * Emptys the underlying array by setting it's private reference to null and allowing
     * the old array to be garbage collected.
     */
    @Override
    public void clear() {           // fixed
        //Implement this method
        array = null;
        //don't forget to initialize a new array and reset size, you can just call the constructor again,
        //so just do:  array = CustomArrayList();
        maxSize = 2;
        size = 0;
        // array = new CustomArrayList();
        array = new Object[size];

    }

    /**
     * Check if object o is found within underlying array, using Object.equals() method
     * @param o object to search for
     * @return index location of first instance of matching object. -1 if not found.
     */
    @Override
    public int contains(Object o) {            // fixed
        //Implement this method
        //loop through the array, and with each iteration check for equality
        //use a for loop, iterate from i = 0 to i < array.length and with each iteration check if
        //o.equals(array[i]), and if true then return i;

        for(int i =0; i < array.length; i++){
            if(o.equals(array[i])){
                return i;
            }
        }
        return -1; // if not found
    }

    /**
     * Removes object at specified index from underlying array, we will then
     * need to shift the remaining elements up in the index order to fill in the gap
     * @param index index of object to remove from array
     */
    @Override
    public void remove(int index) {             // fixed
        //Implement this method
        array[index] = null;
        for (int i = index; i < size-1; ++i) {
            array[i] = array[i+1];
        }
        size--;
    }

    /**
     * returns size of array. This is the one greater than the index of the most advanced stored object,
     * not the maxSize which controls growth of the underlying array.
     * @return one greater than index of most advanced stored object
     */
    @Override
    public int size() {                     // fixed
        //Implement this method
        return size;
    }

    /**
     * iterator implementation
     * @return returns an iterator object to traverse the array list
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int cursor = 0;

            /**
             */
            @Override
            public boolean hasNext() {
                return cursor <= size - 1;
            }
            /**
             * returns the index the cursor points
             * @return the element at the location of the cursor and increment
             */
            @Override
            public E next() {
                return (E)array[cursor++];
            }
        };
    }

    /**
     * Doubles the size of the underlying array by creating a new array and copying the
     * contents of the previous array into it.
     */
    private void growArray(){
        //System.out.println("Growing Array from " + maxSize + " to " + maxSize * 2);
        //set up new array
        maxSize = maxSize * 2;
        Object[] tempArray = array;
        array = new Object[maxSize];

        //copy to new array
        for (int i = 0; i < size; i++) {
            array[i] = tempArray[i];
        }
    }
}