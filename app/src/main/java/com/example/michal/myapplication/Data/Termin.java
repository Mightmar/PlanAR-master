package com.example.michal.myapplication.Data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Mariusz on 2015-05-25.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Termin implements Serializable {

    public Integer id;
    public Integer idWydarzenia;
    public String ownerId;
    public String sala;
    public Date terminRozpoczecia;
    public Date terminZakonczenia;
}
