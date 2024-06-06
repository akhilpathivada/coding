/**
 * author: akhilpathivada
 * time: 06/06/24 08:16
 *
 * https://leetcode.com/problems/peeking-iterator/
 *
 */
package design;

import java.util.Iterator;

public class PeekingIterator implements Iterator<Integer> {

    private final Iterator<Integer> iterator;

    private Integer next;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
        if (iterator.hasNext()) {
            next = iterator.next();
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return next;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer result = next;
        next = iterator.hasNext() ? iterator.next() : null;
        return result;
    }

    @Override
    public boolean hasNext() {
        return next != null;
    }

}
