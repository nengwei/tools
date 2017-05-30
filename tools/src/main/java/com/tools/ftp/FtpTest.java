package com.tools.ftp;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

/**
 * 利用ftp上传文件 上传文件默认格式是文本 如果上传文件为图片则会导致图片不能正常查看
 * 
 * @author weineng
 *
 */
public class FtpTest {
	
	public static void main(String[] args) throws Exception {
		testFtpClient();
	}

	public static void testFtpClient() throws Exception {
		// 创建一个FtpClient对象
		FTPClient ftpClient = new FTPClient();
		// 创建ftp连接。默认是21端口
		ftpClient.connect("服务器ip地址", 21);// 端口可写可不写，不写就是21
		// 登录ftp服务器，使用用户名和密码
		ftpClient.login("username", "password");//
		// 上传文件
		// 读取本地文件
		// 将本地文件读入输入流
		FileInputStream fis = new FileInputStream(new File("/home/weineng/1.jpg"));
		// 设置上传路径
		ftpClient.changeWorkingDirectory("/home/ftpuser/images/1.jpg");
		// 修改上传文件的格式,如果不设置则图片不能使用
		ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
		// 第一个参数：服务器端文件名
		// 第二个参数：上传文档的inputStream
		ftpClient.storeFile("2.jpg", fis);
		// 关闭连接
		ftpClient.logout();
	}

}
