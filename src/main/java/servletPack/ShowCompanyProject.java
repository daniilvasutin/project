package main.java.servletPack;

import com.google.gson.Gson;
import main.java.dto.Company;
import main.java.dto.Project;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.hibernate.Hibernate;
import org.hibernate.proxy.HibernateProxy;

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
public class ShowCompanyProject extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer companyProjectId = Integer.parseInt(req.getParameter("companyProjectId"));

        System.out.println("!!!!!!!!!!" + companyProjectId + "hhhheeeeIIIID");

        Company company = findCompany(companyProjectId);
        List<Project> projects = new ArrayList<Project>();
        if(company != null){
            projects = findProjectInCompany(company);
        }

//        for(Project pro : projects){
//            System.out.println("!!!!!" + pro.getName());
//        }

        if(projects.size() != 0){

//            List<String> listOfCompanys = new ArrayList<String>();
//            listOfCompanys.add(projects.get(0).getName());
//            listOfCompanys.add(projects.get(0).getCompany().getName());

//            Project p = null;
//            Project prog =  projects.get(0);
//            Hibernate.initialize(prog);
//            if (prog instanceof HibernateProxy) {
//                p = (Project) ((HibernateProxy) prog).getHibernateLazyInitializer()
//                        .getImplementation();
//                System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!! go");
//            }

//            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjectPersistenceUnit");
//            EntityManager entityManager = entityManagerFactory.createEntityManager();
//            entityManager.getTransaction().begin();
//                List<Users> users = (List<Users>) entityManager.createQuery("from Users").getResultList();
////                Users users = (Users) entityManager.createQuery("from Users").getResultList().get(0);
//            entityManager.getTransaction().commit();
//            entityManager.close();

//            List<Project> unProxProjects = new ArrayList<Project>();
//            for(Project pro : projects){
//                unProxProjects.add(initializeAndUnproxy(pro));
//            }
//            System.out.println("!!!!!" + unProxProjects.get(0).getName() + "after lazy");

//            JsonObject jsonObject = new JsonObject();
//            jsonObject.addProperty("nameOfProject", );


//            JSONObject jsonObject = new JSONObject();
//            jsonObject.put();

            JSONArray jsonArray = new JSONArray();
            for(Project pro : projects){
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("companyName", company.getName());
                jsonObject.put("projectId", pro.getProjectId());
                jsonObject.put("name", pro.getName());
                jsonObject.put("companyProject", pro.getCompany().getName());
                jsonArray.add(jsonObject);
            }

//            System.out.println("!!!!!" + jsonArray1.toString());


//            for(Object jsonArray1 : jsonArray){
//
//                System.out.println("!!!!!" + jsonArray1.toString());
//            }



            String json = new Gson().toJson(jsonArray);

//            String json = new Gson().toJson(unProxProjects);

//            JsonObject jsonObject = new JsonObject();





//            String json = new Gson().toJson(projects);



            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write(json);
        }



//        resp.setContentType("text/html");
//        req.setAttribute("projects", projects);
//        req.getRequestDispatcher("jsp/privateOffice.jsp").forward(req, resp);
    }

    public static <T> T initializeAndUnproxy(T entity) {
        if (entity == null) {
            throw new
                    NullPointerException("Entity passed for initialization is null");
        }

        Hibernate.initialize(entity);
        if (entity instanceof HibernateProxy) {
            entity = (T) ((HibernateProxy) entity).getHibernateLazyInitializer()
                    .getImplementation();
        }
        return entity;
    }

    private Company findCompany(Integer aCompanyProjectId){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjectPersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        Company company = (Company) entityManager.createQuery("from Company c " +
                "where c.companyId = :companyProjectId").setParameter("companyProjectId",aCompanyProjectId).getResultList().get(0);

        entityManager.getTransaction().commit();
        entityManager.close();

        return company;
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

//        for(Project pro : projects){
//            System.out.println("!!!!!" + pro.getName());
//        }

        entityManager.getTransaction().commit();
        entityManager.close();

        return projects;
    }
}

//<table>
//    <c:forEach items="${accounts}" var="account">
//        <tr>
//            <td>${account.id}</td>
//            <td>${account.type}</td>
//            <td>${account.description}</td>
//        </tr>
//</c:forEach>
//</table>