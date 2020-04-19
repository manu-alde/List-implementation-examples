package utilities;

public class QueueHL<E> extends LinkedList<E> implements QueueInterface<E> {

	public QueueHL() {
		super();
	}

	public void enqueue(E value) {
		super.add(count - 1, value);
	}

	public E dequeue(E value) {
		return super.remove(0);
	}

	public E peek() {
		return super.get(count - 1);
	}

	public boolean isEmpty() {
		return count == 0;
	}

	public int getSize() {
		return count;
	}

}
