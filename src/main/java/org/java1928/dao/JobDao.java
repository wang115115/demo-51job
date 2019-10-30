package org.java1928.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.java1928.entity.Job;

/**
 * 	职位信息数据库操作类
 * @author junki
 * @date 2019年10月30日
 */
public class JobDao {

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	String url = "jdbc:mysql://localhost:3306/java1928test?useSSL=true&characterEncoding=UTF-8";
	String username = "root";
	String password = "root";
	
	public int insert(Job job) throws SQLException {
		
		Connection conn = DriverManager.getConnection(url, username, password);
		
		String sql = "insert into job(name, company, address, salary, date) value(?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, job.getName());
		pstmt.setString(2, job.getCompany());
		pstmt.setString(3, job.getAddress());
		pstmt.setString(4, job.getSalary());
		pstmt.setString(5, job.getDate());
		
		int result = pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
		
		return result;
		
	}

}
