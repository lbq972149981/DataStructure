package colin.sort;
import colin.SortUtil.sortUtil;
import org.junit.Test;

import java.util.Arrays;
public class Heap {
	public int data[];
	private int size = 0;
	public Heap(int length) {
		// TODO 自动生成的构造函数存根
		data = new int[length + 1];
	}
	public int size() {
		return size;
	}
	public Heap(int[] arr){
		data = new int[arr.length+1];
		for(int i=1;i<data.length;i++){
			data[i] = arr[i-1];
			size++;
		}
		for(int i=size/2;i>0;i--){
			contrastDown(i);
		}
	}
	public void add(int su) {
		// 判断数组的长度不够 创建一个新的数组 把原来的数据复制过来
		if (size == data.length - 1) {
			data = Arrays.copyOf(data, data.length + 10);
		}

		data[++size] = su;
		// 向上对比
		contrastUp(size);
	}
	public int get() {
		assert size > 0;
		int su = data[1];
		sortUtil.switchArr(data, 1, size);
		size--;
		// 维护大堆
		contrastDown(1);
		return su;
	}
	public void contrastDown(int i) {
		// int j=i*2;
		while (i *2<= size) {
			int j = i * 2;
			// 满节点

			if(j + 1 <= size &&data[j+1]>data[j])
			{
				j++;
			}
			if(data[i]>data[j])
			{
				break;
			}
			sortUtil.switchArr(data, j, i);
			i = j;
		}
	}
	private void contrastUp(int i) {
		while (i > 1 && data[i / 2] < data[i]) {
			sortUtil.switchArr(data, i, i / 2);
			i /= 2;
		}
	}
}
