package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BEAN.GrammarGuideLine;
import DAO.GrammarGuideLineManageDAO;
import DB.DBConnection;

@WebServlet("/InsertGrammarGuideLineName")
public class InsertGrammarGuideLineName extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public InsertGrammarGuideLineName() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getCharacterEncoding() == null) {
			request.setCharacterEncoding("UTF-8");
		}

		String grammarname = request.getParameter("grammarname");

		GrammarGuideLine grammarguideline = new GrammarGuideLine();

		grammarguideline.setGrammarname(grammarname);

		Connection conn = DBConnection.CreateConnection();

		try {
			boolean kt = GrammarGuideLineManageDAO.InsertGrammarGuideLineName(request, conn, grammarguideline);

			if (kt) {
				RequestDispatcher rd = request.getRequestDispatcher("View/Admin/InsertGrammarGuideLineImage.jsp");
				rd.forward(request, response);
			} else {
				request.setAttribute("msglistgrammarguidelinemanage", "Thêm không thành công!");
				RequestDispatcher rd = request.getRequestDispatcher("ListGrammarGuideLineManage");
				rd.forward(request, response);
			}

			conn.close();
		} catch (SQLException e) {
			request.setAttribute("msglistgrammarguidelinemanage", e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("ListGrammarGuideLineManage");
			rd.forward(request, response);
		}

	}

}
