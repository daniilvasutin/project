package main.java.dto;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created with IntelliJ IDEA.
 * User: jahoope1
 * Date: 26.08.13
 * Time: 16:33
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Log {

    private int logId;
    private String name;
    private String deteils;
    private Date beginDate;
    private Date endDate;
    private int countOfAdopted;
    private int countOfRejected;
    private int countOfSkiped;
    private Project project;

    public Log() {
    }

    public Log(String name, String deteils, int countOfAdopted, int countOfRejected, int countOfSkiped) {
        this.name = name;
        this.deteils = deteils;
        this.countOfAdopted = countOfAdopted;
        this.countOfRejected = countOfRejected;
        this.countOfSkiped = countOfSkiped;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PK_LOG_ID")
    public int getLogId() {
        return logId;
    }

    public void setLogId(int logId) {
        this.logId = logId;
    }

    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Column(name = "DETEILS")
    public String getDeteils() {
        return deteils;
    }

    public void setDeteils(String deteils) {
        this.deteils = deteils;
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
    @Column(name = "COUNTOFADOPTED")
    public int getCountOfAdopted() {
        return countOfAdopted;
    }

    public void setCountOfAdopted(int countOfAdopted) {
        this.countOfAdopted = countOfAdopted;
    }

    @Column(name = "COUNTOFREJECTED")
    public int getCountOfRejected() {
        return countOfRejected;
    }

    public void setCountOfRejected(int countOfRejected) {
        this.countOfRejected = countOfRejected;
    }

    @Column(name = "COUNTOFSKIPED")
    public int getCountOfSkiped() {
        return countOfSkiped;
    }

    public void setCountOfSkiped(int countOfSkiped) {
        this.countOfSkiped = countOfSkiped;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "FK_PRJECT_ID")
    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
