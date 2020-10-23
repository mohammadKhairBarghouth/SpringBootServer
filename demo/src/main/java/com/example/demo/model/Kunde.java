package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity(name = "kunde")
public class Kunde {


    @Column(name = "kundeid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer kundeid;
    private String vorname;
    private String nachname;
    private Integer adresseid;
    private Integer messlokationid;

    private static int idlevel = 0;

    public static int getIdLevel(){
        idlevel++;
        return idlevel;
    }

    public Integer getAdresseid() {
        return adresseid;
    }

    public String getNachname() {
        return nachname;
    }

    public String getVorname() {
        return vorname;
    }

    public Integer getKundeid() {
        return kundeid;
    }

    public Integer getMesslokationid() {
        return messlokationid;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public void setMesslokationid(Integer messlokationid) {
        this.messlokationid = messlokationid;
    }

    public void setKundeid(Integer kundeid) {
        this.kundeid = kundeid;
    }

    public static void setIdlevel(int idlevel) {
        Kunde.idlevel = idlevel;
    }

    public void setAdresseid(Integer adresseid) {
        this.adresseid = adresseid;
    }

    public Kunde(Integer adressei, Integer messlokationid, String vorname, String nachanme) {
        this.adresseid = adresseid;
        this.messlokationid = messlokationid;
        this.vorname = vorname;
        this.nachname = nachanme;
    }

    public Kunde(@JsonProperty("kundeid") Integer kundeid ,
                 @JsonProperty("adresseid") Integer adresseid,
                 @JsonProperty("messlokationid") Integer messlokationid,
                 @JsonProperty("vorname") String vorname,
                 @JsonProperty("nachname") String nachanme) {
        this.adresseid = adresseid;
        this.messlokationid = messlokationid;
        this.vorname = vorname;
        this.nachname = nachanme;
        this.kundeid = kundeid;
    }

    public Kunde(){}
}
