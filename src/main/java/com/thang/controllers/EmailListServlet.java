package com.thang.controllers;

import java.io.IOException;

import com.thang.models.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/emailList")
public class EmailListServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String email = req.getParameter("email");
		if (firstName == null || firstName.isEmpty() || lastName == null || lastName.isEmpty() || email == null
				|| email.isEmpty()) {

			String message = "Please fill out all three text boxes.";
			req.setAttribute("message", message);

			RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
			rd.forward(req, resp);
		} else {
			// Nếu dữ liệu hợp lệ, tạo đối tượng User
			User user = new User(firstName, lastName, email);
			req.setAttribute("user", user);

			// Chuyển tiếp đến trang cảm ơn (thanks.jsp)
			RequestDispatcher rd = req.getRequestDispatcher("thanks.jsp");
			rd.forward(req, resp);
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
		
		}
}
