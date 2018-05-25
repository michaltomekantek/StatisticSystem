/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clickray.browserspot.statisticsystem.rest;

import com.clickray.browserspot.statisticsystem.controller.ManageTestStatistic;
import com.clickray.browserspot.statisticsystem.controller.service.DataProxyOperationStatisticController;
import com.clickray.browserspot.statisticsystem.controller.service.DateOperations;
import com.clickray.browserspot.statisticsystem.controller.service.StatisticScheduler;
import com.clickray.browserspot.statisticsystem.controller.service.UserStatisticController;
import com.clickray.browserspot.statisticsystem.model.FailedOperation;
import com.clickray.browserspot.statisticsystem.model.UserStatistic;
import com.clickray.browserspot.statisticsystem.sqlite.UserStatisticRepository;
import com.clickray.entitylib.entity.DataProxyOperation;
import com.clickray.entitylib.entity.statistic.OperationFailed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author michalnowak
 */
@RestController
@RequestMapping("/operationstatistic/")
public class OperationStatisticRest {
    
    @Autowired
    DataProxyOperationStatisticController dataProxyOperationStatisticController;

    @Autowired
    UserStatisticController userStatisticController;

    @Autowired
    UserStatisticRepository userStatisticRepository;

    @Autowired
    ManageTestStatistic manageTestStatistic;


    @Autowired
    StatisticScheduler statisticScheduler;
    
    @RequestMapping(value = "status", method = RequestMethod.GET)
    @ResponseBody
    public  List<DataProxyOperation> test(@RequestParam Integer status) {
        
        return dataProxyOperationStatisticController.getOperationByStatus(status);
    }  
    
    /**
     * http://10.0.0.36:7770/operationstatistic/timeuserstatus?startTime=2018-05-10+15:18:38&endTime=2018-05-10+16:22:16
     * @param startTime
     * @param endTime
     * @return 
     */
    @RequestMapping(value = "time", method = RequestMethod.GET)
    @ResponseBody
    public  int getByTime(@RequestParam String startTime, @RequestParam String endTime) {
        return dataProxyOperationStatisticController.getOperationsByDate(startTime, endTime);
    }  
    
    /**
     * http://10.0.0.36:7770/operationstatistic/timeuserstatus?startTime=2018-05-10+15:18:38&endTime=2018-05-10+16:22:16
     * @return 
     */
    @RequestMapping(value = "user", method = RequestMethod.GET)
    @ResponseBody
    public  List<DataProxyOperation> getByUser(@RequestParam String userId) {
        return dataProxyOperationStatisticController.getOperationByUserId(userId);
    }  
    
    /**
     * http://10.0.0.36:7770/operationstatistic/timeuserstatus?startTime=2018-05-10+15:18:38&endTime=2018-05-10+16:22:16&idUser=3d02b43c-b1a9-4344-a981-793455d39b25&status=2
     * @param startTime
     * @param endTime
     * @param idUser
     * @param status
     * @return 
     */
    @RequestMapping(value = "timeuserstatus", method = RequestMethod.GET)
    @ResponseBody
    public  int getByTimeAndUserAndStatus(@RequestParam String startTime, @RequestParam String endTime, @RequestParam String idUser, @RequestParam int status) {
        return dataProxyOperationStatisticController.getOperationsByDateAndUserIdAndStatus(startTime, endTime, idUser, status);
    }
    
    /**
     * http://10.0.0.36:7770/operationstatistic/timeuserstatus
     * @return 
     */
    @RequestMapping(value = "deletedoperation", method = RequestMethod.GET)
    @ResponseBody
    public  List<DataProxyOperation> getDeletedOperations() {
        return dataProxyOperationStatisticController.getDeletedDataProxyOperations();
    } 
    
       /**
     * http://10.0.0.36:7770/operationstatistic/users
     * @return 
     */
    @RequestMapping(value = "users", method = RequestMethod.GET)
    @ResponseBody
    public  List<String> removeDeletedOperations() {
        return dataProxyOperationStatisticController.getAllUsers();
    }
    
         /**
     * http://10.0.0.36:7770/operationstatistic/users
     * @return 
     */
    @RequestMapping(value = "test", method = RequestMethod.GET)
    @ResponseBody
    public  long test() {

      //  UserStatistic user = UserStatistic();

        UserStatistic t = new UserStatistic();
        userStatisticRepository.save(t);
        UserStatistic b = t;
        userStatisticRepository.save(b);

        long result = userStatisticRepository.count();
        return result;
    }


    private Set<FailedOperation> mockOperations(){
        Set<FailedOperation> failedOperations = new HashSet<>();

        for(int i =0; i<1000; i++){
            FailedOperation operationFailed = new FailedOperation();
            operationFailed.setName("operation " + i);
            failedOperations.add(operationFailed);
        }

        return failedOperations;

    }
}
