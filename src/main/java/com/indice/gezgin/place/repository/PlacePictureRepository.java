package com.indice.gezgin.place.repository;

import com.indice.gezgin.place.model.PlacePicture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface PlacePictureRepository extends JpaRepository<PlacePicture, Long> {
}
