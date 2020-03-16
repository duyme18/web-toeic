package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BEAN.GrammarGuideLine;
import DAO.GrammarGuideLineManageDAO;
import DB.DBConnection;

@WebServlet("/ListGrammarGuideLineManage")
public class ListGrammarGuideLineManage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ListGrammarGuideLineManage() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			Connection conn = DBConnection.CreateConnection();

			List<GrammarGuideLine> list = GrammarGuideLineManageDAO.DisplayGrammarGuideLineManage(request, conn);
			request.setAttribute("listgrammarguidelinemanage", list);
			conn.close();
		} catch (SQLException e) {
			request.setAttribute("msglistgrammarguidelinemanage", e.getMessage());
		}

		RequestDispatcher rd = request.getRequestDispatcher("View/Admin/ListGrammarGuideLineManage.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
