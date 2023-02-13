package recursion;
import java.util.*;

import javax.imageio.plugins.tiff.GeoTIFFTagSet;
public class Recursion_1 {
	
	public static int[] takeInputArray() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		return arr;
	}
	
	public static void printArray(int[] input) {
		for(int i=0; i<input.length; i++) {
			System.out.print(input[i] + " ");
		}
	}
	
	public static int fact(int n) {
		if(n==0) return 1;
		
		return n * fact(n-1);
	}
	
	public static int sumOfNNaturalNumbers(int n) {
		if(n==1) return 1;
		
		return n + sumOfNNaturalNumbers(n-1);
	}
	
	public static int power(int x, int n) {
		if(n==0) return 1;
		
		return x * power(x,n-1);
	}
	
	public static void print1toN(int n) {
		if(n==1) {
			System.out.print(n + " ");
			return;
		}
		
		print1toN(n-1);
		System.out.print(n + " ");
	}
	
	public static int numOfDigits(int n) {
		
		if(n/10 == 0) return 1;   //There is only a single digit
		
		return 1 + numOfDigits(n/10);
	}
	
	public static int nthFibNo(int n) {
		
		if(n==0 || n==1) return n;
		
		return nthFibNo(n-1) + nthFibNo(n-2);
	}
	
	public static boolean isArraySorted(int[] arr, int n) {
		
		if(n==arr.length-1) return true; //Single element array is always sorted
		
		boolean smallAns = isArraySorted(arr, n+1);
		
		if(!smallAns) return false;
		
		if(arr[n] < arr[n+1]) return true;
		else return false;
	}
	
	public static int sumOfArray(int[] arr, int n) {
		
		if(n==arr.length-1) return arr[n];  //Single element in array
		
		return arr[n] + sumOfArray(arr, n+1);
	}

	public static boolean checkNumberRecursively(int[] arr, int k, int n) {
		
		if(n==arr.length) return false;   //Array has became empty
		
		if(arr[n] == k) return true;
		return checkNumberRecursively(arr, k, n+1);
	}
	
	public static int firstIndexOfX(int[] arr, int x, int si)  {
		
		if(si == arr.length) return -1;
		
		if(arr[si] == x) return si;
		else return firstIndexOfX(arr, x, si+1);
	}
	
	public static int lastIndexOfX(int[] arr, int x, int si) {
		
		if(si == arr.length) return -1;
		
		int smallAns = lastIndexOfX(arr, x, si+1);
		
		if(smallAns == -1 && arr[si] == x) return si;
		else return smallAns;
	}
	
	public static void allIndexesOfX(int[] arr, int x, int si) {
		
		if(si == arr.length) return;
		
		if(arr[si] == x) System.out.print(si + " ");
		allIndexesOfX(arr, x, si+1);
	}
	
	public static int multiplication(int a, int b) {
		
		if(b==0) return 0;
		
		return a + multiplication(a, b-1);
	}
	
	public static int countZeros(int n) {
		
		if(n/10 == 0) {             //Single digit remaining
			if(n==0) return 1;
			else return 0;
		}
		
		int smallAns = countZeros(n/10);
		if(n%10 == 0) return 1 + smallAns;
		else return smallAns;
	}
	
	public static double geometricSum(int k, int startPower) {
		
		if(startPower == k) return (1.0/power(2,k));
		
		double smallAns = geometricSum(k, startPower+1);
		return (1.0/power(2,startPower)) + smallAns;
	}
	
	public static boolean checkPalindrome(String str, int si, int ei) {
		
		if(si == ei) return true; //String length is odd
		
		if(si+1 == ei) return str.charAt(si) == str.charAt(ei); //String length is even
		
		//if(si >= ei) return true;  //Base condition in which length of string is not an issue
		
		if(str.charAt(si) != str.charAt(ei)) return false;
		return checkPalindrome(str, si+1, ei-1);
	}
	
	public static int sumOfDigits(int n) {
		
		if(n/10 == 0) return n;
		
		int smallAns = sumOfDigits(n/10);
		int lastDigit = n%10;
		return lastDigit + smallAns;
	}
	
	public static String replacePi(String str, String ans, int si) {
		
		if(si == str.length()-1) {        //When the si is at last character
			ans = ans + str.charAt(si);
			return ans;
		}
		
		if(si == str.length()) return ans;   //When the si has crossed the string
		
		/* Below statement not possible : when si is at length-1 then pi is not possible but
		 * last character has to be added in string which is not necessary when si is at
		 * length means si has crossed the string
		 */
		
//		if(si >= str.length()-1) return ans; 
		
		if(str.charAt(si) == 'p' && str.charAt(si+1) == 'i') {
			ans = ans + "3.14";
			return replacePi(str, ans, si+2);
		} else {
			ans = ans + str.charAt(si);
			return replacePi(str, ans, si+1);
		}
		
	}
	
	public static String removeX(String str, String ans, int si) {
		
		if(si == str.length()) return ans;
		
		if(str.charAt(si) != 'x') ans = ans + str.charAt(si);
		
		return removeX(str, ans, si+1);
	}
	
	public static int stringToInteger(String str, int ans, int si) {
		
		if(si == str.length()) return ans;
		
		char temp = str.charAt(si);
		int charToInt = Integer.parseInt(String.valueOf(temp));
		ans = ans * 10 + charToInt;
		
		return stringToInteger(str, ans, si+1);
	}
	
	public static String pairStar(String str, String ans, int si) {  //Imp Question
		
		if(si == str.length()) return ans; //String has got empty
		
		if(si == str.length()-1) {         //We are at the last character of string
			ans = ans + str.charAt(si);
			return ans;
		}
		
		if(str.charAt(si) == str.charAt(si+1)) ans = ans + str.charAt(si) + "*";
		else ans = ans + str.charAt(si);
		
		return pairStar(str, ans, si+1);
	}
	
	public static void towerOfHanoi(int n, char a, char b, char c) {  //a:s, b:a, c:d : Wrong Code
		
		if(n==0) return;
		
		if(n==1) {
			System.out.println(a + c);
			return;
		}
		
		if(n==2) {
			System.out.println(a + b);
			System.out.println(a + c);
			System.out.println(b + c);
		}
		
		System.out.println(a + c);
		System.out.println(a + b);
		System.out.println(c + b);
		System.out.println(a + c);
		System.out.println(b + a);
		System.out.println(b + c);
		System.out.println(a + c);
		
		towerOfHanoi(n-3, a, b, c);
	}
	
	public static void mergeSort(int[] arr, int si, int ei) {
		
		if(si >= ei) return; //si==ei : single element is remaining, si>ei : array is empty
		
		int mid = (si+ei)/2;
		
		mergeSort(arr, si, mid);
		mergeSort(arr, mid+1, ei);
		
		mergeSortedArrays(arr, si, ei);
	}
	
	public static void mergeSortedArrays(int[] arr, int si, int ei) {
		
		int mid = (si+ei)/2;
		int[] ans = new int[ei-si+1];
		int index = 0;
		
		int i=si, j=mid+1;  //Traversing in both the arrays
		
		while(i<=mid && j<=ei) {
			if(arr[i] <= arr[j]) ans[index++] = arr[i++];
			else ans[index++] = arr[j++];
		}
		
		while(i<=mid) ans[index++] = arr[i++];
		
		while(j<=ei) ans[index++] = arr[j++];
		
		/* Coping elements of ans array between si & ei
		 * We cannot just point arr to ans array because arr is a very
		 * big array and we are operating within the limit si & ei
		 */
		
		for(int k=0; k<ans.length; k++) {  
			arr[si+k] = ans[k];
		}
	}
	
	public static void quickSort(int[] arr, int si, int ei) {
		
		//si==ei : single element is remaining, si>ei : array is empty
		
		if(si>=ei) return;
		
		int pivotPos = partition(arr, si, ei);
		
		quickSort(arr, si, pivotPos-1);
		quickSort(arr, pivotPos+1, ei);
	}
	
	public static int partition(int[] arr, int si, int ei) {
		int pivot = arr[si];
		int count = 0;
		
		for(int i=si+1; i<=ei; i++) {
			if(arr[i] <= pivot) count++;
		}
		
		/* If si=1, count=3, pivotPos=4
		 * because starting three positions from si will be occupied
		 * by these elements
		 */
		
		int pivotPos = si+count;
		
		arr[si] = arr[pivotPos];
		arr[pivotPos] = pivot;
		
		/*Now we have to ensure all elements to left of pivotPos are <=pivot
		 * and all to the right are > pivot
		 */
		
		int i = si, j = ei;
		
		while(i<pivotPos && j>pivotPos) {
			if(arr[i] > pivot) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				j--;
			} else if(arr[j] <= pivot) {
				int temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
				i++;
			} else {
				i++;
				j--;
			}
		}
		
		return pivotPos;
	}
	
	public static String[] subSequencesOfAString(String str) {
		
		if(str.length() == 0) {
			String[] ans = {""};
			return ans;
		}
		
		String[] smallAns = subSequencesOfAString(str.substring(1));
		String[] ans = new String[smallAns.length * 2];
		int index = smallAns.length;
		
		for(int i=0; i<smallAns.length; i++) {
			ans[i] = smallAns[i];
		}
		
		for(int i=0; i<smallAns.length; i++) {
			ans[index++] = str.charAt(0) + smallAns[i];
		}
		
		return ans;
	}
	
	public static String[] keypadCombination(int n) {
		
		if(n==0) {   //n cannot be 1 here
			String[] ans = {""};
			return ans;
		}
		
		String[] smallAns = keypadCombination(n/10);
		char[] temp = getCharArrayCorrespondingToNumber(n%10);
		
		String[] ans = new String[smallAns.length * temp.length];
		int index = 0;
		
		for(int i=0; i<smallAns.length; i++) {
			for(int j=0; j<temp.length; j++) {
				ans[index++] = smallAns[i] + temp[j];
			}
		}
		
		return ans;
	}
	
	public static char[] getCharArrayCorrespondingToNumber(int n) {
		if(n==2) return new char[] {'a', 'b', 'c'};
		else if(n==3) return new char[] {'d', 'e', 'f'};
		else if(n==4) return new char[] {'g', 'h', 'i'};
		else if(n==5) return new char[] {'j', 'k', 'l'};
		else if(n==6) return new char[] {'m', 'n', 'o'};
		else if(n==7) return new char[] {'p', 'q', 'r', 's'};
		else if(n==8) return new char[] {'t', 'u', 'v'};
		else return new char[] {'w', 'x', 'y', 'z'};
	}
	
	public static void printAllSubsequences(String str, String outputSoFar) {
		
		if(str.length() == 0) {
			System.out.println(outputSoFar);
			return;
		}
		
		printAllSubsequences(str.substring(1), outputSoFar + str.charAt(0));
		printAllSubsequences(str.substring(1), outputSoFar);
	}
	
	public static void printAllKeypadCombination(int n, String outputSoFar) {
		
		if(n==0) {
			System.out.println(outputSoFar);
			return;
		}
		
		char[] charArray = getCharArrayCorrespondingToNumber(n%10);
		for(int i=0; i<charArray.length; i++) {
			printAllKeypadCombination(n/10, charArray[i] + outputSoFar);
		}
	}
	
	public static boolean checkAB(String str) {
		
		if(str.length() == 0) return true;  //Base condition
		
		if(str.charAt(0) != 'a') return false;
		
		/*If str.length is not >=3 then abb is not possible only
		 *aa or aAndNothing is possible
		 */
		
		if(str.length() >= 3 && str.substring(0,3).equals("abb")) return checkAB(str.substring(3));
		else return checkAB(str.substring(1));
	}
	
	public static int staircase(int n) {
		
		if(n==0) return 1; //We are at starting point 
		if(n<0) return 0; //We don't have any stairs
		
		/* We will calculate number of ways of climbing n-1, n-2 & n-3 stairs
		 * Thinking about going from 1st step to n-1,n-2,n-3 step their is
		 * just one way that is direct jump and that will be added in the 
		 * base condition
		 */
		
		return staircase(n-1) + staircase(n-2) + staircase(n-3);
	}
	
	public static int binarySearchUsingRecursion(int[] arr, int x, int si, int ei) {
		
		if(si>ei) return -1; //If array has zero elements
		
		int mid = (si+ei)/2;
		if(arr[mid] == x) return mid;
		else if(arr[mid] > x) return binarySearchUsingRecursion(arr, x, si, mid-1);
		else return binarySearchUsingRecursion(arr, x, mid+1, ei);
	}
	
	public static String[] subsetOfAnArray(int[] arr, int si) {
		
		if(si == arr.length) return new String[] {""};
		
		String[] smallAns = subsetOfAnArray(arr, si+1);
		String[] ans = new String[smallAns.length * 2];
		int index = 0;
		
		for(int i=0; i<smallAns.length; i++) {
			ans[index++] = smallAns[i];
		}
		
		for(int i=0; i<smallAns.length; i++) {
			ans[index++] = arr[si] + " " + smallAns[i];
		}
		
		return ans;
	}
	
	public static void printSubsetOfAnArray(int[] arr, int si, String outputSoFar) {
		
		if(si == arr.length) {
			if(outputSoFar == "") System.out.println("[]");
			else System.out.println(outputSoFar.trim());
			return;
		}
		
		printSubsetOfAnArray(arr, si+1, outputSoFar + " " + arr[si]);
		printSubsetOfAnArray(arr, si+1, outputSoFar);
	}
	
	public static String[] allSubsetsOfArrayWhichSumToK(int[] arr, int k) {
		
		String[] subsets = subsetOfAnArray(arr, 0);
		int count = 0;
		
		for(int i=0; i<subsets.length; i++) {
			if(subsets[i] == "") {
				if(k==0) count++;
				continue;
			}
			
			String[] temp = subsets[i].split(" ");
			if(temp.length == 0) {
				if(k - Integer.parseInt(subsets[i]) == 0) {
					count++;
				}
				continue;
			}
			
			for(int j=0; j<temp.length; j++) k = k - Integer.parseInt(temp[j]);
			
			if(k==0) count++;
			System.out.println(count);
		}
		
		System.out.println(count);
		String[] ans = new String[count];
		int index = 0;
		
		for(int i=0; i<subsets.length; i++) {
			if(subsets[i] == "") {
				if(k==0) ans[index++] = subsets[i];
				continue;
			}
			
			String[] temp = subsets[i].split(" ");
			if(temp.length == 0) {
				if(k - Integer.parseInt(subsets[i]) == 0) {
					ans[index++] = subsets[i];
				}
				continue;
			}
			
			for(int j=0; j<temp.length; j++) k = k - Integer.parseInt(temp[j]);
			
			if(k==0) ans[index++] = subsets[i];
			
		}
//		System.out.println(31);
//		System.out.println(ans[0]);
		return ans;
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(fact(n));
		
		
	}
}
