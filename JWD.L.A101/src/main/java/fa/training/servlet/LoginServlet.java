package fa.training.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fa.training.dao.AccountDao;
import fa.training.dao.AccountDaoImpl;
import fa.training.entities.Account;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private AccountDao accountDao;

    @Override
    public void init() throws ServletException {
        super.init();
        accountDao = new AccountDaoImpl();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Account account = accountDao.findByUsername(username);
        
        if (account != null && account.getPassword().equals(password)) {
            request.getSession().setAttribute("username", username);
            response.sendRedirect("employee_list.jsp");
        } else {
            response.sendRedirect("login.jsp");
        }
    }
}