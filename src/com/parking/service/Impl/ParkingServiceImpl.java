package com.parking.service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import com.parking.data.model.CarDetails;
import com.parking.data.model.ParkingLot;
import com.parking.service.ParkingService;

public class ParkingServiceImpl implements ParkingService {
	private ParkingLot parkingLot;

	@Override
	public void createParkingLot(Integer spaceAvailable) {
		Set<Integer> slots = new TreeSet<>();
		for (int i = 1; i <= spaceAvailable; i++) {
			slots.add(i);
		}
		parkingLot = new ParkingLot(slots);
	}

	@Override
	public Boolean isParkingSpaceAvalable() {
		return (null != parkingLot && null != parkingLot.getFreeSlots() && parkingLot.getFreeSlots().isEmpty())
				? Boolean.FALSE
				: Boolean.TRUE;
	}

	@Override
	public void parkCar(CarDetails carDetails) {
		List<CarDetails> parkedCars = parkingLot.getParkedCars();
		if (null == parkedCars) {
			parkedCars = new ArrayList<>();
		}
		parkedCars.add(carDetails);
		parkingLot.setParkedCars(parkedCars);
		removeSlot(carDetails.getSlotNumber());
	}

	@Override
	public List<String> getAllCarRegistrationByColor(String color) {
		return parkingLot.getParkedCars().stream().filter(T -> T != null && T.getColour().equalsIgnoreCase(color))
				.map(T -> T.getRegistrationNumber()).collect(Collectors.toList());
	}

	@Override
	public List<Integer> getAllSlotsByColor(String color) {
		return parkingLot.getParkedCars().stream().filter(T -> T != null && T.getColour().equalsIgnoreCase(color))
				.map(T -> T.getSlotNumber()).collect(Collectors.toList());
	}

	@Override
	public Integer getSlotDetailsByRegistrationNumber(String registrationNumber) {
		return parkingLot.getParkedCars().stream()
				.filter(T -> T != null && T.getRegistrationNumber().equalsIgnoreCase(registrationNumber)).findAny()
				.map(T -> T.getSlotNumber()).orElse(null);
	}

	@Override
	public List<CarDetails> getParkingLotStatus() {
		return parkingLot.getParkedCars();
	}

	@Override
	public void freeCar(Integer slot) {
		CarDetails carDetails = parkingLot.getParkedCars().stream().filter(T -> T.getSlotNumber().equals(slot))
				.findAny().orElse(null);
		parkingLot.getParkedCars().remove(carDetails);
		addFreeSlot(slot);
	}

	@Override
	public Integer availableSlot() {
		return parkingLot.getFreeSlots().stream().findFirst().orElse(null);
	}

	private void removeSlot(Integer slot) {
		Set<Integer> freeSlots = parkingLot.getFreeSlots();
		freeSlots.remove(slot);
		parkingLot.setFreeSlots(freeSlots);

	}

	private void addFreeSlot(Integer slot) {
		Set<Integer> freeSlots = parkingLot.getFreeSlots();
		freeSlots.add(slot);
		parkingLot.setFreeSlots(freeSlots);

	}

}