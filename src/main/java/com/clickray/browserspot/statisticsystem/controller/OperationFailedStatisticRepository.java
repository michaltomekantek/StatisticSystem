/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clickray.browserspot.statisticsystem.controller;

import com.clickray.entitylib.entity.statistic.OperationFailed;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @author michalnowak
 */
public interface OperationFailedStatisticRepository extends CrudRepository<OperationFailed, Integer> {
    
    @Query("SELECT p FROM OperationFailed p where p.status < 0")
    public List<OperationFailed>  findAll();
    
    @Query("SELECT p FROM OperationFailed p where p.status < 0 and p.createDate >= ?1 and p.createDate <=?2")
    public List<OperationFailed>  getFailedOperationsByDate(@Param("startTime") Timestamp startTime, @Param("endTime") Timestamp endTime);
}
