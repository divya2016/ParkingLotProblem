package com.parking.service;

import java.util.List;

import com.parking.data.model.CarDetails;

public interface ParkingService {
	public void createParkingLot(Integer spaceAvailable);

	public Boolean isParkingSpaceAvalable();

	public void parkCar(CarDetails carDetails);

	public List<String> getAllCarRegistrationByColor(String color);

	public List<Integer> getAllSlotsByColor(String color);

	public Integer getSlotDetailsByRegistrationNumber(String registrationNumber);

	public List<CarDetails> getParkingLotStatus();

	public void freeCar(Integer Slot);

	public Integer availableSlot();

}
