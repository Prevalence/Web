package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bl.UserService;
import util.Encrypter;

/**
 * Servlet implementation class EncodingLogin
 */
public class EncodingLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EncodingLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		String userName = (String) request.getParameter("username");
		String password = (String) request.getParameter("password");
		PrintWriter out = response.getWriter();
		out.write("测试中文");
		// UserService userService = UserService.getImplement();
		// out.println("用户名为：" + userName);
		// out.println("加密前密码为：" + password);
		// out.println("加密后密码为：" + Encrypter.encrypt(password, userName));
		// out.println("登录结果为：" + userService.login(userName, password));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
