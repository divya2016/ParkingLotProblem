package com.parking.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

import com.parking.constants.Constants;
import com.parking.data.model.CarDetails;
import com.parking.service.ParkingService;

public class Run {
	public static void main(String[] args) {
		System.out.println("\n\n\n\n\n");
		System.out.println("===================================================================");
		System.out.println("===================      GOJEK PARKING LOT     ====================");
		System.out.println("===================================================================");
		commandDes();
		ParkingService parking;
		BufferedReader bufferReader = null;
		String input = null;
		switch (args.length)
		{
			case 0: // Interactive: command-line input/output
			{
				System.out.println("Please Enter 'exit' to end Execution");
				System.out.println("Input:");
				bufferReader = new BufferedReader(new InputStreamReader(System.in));
				input = bufferReader.readLine().trim();
				String[] inputs = input.split(" ");
				String key = inputs[0];
				switch (key) {
				case vaue:
					
					break;

				default:
					break;
				}
				if (input.equalsIgnoreCase("exit"))
				{
					break;
				}
				else
				{
					
				}
			}
		if (Constants.PARK_CAR) {
			if (parking.isParkingSpaceAvalable()) {
				Integer slot = parking.availableSlot();
				parking.parkCar(new CarDetails(slot, "", ""));
				parking.removeSlotFromtheList(slot);
			} else {
				System.out.println(Constants.NO_SPACE_AVAILABLE_MESSAGE);
			}

		} else if (Constants.FREECAR) {
			Integer slot = parking.freeCar(1);
			parking.addFreeSlotInTheList(slot);
		} else if (Constants.STATUS) {
			List<CarDetails> carDetails = parking.getParkingLotStatus();
			for (CarDetails details : carDetails) {
				System.out.println(details);
			}
		} else if (Constants.REGISTRATION_NUMBER_FOR_COLOR) {
			List<String> registrationNumber = parking.getAllCarRegistrationByColor("");
			for (String details : registrationNumber) {
				System.out.println(details);
			}
		}
	}

	private static void commandDes() {
		StringBuffer buffer = new StringBuffer();
		buffer = buffer.append(
				"--------------Please Enter one of the below commands. {variable} to be replaced -----------------------")
				.append("\n");
		buffer = buffer.append("A) For creating parking lot of size n               ---> create_parking_lot {capacity}")
				.append("\n");
		buffer = buffer
				.append("B) To park a car                                    ---> park <<car_number>> {car_clour}")
				.append("\n");
		buffer = buffer.append("C) Remove(Unpark) car from parking                  ---> leave {slot_number}")
				.append("\n");
		buffer = buffer.append("D) Print status of parking slot                     ---> status").append("\n");
		buffer = buffer.append(
				"E) Get cars registration no for the given car color ---> registration_numbers_for_cars_with_color {car_color}")
				.append("\n");
		buffer = buffer.append(
				"F) Get slot numbers for the given car color         ---> slot_numbers_for_cars_with_color {car_color}")
				.append("\n");
		buffer = buffer.append(
				"G) Get slot number for the given car number         ---> slot_number_for_registration_number {car_number}")
				.append("\n");
		System.out.println(buffer.toString());
	}

}
