package rps;

import java.security.SecureRandom;

public enum State {
	ROCK,
	PAPER,
	SCISSORS;

	static SecureRandom rnd = new SecureRandom();
	public boolean beats(State s) {
		return this == ROCK && s == SCISSORS || this == SCISSORS && s == PAPER || this == PAPER && s == ROCK;
	}
	
	public static State getRandom() {
		switch(rnd.nextInt(3)) {
		case 0:
			return ROCK;
		case 1:
			return PAPER;
		case 2:
			return SCISSORS;
		default:
			throw new AssertionError();
		}
	}
	
	public static State getFromString(String s) {
		switch(s) {
		case "r":
			return ROCK;
		case "p":
			return PAPER;
		case "s":
			return SCISSORS;
		default:
			return null;
		}
	}
	
	public static State getSuper(State s) {
		switch(s) {
		case ROCK:
			return PAPER;
		case PAPER:
			return SCISSORS;
		case SCISSORS:
			return ROCK;
		}
		
		return null;
	}
	
	public static State getSub(State s) {
		switch(s) {
		case ROCK:
			return SCISSORS;
		case PAPER:
			return ROCK;
		case SCISSORS:
			return PAPER;
		}
		
		return null;
	}
	
	public static State getNext(State prev, boolean plastwon) {
		// 1/4 chance
		if(rnd.nextBoolean())
			return getRandom();
		
		if(plastwon) {
			return getSuper(prev);
		} else {
			return getSub(prev);
		}
	}
}
