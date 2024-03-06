package demo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@WebServlet("/redirectDemo")
public class RedirectDemoServlet extends HttpServlet {
 
    private static final long serialVersionUID = 1L;
 
    // Request:
    // http://localhost:8081/ServletDemo/redirectDemo?redirect=true
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        // Lấy ra giá trị của tham số (parameter) trên URL.
        String redirect = request.getParameter("redirect");
 
        if ("true".equals(redirect)) {
            System.out.println("Redirect to exampleInfo");
 
            // contextPath: Là một String rỗng "" hoặc khác rỗng.
            // Nếu khác rỗng, nó luôn bắt đầu bởi /
            // và không kết thúc bởi /
            String contextPath = request.getContextPath();
 
            // ==> /ServletTutorial/showMe
            response.sendRedirect(contextPath + "/exampleInfo");
            return;
        }
 
        ServletOutputStream out = response.getOutputStream();
        out.println("<h3>Text of RedirectDemoServlet</h3>");
        out.println("- servletPath=" + request.getServletPath());
    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
    }
 
}
