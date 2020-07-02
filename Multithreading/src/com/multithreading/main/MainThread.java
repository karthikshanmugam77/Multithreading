package com.multithreading.main;

import java.util.Scanner;

import com.multithreading.UserPojo;
import com.multithreading.thread1.Thread1;
import com.multithreading.thread2.Thread2;

public class MainThread {
	
	/**
	 * @param hello
	 */
	public static void main(String hello[])
	{
		Scanner sc = new Scanner(System.in);
		try {
	System.out.println("Enter the number of users you want to insert");
	
	int N = sc.nextInt();
	for(int ctr = 0;ctr<N;ctr++) {
		System.out.println("Enter id");
		int id = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter name");
		String name = sc.nextLine();
		System.out.println("Ënter password");
		String password = sc.nextLine();
		System.out.println("Executing Thread-1...");
		UserPojo user =  new UserPojo(id , name , password);
		Thread1 t1 = new Thread1(user);
		t1.setPriority(10);
		t1.start();
		System.out.println("Executing Thread-2...");
		Thread2 t2 = new Thread2(user);
		t2.setPriority(1);
		t2.start();
		System.out.println("Executed...");
	}}
	catch (Exception e) {
		System.out.println(e);
	}
		sc.close();
	
	}

}
