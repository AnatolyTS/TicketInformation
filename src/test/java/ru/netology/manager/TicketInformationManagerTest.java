package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.TicketInformation;
import ru.netology.repository.TicketInformationRepository;

import static org.junit.jupiter.api.Assertions.*;

class TicketInformationManagerTest {
    private TicketInformationRepository repository = new TicketInformationRepository();
    private TicketInformationManager manager = new TicketInformationManager(repository);
    private TicketInformation first = new TicketInformation(1, 15_000, "DME", "KZ", 360 );
    private TicketInformation second = new TicketInformation(2, 15_000, "DME", "EGO", 90 );
    private TicketInformation third = new TicketInformation(3, 15_000, "DME", "KUF", 120 );
    private TicketInformation forth = new TicketInformation(4, 15_000, "DME", "ASF", 155 );
    private TicketInformation fifth = new TicketInformation(5, 15_000, "DME", "KZ", 240 );

    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(forth);
        manager.add(fifth);
    }

    @Test
    public void shouldNotFind() {
        String airportFrom = "PAR";
        String airportTo = "CPH";

        TicketInformation[] expected = new TicketInformation[0];
        TicketInformation[] actual = manager.findAll(airportFrom, airportTo);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindFirst() {
        String airportFrom = "DME";
        String airportTo = "PAR";

        TicketInformation[] expected = new TicketInformation[0];
        TicketInformation[] actual = manager.findAll(airportFrom, airportTo);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindSecond() {
        String airportFrom = "DME";
        String airportTo = "EGO";

        TicketInformation[] expected = new TicketInformation[]{second};
        TicketInformation[] actual = manager.findAll(airportFrom, airportTo);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAll() {
        String airportFrom = "DME";
        String airportTo = "KZ";

        TicketInformation[] expected = new TicketInformation[]{first, fifth};
        TicketInformation[] actual = manager.findAll(airportFrom, airportTo);
        assertArrayEquals(expected, actual);
    }
}