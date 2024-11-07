package exampleTDD;

import java.util.HashMap;
import java.util.Map;

public class FlighControlller {

	private Map<String, Flight> flights;
	
	public FlighControlller() {
		flights = new HashMap<>();
	}

	public void addFlight(Flight flight) {
		Flight flightNew = flights.get(flight.getReference());
		if (flightNew != null) {
			throw new DuplicatedFlightException();
		}		
		
		flights.put(flight.getReference(), flight);	
	}

	public Flight findFlightByReference(String reference) {		
		Flight flight = flights.get(reference);		
		if (flight == null) {
			throw new FlighNotFoundException();
		}		
		return flight;
	}
	
	public void deleteFlight(String reference) {
		if (flights.remove(reference) == null) {
			throw new FlighNotFoundException();
		}
	}
}
