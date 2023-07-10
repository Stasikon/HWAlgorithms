package com.example.main;


import com.example.main.Example.ArrayOutOfBoundsException;
import com.example.main.Example.ElementNotFoundException;
import com.example.main.Example.ValueCanNotBeEmptyException;
import com.example.main.Service.StringList;
import com.example.main.Service.StringListImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringTest {
    @BeforeEach
    @Test
    public void testAddByItem() {
        StringListImpl stringList = new StringListImpl(0);
        String item1 = "Nissan";
        String item2 = "Mazda";
        String item3 = "Toyota";
        String item4 = "Honda";

        assertEquals(item1, stringList.add(item1));
        assertEquals(1, stringList.arraySize());

        assertEquals(item2, stringList.add(item1));
        assertEquals(2, stringList.arraySize());

        assertEquals(item3, stringList.add(item1));
        assertEquals(3, stringList.arraySize());

        assertEquals(item4, stringList.add(item1));
        assertEquals(4, stringList.arraySize());

        assertThrows(ValueCanNotBeEmptyException.class, () -> stringList.add(null));
    }

    @Test
    public void testAddItemCorrectIndex() {
        StringListImpl stringList = new StringListImpl(0);
        String item1 = "Nissan";
        String item2 = "Mazda";
        String item3 = "Toyota";
        String item4 = "Honda";

        stringList.add(0, item1);
        assertEquals(1, stringList.arraySize());
        stringList.add(1, item2);
        assertEquals(2, stringList.arraySize());
        stringList.add(2, item3);
        assertEquals(3, stringList.arraySize());

        assertThrows(ValueCanNotBeEmptyException.class, () -> stringList.add(null));
        assertThrows(ArrayOutOfBoundsException.class, () -> stringList.add(4, item4));
    }

    @Test
    public void testSetElementInCorrectPositionOverwritingExistingOne() {
        StringListImpl stringList = new StringListImpl(0);
        String item1 = "Nissan";
        String item2 = "Mazda";
        String item3 = "Toyota";

        stringList.add(0, item1);
        stringList.add(1, item2);
        stringList.add(2, item3);

        stringList.remove("Mazda");

        assertEquals(2, stringList.arraySize());

        assertNull(stringList.get(2));

        assertThrows(ElementNotFoundException.class, () -> stringList.remove("Honda"));
    }

    @Test
    public void testRemoveByNameElement() {
        StringListImpl stringList = new StringListImpl(0);
        String item1 = "Nissan";
        String item2 = "Mazda";
        String item3 = "Toyota";

        stringList.add(0, item1);
        stringList.add(1, item2);
        stringList.add(2, item3);

        stringList.remove("Mazda");

        assertEquals(2, stringList.arraySize());

        assertNull(stringList.get(2));
        assertThrows(ElementNotFoundException.class, () -> stringList.remove("Honda"));
    }

    @Test
    public void testRemoveElementByIndex() {
        StringListImpl stringList = new StringListImpl(0);
        String item1 = "Nissan";
        String item2 = "Mazda";
        String item3 = "Toyota";

        stringList.add(0, item1);
        stringList.add(1, item2);
        stringList.add(2, item3);

        stringList.remove(1);

        assertEquals(2, stringList.arraySize());


        assertNull(stringList.get(2));

        assertThrows(ArrayOutOfBoundsException.class, () -> {
            stringList.remove(3);
        });
    }
    @Test
    public void testBooleanTrueOrFalseIfElementExistOrNotExist() {

        StringListImpl stringList = new StringListImpl(0);
        String item1 = "Nissan";
        String item2 = "Mazda";
        String item3 = "Toyota";

        stringList.add(0, item1);
        stringList.add(1, item2);
        stringList.add(2, item3);


        assertTrue(stringList.contains("Nissan"));

        //проверяем что элемента нет в списке
        assertFalse(stringList.contains("Honda"));
    }
    @Test
    public void testIndexOf() {
        StringListImpl stringList = new StringListImpl(0);
        String item1 = "Nissan";
        String item2 = "Mazda";
        String item3 = "Toyota";

        int index = stringList.indexOf("Nissan");
        assertEquals(0, index);

        int outIndex = stringList.indexOf("Honda");
        assertEquals(-1, outIndex);

        assertThrows(ValueCanNotBeEmptyException.class, () -> stringList.indexOf(null));
    }

    @Test
    public void  testLastIndexOf() {

        StringListImpl stringList = new StringListImpl(0);
        String item1 = "Nissan";
        String item2 = "Mazda";
        String item3 = "Toyota";

        stringList.add(0, item1);
        stringList.add(1, item2);
        stringList.add(2, item3);

        int index = stringList.lastIndexOf("Mazda");
        assertEquals(1, stringList.lastIndexOf("Mazda"));

        int outIndex = stringList.indexOf("Honda");
        assertEquals(1, outIndex);

        assertThrows(ValueCanNotBeEmptyException.class, () -> stringList.indexOf(null));

    }
    @Test
    public void   testGetIndexElement() {

        StringListImpl stringList = new StringListImpl(0);
        String item1 = "Nissan";
        String item2 = "Mazda";
        String item3 = "Toyota";

        stringList.add(0, item1);
        stringList.add(1, item2);
        stringList.add(2, item3);

        assertEquals(item1,stringList.get(0));

        String outIndex = stringList.get(3);
        assertNull(null,outIndex);

        assertThrows(ValueCanNotBeEmptyException.class, () -> stringList.indexOf(null));
    }
    @Test
    public void testEqualsListTrueOrFalseAndNullException() {
        //тест для сравнения списков
        StringListImpl stringList = new StringListImpl(0);
        String item1 = "Nissan";
        String item2 = "Mazda";
        String item3 = "Toyota";

        stringList.add(0, item1);
        stringList.add(1, item2);
        stringList.add(2, item3);

        StringListImpl list1 = new StringListImpl(0);
        String iItem1 = "Nissan";
        String iItem2 = "Mazda";
        String iItem3 = "Toyota";

        stringList.add(0, iItem1);
        stringList.add(1, iItem2);
        stringList.add(2, iItem3);

        StringListImpl list2 = new StringListImpl(0);
        String eItem1 = "Nissan";
        String eItem2 = "Mazda";
        String eItem3 = "Toyota";
        String eItem4 = "Honda";

        stringList.add(0, eItem1);
        stringList.add(1, eItem2);
        stringList.add(2, eItem3);
        stringList.add(3, eItem4);

        StringListImpl list3 = new StringListImpl(0);

        assertTrue(stringList.equals(list1));
        assertFalse(list2.equals(stringList));
        assertThrows(ElementNotFoundException.class, () -> stringList.indexOf(null));
    }
    @Test
    public void testReturnTrueIfListElementExist() {

        StringListImpl stringList = new StringListImpl(0);
        String item1 = "Nissan";
        String item2 = "Mazda";
        String item3 = "Toyota";

        stringList.add(0, item1);
        stringList.add(1, item2);
        stringList.add(2, item3);

        StringListImpl outElement = new StringListImpl(0);

        assertTrue(stringList.isEmpty());

        assertFalse(outElement.isEmpty());
    }
    @Test
    public void testClearFullList() {
        StringListImpl stringList = new StringListImpl(0);
        String item1 = "Nissan";
        String item2 = "Mazda";
        String item3 = "Toyota";

        stringList.add(0, item1);
        stringList.add(1, item2);
        stringList.add(2, item3);

        stringList.clear();

        assertEquals(0,stringList.size());
    }
    @Test
    public void testAddStringsInListInNewArray() {

        StringListImpl stringList = new StringListImpl(0);
        String item1 = "Nissan";
        String item2 = "Mazda";
        String item3 = "Toyota";

        stringList.add(0, item1);
        stringList.add(1, item2);
        stringList.add(2, item3);

        String[] expectedArray= stringList.toArray();

        assertArrayEquals(expectedArray,stringList.toArray());
    }
}




