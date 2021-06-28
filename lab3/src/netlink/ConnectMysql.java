package netlink;

import java.io.*;
import java.sql.*;
import java.util.Properties;

public class ConnectMysql {

	private String driver;  
	private String url;
	private String userName;
	private String passWord;
	
	public Connection getCon() throws Exception{
		try {
			ClassLoader classLoader = ConnectMysql.class.getClassLoader();
			// 2.通过类加载器的方法获得一个输入流
			InputStream in = classLoader.getResourceAsStream("jdbc.properties");
			// 3.创建一个properties对象(集合)
			Properties props = new Properties();
			// 4.加载输入流
			props.load(in);
			// 5.获取相关参数的值
			driver = props.getProperty("driver");
			url = props.getProperty("url");
			userName = props.getProperty("username");
			passWord = props.getProperty("password");
			Class.forName(driver);
			Connection joint = DriverManager.getConnection(url, userName, passWord);
			return joint;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void connect() {	
		ConnectMysql joint = new ConnectMysql();
		try {
			joint.getCon();
			System.out.println("已成功连接数据库！\n");
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("连接数据库失败！\n");
		}
	}
	
	public void release(Statement state, ResultSet rs) {
		
		if( rs != null) {
			try {
				rs.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("已释放ResultSet!\n");
		if( state != null ) {
			try {
				state.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("已释放Statement!\n");
	}
	
	public void closeConnect(Connection joint) throws Exception{
		if( joint != null ) {
			joint.close();
		}
		System.out.println("已断开和数据库的连接。\n");
	}
}
