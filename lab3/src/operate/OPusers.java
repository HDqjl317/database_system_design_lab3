package operate;

import java.sql.*;
import table.*;

public class OPusers {
	
	public void createTable(Statement state, String userInfo) {
		try {
			state.executeUpdate(userInfo);
			System.out.println("�ѳɹ�����һ��User��\n");
		}
		catch(SQLException e) {
			System.out.println("����ʧ�ܣ�\n");
			e.printStackTrace();
		}
	}
	
	public void addUsers(Statement state, Users user) {
		try {
			String sql="insert into users(userName,pass) values (" + user.getUser() + ");" ;
			System.out.println("������䣺"+sql);
			state.executeUpdate(sql);
			System.out.println("����users�����һ���¼�¼,�û���Ϣ��"+user.getUser()+"\n");
		}
		catch(SQLException e) {
			System.out.println("�쳣����users���������ʧ�ܣ�\n");
			e.printStackTrace();
		}	
	}
	
	public void deleteSome(Statement state,String table,String atrribute,String value) {
		
		try {
			String temp="delete from "+table+" where "+atrribute+" = '"+value+"';";
			state.executeUpdate(temp);
			System.out.println("ɾ���ɹ���");
		} 
		catch (SQLException e) {
			System.out.println("ɾ��ʧ�ܣ�");
			e.printStackTrace();
		}
	}
	
	public void delete(Statement state, ResultSet rs, String delData) {
		
		try {
			String temp = "delete from users where userName like '"+ delData + "%';";
			state.executeUpdate(temp);
			System.out.println("�ѳɹ�ɾ��users������" + delData + "��ͷ�����ݣ�\n");
		}
		catch(SQLException e) {
			System.out.println("ɾ��users������" + delData + "��ͷ������ʧ�ܣ�\n");
			e.printStackTrace();
		}
		
		try {
			String temp2 = "delete from persons where userName like '" + delData + "%';";
			state.executeUpdate(temp2);
			System.out.println("�ѳɹ�ɾ��persons������" + delData + "��ͷ�����ݣ�");
		}
		catch(SQLException e) {
			System.out.println("ɾ��persons������" + delData + "��ͷ������ʧ�ܣ�");
			e.printStackTrace();
		}
	}
	
	public void show(Statement state, ResultSet rs) {
		
		System.out.println("��users:");
		System.out.printf("%-10s","userName");
		System.out.printf("%-10s","pass");
		System.out.println();
		try {
			String sql = "select * from users;";			
			rs = state.executeQuery(sql);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		try {
			while(rs.next()) {
				String s1 = rs.getString(1);
				System.out.printf("%-10s",s1);
				String s2 = rs.getString(2);
				System.out.printf("%-10s",s2);
				System.out.println();
			}
			System.out.println();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
