package utilities;

public interface QueueInterface<E> {
	public void enqueue(E value);

	public E dequeue(E value);

	public E peek();

	public boolean isEmpty();

	public int getSize();
}
