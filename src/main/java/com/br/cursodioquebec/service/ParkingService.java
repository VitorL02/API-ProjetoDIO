package com.br.cursodioquebec.service;

import com.br.cursodioquebec.exception.ParkingNotFoundException;
import com.br.cursodioquebec.model.ParkingModel;
import com.br.cursodioquebec.repository.ParkingRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ParkingService {


    private final ParkingRepository parkingRepository;

    public ParkingService(ParkingRepository parkingRepository) {
        this.parkingRepository = parkingRepository;
    }


    @GetMapping
    public List<ParkingModel> findAll(){
        return parkingRepository.findAll();
    }


    public ParkingModel findById(String id){
        return parkingRepository.findById(id).orElseThrow( () -> new ParkingNotFoundException(id));
    }

    public void delete(String id){
        ParkingModel parking = findById(id);
        if (parking == null)  throw new ParkingNotFoundException(id);
        parkingRepository.deleteById(id);
    }

    private static String getUUID() {
        return UUID.randomUUID().toString().replace("-","");
    }

    public ParkingModel save(ParkingModel parkingCreate) {
        String uuid = getUUID();
        parkingCreate.setId(uuid);
        parkingCreate.setEntryDate(LocalDateTime.now());
        parkingRepository.save(parkingCreate);
        return parkingCreate;
    }

    public ParkingModel update(String id, ParkingModel parkingUpdate) {
        ParkingModel parkingResult = findById(id);
        if(parkingResult == null ) throw new ParkingNotFoundException(id);
        parkingResult.setColor(parkingUpdate.getColor());
        parkingResult.setExitDate(parkingUpdate.getExitDate());
        parkingResult.setModel(parkingUpdate.getModel());
        parkingResult.setState(parkingUpdate.getState());
        parkingResult.setBill(parkingUpdate.getBill());
        parkingResult.setEntryDate(parkingUpdate.getEntryDate());
        parkingRepository.save(parkingResult);
        return parkingResult;
    }

    public ParkingModel exit(String id) {
        ParkingModel parkingResult = findById(id);
        if(parkingResult == null ) throw new ParkingNotFoundException(id);
        parkingResult.setExitDate(LocalDateTime.now());
        return parkingResult;
    }
}
