package com.example.task.controller;

import com.example.task.model.CountryListModel;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "data-set")
public class CountryListController extends CountryListModel {
    private List<CountryListModel> records;
    @XmlElement(name = "record")
    public List<CountryListModel> getRecords() {
        return records;
    }

    public void setRecords(List<CountryListModel> records) {
        this.records = records;
    }

}
