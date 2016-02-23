package com.sixmac.utils;

import java.util.Comparator;

public class ComparatorBe implements Comparator<Double>{

	@Override
	public int compare(Double o1, Double o2) {
		if( o1 < o2 ) {
			return -1;
		}
		else {
			return 1;
		}
	}
}
