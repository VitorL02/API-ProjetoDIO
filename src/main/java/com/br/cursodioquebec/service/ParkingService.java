package com.br.cursodioquebec.service;

import com.br.cursodioquebec.model.ParkingModel;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ParkingService {

    private static Map<String,ParkingModel> parkingMap = new HashMap();

    static {
        var id = getUUID();
        ParkingModel parking = new ParkingModel(id,"DDSAMMASD","MG","CELTA","AZUL");
        parkingMap.put(id,parking);
    }

    public List<ParkingModel> findAll(){
        return parkingMap.values().stream().collect(Collectors.toList());
    }

    private static String getUUID() {
        return UUID.randomUUID().toString().replace("-","");
    }

}
