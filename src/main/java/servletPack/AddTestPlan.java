package main.java.servletPack;

import com.google.gson.Gson;
import main.java.dto.Project;
import main.java.dto.TestPlan;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: jahoope1
 * Date: 22.09.13
 * Time: 8:14
 * To change this template use File | Settings | File Templates.
 */

public class AddTestPlan extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        String username = (String) req.getSession().getAttribute("sessionUsername");
//        String activeCompanyName = (String) req.getSession().getAttribute("activeCompanyName");

        String testPlanName = req.getParameter("testPlanName");
        String beginTestPlan = req.getParameter("beginTestPlan");
        String endTestPlan = req.getParameter("endTestPlan");
        Integer testPlanProjectId = Integer.parseInt(req.getParameter("testPlanProjectId"));

        System.out.println("!!!!!!!!!!" + testPlanProjectId);

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjectPersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

//        Employee employee = (Employee) entityManager.createQuery("from Employee e " +
//                "WHERE e.name " +
//                "LIKE :username").setParameter("username",username).getResultList().get(0);

        Project project = (Project) entityManager.createQuery("from Project p " +
                "WHERE p.projectId = :testPlanProjectId ").
                setParameter("testPlanProjectId", testPlanProjectId).getResultList().get(0);
                                                        //!!!
        TestPlan testPlan = new TestPlan(testPlanName);
        testPlan.setProject(project);
        testPlan.setBeginDate(Date.valueOf(beginTestPlan));
        testPlan.setEndDate(Date.valueOf(endTestPlan));
        entityManager.persist(testPlan);

//        Long countOfCompany = (Long) entityManager.createQuery("SELECT count(*) " +
//                "FROM Employee e " +
//                "JOIN e.companies c " +
//                "WHERE e.employeeId = :employeeId").setParameter("employeeId", employee.getEmployeeId()).getResultList().get(0);

        Long countOfTestPlan = (Long) entityManager.createQuery("SELECT count(*) " +
                "FROM TestPlan t " +
                "JOIN t.project p " +
                "WHERE p.projectId = :projectId").setParameter("projectId", project.getProjectId()).getResultList().get(0);

        String projectName = (String) entityManager.createQuery("select p.name " +
                "from Project p " +
                "where p.projectId = :projectId").setParameter("projectId", testPlanProjectId).getResultList().get(0);

        entityManager.getTransaction().commit();
        entityManager.close();

        List<String> listOfProjects = new ArrayList<String>();
        listOfProjects.add(countOfTestPlan.toString());
        listOfProjects.add(testPlanName);
        listOfProjects.add(beginTestPlan);
        listOfProjects.add(endTestPlan);
        listOfProjects.add(projectName);

        String json = new Gson().toJson(listOfProjects);

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(json);

    }
}
