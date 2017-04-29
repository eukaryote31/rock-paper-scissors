package rps;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int userscore = 0;
		int machinescore = 0;
		
		boolean plastwon = false;
		State laststate = State.getRandom();
		
		Scanner kbscan = new Scanner(System.in);
		
		while(true) {
			State playerstate;
			
			do {
				System.out.print("r/p/s:");
				playerstate = State.getFromString(kbscan.nextLine());
			} while(playerstate == null);
			
			State machinestate = State.getNext(laststate, plastwon);
	
			System.out.println("player: " + playerstate + " computer: " + machinestate);
			
			if(playerstate == machinestate) {
				System.out.println("TIE");
				plastwon = !plastwon;
			} else if(playerstate.beats(machinestate)) {
				System.out.println("PLAYER WIN");
				plastwon = true;
				userscore++;
			} else {
				System.out.println("MACHINE WIN");
				machinescore++;
				plastwon = false;
			}
			
			laststate = playerstate;
			
			System.out.println("USR\tAI\n" + userscore + "\t" + machinescore);
			
		}
	}
}
