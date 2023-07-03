package com.indice.gezgin.message.repository;


import com.indice.gezgin.message.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {


    @Query(value = "SELECT  * FROM message u WHERE u.id= :id", nativeQuery = true)
    Message findMessageById(@Param("id") Long id);


    @Query(value = "SELECT * FROM message u WHERE u.is_active = true ORDER BY u.created_at DESC limit :limit offset :offset", nativeQuery = true)
    List<Message> findAllMessagesWithOffset(@Param("offset") int offset, @Param("limit") int limit);


}
