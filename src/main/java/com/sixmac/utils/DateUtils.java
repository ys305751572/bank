package com.sixmac.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Java�����ڵľ�����һ��������棺 1���������� 2�����ڸ�ʽ����ʾ 3�����ڵ�ת������Ҫ�Ǻ��ַ���֮����໥ת����
 * 4���������ꡢ�¡��ա�ʱ���֡��롢���ڡ��·ݵȻ�ȡ�� 5�����ڵĴ�С�Ƚϡ����ڵļӼ���
 *
 * @author Administrator
 *
 */
public class DateUtils {
	private DateUtils() {

	}

	public static void main(String[] args) throws ParseException {
		// System.out.println(DateTools.dateToDateWithFormat(new Date(),
		// "yyyy-MM-01"));
		//
		// System.out.println(DateTools.dateWithFormat(new Date(),
		// "yyyy-MM-1"));

		// System.out.println(DateTools.dateCompare(DateTools.stringToDateWithFormat("2008-09-12",
		// "yyyy-MM-dd")));

		// System.out.println(DateTools.getDays(new Date()));
		// System.out.println(DateTools.getRemainDays(new Date()));
//		System.out.println(new Date());
//        int year =  getYear(new Date());
//        int month = getMonth(new Date());
//        System.out.println("year:"+year+",month:"+month+1);

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = format.parse("2015-06-15 22:30:00");

        System.out.println(minuteCompare(date,15));

    }

	/**
	 *  �����m�µĵ�һ��
	 * @param nowdate
	 * @param m ����,0�Ǳ��µĵ�һ��,-1���µĵ�һ��
	 * @return
	 * @throws ParseException
	 */
	public static Date getStartDate(Date nowdate,Integer m) throws ParseException{
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(nowdate);
		gc.add(GregorianCalendar.MONTH, m);
		Calendar now = Calendar.getInstance();
		now.setTime(gc.getTime());
		String mm=now.get(Calendar.YEAR)+"-"+(now.get(Calendar.MONTH) + 1);
		return DateUtils.stringToDateWithFormat(mm+"-"+"01 00:00:00","yyyy-MM-dd HH:mm:ss");
	}


    public static int daysBetween(Date smdate,Date bdate) throws ParseException
    {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        smdate=sdf.parse(sdf.format(smdate));
        bdate=sdf.parse(sdf.format(bdate));
        Calendar cal = Calendar.getInstance();
        cal.setTime(smdate);
        long time1 = cal.getTimeInMillis();
        cal.setTime(bdate);
        long time2 = cal.getTimeInMillis();
        long between_days=(time2-time1)/(1000*3600*24);

        return Integer.parseInt(String.valueOf(between_days));
    }


    public static Integer getYear(Date date){

        Calendar now = Calendar.getInstance();
        now.setTime(date);
        return now.get(Calendar.YEAR);
    }

    public static Integer getMonth(Date date){

        Calendar now = Calendar.getInstance();
        now.setTime(date);
        return now.get(Calendar.MONTH);
    }



    /**
	 * ��������
	 *
	 * @return
	 */
	public static Integer getDays(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.getActualMaximum(Calendar.DAY_OF_MONTH);
	}

	/**
	 * ����ʣ������
	 *
	 * @return
	 */
	public static Integer getRemainDays(Date date) {
		Calendar curcal = Calendar.getInstance();
		curcal.setTime(date);
		Integer remain = curcal.getActualMaximum(Calendar.DAY_OF_MONTH) + 1
				- curcal.get(Calendar.DATE);
		return remain;
	}

	/* ����ת���� */
	/**
	 * ������ʾ�ܼ�
	 *
	 * @param date
	 */
	public static String chinaDayOfWeek(Date date) {
		Calendar now = Calendar.getInstance();
		now.setTime(date);
		String dayOfWeek[] = { "", "������", "����һ", "���ڶ�", "������", "������", "������",
				"������" };
		return dayOfWeek[now.get(Calendar.DAY_OF_WEEK)];
	}

	/**
	 * ������ʾ�·�
	 *
	 * @param date
	 * @return
	 */
	public static String chinaMonth(Date date) {
		Calendar now = Calendar.getInstance();
		now.setTime(date);
		String months[] = { "һ��", "����", "����", "����", "����", "����", "����", "����",
				"����", "ʮ��", "ʮһ��", "ʮ����" };
		return months[now.get(Calendar.MONTH)];
	}

	/* ���ڸ�ʽת�� */

	/**
	 * ���format��ʽ������ �˷����ڲ��õ���dateWithCalendar(Date date)���� format notice:
	 * yyyy-MM-01 exception yyyy-MM-1 ok
	 *
	 * @param date
	 * @param format
	 *
	 * @return
	 * @throws ParseException
	 */
	public static Date dateWithFormat(Date date, String format)
			throws ParseException {
		String str = DateUtils.dateWithCalendar(date);
		return DateUtils.stringToDateWithFormat(str, format);
	}

