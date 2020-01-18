public class DrawTriangle{
	public static void DrawTriangle(int N){
		String x = "*";
		int i = 0;
		while(i < N){
			System.out.println(x);
			x = x + "*";
			i = i + 1;
		}
	}
	public static void main(String[] args){
		DrawTriangle(10);
	}
}