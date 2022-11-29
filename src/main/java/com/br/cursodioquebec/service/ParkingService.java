package com.br.cursodioquebec.service;

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

    static {
        var id = getUUID();
        var id1 = getUUID();
        ParkingModel parking = new ParkingModel(id,"DDSAMMASD","MG","CELTA","AZUL");
        ParkingModel parking1 = new ParkingModel(id1,"DDSAMMASD","MG","GOL","PRETO");
        parkingMap.put(id,parking);
        parkingMap.put(id1,parking1);
    }

    @GetMapping
    public List<ParkingModel> findAll(){
        return parkingMap.values().stream().collect(Collectors.toList());
    }


    public ParkingModel findById(String id){
        return parkingMap.get(id);
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
}
