package goat3;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		while (true) {
		
		float wonwithchange = 0;
		float wonwithoutchange = 0;
		float roundswithchange = 0;
		float roundwithoutchange = 0;
		float v1 = 0;
		float v2 = 0;
		float progress = 0;
		
		
		int random = 0;
		int choose = 0;
		int discover = 0;
		boolean won;
		boolean changed = false;
		Scanner input;
		input = new Scanner(System.in);
		System.out.println("loops?");
		int loops = input.nextInt();
		for(int b = 0; b < 2;b++) {
			if(b == 0) {
				changed = true;
			} else {
				changed = false;
			}
			for(int i = 0; i < loops;i++) {
				won = false;
				String[] field = {"O", "O", "O"};
				String[] discoverfield = {"O", "O", "O"};
				String[] changefield = {"O", "O", "O"};
				random = (int) (Math.floor(Math.random() * 3) + 1);
				if(random == 1) {
					field[0] = "X";
				} else if(random == 2) {
					field[1] = "X";
				} else if(random == 3) {
					field[2] = "X";
				}
				discover = 5;
				choose = (int) (Math.floor(Math.random() * 3));
				for(int a = 0; a < 3;a++) {
					if(field[a] == "O" && choose != a && discover != 0) {
						discover = a;
					}
				}
				
				if(b == 0) {
					for(int c = 0;c < 3;c++) {
						if(field[c] == "X" && choose != c && discover != c && won == false) {
							won = true;
						}
					}
				} else {
					if(random - 1 == choose) {
						won = true;
					}
				}
				//discoverfield = field;
				for(int y = 0;y < 3;y++) {
					if(discover == y) {
						discoverfield[y] = "U";
					}
					if(choose == y) {
						changefield[y] = "C";
					}
				}
				for(int x = 0;x < 3;x++) {
					
				}
				if(b == 0) {
					roundswithchange++;
				} else {
					roundwithoutchange++;
				}
				if(won && b == 0) {
					wonwithchange++;
				}
				if(won && b == 1) {
					wonwithoutchange++;
				}
				try {
					v1 = (float)((wonwithchange / roundswithchange) * 100);
				} catch (Exception e) {}
				try {
					v2 = (float)((wonwithoutchange / roundwithoutchange) * 100);
				} catch (Exception e) {}
				try {
					progress = (((roundwithoutchange + roundswithchange) / loops * 2) / 4) * 100;
				} catch (Exception e) {}
				if(b == 0) {
					System.out.println((Math.round(progress * 100) / 100)+"%  field:  " + field[0]+" "+field[1]+" "+field[2] + "  choosen:  " + changefield[0] + " " + changefield[1] + " " + changefield[2] + "  discovered:  " + discoverfield[0] + " " + discoverfield[1] + " " + discoverfield[2] + "  changed?:  " + changed + "  won?:  " + won + "  " 
						+Math.round(wonwithchange)+"/"+Math.round(roundswithchange)+" "+Math.round(v1)+"%");
				} else {
					System.out.println((Math.round(progress * 100) / 100)+"%  field:  "+field[0]+" "+field[1]+" "+field[2] + "  choosen:  " + changefield[0] + " " + changefield[1] + " " + changefield[2] + "  discovered:  " + discoverfield[0] + " " + discoverfield[1] + " " + discoverfield[2] + "  changed?:  " + changed + "  won?:  " + won + "  " 
							+Math.round(wonwithoutchange)+"/"+Math.round(roundwithoutchange)+" "+Math.round(v2)+"%");
				}
			}
			System.out.println("--------------------------------------------------------------------------------------");
		}
		System.out.println("With change:  " + v1);
		System.out.println("Without change:  " + v2);
		//System.exit(0);
	}
}
}
