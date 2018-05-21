/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clickray.browserspot.statisticsystem.rest;

import com.clickray.browserspot.statisticsystem.controller.service.OperationStatisticService;
import com.clickray.entitylib.entity.DataProxyOperation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author michalnowak
 */
@RestController
@RequestMapping("/operationstatistic/")
public class OperationStatisticRest {
    
    @Autowired
    OperationStatisticService operationStatisticService;
    
    @RequestMapping(value = "status", method = RequestMethod.GET)
    @ResponseBody
    public  List<DataProxyOperation> test(@RequestParam Integer status) {
        
        return operationStatisticService.getOperationByStatus(status);
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
        return operationStatisticService.getOperationsByDate(startTime, endTime);
    }  
    
    /**
     * http://10.0.0.36:7770/operationstatistic/timeuserstatus?startTime=2018-05-10+15:18:38&endTime=2018-05-10+16:22:16
     * @param startTime
     * @param endTime
     * @return 
     */
    @RequestMapping(value = "user", method = RequestMethod.GET)
    @ResponseBody
    public  List<DataProxyOperation> getByUser(@RequestParam String userId) {
        return operationStatisticService.getOperationByUserId(userId);
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
        return operationStatisticService.getOperationsByDateAndUserIdAndStatus(startTime, endTime, idUser, status);
    }
    
    /**
     * http://10.0.0.36:7770/operationstatistic/timeuserstatus
     * @return 
     */
    @RequestMapping(value = "deletedoperation", method = RequestMethod.GET)
    @ResponseBody
    public  List<DataProxyOperation> getDeletedOperations() {
        return operationStatisticService.getDeletedDataProxyOperations();
    } 
    
       /**
     * http://10.0.0.36:7770/operationstatistic/users
     * @return 
     */
    @RequestMapping(value = "users", method = RequestMethod.GET)
    @ResponseBody
    public  List<String> removeDeletedOperations() {
        return operationStatisticService.getAllUsers();
    }
    
         /**
     * http://10.0.0.36:7770/operationstatistic/users
     * @return 
     */
    @RequestMapping(value = "test", method = RequestMethod.GET)
    @ResponseBody
    public  void test() {
         operationStatisticService.save();
    }
}
