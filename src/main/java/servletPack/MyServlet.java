package main.java.servletPack;

import com.google.gson.Gson;
import main.java.dto.Email;
import main.java.dto.Employee;
import main.java.dto.Role;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

@WebServlet("/MyServlet/*")
public class MyServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!" + "In AddCompanyServlet" + "!!!!!!!!!!!!!!!!!!!!!!!!!");


//        String userName = req.getParameter("registFormUserName");
//        String password = req.getParameter("registFormPassword");
////        String email = req.getParameter("email");
////        String role = req.getParameter("role");
////        String enterAfeterRegist = req.getParameter("enter");
//
////        Employee employee = new Employee();
////        employee.setName(userName);
////        employee.setPassword(password);
////
////        Role roleObj = new Role();
////        roleObj.setName(role);
////        roleObj.setEmployee(employee);
////
////        Email emailObj = new Email();
////        emailObj.setEmail(email);
////        emailObj.setEmployee(employee);
////
////        saveToDb(emailObj, roleObj);
//
//        System.out.println(userName);
//        System.out.println(password);
//
//
//        resp.setContentType("text/html");
//        req.getRequestDispatcher("jsp/hello.jsp").forward(req, resp);

//        if (enterAfeterRegist.equals("true")){
//            System.out.println("enter");
//
//
//        }

//        req.getRequestDispatcher("jsp/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.setContentType("text/html");
//        req.getRequestDispatcher("jsp/hello.jsp").forward(req, resp);

        String userName = req.getParameter("registFormUserName");
        String password = req.getParameter("registFormPassword");
        String email = req.getParameter("registFormEmail");
        String role = req.getParameter("registFormRole");
        String enter = req.getParameter("enterAfterRegist");

        Employee employee = new Employee();
        employee.setName(userName);
        employee.setPassword(password);

        Role roleObj = new Role();
        roleObj.setName(role);
        roleObj.setEmployee(employee);

        Email emailObj = new Email();
        emailObj.setEmail(email);
        emailObj.setEmployee(employee);

        saveToDb(emailObj, roleObj);

        resp.setContentType("text/html");

        HttpSession session = req.getSession();
        session.setAttribute("sessionUsername", userName);

        resp.sendRedirect("jsp/privateOffice.jsp");
//        req.getRequestDispatcher("jsp/hello.jsp").forward(req, resp);

    }

    private void write(HttpServletResponse resp, Map<String, Object> map) throws IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(new Gson().toJson(map));
    }

    private void saveToDb(Email aEmailObj, Role aRoleObj){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjectPersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(aEmailObj);
        entityManager.persist(aRoleObj);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    private void showAllEmployees(HttpServletResponse resp) throws IOException{

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjectPersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("SELECT employee.name, employee.password, email.email, role.name " +
                "FROM Employee employee " +
                "INNER JOIN employee.emails email " +
                "INNER JOIN employee.role role");
        List<Object[]> list = query.getResultList();

        PrintWriter out = resp.getWriter();
        out.println("<h3>User info</h3>");
        for (Object[] result : list){
            String name = (String) result[0];
            String password = (String) result[1];
            String email = (String) result[2];
            String role = (String) result[3];
            out.println("User name : " + name + "<br>");
            out.println("Password : " + password + "<br>");
            out.println("Email : " + email + "<br>");
            out.println("Role : " + role + "<br>");
        }
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    private List<Object[]> getListOfEmployeesFromDb(){

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjectPersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        Query query = entityManager.createQuery("SELECT employee.name, employee.password, email.email, role.name " +
                "FROM Employee employee " +
                "INNER JOIN employee.emails email " +
                "INNER JOIN employee.role role");
        List<Object[]> listOfEmployees = query.getResultList();

        entityManager.getTransaction().commit();
        entityManager.close();

        return listOfEmployees;

    }

//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//        String userName = req.getParameter("userName");
//
//        Map<String, Object> map = new HashMap<String, Object>();
//        boolean isValid = false;
//        resp.getWriter().println(userName);
//        if(userName != null && userName.trim().length() != 0){
//            isValid= true;
//            map.put("userName",userName);
//        }
//        map.put("isValid", isValid);
//        write(resp, map);
//    }

//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//        resp.setContentType("text/html");
//        String userName = req.getParameter("userName");
//        String password = req.getParameter("password");
//        String email = req.getParameter("email");
//        String role = req.getParameter("role");
//
//        Employee employee = new Employee();
//        employee.setName(userName);
//        employee.setPassword(password);
//
//        Role roleObj = new Role();
//        roleObj.setName(role);
//        roleObj.setEmployee(employee);
//
//        Email emailObj = new Email();
//        emailObj.setEmail(email);
//        emailObj.setEmployee(employee);
//
//        saveToDb(emailObj, roleObj);
//
//        req.setAttribute("listOfEmployees", getListOfEmployeesFromDb());//!!!
//        req.getRequestDispatcher("jsp/employeesInfo.jsp").forward(req, resp);
//    }
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//        String username = req.getParameter("user");
//        String password = req.getParameter("password");
//        String email = req.getParameter("email");
//        String role = req.getParameter("role");
//
//        List<String> list = new ArrayList<String>();
//
//        list.add(username);
//        list.add(password);
//        list.add(email);
//        list.add(role);
//
//        String json = new Gson().toJson(list);
//
//        resp.setContentType("application/json");
//        resp.setCharacterEncoding("UTF-8");
//        resp.getWriter().write(json);
//
    //        resp.getWriter().write(username);
    //        resp.getWriter().write(password);
    //        resp.getWriter().write(email);
    //        resp.getWriter().write(role);
//    }
}
