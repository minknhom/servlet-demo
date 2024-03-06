package fa.training.servlet;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fa.training.dao.EmployeeDao;
import fa.training.dao.EmployeeDaoImpl;
import fa.training.entities.Account;
import fa.training.entities.Employee;

@WebServlet("/addEmployeeServlet")
public class AddEmployeeServlet extends HttpServlet{

	private EmployeeDao employeeDao = new EmployeeDaoImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("add_employee.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String phoneNumber = request.getParameter("phoneNumber");
            LocalDate dateOfBirth = LocalDate.parse(request.getParameter("dateOfBirth"));
            String gender = request.getParameter("gender");
            String username = request.getParameter("username");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String address = request.getParameter("address");
            String department = request.getParameter("department");
            String remark = request.getParameter("remark");

            Account account = new Account();
            account.setUsername(username);
            account.setEmail(email);
            account.setPassword(password);
            account.setStatus(true);

            Employee employee = new Employee();
            employee.setFirstName(firstName);
            employee.setLastName(lastName);
            employee.setPhone(phoneNumber);
            employee.setDateOfBirth(dateOfBirth);
            employee.setGender(1);
            employee.setAccount(account);
            employee.setAddress(address);
            employee.setDepartmentName(department);
            employee.setRemark(remark);

            employeeDao.save(employee);

            response.sendRedirect("listEmployees"); 
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "An error occurred while adding the employee.");
            request.getRequestDispatcher("add_employee.jsp").forward(request, response);
        }
    }
}
