package com.plnb.clan.model;

import java.util.List;

public class DiamondAllTime {


    private Long Sum;       
    private List<DiamondContribution> Data;

    public Long getSum() {
        return Sum;
    }

    public void setSum(Long sum) {
        Sum = sum;
    }

    public List<DiamondContribution> getData() {
        return Data;
    }

    public void setData(List<DiamondContribution> data) {
        Data = data;
    }
}