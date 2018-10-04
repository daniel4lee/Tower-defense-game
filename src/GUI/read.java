package GUI;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class read {
	read() {
	}

	{
		int sum=0;
		int j = 0;
		Scanner s = null;
		try {
			try {
				s = new Scanner(new BufferedReader(new FileReader("map.txt")));
			} catch (Exception e) {
				System.out.println(e);
			}
			while (s.hasNext()) {
				String str = s.next();
				
					sum=0;
					for (int i = 0; i < 22; i++) {
						Main.p.map1[j][i] = str.charAt(sum);
						sum=sum+1;
					}
					j=j+1;
				
				}
			
			
		} finally {
			
			if (s != null) {
				s.close();
			}
		}
	}
}
