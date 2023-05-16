package it.gferrara.st.es1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Iterator;

/**
 * Test unitario per il metodo di App.
 */

class AppTest {

    private List<String> list;
    private Iterator<String> itr;

    @BeforeEach
    void setup() {
        list = new ArrayList<String>();
        list.add("cat");
        list.add("dog");
        itr = list.iterator();
    }

    @Test
    void test1() {
        Assertions.assertTrue(itr.hasNext());
    }

    @Test
    void test2() {
        itr.next();
        itr.next();
        Assertions.assertTrue(!itr.hasNext());
    }

    @Test
    void test3() {
        itr = null;
        Assertions.assertThrows(NullPointerException.class, () -> itr.hasNext());
    }

    @Test
    void test_next_1() {
        itr = list.iterator();
        if(itr.hasNext()) {
            String item = itr.next();
            Assertions.assertEquals("cat", item);
        } else {
            Assertions.fail("Iterator should have a next item");
        }
        

    }

    @Test
    void test_next_2() {
        itr = list.iterator();
        itr.next();
        itr.next();
        Assertions.assertThrows(NoSuchElementException.class, () -> itr.next());
    }

    @Test
    void test_next_3() {
        list.add(null);
        itr = list.iterator();
        itr.next();
        itr.next();
        assertNull(itr.next());
    }

    @Test
    void testRemove1() {
        itr = list.iterator();
        itr.next();
        itr.remove();
        Assertions.assertFalse(list.contains("cat"));
    }

    @Test
    void testRemove2() {
        itr = list.iterator();
        while(itr.hasNext()) {
            itr.next();
        }
        itr.remove();
        Assertions.assertFalse(list.contains("dog"));
    }

    @Test
    void testRemove3() {
        itr = list.iterator();
        Assertions.assertThrows(IllegalStateException.class, () -> itr.remove());
    }

    @Test
    void testRemove4() {
        itr.next();
        list.add("elephant");
        Assertions.assertThrows(ConcurrentModificationException.class, () -> itr.remove());
    }

    @Test
    void testRemove5() {
        list = Collections.unmodifiableList(list);
        itr = list.iterator();
        itr.next();
        Assertions.assertThrows(UnsupportedOperationException.class, () -> itr.remove());
    }

    @Test
    void testRemove6() {
        itr = list.iterator();
        itr.next();
        itr.remove();
        itr.next();
        itr.remove();
        Assertions.assertTrue(list.isEmpty());
    }
}
