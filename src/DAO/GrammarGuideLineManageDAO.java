package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import BEAN.GrammarGuideLine;

public class GrammarGuideLineManageDAO {
	public static List<GrammarGuideLine> DisplayGrammarGuideLineManage(HttpServletRequest request, Connection conn) {
		List<GrammarGuideLine> list = new ArrayList<GrammarGuideLine>();

		String sql = "SELECT * FROM grammarguideline";
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);

			ResultSet rs = ptmt.executeQuery();
			if (rs.isBeforeFirst()) {
				while (rs.next()) {
					GrammarGuideLine grammarGuideLine = new GrammarGuideLine();
					int grammarguidelineid = rs.getInt("grammarguidelineid");
					String grammarname = rs.getString("grammarname");
					String grammarimage = rs.getString("grammarimage");
					String content = rs.getString("content");

					grammarGuideLine.setGrammarguidelineid(grammarguidelineid);
					grammarGuideLine.setGrammarname(grammarname);
					grammarGuideLine.setGrammarimage(grammarimage);
					grammarGuideLine.setContent(content);

					list.add(grammarGuideLine);
				}

			} else {
				request.setAttribute("msglistgrammarguidelinemanage", "Không có bài hướng dẫn nào trong danh sách!");

			}

		} catch (SQLException e) {
			request.setAttribute("msglistgrammarguidelinemanage", e.getMessage());
		}

		return list;
	}
}
