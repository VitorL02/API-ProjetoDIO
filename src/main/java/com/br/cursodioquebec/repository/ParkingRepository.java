package com.br.cursodioquebec.repository;

import com.br.cursodioquebec.model.ParkingModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingRepository extends JpaRepository<ParkingModel,String> {
}
