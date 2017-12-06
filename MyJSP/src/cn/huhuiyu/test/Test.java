package cn.huhuiyu.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
	// 格式化日期的类
	private static SimpleDateFormat sdf = new SimpleDateFormat();

	public static String getNow() {
		// 设置日期格式
		sdf.applyPattern("yyyy年MM月dd日 HH:mm:ss");
		Date date = new Date();
		return sdf.format(date); // 将日期格式化成指定效果的字符串
	}

	// 执行外部程序的功能演示
	public static void exec() throws Exception {
		for (int i = 0; i < 3; i++) {
			Runtime.getRuntime().exec("C:/Program Files (x86)/UCBrowser/Application/UCBrowser.exe").waitFor();
		}
	}

	// 复制文件
	public static void copy() throws Exception {
		String file = "D:\\SublimeText3.zip"; // 要复制的原始文件地址
		String dest = "a.zip"; // 复制的目的文件
		// 打开文件输入流
		InputStream is = new FileInputStream(file);
		// 计算机认为文件都是byte
		byte[] bytes = new byte[8 * 1024]; // 每次读取8k
		int len = is.read(bytes); // 读取
		// 打开文件输出流
		OutputStream os = new FileOutputStream(dest);
		while (len > 0) { // 反复读取
			os.write(bytes, 0, len); //写出
			os.flush(); //立即写出
			len=is.read(bytes);
		}
		os.close();
		is.close();
		System.out.println("文件复制完毕");
	}

	public static void main(String[] args) throws Exception {
		Test.copy();
	}

}
