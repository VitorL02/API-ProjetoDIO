package com.br.cursodioquebec.service;

import com.br.cursodioquebec.exception.ParkingNotFoundException;
import com.br.cursodioquebec.model.ParkingModel;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ParkingService {

    private static Map<String,ParkingModel> parkingMap = new HashMap();



    @GetMapping
    public List<ParkingModel> findAll(){
        return parkingMap.values().stream().collect(Collectors.toList());
    }


    public ParkingModel findById(String id){

        ParkingModel parkingModel = parkingMap.get(id);
        if(parkingModel == null){
            throw  new ParkingNotFoundException(id);
        }
        return parkingModel;
    }

    public void delete(String id){
        ParkingModel parking = findById(id);
        if (parking == null)  throw new ParkingNotFoundException(id);
        parkingMap.remove(id);
    }

    private static String getUUID() {
        return UUID.randomUUID().toString().replace("-","");
    }

    public ParkingModel save(ParkingModel parkingCreate) {
        String uuid = getUUID();
        parkingCreate.setId(uuid);
        parkingCreate.setEntryDate(LocalDateTime.now());
        parkingMap.put(uuid,parkingCreate);
        return parkingCreate;
    }

    public ParkingModel update(String id, ParkingModel parkingUpdate) {
        ParkingModel parkingResult = findById(id);
        if(parkingResult == null ) throw new ParkingNotFoundException(id);
        parkingResult.setColor(parkingUpdate.getColor());
        return parkingResult;
    }

    public ParkingModel exit(String id) {
        ParkingModel parkingResult = findById(id);
        if(parkingResult == null ) throw new ParkingNotFoundException(id);
        parkingResult.setExitDate(LocalDateTime.now());
        return parkingResult;
    }
}
