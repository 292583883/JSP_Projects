package com.skybow.tools;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * �ַ���������
 * @author le
 * 2015��6��18�� ����12:25:33
 * ����:
 * 	1HTMLChange HTMLת��
 * 	2dateTimeChange ʱ��ת��date->String("yyyy-MM-dd HH:mm:ss")
 */
public class DoString {
	/**
	 * HTMLת��
	 * @param source
	 * @return
	 */
	public static String HTMLChange(String source){
		String changeStr="";
		changeStr=source.replaceAll("&","&amp;");
		changeStr=changeStr.replaceAll(" ","&nbsp;");
		changeStr=changeStr.replaceAll("<","&lt;");
		changeStr=changeStr.replaceAll(">","&gt;");		
		changeStr=changeStr.replaceAll("\r\n","<br>");
		return changeStr;
	}
	/**
	 * ʱ��ת��
	 * @param source
	 * @return
	 */
	public static String dateTimeChange(Date source){
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String changeTime=format.format(source);		
		return changeTime;
	}
}
