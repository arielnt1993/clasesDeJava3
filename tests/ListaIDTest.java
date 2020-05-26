import static org.junit.Assert.*;
import  org.junit.Before;
import  org.junit.Test;

import java.util.NoSuchElementException;

public class ListaIDTest {
    private ListaID lista;
    @Before
    public void setup(){
        lista = new ListaID();
    }
    @Test
    public void testEmptyListIsEmpty(){
        assertTrue(lista.isEmpty());
    }
    @Test
    public void testSizeIsZeroInitially(){
        assertEquals(0,lista.size());
    }
    @Test
    public void testSizeIsNotZeroWhenElementsAreAdded(){
        lista.add(1);
        assertEquals(1,lista.size());
    }

    @Test
    public void testEmptyListIsFalseWhenElementsAreAdded(){
        lista.add(1);
        assertFalse(lista.isEmpty());
    }
    @Test (expected = NoSuchElementException.class)
    public void testGetNegativeNumbersFails(){

        lista.get(-1);
    }
    @Test(expected = NoSuchElementException.class)
    public void testGetInvalidIndexFails(){
        lista.get(5);
    }
    @Test(expected = NoSuchElementException.class)
    public void testGetInvalidIndexFail2(){
        lista.get(0);
    }
    @Test
    public void testGet(){
        for (int i = 0; i < 10; i++) {
            lista.add(i);
        }
        assertEquals(9,lista.get(0));
        assertEquals(4,lista.get(5));
        assertEquals(0,lista.get(9));
    }
    @Test
    public void testToStringEmptyList(){
        assertEquals("[]",lista.toString());
    }
    @Test
    public void testToStringNotEmptyList(){
        lista.add(3);
        lista.add(5);
        assertEquals("[5,3,]",lista.toString());
    }
    @Test
    public void testToStringNotEmptyListTwice(){
        lista.add(3);
        lista.add(5);
        assertEquals("[5,3,]",lista.toString());
        assertEquals("[5,3,]",lista.toString());
    }
    @Test
    public void testIterate(){
        for (int i = 0; i <10 ; i++) {
            lista.add(i);
        }
        int expected = 9;
        lista.start();
        while (lista.hasNext()){
            int x = lista.next();
            assertEquals(expected,x);
            expected--;
        }
        assertEquals(-1,expected);
    }
}