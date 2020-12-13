package ru.netology.repository;

import ru.netology.domain.TicketInformation;
import ru.netology.exception.NotFoundException;

public class TicketInformationRepository {
    private TicketInformation[] items = new TicketInformation[0];

    public void save(TicketInformation item) {
        int length = items.length + 1;
        TicketInformation[] tmp = new TicketInformation[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public TicketInformation[] findAll() {
        return items;
    }


    public TicketInformation findById(int id) {
        for (TicketInformation product : items) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public void removeById(int id) {
        if (findById(id) == null) {
            throw new NotFoundException("Element with id " + id + " not found");
        }
        int length = items.length - 1;
        TicketInformation[] tmp = new TicketInformation[length];
        int index = 0;
        for (TicketInformation item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
    }
}
