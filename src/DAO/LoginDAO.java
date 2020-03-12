package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import BEAN.Member;

public class LoginDAO {
	public static String AuthenticationMember(HttpServletRequest request, Connection conn, Member member)
	{
		PreparedStatement ptmt = null;
		
		String test = "fail";
		String sql = "select membername,memberpass from `member`";
		
		try 
		{
			ptmt = conn.prepareStatement(sql);
			
			
			ResultSet rs = ptmt.executeQuery();
			
			while (rs.next())
			{
				String membername = rs.getString("membername");
				String memberpass= rs.getString("memberpass");
				
				if (member.getMembername().equals(membername) && member.getMemberpass().equals(memberpass))
				{
					test = "success";
				}				
			}
			
			ptmt.close();
			rs.close();
		} 
		catch (SQLException e) 
		{
			request.setAttribute("msgLogin",e.getMessage());
		}
		
		return test;
		
	}
	
	public static int AuthorizationMember(HttpServletRequest request, Connection conn, Member member)
	{
		PreparedStatement ptmt = null;
		
		
		String sql = "select categorymemberid from `member` where membername='"+member.getMembername()+"' AND memberpass='"+member.getMemberpass()+"'";
		int categorymemberid = 0;
		
		try 
		{
			ptmt = conn.prepareStatement(sql);
			
			
			ResultSet rs = ptmt.executeQuery();
			
			while (rs.next())
			{
				categorymemberid = rs.getInt("categorymemberid");		
			}
			
			ptmt.close();
			rs.close();
		} 
		catch (SQLException e) 
		{
			request.setAttribute("msgLogin",e.getMessage());
		}
		
		return categorymemberid;
	}
	
	
	public static String ExportNameMember(HttpServletRequest request, Connection conn, Member member)
	{
		PreparedStatement ptmt = null;
		
		
		String sql = "select fullname from `member` where membername='"+member.getMembername()+"' AND memberpass='"+member.getMemberpass()+"'";
		String name = "";
		
		try 
		{
			ptmt = conn.prepareStatement(sql);
			
			
			ResultSet rs = ptmt.executeQuery();
			
			while (rs.next())
			{
				name = rs.getString("fullname");
			}
			
			ptmt.close();
			rs.close();
		} 
		catch (SQLException e) 
		{
			request.setAttribute("msgLogin",e.getMessage());
		}
		
		return name;
	}
}
