package main.java.dto;

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: jahoope1
 * Date: 24.08.13
 * Time: 13:05
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "COMPANY")
public class Company {

    private int companyId;
    private String name;
    private String deteils;
    private Collection<Project> project = new ArrayList<Project>();
    private Collection<Employee> employees = new ArrayList<Employee>();

    public Company() {
    }

    public Company(String name, String deteils) {
        this.name = name;
        this.deteils = deteils;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PK_COMPANY_ID")
    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
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

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "company", fetch = FetchType.LAZY)
    public Collection<Project> getProject() {
        return project;
    }

    public void setProject(Collection<Project> project) {
        this.project = project;
    }

    @ManyToMany(mappedBy = "companies")
    public Collection<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Collection<Employee> employees) {
        this.employees = employees;
    }




}
