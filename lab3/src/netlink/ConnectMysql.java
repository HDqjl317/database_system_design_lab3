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
			// 2.ͨ����������ķ������һ��������
			InputStream in = classLoader.getResourceAsStream("jdbc.properties");
			// 3.����һ��properties����(����)
			Properties props = new Properties();
			// 4.����������
			props.load(in);
			// 5.��ȡ��ز�����ֵ
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
			System.out.println("�ѳɹ��������ݿ⣡\n");
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("�������ݿ�ʧ�ܣ�\n");
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
		System.out.println("���ͷ�ResultSet!\n");
		if( state != null ) {
			try {
				state.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("���ͷ�Statement!\n");
	}
	
	public void closeConnect(Connection joint) throws Exception{
		if( joint != null ) {
			joint.close();
		}
		System.out.println("�ѶϿ������ݿ�����ӡ�\n");
	}
}
