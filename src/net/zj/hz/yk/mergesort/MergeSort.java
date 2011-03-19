package net.zj.hz.yk.mergesort;

/**
 * 归并排序算法实现
 * 
 * @author Administrator
 * 
 */
public class MergeSort {
	public int[] sort(int[] data) {
		int[] temp = new int[data.length];
		mergeSort(data, temp, 0, data.length - 1);
		return data;
	}

	private void mergeSort(int[] data, int[] temp, int low, int high) {
		int mid = (low + high) / 2;
		System.out.println(low + ", " + mid + ", " + high);
		if (low == high)
			return;

		mergeSort(data, temp, low, mid);
		mergeSort(data, temp, mid + 1, high);
		for (int i = low; i <= high; i++) {
			System.out.println("i=" + i);
			temp[i] = data[i];
		}
		int i1 = low;
		int i2 = mid + 1;
		System.out.println("###:"+low + ", " + mid + ", " + high);
		for (int cur = low; cur <= high; cur++) {
			if (i1 == mid + 1)
				data[cur] = temp[i2++];
			else if (i2 > high) {
				data[cur] = temp[i1++];
				System.out.println("!!!!!!!!!!!:"+i2+";"+high);
			}

			else if (temp[i1] < temp[i2])
				data[cur] = temp[i1++];
			else
				data[cur] = temp[i2++];
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] datas = { 1, 21, 34, 79, 98, 23, 68, 2, 3, 8, 6, 33, 6, 7, 87,
				32, 24, 6, 776 };
		MergeSort mergeSort = new MergeSort();
		datas = mergeSort.sort(datas);
		for (int i = 0; i < datas.length; i++) {
			System.out.print(datas[i] + ",");
		}
	}

}
