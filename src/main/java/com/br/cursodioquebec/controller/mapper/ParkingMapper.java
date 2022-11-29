package com.br.cursodioquebec.controller.mapper;

import com.br.cursodioquebec.controller.dto.ParkingCreateDTO;
import com.br.cursodioquebec.controller.dto.ParkingDTO;
import com.br.cursodioquebec.model.ParkingModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ParkingMapper {
    private static  final ModelMapper MODEL_MAPPER = new ModelMapper();

    public ParkingDTO toParkingDTO(ParkingModel parking){
        return MODEL_MAPPER.map(parking,ParkingDTO.class);
    }
    public List<ParkingDTO> toParkingDTOList(List<ParkingModel> parkingModelList){
        return parkingModelList.stream().map(this::toParkingDTO).collect(Collectors.toList());
    }

    public ParkingModel toParking(ParkingDTO parkingDTO) {
     return MODEL_MAPPER.map(parkingDTO, ParkingModel.class);
    }

    public ParkingModel toParkingCreate(ParkingCreateDTO parkingCreateDTO) {
        return MODEL_MAPPER.map(parkingCreateDTO, ParkingModel.class);
    }
}
