package ru.netology.manager;

import ru.netology.domain.TicketInformation;
import ru.netology.repository.TicketInformationRepository;

import java.util.Arrays;

public class TicketInformationManager {
    private TicketInformationRepository repository;

    public TicketInformationManager(TicketInformationRepository repository) {
        this.repository = repository;
    }

    public void add (TicketInformation item) {
        repository.save(item);
    }

    public TicketInformation[] findAll(String airportFrom, String airportTo) {
        TicketInformation[] result = new TicketInformation[0];
        for (TicketInformation airRoute : repository.findAll()) {
            if (airRoute.getAirportFrom().equalsIgnoreCase(airportFrom) && airRoute.getAirportTo().equalsIgnoreCase(airportTo)) {
                TicketInformation[] tmp = new TicketInformation[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = airRoute;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }


}


