package com.sg.eportal;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Prime {
	public static void main(String args[]){
		int n=3;
		Prime prime=new Prime();
		System.out.println(prime.isPrimeMine(n));
		System.out.println(prime.isPrime2(n));

	
	}
	
	public boolean isPrimeMine(int n){
		return Stream.iterate(2,f->f+1).limit(n-2).noneMatch(p->n%p==0);
	}
	public boolean isPrime2(int n){
		return IntStream.rangeClosed(2, n/2).noneMatch(p->n%p==0);
	}
	

}
