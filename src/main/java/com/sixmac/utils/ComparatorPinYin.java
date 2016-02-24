package com.sixmac.utils;

import java.util.Comparator;
import com.sixmac.entity.vo.EmCustVo;
import net.sourceforge.pinyin4j.PinyinHelper;

public class ComparatorPinYin implements Comparator<EmCustVo> {

	private String ToPinYinString(String str) {

		StringBuilder sb = new StringBuilder();
		String[] arr = null;

		for (int i = 0; i < str.length(); i++) {
			arr = PinyinHelper.toHanyuPinyinStringArray(str.charAt(i));
			if (arr != null && arr.length > 0) {
				for (String string : arr) {
					sb.append(string);
				}
			}
		}
		return sb.toString();
	}

	@Override
	public int compare(EmCustVo o1, EmCustVo o2) {
		return ToPinYinString(o1.getCustomerName()).compareTo(ToPinYinString(o2.getCustomerName()));
	}
}
