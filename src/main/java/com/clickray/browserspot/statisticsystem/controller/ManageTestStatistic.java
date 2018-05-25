package com.clickray.browserspot.statisticsystem.controller;

import com.clickray.entitylib.entity.ManageTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Timestamp;
import java.util.List;

public interface ManageTestStatistic extends JpaRepository<ManageTest, Integer> {

    public List<ManageTest> findAll();

    @Query("Select count(m) from ManageTest m")
    public long countAll();

    @Query("Select count(m) from ManageTest m where m.createDate >= ?1 and m.createDate <=?2 and m.deleted = false ")
    public long findAllByDate(@Param("startDate") Timestamp startDate, @Param("endDate") Timestamp endDate);

    @Query("Select m from ManageTest m where m.createDate >= ?1 and m.createDate <=?2 and m.deleted = false and m.testAutomation = ?3")
    public List<ManageTest> findAllByDateAndType(@Param("startDate") Timestamp startDate, @Param("endDate") Timestamp endDate, @Param("isAutomate") Boolean isAutomate);

    @Query("Select m from ManageTest m where m.createDate >= ?1 and m.createDate <=?2 and m.deleted = false and m.idUser = ?3")
    public List<ManageTest> findAllByDateAndUser(@Param("startDate") Timestamp startDate, @Param("endDate") Timestamp endDate, @Param("idUser") String idUser);

    @Query("Select m from ManageTest m where m.createDate >= ?1 and m.createDate <=?2 and m.deleted = false and m.idUser = ?3 and m.testAutomation = ?4")
    public List<ManageTest> findAllByDateAndUserAndType(@Param("startDate") Timestamp startDate, @Param("endDate") Timestamp endDate, @Param("idUser") String idUser, @Param("isAutomate") Boolean isAutomate);

    @Query("Select distinct m.idUser from ManageTest m where m.createDate >= ?1 and m.createDate <=?2 and m.deleted = false")
    public List<String> findDistinctUsersByDate(@Param("startDate") Timestamp startDate, @Param("endDate") Timestamp endDate);
}
