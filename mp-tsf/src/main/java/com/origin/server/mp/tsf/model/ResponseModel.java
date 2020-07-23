package com.origin.server.mp.tsf.model;

public class ResponseModel {

    String v0;
    String v1;
    String v2;

    public ResponseModel() {
    }

    public ResponseModel(String v0, String v1, String v2) {
        this.v0 = v0;
        this.v1 = v1;
        this.v2 = v2;
    }

    @Override
    public String toString() {
        return "ResponseModel{" +
                "v0='" + v0 + '\'' +
                ", v1='" + v1 + '\'' +
                ", v2='" + v2 + '\'' +
                '}';
    }

    public String getV0() {
        return v0;
    }

    public void setV0(String v0) {
        this.v0 = v0;
    }

    public String getV1() {
        return v1;
    }

    public void setV1(String v1) {
        this.v1 = v1;
    }

    public String getV2() {
        return v2;
    }

    public void setV2(String v2) {
        this.v2 = v2;
    }
}
