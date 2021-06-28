package operate;

import java.sql.*;
import table.*;

public class OPpersons {
	
	public void createTable(Statement state, String personInfo) {
		try {
			state.executeUpdate(personInfo);
			System.out.println("�ѳɹ�����һ��Persons��\n");
		}
		catch(SQLException e) {
			System.out.println("����ʧ�ܣ�\n");
			e.printStackTrace();
		}
	}
	
	public void addPersons(Statement state, ResultSet rs, Persons people) {

		try {
			String temp2 = "select * from users where userName='" + people.getUserName() + "';";
			rs = state.executeQuery(temp2);
			rs.last();
			if( rs.getRow() == 0 ) {
				System.out.println("users�����ڸ�userName,���²����userName���û���Ϣ��"+people.getPersons());
				String temp3 = "insert into users(userName,pass) values ('" + people.getUserName() + "','888888');";
				System.out.println("������䣺"+temp3);
				state.execute(temp3);
				System.out.println("����ɹ�!\n");
			}
		}
		catch(SQLException e) {
			System.out.println("�쳣��users�����ڸ�userName,��users���½�һ��userNameʧ�ܣ�\n");
			e.printStackTrace();
		}
		
		String sql = "";
		
		if( people.getAge() != null && people.getTeleNo() != null ) {
			sql = "insert into persons(userName,name,age,teleNo) values (" + people.getPersons() + ");";
		}
		
		else if( people.getAge() != null && people.getTeleNo() == null ) {
			sql = "insert into persons(userName,name,age) values (" + people.getPersons() + ");";
		}
		
		else if( people.getAge() == null && people.getTeleNo() != null) {
			sql = "insert into persons(userName,name,teleNo) values (" + people.getPersons() + ");";
		}
		
		else {
			sql = "insert into persons(userName,name) values (" + people.getPersons() + ");";
		}		

		System.out.println("������䣺"+sql);
		
		try {
			String temp = "select * from persons where userName='" + people.getUserName() + "';";
			rs = state.executeQuery(temp);
			if( !rs.next()) {
				System.out.println("persons�����ڸ�userName,���²����userName���û���Ϣ��"+people.getPersons());
				state.executeUpdate(sql);
				System.out.println("����ɹ���"+"\n");
			}
			else {
				System.out.println("persons�������и�userName,�ֽ��и��£�");
				this.deleteSome(state,"persons","userName", people.getUserName());
				state.executeUpdate(sql);
				System.out.println("������ϣ�\n");
			}
		}
		catch(SQLException e) {
			System.out.println("�쳣����persons��������¸�userName����ʧ�ܣ�\n");
			e.printStackTrace();
		}	
	}
	
	public void delete(Statement state, ResultSet rs, String delData) {	
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
	
	public void show(Statement state, ResultSet rs) {
		System.out.println("��persons��");
		System.out.printf("%-10s","userName");
		System.out.printf("%-10s","name");
		System.out.printf("%-10s","age");
		System.out.printf("%-12s","teleNO");
		System.out.println();
		
		try {
			String sql = "select * from persons;";
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
				String s3 = rs.getString(3);
				if( s3 != null ) {
					System.out.printf("%-10s",s3);
				}
				String s4 = rs.getString(4);
				if( s4 != null ) {
					System.out.printf("%-10s",s4);
				}			
				System.out.println();
			}
			System.out.println();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
