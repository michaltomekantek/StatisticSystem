package com.clickray.browserspot.statisticsystem.controller.service;

import com.clickray.browserspot.statisticsystem.controller.ManageTestStatistic;
import com.clickray.browserspot.statisticsystem.model.UserStatistic;
import com.clickray.entitylib.entity.ManageTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ManageTestStatisticController {

    @Autowired
    ManageTestStatistic manageTestStatistic;

    public int getAllManageTests(){
        List<ManageTest> manageTests = manageTestStatistic.findAll();
        return manageTests.size();
    }

//    public int getAllManageTestsByDate(String startDate, String endDate){
//        List<ManageTest> manageTests = manageTestStatistic.findAllByDate(DateOperations.convertDate(startDate), DateOperations.convertDate(endDate));
//        return manageTests.size();
//    }

    public int getAllManageTestsByDateAndType(String startDate, String endDate, Boolean isAutomate){
        List<ManageTest> manageTests = manageTestStatistic.findAllByDateAndType(DateOperations.convertDate(startDate), DateOperations.convertDate(endDate), isAutomate);
        return manageTests.size();
    }

    public int getDistinctUsersByDate(String startDate, String endDate){
        List<String> users = manageTestStatistic.findDistinctUsersByDate(DateOperations.convertDate(startDate), DateOperations.convertDate(endDate));
        return users.size();
    }

    public int getManageTestByUser(String startDate, String endDate, String idUser){
        Timestamp startDateQuery = DateOperations.convertDate(startDate);
        Timestamp endDateQuery   = DateOperations.convertDate(endDate);

        List<String> allUsers = manageTestStatistic.findDistinctUsersByDate(startDateQuery, endDateQuery);
        List<UserStatistic> usersStatistics = new ArrayList<>();

        for (String userID : allUsers) {
            UserStatistic userStatistic = new UserStatistic();
            userStatistic.setUserId(userID);
            List<ManageTest> allOperations = manageTestStatistic.findAllByDateAndUser(startDateQuery, endDateQuery, idUser);
            List<ManageTest> screenShotOperations = manageTestStatistic.findAllByDateAndUserAndType(startDateQuery, endDateQuery, idUser, false);
            List<ManageTest> automateTestsOperations = manageTestStatistic.findAllByDateAndUserAndType(startDateQuery, endDateQuery, idUser, false);

            userStatistic.setNumberOfOperations(allOperations.size());
            userStatistic.setNumberOfAutomatTests(automateTestsOperations.size());
            userStatistic.setNumberOfScreenShotTests(screenShotOperations.size());
        }



        List<ManageTest> users = manageTestStatistic.findAllByDateAndUser(DateOperations.convertDate(startDate), DateOperations.convertDate(endDate), idUser);

        return 100;
    }
}
