package main.java.dto;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: jahoope1
 * Date: 26.08.13
 * Time: 11:59
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Role {

    private int roleId;
    private String name;

    public Role() {
    }

    public Role(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PK_ROLE_ID")
    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
