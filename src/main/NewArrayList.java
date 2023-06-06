package main;

import main.exception.ElementNotFoundException;
import main.exception.FullException;
import main.exception.InvalidIndexExeption;
import main.exception.NullItemException;

import java.util.Arrays;


public class NewArrayList implements StringList {

	private final String[] string;
	private int size;


	public NewArrayList() {
		string = new String[10];
	}

	public NewArrayList(int sizeArray) {
		string = new String[sizeArray];
	}

	@Override
	public String add(String item) {
		isNull(item);
		validateSize();
		string[size++] = item;
		return item;
	}

	@Override
	public String add(int index, String item) {
		validateSize();
		isNull(item);
		validateIndex(index);
		if (index == size) {
			string[size++] = item;
			return item;
		}
		System.arraycopy(string, index, string, index + 1, size - index);
		string[index] = item;
		size++;
		return item;
	}

	@Override
	public String set(int index, String item) {
		isNull(item);
		validateIndex(index);
		string[index] = item;
		return item;
	}

	@Override
	public String remove(String item) {
		isNull(item);
		int index = indexOf(item);
		if (index == -1){
			throw new ElementNotFoundException();
		}
		remove(index);
		return item;
	}

	@Override
	public String remove(int index) {
		validateIndex(index);
		String item = string[index];
		if (index != size) {
			System.arraycopy(string, index + 1, string, index + 1, size - index);
		}
		size--;
		return item;
	}

	@Override
	public boolean contains(String item) {
		return indexOf(item) != -1;
	}

	@Override
	public int indexOf(String item) {
		for (int i = 0; i < size; i++) {
			if (string[i].equals(item)) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public int lastIndexOf(String item) {
		for (int i = size - 1; i >= 0; i--) {
			if (string[i].equals(item)) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public String get(int index) {
		validateIndex(index);
		return string[index];
	}

	@Override
	public boolean equals(StringList otherList) {
		if (otherList == null) {
			throw new NullItemException();
		}
		return Arrays.equals(this.toArray(), otherList.toArray());
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public void clear() {
		size = 0;
	}

	@Override
	public String[] toArray() {
		return Arrays.copyOf(string, size);
	}

	private void isNull(String item) {
		if (item == null) {
			throw new NullItemException();
		}
	}

	private void validateSize() {
		if (size == string.length) {
			throw new FullException();
		}
	}

	private void validateIndex(int index) {
		if (index < 0 || index > size) {
			throw new InvalidIndexExeption();
		}
	}

}
