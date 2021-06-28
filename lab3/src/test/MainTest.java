package test;

import java.sql.*;
import table.*;
import netlink.*;
import operate.*;

public class MainTest {
	public static void main(String[] args) {
		
		ConnectMysql joint = new ConnectMysql();
		joint.connect();
	
		try {
			Statement state = joint.getCon().createStatement();
			ResultSet rs = state.getResultSet();
			
			OPusers opusers = new OPusers();
			OPpersons oppersons = new OPpersons();
			
			String createUsersSql="create table users(userName varchar(10) not null,pass varchar(8) not null,primary key(userName));";
			String createPersonsSql ="create table persons(userName varchar(10) not null,name varchar(20) not null,age int,teleNo char(11),primary key(name));";
			opusers.createTable(state, createUsersSql);
			oppersons.createTable(state, createPersonsSql);
			
			opusers.show(state, rs);
			oppersons.show(state, rs);

			String [][]Users={ {"ly","123456"},{"liming","345678"},{"test","11111"},{"test1","12345"}};
			String[][]Persons= {{"ly","雷力",null,null},{"liming","李明","25",null},{"test","测试用户","20","13388449933"},
					{"ly","王五",null,null},{"test2","测试用户2",null,null},{"test1","测试用户1","33",null},
					{"test","张三","23","18877009966"},{"admin","admin",null,null}}; 
					
			for(int i = 0 ; i < 4 ; ++i ) {
				Users user = new Users(Users[i][0],Users[i][1]);
				opusers.addUsers(state,user);
			}
			opusers.show(state, rs);
			oppersons.show(state, rs);
			
			for(int i = 0 ; i < 8 ; ++i ) {	
				Persons person = new Persons(Persons[i][0],Persons[i][1],Persons[i][2],Persons[i][3]);
				oppersons.addPersons(state,rs,person);	
				if( i == 2 ) {
					oppersons.show(state, rs);					
				}
			}	
			opusers.show(state, rs);
			oppersons.show(state, rs);
			
			opusers.delete(state, rs,"test");
			
			opusers.show(state, rs);
			oppersons.show(state, rs);
			joint.release(state, rs);
		} 
		catch (SQLException e) {
			e.printStackTrace();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			joint.closeConnect(joint.getCon());
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
