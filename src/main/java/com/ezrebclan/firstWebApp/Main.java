package com.ezrebclan.firstWebApp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.*;

public class Main extends HttpServlet {
	public static String[] Ips = new String[0];
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
		if (req.getRequestURI().endsWith("/db")) {
			showDatabase(req,resp);
		} else if(req.getRequestURI().endsWith("/love")) {
			showSignup(req, resp);
		} else if(req.getRequestURI().endsWith("IP")) {
			String[] ips2 = new String[Ips.length + 1];
			System.arraycopy(Ips, 0, ips2, 0, Ips.length);
			ips2[Ips.length] = req.getRemoteAddr()+"\t"+req.getRemoteHost()+"\t"+req.getRemotePort();
			Ips = ips2;
			for (String string : ips2) {
				resp.getWriter().println(string+"<br>");
			}
		} else if(req.getRequestURI().endsWith("/php")) {
			showPHP();
		} else {
		    showHome(req,resp);
		}
	}
    @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		if(req.getRequestURI().endsWith("/IPPOST")) {
			req.getParameter("IP");
		}
	}

  private void showHome(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    resp.getWriter().print("Hello from Java!");
  }

  private void showDatabase(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    Connection connection = null;
    try {
      connection = getConnection();

      Statement stmt = connection.createStatement();
      stmt.executeUpdate("CREATE TABLE IF NOT EXISTS ticks (tick timestamp)");
      stmt.executeUpdate("INSERT INTO ticks VALUES (now())");
      ResultSet rs = stmt.executeQuery("SELECT tick FROM ticks");

      String out = "<h1>Hello!\n";
      while (rs.next()) {
          out += "Read from DB: " + rs.getTimestamp("tick") + "\n";
      }
      out += "</h1>";

      resp.getWriter().print(out);
    } catch (Exception e) {
      resp.getWriter().print("There was an error: " + e.getMessage());
    } finally {
      if (connection != null) try{connection.close();} catch(SQLException e){}
    }
  }

  private Connection getConnection() throws URISyntaxException, SQLException {
    URI dbUri = new URI(System.getenv("DATABASE_URL"));

    String username = dbUri.getUserInfo().split(":")[0];
    String password = dbUri.getUserInfo().split(":")[1];
    int port = dbUri.getPort();

    String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ":" + port + dbUri.getPath();

    return DriverManager.getConnection(dbUrl, username, password);
  }
  
  private void showSignup(HttpServletRequest req, HttpServletResponse resp)
	      throws ServletException, IOException {
	  resp.getWriter().print("<p>Hello from Java!</p>");
	  resp.getWriter().print("<h1>This is so freakin cool! I LOVE JAVA!</h1>");
  }
  private void showPHP(HttpServletRequest req, HttpServletResponse resp)
	      throws ServletException, IOException {
	  resp.getWriter().print("<p>Hello from Java!</p>");
	  resp.getWriter().print("<h1>This is so freakin cool! I LOVE JAVA!</h1>");
	  resp.getWriter().print("<?php echo \"hello\";");
  }

  public static void main(String[] args) throws Exception {
	  Server server = null;
	  try {
		  server = new Server(Integer.valueOf(System.getenv("PORT")));
	  } catch(NumberFormatException nfe) {
		  server = new Server(80);
	  }
	  ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
	  context.setContextPath("/");
	  server.setHandler(context);
	  context.addServlet(new ServletHolder(new Main()),"/*");
	  server.start();
	  server.join();
  }
}
