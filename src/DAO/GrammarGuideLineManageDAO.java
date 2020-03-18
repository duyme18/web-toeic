package DAO;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

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

	public static boolean InsertGrammarGuideLineName(HttpServletRequest request, Connection conn,
			GrammarGuideLine grammarguideline) {

		PreparedStatement ptmt = null;

		String sql = "INSERT INTO `grammarguideline`(grammarname) values (?)";

		try {
			ptmt = conn.prepareStatement(sql);

			String grammarname = grammarguideline.getGrammarname();

			ptmt.setString(1, grammarname);

			int kt = ptmt.executeUpdate();

			if (kt != 0) {
				return true;
			}

			ptmt.close();

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return false;

	}

	public static void UploadImageGrammarGuideLine(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		ServletContext context = request.getServletContext();
		final String Address = context.getRealPath("/ImageUpload");
		final int MaxMemorySize = 1024 * 1024 * 3; // 3MB
		final int MaxRequestSize = 1024 * 1024 * 50; // 50 MB

		boolean isMultipart = ServletFileUpload.isMultipartContent(request);

		if (!isMultipart) {
//			request.setAttribute("message", "not have enctypr: multipart/form-data");
			out.print("not have enctypr: multipart/form-data");
		}

		DiskFileItemFactory factory = new DiskFileItemFactory();

		// Set factory constraints
		factory.setSizeThreshold(MaxMemorySize);

		factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

		// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload(factory);

		// Set overall request size constraint
		upload.setSizeMax(MaxRequestSize);

		try {
			// Parse the request
			List<FileItem> items = upload.parseRequest(request);

			// Process the uploaded items
			Iterator<FileItem> iter = items.iterator();

			while (iter.hasNext()) {
				FileItem item = iter.next();

				if (!item.isFormField()) {
					String fileName = item.getName();

					// pathFile: vị trí mà chúng ta muốn upload file vào
					// gửi cho server

					String pathFile = Address + File.separator + fileName;

					File uploadedFile = new File(pathFile);
					boolean kt = uploadedFile.exists();

					try {
						if (kt == true) {
//							request.setAttribute("message", "File exitst. Require: test file again!");
							out.print("File exitst. Require: test file again!");
						} else {
							item.write(uploadedFile);
//							request.setAttribute("message", "Upload file success");
							out.println("address" + pathFile);
						}

					} catch (Exception e) {

//						request.setAttribute("message", e.getMessage());
						out.print(e.getMessage());
					}

				} else {
//					request.setAttribute("message", "Upload file failed");
					out.print("Upload file failed");
				}
			}

		} catch (FileUploadException e) {
//			request.setAttribute("message", e.getMessage());
			out.print(e.getMessage());
		}

	}

}