	/**
	 * ��Calendar��þ�ȷ������������ַ���
	 *
	 * @param date
	 * @return
	 */
	public static String dateWithCalendar(Date date) {
		StringBuffer sb = new StringBuffer();
		Calendar now = Calendar.getInstance();
		now.setTime(date);
		sb.append(now.get(Calendar.YEAR));
		sb.append("-");
		sb.append(now.get(Calendar.MONTH) + 1);
		sb.append("-");
		sb.append(now.get(Calendar.DATE));
		sb.append(" ");
		sb.append(now.get(Calendar.HOUR));
		sb.append(":");
		sb.append(now.get(Calendar.MINUTE));
		sb.append(":");
		sb.append(now.get(Calendar.SECOND));
		sb.append(":");
		sb.append(now.get(Calendar.MILLISECOND));
		return sb.toString();
	}

	/**
	 * ����ת����,format��ʽ�������ַ���
	 *
	 * @param date
	 *            new Date()
	 * @param format
	 *            yyyy-MM-dd
	 * @return
	 */
	public static String dateToStringWithFormat(Date date, String format) {
		SimpleDateFormat df = new SimpleDateFormat(format);
		return df.format(date);
	}

	/**
	 * �������ַ���ת����,format��ʽ������
	 *
	 * @param date
	 *            �����ַ���
	 * @param format
	 *            ���ڸ�ʽ:yyyy-MM-dd
	 * @return
	 * @throws ParseException
	 */
	public static Date stringToDateWithFormat(String date, String format)
			throws ParseException {
		SimpleDateFormat df = new SimpleDateFormat(format);
		return df.parse(date);
	}

	/**
	 * ������ת����format��ʽ������
	 *
	 * @param date
	 *            ����
	 * @param format
	 *            ���ڸ�ʽ:yyyy-MM-dd
	 * @return
	 * @throws ParseException
	 */
	public static Date dateToDateWithFormat(Date date, String format)
			throws ParseException {
		String str = DateUtils.dateToStringWithFormat(date, format);
		date = DateUtils.stringToDateWithFormat(str, format);
		return date;
	}

	/* ���ڱȽ� */

	/**
	 * ��ǰ������������ڵıȽ�, �������ڴ��ڵ�ǰ����ʱ����true
	 *
	 * @param date
	 * @return
	 */
	public static boolean dateCompare(Date date) {
		if (new Date().before(date)) {
			return true;
		}
		return false;
	}

	public static Date dateAddDay(Date date, int day) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(date);
		gc.add(GregorianCalendar.DATE, day);
		return gc.getTime();
	}

	public static Date dateAddMonth(Date date, int m) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(date);
		gc.add(GregorianCalendar.MONTH, m);
		return gc.getTime();
	}

	/**
	 * ���з������жϵ�ǰʱ����ɵ�ʱ���Ƿ����second�룬�Ƿ����棬�񷵻ؼ� �����ǰ������������ڼ������second��ʱ�����棬
	 *
	 * @param date
	 * @param second
	 * @return
	 */
	public static boolean secondCompare(Date date, int second) {
		GregorianCalendar gc = new GregorianCalendar();
		Date d = new Date();
		gc.setTime(d);
		gc.add(GregorianCalendar.SECOND, -second);
		// ��ǰʱ���ȥsecond��֮���Ƿ��ھ�ʱ��ǰ��
		// ��ʱ���ǰ�� olddate.before
		if (date.before(gc.getTime())) {
			return true;
		}
		return false;
	}

	/**
	 * �����ǰ����������ڼ������minute��ʱ�����棬
	 * @param olddate
	 * @param minute
	 * @return
	 */
	public static boolean minuteCompare(Date olddate, int minute) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(new Date());
		gc.add(GregorianCalendar.MINUTE, -minute);
		if (olddate.before(gc.getTime())) {
			return true;
		}
		return false;
	}

	/**
	 * �����ǰ����������ڼ������hourСʱ,�����棬
	 *
	 * @param olddate
	 * @param hour
	 * @return
	 */
	public static boolean hourCompare(Date olddate, int hour) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(new Date());
		gc.add(GregorianCalendar.HOUR, -hour);
		if (olddate.before(gc.getTime())) {
			return true;
		}
		return false;
	}

	/**
	 * �����ǰ����������ڼ������day��ʱ�����棬
	 *
	 * @param olddate
	 * @param day
	 * @return
	 */
	public static boolean dayCompare(Date olddate, int day) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(new Date());
		gc.add(GregorianCalendar.DATE, -day);
		if (olddate.before(gc.getTime())) {
			return true;
		}
		return false;
	}

	/**
	 * �����ǰ����������ڼ������month��,������
	 *
	 * @param olddate
	 * @param month
	 * @return
	 */
	public static boolean monthCompare(Date olddate, int month) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(new Date());
		gc.add(GregorianCalendar.MONTH, -month);
		if (olddate.before(gc.getTime())) {
			return true;
		}
		return false;
	}

	/**
	 * �����ǰ����������ڼ������year��,�����棬
	 * 
	 * @param olddate
	 * @param year
	 * @return
	 */
	public static boolean yearCompare(Date olddate, int year) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(new Date());
		gc.add(GregorianCalendar.YEAR, -year);
		if (olddate.before(gc.getTime())) {
			return true;
		}
		return false;
	}


}
