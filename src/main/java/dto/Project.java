package main.java.dto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: jahoope1
 * Date: 24.08.13
 * Time: 13:07
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "PROJECT")
public class Project {

    private int projectId;
    private String name;
    private Company company;
    private Collection<TestPlan> testPlans= new ArrayList<TestPlan>();
    private Collection<Log> logs = new ArrayList<Log>();

    public Project() {
    }

    public Project(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PK_PROJECT_ID")
    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "FK_COMPANY_ID")
    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @OneToMany(mappedBy = "project")
    public Collection<TestPlan> getTestPlans() {
        return testPlans;
    }

    public void setTestPlans(Collection<TestPlan> testPlans) {
        this.testPlans = testPlans;
    }

    @OneToMany(mappedBy = "project")
    public Collection<Log> getLogs() {
        return logs;
    }

    public void setLogs(Collection<Log> logs) {
        this.logs = logs;
    }
}
