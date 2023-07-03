package com.indice.gezgin.proposal.repository;


import com.indice.gezgin.proposal.model.Proposal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProposalRepository extends JpaRepository<Proposal, Long> {


    @Query(value = "SELECT * FROM proposal u WHERE u.id = true", nativeQuery = true)
    Proposal findProposalById(Long id);


    @Query(value = "SELECT * FROM proposal u WHERE u.is_active= true ORDER BY id DESC limit :limit offset :offset", nativeQuery = true)
    List<Proposal> findAllProposalsWithOffset(@Param("offset") int offset, @Param("limit") int limit);

    @Query(value = "SELECT * FROM proposal u", nativeQuery = true)
    List<Proposal> test();


    @Query(value = "SELECT * FROM proposal u WHERE u.is_active= true", nativeQuery = true)
    List<Proposal> test2();


    @Query(value = "SELECT * FROM proposal u WHERE u.is_active= true ORDER BY id DESC", nativeQuery = true)
    List<Proposal> test3();


    @Query(value = "SELECT * FROM proposal u WHERE date(u.created_at) =:date AND u.is_active = true ORDER BY u.created_at DESC limit :limit offset :offset", nativeQuery = true)
    List<Proposal> findProposalByDateWithOffset(@Param("date") String date, @Param("offset") int offset, @Param("limit") int limit);






}
