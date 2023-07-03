package com.indice.gezgin.ads.repository;


import com.indice.gezgin.ads.model.Ads;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdsRepository extends JpaRepository<Ads, Long> {


    Ads getAdsById(Long id);

    @Query(value = "SELECT * FROM ads u WHERE u.is_active = true ORDER BY u.created_at DESC  limit :limit offset :offset  ", nativeQuery = true)
    List<Ads> findAllActiveAdsWithOffset(@Param("offset") int offset, @Param("limit") int limit);

    @Query(value = "SELECT * FROM ads u  ORDER BY u.created_at DESC  limit :limit offset :offset  ", nativeQuery = true)
    List<Ads> findAllAdsWithOffset(@Param("offset") int offset, @Param("limit") int limit);


//    @Query(value = "SELECT * FROM ads u WHERE u.is_active = true AND u.aura LIKE CONCAT('%',:aura,'%')" +
//            "ORDER BY u.created_at DESC  limit :limit offset :offset  ", nativeQuery = true)
//    List<Ads> findAllAdsWithOffset(@Param("offset") int offset, @Param("limit") int limit);


}
