package com.parking.data.model;

public class CarDetails {
	private Integer slotNumber;
	private String registrationNumber;
	private String colour;

	public Integer getSlotNumber() {
		return slotNumber;
	}

	public void setSlotNumber(Integer slotNumber) {
		this.slotNumber = slotNumber;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public CarDetails(Integer slotNumber, String registrationNumber, String colour) {

		this.slotNumber = slotNumber;
		this.registrationNumber = registrationNumber;
		this.colour = colour;
	}

}
