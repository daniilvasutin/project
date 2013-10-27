package main.java.dto;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: jahoope1
 * Date: 26.08.13
 * Time: 15:31
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class TestResult {

    private int testResultId;
    private String name;

    public TestResult() {
    }

    public TestResult(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PK_TESTRESULT_ID")
    public int getTestResultId() {
        return testResultId;
    }

    public void setTestResultId(int testResultId) {
        this.testResultId = testResultId;
    }

    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
