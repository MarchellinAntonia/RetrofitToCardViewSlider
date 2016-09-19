package com.nkdroid.recyclerview;

import java.util.List;


public class Bank {
    //Variables that are in our json
    private String kode;
    private String status;
    private List<DataBank> dataBank;

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<DataBank> getDataBank() {
        return dataBank;
    }

    public void setDataBank(List<DataBank> dataBank) {
        this.dataBank = dataBank;
    }
}
