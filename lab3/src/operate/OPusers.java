package operate;

import java.sql.*;
import table.*;

public class OPusers {
	
	public void createTable(Statement state, String userInfo) {
		try {
			state.executeUpdate(userInfo);
			System.out.println("已成功创建一个User表\n");
		}
		catch(SQLException e) {
			System.out.println("创建失败！\n");
			e.printStackTrace();
		}
	}
	
	public void addUsers(Statement state, Users user) {
		try {
			String sql="insert into users(userName,pass) values (" + user.getUser() + ");" ;
			System.out.println("构造语句："+sql);
			state.executeUpdate(sql);
			System.out.println("已在users表插入一条新记录,用户信息："+user.getUser()+"\n");
		}
		catch(SQLException e) {
			System.out.println("异常！向users表插入数据失败！\n");
			e.printStackTrace();
		}	
	}
	
	public void deleteSome(Statement state,String table,String atrribute,String value) {
		
		try {
			String temp="delete from "+table+" where "+atrribute+" = '"+value+"';";
			state.executeUpdate(temp);
			System.out.println("删除成功！");
		} 
		catch (SQLException e) {
			System.out.println("删除失败！");
			e.printStackTrace();
		}
	}
	
	public void delete(Statement state, ResultSet rs, String delData) {
		
		try {
			String temp = "delete from users where userName like '"+ delData + "%';";
			state.executeUpdate(temp);
			System.out.println("已成功删除users表中以" + delData + "开头的数据！\n");
		}
		catch(SQLException e) {
			System.out.println("删除users表中以" + delData + "开头的数据失败！\n");
			e.printStackTrace();
		}
		
		try {
			String temp2 = "delete from persons where userName like '" + delData + "%';";
			state.executeUpdate(temp2);
			System.out.println("已成功删除persons表中以" + delData + "开头的数据！");
		}
		catch(SQLException e) {
			System.out.println("删除persons表中以" + delData + "开头的数据失败！");
			e.printStackTrace();
		}
	}
	
	public void show(Statement state, ResultSet rs) {
		
		System.out.println("表users:");
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
