package dsaArray;

public class ArrayResize {
	private int arr[];
	private int size = 0,check = 0 ;
	public ArrayResize(int size) {
		// TODO Auto-generated constructor stub
		arr = new int [size];
		this.size =size;
	}
	public void display() {
		if(check == 0) {
			System.out.println("Array is empty");
		}
		else {
			for(int i:arr) {
				System.out.print(i+" ");
			}
		}}
		public void add(int val) {
			if(check == size) {
				System.out.println("Array is resized");
				resize();
				add(val);
			}
			else {
				arr[check] =val;
				check++;
			}
		}
		private void resize() {
			int presize = size;
			size = size+10;
			int  [] dummy = new int [size];
			for (int i =0 ; i < presize; i++) {
				dummy[i]=arr[i];
			}
			arr = dummy;
		}
		
		public void deleteLast() {
			check--;
			//capacity
			size--;
			//input element
			int  [] dummy = new int [size];
			for (int i =0 ; i < check; i++) {
				dummy[i]=arr[i];
			}
			arr = dummy;
		
		}
		public int []linearSearch(int x) {
	
			int occur=0;
			
			for(int i =0 ; i < check;i++ ) {
			
				if(x==arr[i]) occur++;
			}
			int j=0;
			int  [] collect = new int[occur];
			for(int i =0 ; i < check;i++ ) {
				
				if(x==arr[i]) {
					collect[j] = i;
					j++;
				}
			}
				
			return collect;
		}
		
		public static void main(String [] args) {
			ArrayResize array = new ArrayResize(1);
			array.add(1);
			array.display();
			array.add(2);
			array.add(2);
			array.add(3);
			array.add(2);
			array.add(5);
			array.add(4);
			array.add(2);
			array.display();
			array.deleteLast();
			System.out.print("\n");
			array.display();
			int [] arr2 =array.linearSearch(2);
			System.out.print("\nIndexes: ");
			for(int i : arr2) {
				System.out.print( i + " ");
			}
		}
	}


//deletelast
//custom data type
//student obj add ya del
//all indexes regturn