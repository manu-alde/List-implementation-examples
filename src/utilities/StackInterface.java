package utilities;

public interface StackInterface<E> {
	public E pop();

	public E getTop();

	public void push(E value);

}
