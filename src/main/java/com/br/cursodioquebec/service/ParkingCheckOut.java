package com.br.cursodioquebec.service;

import com.br.cursodioquebec.model.ParkingModel;

import java.time.LocalDateTime;

public class ParkingCheckOut {

    public static Double getBill(ParkingModel parking){
        return getBill(parking.getEntryDate(),parking.getExitDate());
    }

    private static Double getBill(LocalDateTime entryDate, LocalDateTime exitDate) {
        return null;
    }
}
