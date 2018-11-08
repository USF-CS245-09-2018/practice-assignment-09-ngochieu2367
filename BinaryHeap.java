public class BinaryHeap{
	int [] array;
	int size;

	public BinaryHeap(){
		array = new int[10];
		size = 0;
	}

	public void swap(int[] array, int first, int second){
		int temp  = array[first];
		array[first] = array[second];
		array[second]  = temp;
	}

	public void add(int priority){
		if(size == array.length){
			grow_array();
		}
		array[size] = priority;
		++size;
		int i = size - 1;
		int parent = (i-1)/2;
		while(i > 0 && array[i] < array[parent]){
			swap(array,i,parent);
			i = parent;
			parent = (i -1)/2;

		}
	}

	public int remove(){
		if(size == 0){
			throw new Exception("Empty");
		}
		int priority = array[0];
		array[0] = array[size - 1];
		--size;
		if (size != 0) {
			shift_down(0);
		}
		
		return priority;
	}

	private void shift_down(int parent){
		if(size == 0){
			return;
		}

		int child = (parent * 2) + 1;
		if (child >= size) {
			return;
		}
		if((child + 1) < size && array[child + 1] < array[child]){
			child++;
		}
		if(array[parent] > array[child]){
			swap(array,child,parent);
			
		}
		shift_down(child);
	}

	public void grow_array(){
		int [] newArray = new int[array.length * 2];
		for (int i = 0;i < array.length ;i++ ) {
			newArray[i] = array[i];
		}
		array = newArray;
	}	
}