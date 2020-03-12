package Controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BEAN.Member;
import DAO.LoginDAO;
import DB.DBConnection;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Connection conn = DBConnection.CreateConnection();

		String membername = request.getParameter("membername");
		String memberpass = request.getParameter("memberpass");

		Member member = new Member();
		member.setMembername(membername);
		member.setMemberpass(memberpass);

		String fullname = LoginDAO.ExportNameMember(request, conn, member);
		String authentication = LoginDAO.AuthenticationMember(request, conn, member);

		if (authentication == "success") {
			int authorization = LoginDAO.AuthorizationMember(request, conn, member);
			if (authorization == 1) {

				HttpSession httpSession = request.getSession(true);
				httpSession.setAttribute("sessionuser", fullname);
				RequestDispatcher rd = request.getRequestDispatcher("HomeForward");
				rd.forward(request, response);
			} else {
				if (authorization == 2) {
					HttpSession httpSession = request.getSession(true);
					httpSession.setAttribute("sessionadmin", fullname);
					RequestDispatcher rd = request.getRequestDispatcher("HomeForward");
					rd.forward(request, response);
				}
			}
		} else {

			if (authentication.equals("fail")) {
				request.setAttribute("msgLogin", "Tên hoặc mật khẩu sai!!!");
				RequestDispatcher rd = request.getRequestDispatcher("View/Login.jsp");
				rd.forward(request, response);
			}
		}
	}

}
