package main.java.servletPack;

import com.google.gson.Gson;
import main.java.dto.Project;
import main.java.dto.TestPlan;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
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
 * Date: 23.09.13
 * Time: 16:03
 * To change this template use File | Settings | File Templates.
 */
public class ShowProjectTestPlan extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer projectId = Integer.parseInt(req.getParameter("projectId"));

        System.out.println("!!!!!!!!!!" + projectId + "hhhheeeeIIIID");

        Project project = findProject(projectId);
        List<TestPlan> testPlans = new ArrayList<TestPlan>();
        if(project != null){
            testPlans = findTestPlansInProject(project);
        }

        if(testPlans.size() != 0){

            System.out.println("!!!!!!!!!!projectName" + project.getName());

            JSONArray jsonArray = new JSONArray();
            for(TestPlan testPlan : testPlans){
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("projectName", project.getName());
                jsonObject.put("testPlanId", testPlan.getTestPlanId());
                jsonObject.put("testPlanName", testPlan.getName());
                jsonObject.put("testPlanBeginData", testPlan.getBeginDate().toString());
                jsonObject.put("testPlanEndData", testPlan.getEndDate().toString());
                jsonObject.put("projectTestPlan", testPlan.getProject().getName());
                jsonArray.add(jsonObject);
            }

            String json = new Gson().toJson(jsonArray);

            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write(json);
        }
    }

    private Project findProject(Integer aProjectId){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjectPersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        Project project = (Project) entityManager.createQuery("from Project p " +
                "where p.projectId = :projectId").setParameter("projectId",aProjectId).getResultList().get(0);

        entityManager.getTransaction().commit();
        entityManager.close();

        return project;
    }

    private List<TestPlan> findTestPlansInProject(Project aProject){

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjectPersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        System.out.println("!!!!!" + aProject.getProjectId());

        Query query = entityManager.createQuery("SELECT t " +
                "FROM TestPlan t " +
                "JOIN t.project p " +
                "WHERE p.projectId = :projectId").setParameter("projectId", aProject.getProjectId());
        List<TestPlan> testPlans = query.getResultList();

        entityManager.getTransaction().commit();
        entityManager.close();

        for(TestPlan pro : testPlans){
            System.out.println("!!!!!testPlan" + pro.getName());
        }

        return testPlans;
    }
}