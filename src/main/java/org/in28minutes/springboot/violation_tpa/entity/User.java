package org.in28minutes.springboot.violation_tpa.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    private Role role;

    private String militaryRank;
    private String comments;
    private String lastname;
    private String firstname;
    private String ip;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLogin;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastPasswordReset;

    public User() {}

    public User(Long id, String username, String password, Role role,
                String militaryRank, String comments, String lastname,
                String firstname, String ip,
                Date lastLogin, Date lastPasswordReset) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.militaryRank = militaryRank;
        this.comments = comments;
        this.lastname = lastname;
        this.firstname = firstname;
        this.ip = ip;
        this.lastLogin = lastLogin;
        this.lastPasswordReset = lastPasswordReset;
    }

    // getters & setters...

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public Role getRole() {
//        return role;
//    }
//
//    public void setRole(Role role) {
//        this.role = role;
//    }
//
//    public String getRank() {
//        return militaryRank;
//    }
//
//    public void setRank(String militaryRank) {
//        this.militaryRank = militaryRank;
//    }
//
//    public String getComments() {
//        return comments;
//    }
//
//    public void setComments(String comments) {
//        this.comments = comments;
//    }
//
//    public String getLastname() {
//        return lastname;
//    }
//
//    public void setLastname(String lastname) {
//        this.lastname = lastname;
//    }
//
//    public String getFirstname() {
//        return firstname;
//    }
//
//    public void setFirstname(String firstname) {
//        this.firstname = firstname;
//    }
//
//    public String getIp() {
//        return ip;
//    }
//
//    public void setIp(String ip) {
//        this.ip = ip;
//    }
//
//    public Date getLastLogin() {
//        return lastLogin;
//    }
//
//    public void setLastLogin(Date lastLogin) {
//        this.lastLogin = lastLogin;
//    }
//
//    public Date getLastPasswordReset() {
//        return lastPasswordReset;
//    }
//
//    public void setLastPasswordReset(Date lastPasswordReset) {
//        this.lastPasswordReset = lastPasswordReset;
//    }
}
