package com.clickray.browserspot.statisticsystem.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FailedOperation {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    private int dataProxyOperationId;

    private String name;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDataProxyOperationId() {
        return dataProxyOperationId;
    }

    public void setDataProxyOperationId(int dataProxyOperationId) {
        this.dataProxyOperationId = dataProxyOperationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
