package main.java.servletPack;
 
import main.java.dto.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Main {
 
    public static void main(String[] args) {

        Role role1 = new Role("Owner");
        Role role2 = new Role("Admin");
        Role role3 = new Role("Leader");
        Role role4 = new Role("Tester");

        Email email1 = new Email("tom123@mail.ru");
        Email email2 = new Email("tom123@gmail.com");
        Email email3 = new Email("tom123@bk.ru");
        Email email4 = new Email("edd123@mail.ru");
        Email email5 = new Email("edd123@gmail.com");

        Employee employee1 = new Employee("Tom","Tom123");
        Employee employee2 = new Employee("Edd","Edd123");

        email1.setEmployee(employee1);
        email2.setEmployee(employee1);
        email3.setEmployee(employee1);
        email4.setEmployee(employee2);
        email5.setEmployee(employee2);

        employee1.setRole(role1);
        employee2.setRole(role1);

        Company company1 = new Company("First company","It's first company");
        Company company2 = new Company("Second company","It's second company");

        employee1.getCompanies().add(company1);
        employee2.getCompanies().add(company1);
        employee1.getCompanies().add(company2);

        Project project1 = new Project("First project 1-st company");
        Project project2 = new Project("Second project 1-st company");
        Project project3 = new Project("First project 2-nd company");

        project1.setCompany(company1);
        project2.setCompany(company1);
        project3.setCompany(company2);

        TestPlan testPlan1 = new TestPlan("First test plan 1-st project");
        TestPlan testPlan2 = new TestPlan("Second test plan 1-st project");
        TestPlan testPlan3 = new TestPlan("First test plan 2-nd project");
        TestPlan testPlan4 = new TestPlan("First test plan 3-ed project");

        testPlan1.setProject(project1);
        testPlan2.setProject(project1);
        testPlan3.setProject(project2);
        testPlan4.setProject(project3);

        Test  test1 = new Test("First test 1-st test plan","It's first test");
        Test  test2 = new Test("Second test 1-st test plan","It's second test");
        Test  test3 = new Test("First test 2-nd test plan","It's first test");
        Test  test4 = new Test("First test 3-ed test plan","It's first test");
        Test  test5 = new Test("First test 4-ed test plan","It's first test");

        test1.setTestPlan(testPlan1);
        test2.setTestPlan(testPlan1);
        test3.setTestPlan(testPlan2);
        test4.setTestPlan(testPlan3);
        test5.setTestPlan(testPlan4);

        TestResult testResult1 = new TestResult("Adopted");
        TestResult testResult2 = new TestResult("Rejected");
        TestResult testResult3 = new TestResult("Skiped");

        test1.setTestResult(testResult1);
        test2.setTestResult(testResult2);
        test3.setTestResult(testResult3);
        test4.setTestResult(testResult1);
        test5.setTestResult(testResult2);

        Log log1 = new Log("1 log", "It's 1 log", 2, 1, 1);
        Log log2 = new Log("2 log", "It's 2 log", 2, 2, 3);
        Log log3 = new Log("3 log", "It's 3 log", 1, 3, 2);
        Log log4 = new Log("4 log", "It's 4 log", 2, 1, 1);
        Log log5 = new Log("5 log", "It's 5 log", 0, 0, 3);

        log1.setProject(project1);
        log2.setProject(project1);
        log3.setProject(project1);
        log4.setProject(project2);
        log5.setProject(project3);


        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjectPersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

            entityManager.persist(test1);
            entityManager.persist(test2);
            entityManager.persist(test3);
            entityManager.persist(test4);
            entityManager.persist(test5);

            entityManager.persist(email1);
            entityManager.persist(email2);
            entityManager.persist(email3);
            entityManager.persist(email4);
            entityManager.persist(email5);

            entityManager.persist(log1);
            entityManager.persist(log2);
            entityManager.persist(log3);
            entityManager.persist(log4);
            entityManager.persist(log5);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}