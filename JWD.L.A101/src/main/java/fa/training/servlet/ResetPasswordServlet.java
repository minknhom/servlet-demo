package fa.training.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fa.training.dao.AccountDao;
import fa.training.dao.AccountDaoImpl;
import fa.training.entities.Account;

@WebServlet("/resetPasswordServlet")
public class ResetPasswordServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private AccountDao accountDao;

	@Override
	public void init() throws ServletException {
		super.init();
		accountDao = new AccountDaoImpl();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String newPassword = request.getParameter("newPassword");

		Account account = accountDao.findByUsername(username);

		if (account != null) {

			account.setPassword(newPassword);
			accountDao.update(account);

			response.sendRedirect("login.jsp");
		} else {
			response.sendRedirect("reset_password.jsp");
		}
	}
}
