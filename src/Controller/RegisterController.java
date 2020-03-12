package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BEAN.Member;
import DAO.RegisterDAO;
import DB.DBConnection;
import java.sql.*;

@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegisterController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("View/Register.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getCharacterEncoding() == null) {
			request.setCharacterEncoding("UTF-8");
		}

		Connection conn = DBConnection.CreateConnection();

		String fullname = request.getParameter("fullname");
		String membername = request.getParameter("membername");
		String memberpass = request.getParameter("memberpass");

		Member member = new Member();
		member.setFullname(fullname);
		member.setMembername(membername);
		member.setMemberpass(memberpass);

		boolean test = RegisterDAO.InsertAccount(request, conn, member);

		if (test) {
			request.setAttribute("msgRegister", "Đăng ký thành công");
			RequestDispatcher rd = request.getRequestDispatcher("RegisterForward");
			rd.forward(request, response);
		} else {
			request.setAttribute("msgRegister", "Đăng ký không thành công");
			RequestDispatcher rd = request.getRequestDispatcher("RegisterForward");
			rd.forward(request, response);
		}

	}

}
