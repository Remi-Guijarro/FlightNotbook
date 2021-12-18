package com.flightnotebook.flightnotebookback.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Table(name = "flights")
public class FlightRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@GeneratedValue(generator = "UUID")
    /*@GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(
                            name = "uuid_gen_strategy_class",
                            value = "org.hibernate.id.uuid.CustomVersionOneStrategy"
                    )
            }
    )
    @Column(name = "id", updatable = false, nullable = false)*/
    private Integer id;

    private Date date;

    private String immat;

    private String typeVol;

    private String aeroDep;

    private String aeroArr;

    @JsonFormat(pattern = "HH:mm")
    private LocalTime horaDep;

    @JsonFormat(pattern = "HH:mm")
    private LocalTime horaArr;

    private Integer nbLanding;

    private String comment;

    public Integer getUiud() {
        return id;
    }

    public void setUiud(Integer uiud) {
        this.id = uiud;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getImmat() {
        return immat;
    }

    public void setImmat(String immat) {
        this.immat = immat;
    }

    public String getTypeVol() {
        return typeVol;
    }

    public void setTypeVol(String typeVol) {
        this.typeVol = typeVol;
    }

    public String getAeroDep() {
        return aeroDep;
    }

    public void setAeroDep(String aeroDep) {
        this.aeroDep = aeroDep;
    }

    public String getAeroArr() {
        return aeroArr;
    }

    public void setAeroArr(String aeroArr) {
        this.aeroArr = aeroArr;
    }

    public LocalTime getHoraDep() {
        return horaDep;
    }

    public void setHoraDep(LocalTime horaDep) {
        this.horaDep = horaDep;
    }

    public LocalTime getHoraArr() {
        return horaArr;
    }

    public void setHoraArr(LocalTime horaArr) {
        this.horaArr = horaArr;
    }

    public Integer getNbLanding() {
        return nbLanding;
    }

    public void setNbLanding(Integer nbLanding) {
        this.nbLanding = nbLanding;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
