package com.example.michal.myapplication.Data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * Created by Mariusz on 2015-05-25.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class KomentarzProwadzacy implements Serializable {

    public Integer id;
    public Integer idProwadzacego;
    public Integer ocena;
    public Integer ownerId;
    public String tresc;
}
