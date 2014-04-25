package com.example.pirateanddiamond;

import java.util.ArrayList;

public class Pirates {
	public final int id;
	public int recievingdiamonds = 0;
	private static int pirateNo ;
	private static int diamondNo ;
	public static ArrayList<Integer> requesteddiamonds;
	public static int[] scheme = null;
	private Thegame game;
	public static boolean initialed = false;

	public Pirates(int id) {
		// TODO Auto-generated constructor stub
		this.id = id;
	}

	public void setgame(Thegame game) {
		this.game = game;	
		if(!initialed)
		{
			pirateNo = game.getPirateNo();
			diamondNo = game.getDiamondNo();
			scheme = new int[pirateNo];
			requesteddiamonds = new ArrayList<Integer>();
			
			for(int i = 0 ; i < pirateNo ; i++)
			{
				requesteddiamonds.add(diamondNo+2);
				scheme[i] = 0;
			}
			initialed = true;
		}
		
		
	}
	
	public int getRequestNo() {
		return getExpectedDiamonds() + 1;
	}

	public int getExpectedDiamonds() {
		return Pirates.scheme[id];
	}

	public int[] makeScheme() {
		int all = 0;
		if (id == (pirateNo-1)) {
			Pirates.scheme[pirateNo-1] = diamondNo;
			return Pirates.scheme;
		}
		game.getPirate(id + 1).makeScheme();
		for (int i = id + 1; i < pirateNo; i++) {
			requesteddiamonds.set(i, game.getPirate(i).getRequestNo());
		}
		int[] min = getMinIndexs(requesteddiamonds, (pirateNo - id) / 2);
		for (int i = 0; i < pirateNo; i++) {
			scheme[i] = 0;
		}
		for (int i = 0; i < min.length; i++) {
			scheme[min[i]] = requesteddiamonds.get(min[i]);
			all += scheme[min[i]];
		}
		scheme[id] = diamondNo - all;
		return scheme;
	}

	public int[] getMinIndexs(ArrayList<Integer> list, int n) {
		ArrayList<Integer> myList = (ArrayList<Integer>) list.clone();
		int[] min = new int[n];
		int size = myList.size();
		for (int i = 0; i < n; i++) {
			min[i] = 0;
			for (int j = 0; j < size - 1; j++) {
				if (myList.get(j + 1) < myList.get(j))
					min[i] = j + 1;
			}
			myList.set(min[i],diamondNo+2);
		}
		return min;
	}
}
