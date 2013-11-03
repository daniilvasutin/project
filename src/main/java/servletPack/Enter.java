package main.java.servletPack;

import main.java.dto.Company;
import main.java.dto.Employee;
import main.java.dto.Project;
import main.java.dto.TestPlan;

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
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: jahoope1
 * Date: 18.09.13
 * Time: 14:16
 * To change this template use File | Settings | File Templates.
 */
@WebServlet("/Enter/*")
public class Enter extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!" + "In MyServletPost" + "!!!!!!!!!!!!!!!!!!!!!!!!!");

        String userName = req.getParameter("nameInHeaderPanel");
        String password = req.getParameter("passwordInHeaderPanel");

        List<Company> companies = findCompanies(userName, password);
        List<Project> projects = new ArrayList<Project>();
        if(companies.size() >= 1){
            projects = findProjectInCompany(companies.get(companies.size()-1));
        }
        List<TestPlan> testPlans = new ArrayList<TestPlan>();
        if(projects.size() >=1){
            testPlans = findTestPlansInProject(projects.get(projects.size()-1));
        }

        HttpSession session = req.getSession();
        session.setAttribute("sessionUsername", userName);

        resp.setContentType("text/html");
        req.setAttribute("companies",companies);
        req.setAttribute("projects", projects);
        req.setAttribute("testPlans", testPlans);
        req.setAttribute("companiesCount", companies.size());
        req.setAttribute("projectsCount", projects.size());
        req.setAttribute("testPlansCount", testPlans.size());
        req.getRequestDispatcher("jsp/privateOffice.jsp").forward(req, resp);
    }

    private List<Company> findCompanies(String aUserName, String aPassword){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjectPersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        Query query = entityManager.createQuery(
                "FROM Employee " +
                "WHERE name LIKE :username " +
                "AND password LIKE :password").setParameter("username", aUserName).setParameter("password", aPassword);
        Employee employee = (Employee) query.getResultList().get(0);

        query = entityManager.createQuery("SELECT c " +
                "FROM Employee e " +
                "JOIN e.companies c " +
                "WHERE e.employeeId = :employeeId").setParameter("employeeId", employee.getEmployeeId());
        List<Company> companyList = query.getResultList();

        entityManager.getTransaction().commit();
        entityManager.close();

        return companyList;
    }

    private List<Project> findProjectInCompany(Company aCompany){

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjectPersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        System.out.println("!!!!!" + aCompany.getCompanyId());


        Query query = entityManager.createQuery("SELECT p " +
                "FROM Company c " +
                "JOIN c.project p " +
                "WHERE c.companyId = :companyId").setParameter("companyId", aCompany.getCompanyId());
        List<Project> projects = query.getResultList();

        entityManager.getTransaction().commit();
        entityManager.close();

        return projects;
    }

    private List<TestPlan> findTestPlansInProject(Project aProject){

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjectPersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        System.out.println("!!!!!" + aProject.getProjectId());

        Query query = entityManager.createQuery("SELECT t " +
                "FROM Project p " +
                "JOIN p.testPlans t " +
                "WHERE p.projectId = :projectId").setParameter("projectId", aProject.getProjectId());
        List<TestPlan> testPlans = query.getResultList();

        entityManager.getTransaction().commit();
        entityManager.close();

        for(TestPlan plan : testPlans){
            System.out.println("!!!!!" + plan.getName() + " :: " + plan.getBeginDate() + " :: " + plan.getEndDate());
        }

        return testPlans;
    }

}