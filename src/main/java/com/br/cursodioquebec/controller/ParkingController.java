package com.br.cursodioquebec.controller;

import com.br.cursodioquebec.controller.dto.ParkingCreateDTO;
import com.br.cursodioquebec.controller.dto.ParkingDTO;
import com.br.cursodioquebec.controller.mapper.ParkingMapper;
import com.br.cursodioquebec.model.ParkingModel;
import com.br.cursodioquebec.service.ParkingService;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/parking")
@Api(tags ="Parking Controller")
public class ParkingController {

    private final ParkingService parkingService;
    private final ParkingMapper parkingMapper ;

    public ParkingController(ParkingService parkingService,ParkingMapper parkingMapper) {
        this.parkingService = parkingService;
        this.parkingMapper = parkingMapper;
    }

    @GetMapping
    public ResponseEntity<List<ParkingDTO>> findAll(){
        List<ParkingModel> parkingList = parkingService.findAll();
        List<ParkingDTO> result = parkingMapper.toParkingDTOList(parkingList);
        return ResponseEntity.ok(result) ;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParkingDTO> findById(@PathVariable String id){
        ParkingModel parkingRegistry = parkingService.findById(id);
        ParkingDTO result = parkingMapper.toParkingDTO(parkingRegistry);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<ParkingDTO> create(@RequestBody ParkingCreateDTO parkingCreateDTODTO){
        var parkingCreate =  parkingMapper.toParkingCreate(parkingCreateDTODTO);
        var parkingRegistry = parkingService.save(parkingCreate);
        var result = parkingMapper.toParkingDTO(parkingRegistry);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable String id){
        parkingService.delete(id);
        return ResponseEntity.noContent().build();
    }


    @PutMapping("/{id}")
    public ResponseEntity<ParkingDTO> update(@PathVariable String id, @RequestBody ParkingCreateDTO parkingCreateDTODTO){
        var parkingCreate =  parkingMapper.toParkingCreate(parkingCreateDTODTO);
        var parkingRegistry = parkingService.update(id,parkingCreate);
        var result = parkingMapper.toParkingDTO(parkingRegistry);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PostMapping("/{id}")
    public ResponseEntity<ParkingDTO> exit(@PathVariable String id){
        var parkingRegistry = parkingService.exit(id);
        var result = parkingMapper.toParkingDTO(parkingRegistry);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
