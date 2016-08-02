package com.hly.videosys2.entity;



/**
 * Banuserlist entity. @author MyEclipse Persistence Tools
 */

public class Banuserlist  implements java.io.Serializable {


    // Fields    

     private Integer banListNum;
     private String banTarget;
     private String banByUser;
     private Integer startTime;
     private Integer endTime;
     private Integer banLevel;


    // Constructors

    /** default constructor */
    public Banuserlist() {
    }

    
    /** full constructor */
    public Banuserlist(String banTarget, String banByUser, Integer startTime, Integer endTime, Integer banLevel) {
        this.banTarget = banTarget;
        this.banByUser = banByUser;
        this.startTime = startTime;
        this.endTime = endTime;
        this.banLevel = banLevel;
    }

   
    // Property accessors

    public Integer getBanListNum() {
        return this.banListNum;
    }
    
    public void setBanListNum(Integer banListNum) {
        this.banListNum = banListNum;
    }

    public String getBanTarget() {
        return this.banTarget;
    }
    
    public void setBanTarget(String banTarget) {
        this.banTarget = banTarget;
    }

    public String getBanByUser() {
        return this.banByUser;
    }
    
    public void setBanByUser(String banByUser) {
        this.banByUser = banByUser;
    }

    public Integer getStartTime() {
        return this.startTime;
    }
    
    public void setStartTime(Integer startTime) {
        this.startTime = startTime;
    }

    public Integer getEndTime() {
        return this.endTime;
    }
    
    public void setEndTime(Integer endTime) {
        this.endTime = endTime;
    }

    public Integer getBanLevel() {
        return this.banLevel;
    }
    
    public void setBanLevel(Integer banLevel) {
        this.banLevel = banLevel;
    }
   








}