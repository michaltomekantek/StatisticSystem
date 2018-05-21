  /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clickray.browserspot.statisticsystem.controller.service;

import com.clickray.browserspot.statisticsystem.controller.OperationStatisticRepository;
import com.clickray.entitylib.entity.DataProxyOperation;
import com.clickray.entitylib.entity.statistic.OperationFailed;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import com.clickray.browserspot.statisticsystem.controller.OperationFailedStatisticRepository;
import com.clickray.entitylib.entity.DataBrowser;

/**
 *
 * @author michalnowak
 */
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class OperationStatisticService {
    
    @Autowired
    OperationStatisticRepository operationStatisticRepository;
    
    @Autowired
    OperationFailedStatisticRepository operationFailedStatisticRepository;
     
    public List<DataProxyOperation> getOperationByStatus(int status){
        List<DataProxyOperation> operations = operationStatisticRepository.findByStatus(status);
        return operations;
    }
      
    public int getOperationsByDate(String startTime, String endTime) {
        Timestamp startTimeQuery = convertDate(startTime);
        Timestamp endTimeQuery = convertDate(endTime);
        List<DataProxyOperation> operations = operationStatisticRepository.findByDate(startTimeQuery, endTimeQuery);
        return operations.size();
    }
    
    public int getOperationsByDateAndUserIdAndStatus(String startTime, String endTime, String idUser, int status) {
        Timestamp startTimeQuery = convertDate(startTime);
        Timestamp endTimeQuery = convertDate(endTime);
        List<DataProxyOperation> operations = operationStatisticRepository.findByDateAndUserAndStatus(startTimeQuery, endTimeQuery, idUser, status);
        return operations.size();
    }
    
    public List<DataProxyOperation> getDeletedDataProxyOperations(){
        List<DataProxyOperation> operations = new ArrayList<>();
        return operations;
    }
    
    public List<DataProxyOperation> getOperationByUserId(String userId) {
        return operationStatisticRepository.getOperationsByUserId(userId);
    }  
    
    public List<OperationFailed> getOperationFailed(){
        return operationFailedStatisticRepository.findAll();
    }
    
    public List<OperationFailed> getOperationFailedByDate(String startTime, String endTime) {
        Timestamp startTimeQuery = convertDate(startTime);
        Timestamp endTimeQuery = convertDate(endTime);
        List<OperationFailed> operations = operationFailedStatisticRepository.getFailedOperationsByDate(startTimeQuery, endTimeQuery);
        return operations;
    }
    
    public List<String> getAllUsers(){
        return operationStatisticRepository.findDistinctUserId();
    }
    
    public void save(){
        
        DataProxyOperation test =  new DataProxyOperation();
        DataBrowser d = new DataBrowser();
        d.setId(3);
        test.setOperationName("śćóąę");
        test.setDataBrowser(d);
        operationStatisticRepository.save(test);
        
    }
    
    
    private Timestamp convertDate(String time){
         SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:s");
        try {
            Date parsedTime = dateFormat.parse(time);
            Timestamp timeStampTime = new Timestamp(parsedTime.getTime());
            return timeStampTime;
        } catch (ParseException ex) {
            Logger.getLogger(OperationStatisticService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new Timestamp(0);
    }
}
