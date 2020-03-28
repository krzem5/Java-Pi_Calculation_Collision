package com.krzem.pi_calculation_collision;


public class Main{
	public static void main(String[] args){
		long s=System.nanoTime();
		System.out.println(Main.calc_pi_digits(20));
		long diff=System.nanoTime()-s;
		System.out.printf("Process took %fs",(double)diff/10e8);
	}



	public static long calc_pi_digits(int d){
		long c=0;
		int STEPS=(int)Math.pow(10,d-1);
		double b1p=1;
		double b1v=0;
		double b1m=1;
		double b2p=2;
		double b2v=-1d/STEPS;
		double b2m=Math.pow(100,d-1);
		while (true){
			if (Math.abs(b1v)<Math.abs(b2v)&&b2v>0){
				break;
			}
			if (!(b1p+1<b2p||b1p>b2p+1)){
				double v1=(b1m-b2m)/(b1m+b2m)*b1v+(2*b2m/(b1m+b2m))*b2v;
				double v2=(b2m-b1m)/(b1m+b2m)*b2v+(2*b1m/(b1m+b2m))*b1v;
				b1v=v1;
				b2v=v2;
				c++;
				System.out.println(c);
			}
			if (b1p<=0){
				b1v*=-1;
				c++;
				System.out.println(c);
			}
			b1p+=b1v;
			b2p+=b2v;
		}
		return c;
	}
}