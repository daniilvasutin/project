package main.java.dto;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: jahoope1
 * Date: 10.08.13
 * Time: 11:52
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "USER_INFO")
public class Users {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;
    private String userName;
    private String fullName;
    private String experience;
    private String profession;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }
}
