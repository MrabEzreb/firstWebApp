package com.ezrebclan.firstWebApp.htcpcp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CoffeePotServlet extends HttpServlet {

	protected void doBrew(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doBrew(req, resp);
	}
}
