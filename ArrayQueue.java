public class ArrayQueue<E> implements Queue<E> {
	//复用我们的Array
	private Array<E> array;
	
	public ArrayQueue() {
		array = new Array<>();
	}
	
	public ArrayQueue(int capaticy) {
		array = new Array<>(capaticy);
	}

	@Override
	public int getSize() {
		
		return array.getSize();
	}

	@Override
	public boolean isEmpty() {
		return array.isEmpty();
	}
	/**
	 * 入队
	 * */
	@Override
	public void enqueue(E e) {
		array.addLast(e);
		
	}
	
	public int getCapacity() {
		return array.getCapacity();
	}
	
	/**
	 * 出队
	 * */
	@Override
	public E dequeue() {
		
		return array.removeFirst();
	}
	/**
	 * 获得队首元素
	 * */
	@Override
	public E getFront() {
		
		return array.getFirst();
	}
  //打印队列中的元素
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("Queue:");
		sb.append("front[");
		for(int i=0;i<array.getSize();i++) {
			sb.append(array.get(i));
			if(i!=array.getSize()-1)
				sb.append(",");
		}
		sb.append("]tail");
		return sb.toString();
	}
	
}
