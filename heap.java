public class heap
{
	private int[] a = new int[1000];
	private int currentIndex = 1;
	public void insert(int i)
	{
		a[currentIndex] = i;
		swim(currentIndex);
		currentIndex++;
	}
	public void swim(int index)
	{
		if(index <= 1)
			return;
		if(a[index] > a[index/2])
		{
			swap(a,index,index/2);
			swim(index/2);
		}
	}
	private void swap(int[] a ,int i, int j)
	{
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	public int getMax()
	{
		return a[1];
	}
	public int delMax()
	{
		int result = getMax();
		swap(a,1,currentIndex-1);
		currentIndex--;
		sink(1);
		return result;
	}
	private void sink(int i)
	{
		if(i*2 > currentIndex-1)
			return;
		int max = i*2;
		if(i*2+1 <= currentIndex-1 && a[i*2+1] > a[i*2])
			max = i*2+1;;		
		if(a[i] < a[max])
		{
			swap(a,i,max);
			sink(max);
		}
	}
	public static void main(String[] args)
	{
		heap m = new heap();
		m.insert(5);
		m.insert(2);
		m.insert(8);
		m.insert(6);
		System.out.println(m.getMax());	
		m.delMax();
		System.out.println(m.getMax());	
	}
}











