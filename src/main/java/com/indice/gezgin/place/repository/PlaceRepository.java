package com.indice.gezgin.place.repository;


import com.indice.gezgin.place.model.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Long>, PlaceCustomRepository {


    @Query(value = "SELECT * FROM place u WHERE u.id = :id", nativeQuery = true)
    Place findPlaceByID(@Param("id") Long id);


    @Query(value = "SELECT * FROM place u WHERE u.is_active = true AND u.name LIKE CONCAT('%',:name,'%')" +
            "ORDER BY u.created_at DESC  limit :limit offset :offset  ", nativeQuery = true)
    List<Place> findPlaceByNameWithOffset(@Param("name") String name, @Param("offset") int offset, @Param("limit") int limit);


    @Query(value = "SELECT * FROM place u WHERE u.is_active = true AND u.aura LIKE CONCAT('%',:aura,'%')" +
            "ORDER BY u.created_at DESC  limit :limit offset :offset  ", nativeQuery = true)
    List<Place> findPlaceByAuraWithOffset(@Param("aura") String aura, @Param("offset") int offset, @Param("limit") int limit);

}
