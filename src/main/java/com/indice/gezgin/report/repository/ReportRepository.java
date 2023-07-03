package com.indice.gezgin.report.repository;


import com.indice.gezgin.report.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {


    @Query(value = "SELECT * FROM report u WHERE u.id = :id", nativeQuery = true)
    Report findReportById(@Param("id") Long id);


    @Query(value = "SELECT * FROM report u WHERE u.is_active= true ORDER BY id DESC limit :limit offset :offset", nativeQuery = true)
    List<Report> findAllReportsWithOffset(@Param("offset") int offset, @Param("limit") int limit);


    @Query(value = "SELECT * FROM report u WHERE u.reported_place = :place ORDER BY u.created_at DESC", nativeQuery = true)
    List<Report> findAllReportsByPlace(@Param("place") Long place);

}
