package com.xdevsoftware;

import java.io.FileOutputStream;
import java.time.LocalDateTime;

public class Demo {

	public static void main(final String[] args) throws Exception {

		LocalDateTime now = LocalDateTime.now();

		String str = "Hello " + now;
		try (FileOutputStream outputStream = new FileOutputStream("file.data")) {
			byte[] strToBytes = str.getBytes();
			outputStream.write(strToBytes);
		}
		System.out.println("done writing");

	}

}
