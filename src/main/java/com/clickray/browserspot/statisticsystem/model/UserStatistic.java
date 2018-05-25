package com.clickray.browserspot.statisticsystem.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class UserStatistic {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    private String userId;

    private int numberOfDataProxyOperations;

    private int numberOfFailedDataProxyOperation;

    private int numberOfOperations;

    private int numberOfScreenShotTests;

    private int numberOfAutomatTests;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval=true)
    @JoinColumn(name="id_failedoperation")
    Set<FailedOperation> failedOperationList;

    public Set<FailedOperation> getFailedOperationList() {
        return failedOperationList;
    }

    public void setFailedOperationList(Set<FailedOperation> failedOperationList) {
        this.failedOperationList = failedOperationList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumberOfFailedDataProxyOperation() {
        return numberOfFailedDataProxyOperation;
    }

    public void setNumberOfFailedDataProxyOperation(int numberOfFailedDataProxyOperation) {
        this.numberOfFailedDataProxyOperation = numberOfFailedDataProxyOperation;
    }

    public int getNumberOfOperations() {

        return numberOfOperations;
    }

    public void setNumberOfOperations(int numberOfOperations) {
        this.numberOfOperations = numberOfOperations;
    }

    public int getNumberOfDataProxyOperations() {
        return numberOfDataProxyOperations;
    }

    public void setNumberOfDataProxyOperations(int numberOfDataProxyOperations) {
        this.numberOfDataProxyOperations = numberOfDataProxyOperations;
    }

    public int getNumberOfScreenShotTests() {
        return numberOfScreenShotTests;
    }

    public void setNumberOfScreenShotTests(int numberOfScreenShotTests) {
        this.numberOfScreenShotTests = numberOfScreenShotTests;
    }

    public int getNumberOfAutomatTests() {
        return numberOfAutomatTests;
    }

    public void setNumberOfAutomatTests(int numberOfAutomatTests) {
        this.numberOfAutomatTests = numberOfAutomatTests;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
