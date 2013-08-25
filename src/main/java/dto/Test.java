package main.java.dto;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: jahoope1
 * Date: 26.08.13
 * Time: 15:06
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Test {

    private int testId;
    private String name;
    private String description;
    private TestResult testResult;
    private TestPlan testPlan;

    public Test() {
    }

    public Test(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PK_TESTPLAN_ID")
    public int getTestId() {
        return testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }

    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "FK_TESTRESULT_ID")
    public TestResult getTestResult() {
        return testResult;
    }

    public void setTestResult(TestResult testResult) {
        this.testResult = testResult;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "FK_TESTPLAN_ID")
    public TestPlan getTestPlan() {
        return testPlan;
    }

    public void setTestPlan(TestPlan testplan) {
        this.testPlan = testplan;
    }
}
