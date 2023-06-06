package test;

import main.exception.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static test.Constants.*;

class NewArrayListTest {


	@Test
	void testAddItem() {
		assertEquals(STR1, TEST.add(STR1));
		assertNotEquals(TEST, TEST2);
	}

	@Test
	void testAddItemOnIndex() {
		assertEquals(TEST.add(0, STR2), STR2);
	}

	@Test
	void set() {
		TEST.add(STR1);
		TEST.add(STR2);
		assertEquals(TEST.set(1, STR3), STR3);
	}

	@Test
	void testRemoveElement() {
		TEST.add(STR1);
		TEST.add(STR2);
		assertEquals(TEST.remove(STR2), STR2);
	}

	@org.junit.jupiter.api.Test
	void testRemoveElementOnIndex() {
		TEST.add(STR1);
		TEST.add(STR2);
		assertEquals(TEST.remove(1), STR2);
	}

	@Test
	void testContains() {
		TEST.add(STR1);
		TEST.add(STR2);
		assertTrue(TEST.contains(STR2));
		assertFalse(TEST.contains(STR3));
	}

	@Test
	void testIndexOf() {
		TEST.add(STR1);
		TEST.add(STR2);
		assertEquals(1, TEST.indexOf(STR2));
		assertEquals(-1, TEST.indexOf(STR3));
	}

	@Test
	void testLastIndexOf() {
		TEST.add(STR1);
		TEST.add(STR2);
		assertEquals(1, TEST.lastIndexOf(STR2));
		assertEquals(-1, TEST.lastIndexOf(STR3));
	}

	@Test
	void testGet() {
		TEST.add(STR1);
		TEST.add(STR2);
		TEST.add(STR3);
		assertEquals(STR2, TEST.get(1));
	}

	@Test
	void testEquals() {
		TEST.add(STR1);
		TEST.add(STR2);
		TEST.add(STR3);
		TEST2.add(STR1);
		TEST2.add(STR2);
		TEST2.add(STR3);
		assertTrue(TEST.equals(TEST2));
		TEST.remove(0);
		assertFalse(TEST.equals(TEST2));
	}

	@Test
	void size() {
		TEST.add(STR1);
		TEST.add(STR2);
		TEST.add(STR3);
		assertEquals(3, TEST.size());
	}

	@Test
	void isEmpty() {
		assertTrue(TEST.isEmpty());
		TEST.add(STR1);
		assertFalse(TEST.isEmpty());
	}

	@Test
	void clear() {
		TEST.add(STR1);
		TEST.add(STR2);
		TEST.add(STR3);
		TEST.clear();
		assertEquals(0, TEST.size());
	}

	@Test
	void toArray() {
		TEST.add(STR1);
		TEST.add(STR2);
		TEST.add(STR3);
		assertArrayEquals(STR_TEST, TEST.toArray());
	}
	@Test
	void shouldElementNotFoundException(){
		TEST.add(STR1);
		TEST.add(STR2);
		TEST.add(STR3);
		assertThrowsExactly(ElementNotFoundException.class, ()->TEST.remove(STR4));
	}

	@Test
	void shouldFullException(){
		TEST.add(STR1);
		TEST.add(STR2);
		TEST.add(STR3);
		assertThrowsExactly(FullException.class, ()->TEST.add(STR4));
		assertThrowsExactly(FullException.class, ()->TEST.add(3, STR4));
	}

	@Test
	void shouldInvalidIndexException(){
		TEST.add(STR1);
		TEST.add(STR2);
		assertThrowsExactly(InvalidIndexExeption.class, ()->TEST.remove(3));
		assertThrowsExactly(InvalidIndexExeption.class, ()->TEST.remove(-1));
	}
	@Test
	void shouldNullItemException(){
		TEST.add(STR1);
		TEST.add(STR2);
		assertThrowsExactly(NullItemException.class, ()->TEST.add(null));

	}

}