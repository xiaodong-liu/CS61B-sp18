public class MaxNumber {
    /** Returns the maximum value from m. */
    public static int max(int[] m) {
    	int length = m.length;
    	if(length == 1){
    		return m[0];
    	}
        else{
        	int max = m[0];
        	int i = 1;
        	while(i < length){
        		if(max < m[i]){
        			max = m[i];
        		}
        		i = i + 1;
        	}
        	return max;
        }
    }
    public static void main(String[] args) {
       int[] numbers = new int[]{9, 2, 15, 2, 22, 10, 6};      
       System.out.println(max(numbers));
    }
}