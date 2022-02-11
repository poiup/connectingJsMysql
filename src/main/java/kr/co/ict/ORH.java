package kr.co.ict;

public class ORH {
	public static void main(String[] args) {
		double orh = 11;
		double w = 1.1;
		double g = 0.3;
		double b = 1.8;
		
		double stuff = (w*64) + (g*26) + (b*8) + 205;
		System.out.println((((330 - stuff - 16) / 3) *4) * 24);
	}
}
