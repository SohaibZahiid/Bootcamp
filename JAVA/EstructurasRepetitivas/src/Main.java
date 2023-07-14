
public class Main {

	public static void main(String[] args) {
		// 1--
		
		int nums[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		
//		for (int i = 0; i < nums.length; i++) {
//			if(nums[i] % 2 == 0) {
//				System.out.println(nums[i]);
//			}
//		}
		
		
		// 2--
//		for (int i = 0; i < nums.length; i++) {
//			if(nums[i] % 3 == 0) {
//				System.out.println(nums[i]);
//			}
//		}
		
//		int x = 0;
//		while(x < nums.length) {
//			if(nums[x] % 3 == 0) {
//				System.out.println(nums[x]);
//			}
//			x++;
//		}
		
		
		// 3--
		
//		int num = 5;
//		int i = 0;
//		do {
//			System.out.println("Hi!!!");
//			i++;
//		} while (num > i);
		
		
		
		
		// 4--
	
		String abc = "abcdefghijklmnopqrstuvwxyz";
		String reverse = "";
		String abc2 = "";
		
		for (int i = abc.length() - 1; i >= 0; i--) {
			reverse = abc.substring(0, i);
			System.out.println(reverse);
			
			if(abc.charAt(i) == 'a') {
				for (int j = 0; j < abc.length(); j++) {
					abc2 += abc.charAt(j);
					System.out.println(abc2);
				}
			}
		}
		
		
		
		
		
		
	}

}
