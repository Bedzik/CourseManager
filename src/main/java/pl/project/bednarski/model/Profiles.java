package pl.project.bednarski.model;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;


/**
 +------------+--------------+------+-----+-------------------+-------------------+
 | Field      | Type         | Null | Key | Default           | Extra             |
 +------------+--------------+------+-----+-------------------+-------------------+
 | id_profile | int(11)      | NO   | PRI | NULL              | auto_increment    |
 | email      | varchar(255) | NO   |     | NULL              |                   |
 | ip         | varchar(255) | YES  |     | NULL              |                   |
 | login      | varchar(255) | NO   |     | NULL              |                   |
 | name       | varchar(255) | NO   |     | NULL              |                   |
 | password   | varchar(255) | NO   |     | NULL              |                   |
 | regstamp   | datetime     | YES  |     | CURRENT_TIMESTAMP | DEFAULT_GENERATED |
 | role       | varchar(255) | NO   |     | user              |                   |
 | surname    | varchar(255) | NO   |     | NULL              |                   |
 +------------+--------------+------+-----+-------------------+-------------------+
 */
@Entity
@Table(name = "profiles")
public class Profiles implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_profile")
    private long id;

    @Column(unique = true, nullable = false)
    private String login;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @Column(nullable = false)
    private String password;

    private String ip;

    @CreationTimestamp
    @ColumnDefault("CURRENT_TIMESTAMP")
    private Timestamp regstamp;

    @Enumerated(EnumType.STRING)
    private Role role;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Timestamp getRegstamp() {
        return regstamp;
    }

    public void setRegstamp(Timestamp regstamp) {
        this.regstamp = regstamp;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
    @Override
    public String toString() {
        return "Profiles{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", password='" + password + '\'' +
                ", ip='" + ip + '\'' +
                ", regstamp=" + regstamp +
                ", role=" + role +
                '}';
    }
}
