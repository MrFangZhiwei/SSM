package com.keyone.pojo;

public class Cellrecord {
    private String id;

    private String toid;

    private Long cellnum;

    private String cellstatus;

    private String osresult;

    private String endtime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getToid() {
        return toid;
    }

    public void setToid(String toid) {
        this.toid = toid == null ? null : toid.trim();
    }

    public Long getCellnum() {
        return cellnum;
    }

    public void setCellnum(Long cellnum) {
        this.cellnum = cellnum;
    }

    public String getCellstatus() {
        return cellstatus;
    }

    public void setCellstatus(String cellstatus) {
        this.cellstatus = cellstatus == null ? null : cellstatus.trim();
    }

    public String getOsresult() {
        return osresult;
    }

    public void setOsresult(String osresult) {
        this.osresult = osresult == null ? null : osresult.trim();
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime == null ? null : endtime.trim();
    }
}