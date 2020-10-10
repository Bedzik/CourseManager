package pl.project.bednarski.model;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;


/**
 +------------------+----------+------+-----+-------------------+-------------------+
 | Field            | Type     | Null | Key | Default           | Extra             |
 +------------------+----------+------+-----+-------------------+-------------------+
 | id_subscribtions | int(11)  | NO   | PRI | NULL              | auto_increment    |
 | regstamp         | datetime | YES  |     | CURRENT_TIMESTAMP | DEFAULT_GENERATED |
 | subs_idcour      | int(11)  | NO   | MUL | NULL              |                   |
 | subs_idprof      | int(11)  | YES  | MUL | NULL              |                   |
 +------------------+----------+------+-----+-------------------+-------------------+
 CREATE UNIQUE INDEX uniq_subs ON subscribtions (subs_idprof, subs_idcour);
 Powyższe utowrzenie unikatowego indeksu ma był zastąpione przez adnotacje w klasie encyjnej
 */

@Entity
@Table(name = "subscribtions")
public class Subscribtions implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = " id_subscribtions")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "subs_idprof", referencedColumnName = "id_profile")
    private Profiles idprof;

    @ManyToOne
    @JoinColumn(name = "subs_idcour", referencedColumnName = "id_course")
    private Courses idcour;

    @CreationTimestamp
    @ColumnDefault("CURRENT_TIMESTAMP")
    private Timestamp regstamp;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Profiles getIdprof() {
        return idprof;
    }

    public void setIdprof(Profiles idprof) {
        this.idprof = idprof;
    }

    public Courses getIdcour() {
        return idcour;
    }

    public void setIdcour(Courses idcour) {
        this.idcour = idcour;
    }

    public Timestamp getRegstamp() {
        return regstamp;
    }

    public void setRegstamp(Timestamp regstamp) {
        this.regstamp = regstamp;
    }
}
