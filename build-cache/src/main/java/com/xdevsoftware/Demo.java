package com.xdevsoftware;

public class Demo
{
	
	public static void main(final String[] args) throws Exception
	{
		new Thread(() -> System.out.println("Hello lambda")).start();
	}
	
}
