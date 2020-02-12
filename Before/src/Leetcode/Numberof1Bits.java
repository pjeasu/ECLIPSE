package Leetcode;


public class Numberof1Bits {
	 public int hammingWeight(int n) {
		 int count = 0;
		 int temp = n;
		 
		 for(int i = 0; i <32; i++) {
			 if ((temp & 0x1) == 0x1)
				 count++;
			 
			 temp >>= 1;
		 }
	        return count;
	   }

}
