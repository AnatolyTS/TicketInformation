package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class TicketInformation implements Comparable <TicketInformation> {
    private int id;
    private int price;
    private String airportFrom;
    private String airportTo;
    private int travelTimeMin;

    @Override
    public int compareTo(TicketInformation o) {
        return price - o.price;
    }
}
