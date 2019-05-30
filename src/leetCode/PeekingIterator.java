package leetCode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author fengjie
 * @date 2019:04:10
 */
public class PeekingIterator implements Iterator<Integer> {
    Iterator<Integer> iterator;
    List<Integer> list;
    int index;

    public PeekingIterator(Iterator<Integer> iterator) {
        this.iterator = iterator;
        list = new ArrayList<>();
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return list.get(index);
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        return list.get(index++);
    }

    @Override
    public boolean hasNext() {
        return index <= list.size() - 1;
    }

}
