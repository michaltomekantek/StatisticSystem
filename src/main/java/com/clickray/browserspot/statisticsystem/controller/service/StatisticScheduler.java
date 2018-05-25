package com.clickray.browserspot.statisticsystem.controller.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class StatisticScheduler {

    @Autowired
    DataProxyOperationStatisticController dataProxyOperationStatisticController;

    @Autowired
    ManageTestStatisticController manageTestStatisticController;

    public void doReport(String startDate, String endDate){
        int numberOfOperations = dataProxyOperationStatisticController.getOperationsByDate(startDate, endDate);
        System.out.println(numberOfOperations + " Liczba dataProxyOperation w czasie: " + startDate + " " + endDate);

        int numberOfFailedOperations = dataProxyOperationStatisticController.getFailedOperationsByDate(startDate, endDate);
        System.out.println(numberOfFailedOperations + " Liczba dataProxyOperation blednych (Status < 0) w czasie: " + startDate + " " + endDate);

//        int numberOfManageTest = manageTestStatisticController.getAllManageTestsByDate(startDate, endDate);
//        System.out.println(numberOfManageTest + " Liczba operacji ManageTest w czasie: " + startDate + " " + endDate);

        int numberOfAutomateTest = manageTestStatisticController.getAllManageTestsByDateAndType(startDate, endDate, true);
        System.out.println(numberOfAutomateTest + " Liczba Testow automatycznych ManageTest w czasie: " + startDate + " " + endDate);

        int numberOfScreenShotTest = manageTestStatisticController.getAllManageTestsByDateAndType(startDate, endDate, false);
        System.out.println(numberOfScreenShotTest + " Liczba Testow screenshot ManageTest w czasie: " + startDate + " " + endDate);

        int numberOfDistinctUsers = manageTestStatisticController.getDistinctUsersByDate(startDate, endDate);
        System.out.println(numberOfDistinctUsers + " Liczba unikalnych uzytkownikow wykonujacych operacje: " + startDate + " " + endDate);

    }
}
