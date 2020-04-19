package utilities;

public class Node <E>{
	private E value;
	private Node<E> next;
	
	Node(){
		setValue(null);
		setNext(null);
	}
	
	Node(E value){
		this.value = value;
		this.next = null;
	}

	public E getValue() {
		return value;
	}

	public void setValue(E value) {
		this.value = value;
	}

	public Node<E> getNext() {
		return next;
	}

	public void setNext(Node<E> next) {
		this.next = next;
	}
}
