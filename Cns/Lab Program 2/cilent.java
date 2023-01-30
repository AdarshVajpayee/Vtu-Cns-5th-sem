package com;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

public class cilent {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String address="";
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Server Address:");
		address = sc.nextLine();
		
		Socket s = new Socket(address,5000);
		DataInputStream din = new DataInputStream(s.getInputStream());
		DataOutputStream dout = new DataOutputStream(s.getOutputStream());
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String filename = "";
		
		//Read the File Name.
		System.out.println("Enter File Name:");
		filename =sc.nextLine();
		sc.close();
		dout.writeUTF(filename);
		
		System.out.println("Receiving file:"+filename);
		filename = "Cilent"+filename;
		System.out.println("Saving as File:"+filename);
		byte b[] = new byte[1024];
		System.out.println("Receving File.....");
		FileOutputStream fos = new FileOutputStream(new File(filename),true);
		long bytesRead;
		
		do
		{
			bytesRead = din.read(b,0,b.length);
			fos.write(b,0,b.length);
		}while(!(bytesRead<1024));
		System.out.println("Completed");
		dout.close();
		s.close();
	}

}


