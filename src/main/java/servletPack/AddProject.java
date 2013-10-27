package main.java.servletPack;

import com.google.gson.Gson;
import main.java.dto.Company;
import main.java.dto.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: jahoope1
 * Date: 22.09.13
 * Time: 8:14
 * To change this template use File | Settings | File Templates.
 */
public class AddProject extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        String username = (String) req.getSession().getAttribute("sessionUsername");
//        String activeCompanyName = (String) req.getSession().getAttribute("activeCompanyName");

        String projectName = req.getParameter("projectName");
        Integer projectCompanyId = Integer.parseInt(req.getParameter("projectCompanyId"));

        System.out.println("!!!!!!!!!!" + projectCompanyId);

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjectPersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

//        Employee employee = (Employee) entityManager.createQuery("from Employee e " +
//                "WHERE e.name " +
//                "LIKE :username").setParameter("username",username).getResultList().get(0);

        Company company = (Company) entityManager.createQuery("from Company c " +
                "WHERE c.companyId = :projectCompanyId ").
                setParameter("projectCompanyId", projectCompanyId).getResultList().get(0);

        Project project = new Project(projectName);
        project.setCompany(company);
        entityManager.persist(project);

//        Long countOfCompany = (Long) entityManager.createQuery("SELECT count(*) " +
//                "FROM Employee e " +
//                "JOIN e.companies c " +
//                "WHERE e.employeeId = :employeeId").setParameter("employeeId", employee.getEmployeeId()).getResultList().get(0);

        Long countOfCompany = (Long) entityManager.createQuery("SELECT count(*) " +
                "FROM Company c " +
                "JOIN c.project p " +
                "WHERE c.companyId = :companyId").setParameter("companyId", company.getCompanyId()).getResultList().get(0);

        String companyName = (String) entityManager.createQuery("select c.name " +
                "from Company c " +
                "where c.companyId = :companyId").setParameter("companyId", projectCompanyId).getResultList().get(0);

        entityManager.getTransaction().commit();
        entityManager.close();


        List<String> listOfProjects = new ArrayList<String>();
        listOfProjects.add(countOfCompany.toString());
        listOfProjects.add(projectName);
        listOfProjects.add(companyName);

        String json = new Gson().toJson(listOfProjects);

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(json);

    }
}
