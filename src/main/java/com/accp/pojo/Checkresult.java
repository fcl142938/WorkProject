package com.accp.pojo;

public class Checkresult {
    private Integer resultid;

    private String resultname;

    public Integer getResultid() {
        return resultid;
    }

    public void setResultid(Integer resultid) {
        this.resultid = resultid;
    }

    public String getResultname() {
        return resultname;
    }

    public void setResultname(String resultname) {
        this.resultname = resultname == null ? null : resultname.trim();
    }
}