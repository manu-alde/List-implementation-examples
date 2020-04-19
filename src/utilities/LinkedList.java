package utilities;

import java.util.Collection;

public class LinkedList<E> {

	private Node<E> head;
	protected int count;

	public LinkedList() {
	}

	public boolean add(E value) {
		if (value == null) {
			return false;
		}
		Node<E> newNode = new Node<E>(value);
		if (head != null) {
			Node<E> navigator = head;
			while (navigator.getNext() != null) {
				navigator = navigator.getNext();
			}
			navigator.setNext(newNode);
		} else
			head = newNode;
		incrementCount();
		return true;
	}

	public void add(int index, E value) {
		Node<E> newNode = new Node<E>(value);
		if (head == null && index == 0) {
			head = newNode;
		} else {
			if (index < 0 || index >= count)
				return;
			Node<E> leftNav = head;
			for (int i = 0; i < index; i++) {
				leftNav = leftNav.getNext();
			}
			if (leftNav == head) {
				newNode.setNext(leftNav);
				head = newNode;
			} else {
				newNode.setNext(leftNav.getNext());
				leftNav.setNext(newNode);
			}
		}
		incrementCount();

	}

	public boolean addAll(Collection<? extends E> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean addAll(int arg0, Collection<? extends E> arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	public void clear() {
		if (head == null)
			return;
		head.setNext(null);
	}

	public boolean contains(Object value) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean containsAll(Collection<?> collection) {
		// TODO Auto-generated method stub
		return false;
	}

	public E get(int index) {
		if (index < 0 || index >= count)
			return null;
		Node<E> navigator = head;
		for (int i = 0; i <= index; i++) {
			navigator = navigator.getNext();
		}
		return navigator.getValue();
	}

	public int indexOf(Object value) {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean isEmpty() {
		return count > 0;
	}

	public int lastIndexOf(Object value) {
		Node<E> navigator = head;
		int objIndex = -1;
		for (int i = 0; i < count; i++) {
			if (navigator.getValue() == value)
				objIndex = i;
			navigator = navigator.getNext();
		}
		return objIndex;
	}

	public boolean remove(Object value) {
		Node<E> navigator = head;
		Node<E> toReplace;
		while (navigator.getNext() != null || navigator.getNext().getValue() != value) {
			navigator = navigator.getNext();
		}
		if (navigator.getNext() != null && navigator.getNext().getValue() == value) {
			toReplace = navigator.getNext();
			if (toReplace.getNext() != null) {
				navigator.setNext(toReplace.getNext());
			} else
				navigator.setNext(null);
			decrementCount();
			return true;
		}
		return false;
	}

	public E remove(int index) {
		E removedValue = null;
		if (index < 0 || index >= count)
			return null;
		else if (index == 0 && count == 1) {
			removedValue = head.getValue();
			head = null;
			decrementCount();
			return removedValue;
		}
		Node<E> navigator = head;
		for (int i = 0; i < index - 1; i++) {
			navigator = navigator.getNext();
		}
		removedValue = navigator.getNext().getValue();
		if (navigator.getNext().getNext() != null)
			navigator.setNext(navigator.getNext().getNext());
		else {
			navigator.setNext(null);
		}
		decrementCount();
		return removedValue;
	}

	public boolean removeAll(Collection<?> values) {
		boolean result = false;
		for (Object o : values) {
			if (this.remove(o) && result == false)
				result = true;
		}
		return false;
	}

	public boolean retainAll(Collection<?> values) {
		// TODO Auto-generated method stub
		return false;
	}

	public E set(int index, E value) {
		Node<E> navigator = head;
		if (index < 0 || index >= count)
			return null;
		for (int i = 0; i <= index; i++) {
			navigator = navigator.getNext();
		}
		navigator.setValue(value);
		return navigator.getValue();
	}

	public int size() {
		return count;
	}

	public LinkedList<E> subList(int from, int to) {
		if (from < 0 || to < 0 || from > to || from >= count || to >= count)
			return null;
		LinkedList<E> newList = new LinkedList<>();
		Node<E> navigator = head;
		for (int i = 0; i <= from; i++) {
			navigator = navigator.getNext();
		}
		for (int i = 0; i <= to - from; i++) {
			newList.add(navigator.getValue());
			navigator = navigator.getNext();
		}
		return newList;
	}

	public Object[] toArray() {
		Object[] newArray = new Object[count];
		Node<E> navigator = head;
		for (int i = 0; i < count; i++) {
			newArray[i] = navigator.getValue();
			navigator = navigator.getNext();
		}
		return newArray;
	}

	public <T> T[] toArray(T[] values) {
		return values;
	}

	private void incrementCount() {
		count++;
	}

	private void decrementCount() {
		count--;
	}

	@Override
	public String toString() {
		String out = "[";
		Node<E> navigator = head;
		for (int i = 0; i < count; i++) {
			out += navigator.getValue() + ", ";
			navigator = navigator.getNext();
		}
		return (out != "[") ? out.subSequence(0, out.length() - 2) + "]" : "null";
	}

}
