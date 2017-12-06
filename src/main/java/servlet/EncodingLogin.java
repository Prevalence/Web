package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bl.UserService;
import util.Encrypter;

/**
 * Servlet implementation class EncodingLogin
 */
@WebServlet(initParams = { @WebInitParam(name = "charset", value = "utf-8") }, value = "/EncodingLogin")
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
		request.setCharacterEncoding("UTF-8");
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		String userName = (String) request.getParameter("username");
		String password = (String) request.getParameter("password");
		PrintWriter out = response.getWriter();

		UserService userService = UserService.getImplement();
		out.write("用户名为：" + userName);
		out.write("加密前密码为：" + password);
		out.write("加密后密码为：" + Encrypter.encrypt(password, userName));
		out.write("登录结果为：" + userService.login(userName, Encrypter.encrypt(password, userName)));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
