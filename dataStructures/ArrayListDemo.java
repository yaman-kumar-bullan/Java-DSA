package dataStructures;
import java.util.*;
public class ArrayListDemo {

	public static void main(String[] args) {
		
		//ArrayList<Integer> list1 = new ArrayList<>(5); //Now capacity of array is 5
		
		ArrayList<Integer> list1 = new ArrayList<>();
		System.out.println(list1.size());;
		list1.add(12);
		list1.add(20);
		list1.add(50);
		
		System.out.println(list1.size());
		
		System.out.println(list1.get(1));
		
		list1.add(1, 30);
		list1.set(1, 70);
		for(int i=0; i<list1.size(); i++) {
			System.out.print(list1.get(i) + " ");
		}
		
		System.out.println();
		
		list1.remove(1);
		
		for(int i=0; i<list1.size(); i++) {
			System.out.print(list1.get(i) + " ");
		}
		
		
	}

}
