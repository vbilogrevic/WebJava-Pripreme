package hr.tvz.bilogrevic.njamapp.repository;

import hr.tvz.bilogrevic.njamapp.model.Restoran;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.*;

@Repository
public class MockRestoranRepository implements RestoranRepository {

    @Override
    public List<Restoran> findAll() {
        Restoran prvi = new Restoran(1L, "Batak Grill", "Rotor 12", "014521564",
                Map.of("pon-pet", "10:00-22:00", "sub-ned", "12:00-23:00"), true, new BigDecimal(30),
                new BigDecimal(4.5), 10);
        Restoran drugi = new Restoran(2L, "KFC", "Ilica 12", "014574931",
                Map.of("pon-ned", "07:00-23:30"), true, new BigDecimal(15),
                new BigDecimal(4.0), 30);
        List<Restoran> restorani = new ArrayList<>();
        restorani.add(prvi);
        restorani.add(drugi);
        return restorani;
    }

    @Override
    public Optional<Restoran> findRestoranByID(Long id) {
        List<Restoran> restorani = findAll();
        return restorani.stream().filter(r -> r.getSifra().equals(id)).findFirst();
    }
}
