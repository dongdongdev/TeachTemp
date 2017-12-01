package cn.huhuiyu.test;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
	//格式化日期的类
	private static SimpleDateFormat sdf=new SimpleDateFormat();
	
	public static String getNow() {
		//设置日期格式
		sdf.applyPattern("yyyy年MM月dd日 HH:mm:ss");
		Date date=new Date();
		return sdf.format(date); //将日期格式化成指定效果的字符串
	}
	
	public static void main(String[] args) throws Exception {
		for (int i = 0; i < 3; i++) {
			Runtime.getRuntime().exec(
"C:/Program Files (x86)/UCBrowser/Application/UCBrowser.exe")
			.waitFor();
		}
		
	}
	
}
