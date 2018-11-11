public interface Queue<E> {
	//得到队列的元素个数
	int getSize();
	//判断队列是否为空
	boolean isEmpty();
	//出队操作，返回出队元素
	E dequeue();
	//入队操作
	void enqueue(E e);
	//得到队首元素（注意：不删除）
	E getFront();
}
