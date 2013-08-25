package main.java.dto;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: jahoope1
 * Date: 26.08.13
 * Time: 15:02
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class TestPlan {

    private int testPlanId;
    private String name;
    private Date beginDate;
    private Date endDate;
    private Project project;
    private Collection<Test> tests = new ArrayList<Test>();

    public TestPlan() {
    }

    public TestPlan(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PK_TESTPLAN_ID")
    public int getTestPlanId() {
        return testPlanId;
    }

    public void setTestPlanId(int testPlanId) {
        this.testPlanId = testPlanId;
    }

    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "BEGINDATE")
    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    @Column(name = "ENDDATE")
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "FK_PROJECT_ID")
    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    @OneToMany(mappedBy = "testPlan")
    public Collection<Test> getTests() {
        return tests;
    }

    public void setTests(Collection<Test> tests) {
        this.tests = tests;
    }
}
