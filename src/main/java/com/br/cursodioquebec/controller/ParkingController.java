package com.br.cursodioquebec.controller;

import com.br.cursodioquebec.model.ParkingModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping("/parking")
public class ParkingController {

    @GetMapping
    public List<ParkingModel> findAll(){
        var parking = new ParkingModel();
        parking.setColor("Azul");
        parking.setBill(28.1);
        parking.setId("1");
        parking.setLicese("E2EWE28");
        parking.setModel("Gol");
        parking.setState("MG");
        return Arrays.asList(parking);
    }
}
