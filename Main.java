package utd.ds.assign2;

public class Main {

	public static void main(String[] args) {

		int[] array = new int[16];
		int val = 10;
		
		for(int i = 0; i < array.length; i++) {
			array[i] = i+1;
		}
		System.out.print("Array is : ");
		for(int i = 0; i < array.length; i++) {
			System.out.print(i+" ");
		}
		System.out.println();
		System.out.println("Number to be found is : "+val);
		Integer r = tertiarySearch(array, 0, array.length-1, val);
		if(r == null) {
			System.out.println("Number not found in array");
		}else {
			System.out.println("The number is at index : "+r);
		}
	}

	static Integer tertiarySearch(int[] array, int start, int end, int val) {

		if(start < 0 || start >= array.length) {
			return null;
		}

		int h = (end+1 - start)/ 3;
		int i = start;
		int m = start + (h);
		int n = start + (2*h);

		if(array[i] == val) {
			return i;
		}else if(array[m] == val) {
			return m;
		}else if(array[n] == val) {
			return n;
		}

		if(array[m] > val) {
			return tertiarySearch(array, i+1, m-1, val);
		}else if(array[m] < val && array[n] > val) {
			return tertiarySearch(array, m+1, n-1, val);
		}else if(array[n] < val) {
			return tertiarySearch(array, n+1, array.length, val);
		}		

		return null;
	}

}
