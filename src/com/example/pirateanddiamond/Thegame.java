package com.example.pirateanddiamond;

import java.util.ArrayList;

public class Thegame {
	public static int[] scheme = null;
	private static ArrayList<Pirates> pirates = null;
	private static int pirateNo = 5;
	private static int diamondNo = 100;

	public Thegame(ArrayList<Pirates> pirates) {
		// TODO Auto-generated constructor stub
		pirateNo = pirates.size();
		Thegame.pirates = pirates;
		for (int i = 0; i < pirateNo; i++) {
			Thegame.pirates.get(i).setgame(this);
		}
		Thegame.scheme = pirates.get(0).makeScheme();
	}

	public Thegame(String pirateNo, String diamondNo) {
		pirates = new ArrayList<Pirates>();
		int temp = Integer.parseInt(pirateNo);
		for (int i = 0; i < temp; i++) {
			pirates.add(new Pirates(i));
		}
		Thegame.pirateNo = pirates.size();
		Thegame.diamondNo = Integer.parseInt(diamondNo);
		temp = Integer.parseInt(pirateNo);
		for (int i = 0; i < temp; i++) {
			Thegame.pirates.get(i).setgame(this);
		}
		Thegame.scheme = pirates.get(0).makeScheme();
		Pirates.initialed = false;
	}

	public int[] getScheme() {
		return scheme;
	}

	public Pirates getPirate(int id) {
		return pirates.get(id);
	}

	public int getPirateNo() {
		return pirateNo;
	}

	public int getDiamondNo() {
		return diamondNo;
	}
}
