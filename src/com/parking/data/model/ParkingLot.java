package com.parking.data.model;

import java.util.List;
import java.util.Set;

public class ParkingLot {
	private Set<Integer> freeSlots;
	private List<CarDetails> parkedCars;

	public ParkingLot(Set<Integer> freeSlots) {
		this.freeSlots = freeSlots;
	}

	public Set<Integer> getFreeSlots() {
		return freeSlots;
	}

	public List<CarDetails> getParkedCars() {
		return parkedCars;
	}

	public void setParkedCars(List<CarDetails> parkedCars) {
		this.parkedCars = parkedCars;
	}

	public void setFreeSlots(Set<Integer> freeSlots) {
		this.freeSlots = freeSlots;
	}

	public ParkingLot(Set<Integer> freeSlots, List<CarDetails> parkedCars) {
		this.freeSlots = freeSlots;
		this.parkedCars = parkedCars;
	}

}
