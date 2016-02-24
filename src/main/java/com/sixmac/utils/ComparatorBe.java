package com.sixmac.utils;

import java.util.Comparator;

import com.sixmac.entity.vo.EmCustVo;

public class ComparatorBe implements Comparator<EmCustVo>{

	@Override
	public int compare(EmCustVo o1, EmCustVo o2) {
		
		if( o1.getAllBf() < o2.getAllBf() ) {
			return -1;
		}
		else {
			return 1;
		}
	}
}
