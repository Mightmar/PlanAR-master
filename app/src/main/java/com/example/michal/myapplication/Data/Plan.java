package com.example.michal.myapplication.Data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * Created by Mariusz on 2015-05-25.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Plan implements Serializable {


    public Double gpsLat;
    public Double gpsLong;
    public Integer id;
    public Integer ownerID;
    public String title;

}
