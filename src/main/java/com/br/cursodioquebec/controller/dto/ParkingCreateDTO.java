package com.br.cursodioquebec.controller.dto;

//Esse dto foi criado para limitar os campos que serão inseridos
public class ParkingCreateDTO {
    private String licese;
    private String state;
    private String model;
    private String color;

    public String getLicese() {
        return licese;
    }

    public void setLicese(String licese) {
        this.licese = licese;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
