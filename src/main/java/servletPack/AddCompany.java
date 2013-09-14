package main.java.servletPack;

import com.google.gson.Gson;
import main.java.dto.Company;
import main.java.dto.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: jahoope1
 * Date: 11.09.13
 * Time: 18:53
 * To change this template use File | Settings | File Templates.
 */
@WebServlet("/AddCompany/*")
public class AddCompany extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!" + "In AddCompanyServlet" + "!!!!!!!!!!!!!!!!!!!!!!!!!");

//        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!" + "In AddCompanyServlet" + "!!!!!!!!!!!!!!!!!!!!!!!!!");
//
//        String username = (String) req.getSession().getAttribute("sessionUsername");
//        String companyName = req.getParameter("registFormCompanyName");
//        String companyDetails = req.getParameter("registFormCompanyDetails");
//
//        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!" + username + companyName + companyDetails + "!!!!!!!!!!!!!!!!!!!!!!!!!");
//
//
//        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjectPersistenceUnit");
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//
//        entityManager.getTransaction().begin();
//
//        Employee employee = (Employee) entityManager.createQuery("from Employee e " +
//                "WHERE e.name " +
//                "LIKE :username").setParameter("username",username).getResultList().get(0);
//
//        Company company = new Company(companyName, companyDetails);
//        employee.getCompanies().add(company);
//
//        Query query = entityManager.createQuery("SELECT c.name, c.deteils " +
//                "from Employee e " +
//                "INNER JOIN e.companies c");
//        List<Object[]> list = query.getResultList();
//
//        List<String> listOfCompanys = new ArrayList<String>();
//        for (Object[] result : list){
//            companyName = (String) result[0];
//            companyDetails = (String) result[1];
//
//            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!" + companyName + " :: " + companyDetails + "!!!!!!!!!!!!!!!!!!!!!!!!!");
//
//            listOfCompanys.add(companyName);
//            listOfCompanys.add(companyDetails);
//        }
//
//        for (String str : listOfCompanys){
//            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!" + str + "!!!!!!!!!!!!!!!!!!!!!!!!!");
//        }
//
//        entityManager.getTransaction().commit();
//        entityManager.close();
//
//        String json = new Gson().toJson(listOfCompanys);
//
//        resp.setContentType("application/json");
//        resp.setCharacterEncoding("UTF-8");
//        resp.getWriter().write(json);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!" + "In AddCompanyServlet" + "!!!!!!!!!!!!!!!!!!!!!!!!!");

        String username = (String) req.getSession().getAttribute("sessionUsername");
        String companyName = req.getParameter("registFormCompanyName");
        String companyDetails = req.getParameter("registFormCompanyDetails");

        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!" + username + companyName + companyDetails + "!!!!!!!!!!!!!!!!!!!!!!!!!");


        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjectPersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        Employee employee = (Employee) entityManager.createQuery("from Employee e " +
                "WHERE e.name " +
                "LIKE :username").setParameter("username",username).getResultList().get(0);

        Company company = new Company(companyName, companyDetails);
        employee.getCompanies().add(company);

        Query query = entityManager.createQuery("SELECT c.name, c.deteils " +
                "from Employee e " +
                "INNER JOIN e.companies c");
        List<Object[]> list = query.getResultList();

        List<String> listOfCompanys = new ArrayList<String>();
        for (Object[] result : list){
            companyName = (String) result[0];
            companyDetails = (String) result[1];

            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!" + companyName + " :: " + companyDetails + "!!!!!!!!!!!!!!!!!!!!!!!!!");

            listOfCompanys.add(companyName);
            listOfCompanys.add(companyDetails);
        }

        for (String str : listOfCompanys){
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!" + str + "!!!!!!!!!!!!!!!!!!!!!!!!!");
        }

        entityManager.getTransaction().commit();
        entityManager.close();

        String json = new Gson().toJson(listOfCompanys);

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(json);

        //        Integer companyId = (Integer) entityManager.createQuery("SELECT c.id " +
//                "FROM Company c " +
//                "WHERE c.name " +
//                "LIKE :companyName").setParameter("companyName", companyName).getResultList().get(0);

//        System.out.println("!!!!!!!!!!!!!!!!!!!" + userId + "!!!!!!!!!!!!!!!!!!!!!");
//        System.out.println("!!!!!!!!!!!!!!!!!!!" + companyId + "!!!!!!!!!!!!!!!!!!!!!");


//        Integer userId = null;
//
//        if (temp.size() > 0){
//            userId = (Integer) temp.get(0);
//            System.out.println("!!!!!!!!!!!!!!!!!!!" + userId + "!!!!!!!!!!!!!!!!!!!!!");
//        } else {
//            System.out.println("!!!!!!!!!!!!!!!!!!!" + "EMPTY" + "!!!!!!!!!!!!!!!!!!!!!");
//        }

//        List temp = entityManager.createQuery("SELECT e.id " +
//                "FROM Employee e " +
//                "WHERE e.name " +
//                "LIKE :username").setParameter("username",username).getResultList();
//        Integer userId = null;
    }
}
