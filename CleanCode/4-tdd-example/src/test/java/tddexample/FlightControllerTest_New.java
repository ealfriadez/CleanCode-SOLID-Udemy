package tddexample;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import exampleTDD.DuplicatedFlightException;
import exampleTDD.FlighControlller;
import exampleTDD.FlighNotFoundException;

class FlightControllerTest_New {

	private FlighControlller flighControlller;

	@BeforeEach
	void setUp() {
		flighControlller = new FlighControlller();
	}

	@Test
	void givenEmptyFlightController_whenFlighAdded_thenGetByReferenceReturnsFlight() {

		// GIVEN -> Pre condicion
		exampleTDD.Flight flight = getDefaultFlight();

		// WHEN -> Se realiza un accion
		flighControlller.addFlight(flight);

		// THEN -> Pasa algo
		assertEquals(flight, flighControlller.findFlightByReference("1"));
	}

	@Test
	void givenEmptyFlightController_whenGetByReference_thenThrowFlightNotFoundException() {

		// THEN -> Pasa algo
		assertThrows(FlighNotFoundException.class, () -> {
			flighControlller.findFlightByReference("qw23");
		});
	}

	@Test
	void givenFlightControllerFlight_whenSameFlightAdded_thenThrowDuplicatedFlightException() {
		// GIVEN -> Pre condicion
		exampleTDD.Flight flight = getDefaultFlight();

		// WHEN -> Se realiza un accion
		flighControlller.addFlight(flight);

		// THEN -> Pasa algo
		assertThrows(DuplicatedFlightException.class, () -> {
			flighControlller.addFlight(flight);
		});
	}

	@Test
	void givenFlightControllerWithFlight_whenDeleteFlight_thenGetReferenceReturnsFlightNotFoundException() {
		// GIVEN -> Pre condicion
		exampleTDD.Flight flight = getDefaultFlight();

		// WHEN -> Se realiza un accion
		flighControlller.addFlight(flight);
		flighControlller.deleteFlight(flight.getReference());

		// THEN -> Pasa algo
		assertThrows(FlighNotFoundException.class, () -> {
			flighControlller.findFlightByReference(flight.getReference());
		});
	}

	@Test
	void givenEmptyFlightController_whenDeleteFlight_thenThrowFlightNotFoundException() {
		assertThrows(FlighNotFoundException.class, () -> {
			flighControlller.findFlightByReference("1");
		});
	}

	private exampleTDD.Flight getDefaultFlight() {
		LocalDate date = LocalDate.of(2024, 1, 1);
		LocalTime time = LocalTime.of(10, 30);
		return new exampleTDD.Flight("1", LocalDateTime.of(date, time), "Madrid", "Barcelona");
	}
}
