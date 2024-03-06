package fa.training.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fa.training.dao.EmployeeDao;
import fa.training.dao.EmployeeDaoImpl;
import fa.training.entities.Employee;

@WebServlet("/employeeListServlet")
public class EmployeeListServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EmployeeDao employeeDao = new EmployeeDaoImpl();
    private static final int PAGE_SIZE = 10;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String searchName = request.getParameter("searchName");
        String pageParam = request.getParameter("page");
        int pageNumber = pageParam != null ? Integer.parseInt(pageParam) : 1;

        List<Employee> employees;
        int totalEmployees;

        if (searchName != null && !searchName.isEmpty()) {
            employees = employeeDao.getEmployeesByName(searchName);
            totalEmployees = employees.size();
        } else {
            employees = employeeDao.getEmployeesByPage(pageNumber, PAGE_SIZE);
            totalEmployees = employeeDao.getTotalEmployeeCount();
        }

        int totalPages = (int) Math.ceil((double) totalEmployees / PAGE_SIZE);

        request.setAttribute("employees", employees);
        request.setAttribute("currentPage", pageNumber);
        request.setAttribute("totalPages", totalPages);
        request.setAttribute("searchName", searchName);

        request.getRequestDispatcher("employee_list.jsp").forward(request, response);
    }
}