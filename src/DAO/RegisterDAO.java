package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import BEAN.Member;

public class RegisterDAO {
	public static boolean InsertAccount(HttpServletRequest request, Connection conn, Member member) {

		PreparedStatement ptmt = null;

		String sql = "INSERT INTO `member`(fullname, membername, memberpass, categorymemberid) VALUES (?, ?, ?, ?)";

		try {
			ptmt = conn.prepareStatement(sql);

			String fullname = member.getFullname();
			String membername = member.getMembername();
			String memberpass = member.getMemberpass();
			int categorymemberid = 1;

			ptmt.setString(1, fullname);
			ptmt.setString(2, membername);
			ptmt.setString(3, memberpass);
			ptmt.setInt(4, categorymemberid);

			int kt = ptmt.executeUpdate();

			if (kt != 0) {
				return true;
			}

			ptmt.close();
		} catch (SQLException e) {
			request.setAttribute("msgRegister", e.getMessage());
		}

		return false;
	}
}
