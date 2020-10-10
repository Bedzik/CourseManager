package pl.project.bednarski.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 +-------------+--------------+------+-----+---------+----------------+
 | Field       | Type         | Null | Key | Default | Extra          |
 +-------------+--------------+------+-----+---------+----------------+
 | id_course   | int(11)      | NO   | PRI | NULL    | auto_increment |
 | description | varchar(255) | YES  |     | NULL    |                |
 | end_date    | datetime     | NO   |     | NULL    |                |
 | max_attende | int(11)      | YES  |     | NULL    |                |
 | start_date  | datetime     | NO   |     | NULL    |                |
 | title       | varchar(255) | NO   |     | NULL    |                |
 +-------------+--------------+------+-----+---------+----------------+
 */
@Entity
@Table(name ="courses")
public class Courses implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id_course")
    private Integer id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private Timestamp start_date;

    @Column(nullable = false)
    private Timestamp end_date;

    private String description;

    private Integer max_attende;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Timestamp getStart_date() {
        return start_date;
    }

    public void setStart_date(Timestamp start_date) {
        this.start_date = start_date;
    }

    public Timestamp getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Timestamp end_date) {
        this.end_date = end_date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getMax_attende() {
        return max_attende;
    }

    public void setMax_attende(Integer max_attende) {
        this.max_attende = max_attende;
    }

}
