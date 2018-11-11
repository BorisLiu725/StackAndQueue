/**
 * 基于JAVA静态数组实现的动态数组
 * */
public class Array<E> {
	
	private E[] data; 
	
	private int size;
	/**
	 * 数组初始化时可传入一个自定义的容量
	 * */
	public Array(int capacity) {
		data = (E[])new Object[capacity];
		size = 0;
	}
	
	/**
	 * 给定一个定长数组，包装成一个不定长数组
	 * */
	public Array(E[] arr) {
		data = (E[])new Object[arr.length];
		for(int i = 0;i<arr.length;i++)
			data[i] = arr[i];
		size = arr.length;
	}
	
	
	/**
	 * 数组默认容量为10
	 * */
	public Array() {
		this(10);
	}
	/**
	 * 获取数组中的元素个数
	 * 
	 * */
	public int getSize() {
		return size;
	}
	/**
	 * 获取数组的容量
	 * */
	public int getCapacity() {
		return data.length;
	}
	/**
	 * 向数组末尾添加元素
	 * */
	public void addLast(E e) {
		add(size,e);
	}
	
	/**
	 * 在所有元素前添加一个元素
	 * 
	 * */
	public void addFirst(E e) {
		add(0,e);
	}
	
	/**
	 * 在index个位置插入一个元素
	 * */
	public void add(int index,E e) {
		
		if(index < 0 || index > size)
			throw new IllegalArgumentException("AddList failed.Require index>=0 and index<=size！");
		
		if(size == data.length)
			resize(2 * data.length);
		
		for(int i=size-1;i>=index;i--) {
			data[i+1] = data[i];
		}
		data[index] = e;
		
		size++;
	}
	
	
	
	/**
	 * 获取index索引位置的元素
	 * */
	public E get(int index) {
		if(index < 0 || index >= size)
			throw new IllegalArgumentException("Get failed.Index illegal！");
		return data[index];
	}
	
	/**
	 * 获取第一个元素
	 * */
	public E getFirst() {
		return get(0);
	}
	
	/**
	 * 获取最后一个元素
	 * */
	public E getLast() {
		return get(size-1);
	}
	
	
	
	
	/**
	 * 修改index索引位置的元素e
	 * */
	
	void set(int index,E e) {
		if(index < 0 || index >= size)
			throw new IllegalArgumentException("Set failed.Index illegal！");
		data[index] = e;
	}
	/**
	 * 查找数组中是否有元素e
	 * */
	public boolean contains(E e) {
		for(int i=0;i<size;i++) {
			if(data[i].equals(e) )
				return true;
		}
		return false;
	}
	
	/**
	 * 查找数组中元素e所在的索引，如果不存在元素e，则返回-1
	 * */
	public int find(E e) {
		for(int i=0;i<size;i++) {
			if(data[i].equals(e))
				return i;
		}
		return -1;
	}
	
	/**
	 * 删除Array中某index的元素
	 * */
	public E remove(int index) {
		if(index < 0 || index >= size)
			throw new IllegalArgumentException("Remove failed.Index illegal！");
		E ret = data[index];
		for(int i=index;i<size-1;i++) {
			data[i] = data[i+1];
		}
		size--;
		data[size] = null;
		
		//这里防止复杂度的震荡,采用“懒”策略，不着急缩容，防止刚缩容又扩容导致复杂度极具增加
		if(size <= data.length/4 && data.length/2!=0) {
			resize(data.length/2);
		}
		return ret;
	}
	
	/**
	 * 从数组中删除第一个元素，返回删除元素
	 * */
	public E removeFirst() {
		return remove(0);
	}
	
	/**
	 * 删除数组中的最后一个元素，并返回
	 * */
	public E removeLast() {
		return remove(size-1);
	}
	
	/**
	 * 删除数组中的某一个指定元素
	 * */
	public void removeElement(E e) {
		int index = find(e);
		if(index != -1)
			remove(index);
	}
	/**
	 * 交换位置为i,j的元素
	 */
	public void swap(int i,int j) {
		if(i<0 || i>=size || j<0 || j>=size)
			throw new IllegalArgumentException("Index is illegal");
		E t = data[i];
		data[i] = data[j];
		data[j] = t;
		
	}

	/**
	 * 打印数组的详细信息
	 * */
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("Array: size = %d , Capacity = %d\n", size,data.length));
		sb.append("[");
		for(int i=0;i<size;i++) {
			sb.append(data[i]);
			if(i!=size-1)
				sb.append(",");
		}
		sb.append("]");
		return sb.toString();
	}
	
	/**
	 * 数组扩容
	 */
	private void resize(int newCapacity) {
		E[] newData = (E[])new Object[newCapacity];
		for(int i=0;i<size;i++) {
			newData[i] = data[i];
		}
		data = newData;
	}
	/**
	 * 数组是不是空
	 * */
	public boolean isEmpty() {
		return size == 0;
	}

}
