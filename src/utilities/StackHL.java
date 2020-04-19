package utilities;

public class StackHL<E> extends LinkedList<E> implements StackInterface<E>{
	
	public StackHL() {
		super();
	}
	
	public E pop() {
		return this.remove(0);
	}
	
	public E getTop() {
		return super.get(0);
	}

	@Override
	public void push(E value) {
		this.add(0, value);
	}
}
