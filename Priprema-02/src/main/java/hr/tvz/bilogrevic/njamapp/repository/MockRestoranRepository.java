package hr.tvz.bilogrevic.njamapp.repository;

import hr.tvz.bilogrevic.njamapp.model.Restoran;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.*;

@Repository
public class MockRestoranRepository implements RestoranRepository {

    private final List<Restoran> restorani = new ArrayList<>();

    public MockRestoranRepository() {
        Restoran prvi = new Restoran(1L, "Batak Grill", "Rotor 12", "014521564",
                Map.of("pon-pet", "10:00-22:00", "sub-ned", "12:00-23:00"), true, new BigDecimal(30),
                new BigDecimal(4.5), 10, 2, "Najbolji cevapi");

        Restoran drugi = new Restoran(2L, "KFC", "Ilica 12", "014574931",
                Map.of("pon-ned", "07:00-23:30"), true, new BigDecimal(15),
                new BigDecimal(4.0), 30, 1, "Solidni burgeri");

        restorani.add(prvi);
        restorani.add(drugi);
    }


    @Override
    public List<Restoran> findAll() {
        return restorani;
    }

    @Override
    public Optional<Restoran> findRestoranByID(Long id) {
        return restorani.stream().filter(r -> r.getSifra().equals(id)).findFirst();
    }

    @Override
    public void deleteRestoranByID(Long id) {
        restorani.removeIf(r -> r.getSifra().equals(id));
    }

    @Override
    public List<Restoran> findRestoranByName(String restoranName) {
        return findAll().stream().filter(r -> r.getIme().toLowerCase().contains(restoranName.toLowerCase())).toList();
    }

    @Override
    public Optional<Restoran> saveRestoran(Restoran restoran) {
        Long generatedId = generateNewRestoranId();
        restoran.setSifra(generatedId);
        restorani.add(restoran);
        return Optional.of(restoran);
    }

    private Long generateNewRestoranId() {
        Optional<Restoran> lastPrimaryKeyValueOptional = restorani.stream()
                .max((fi1, fi2) -> fi1.getSifra().compareTo(fi2.getSifra()));

        if(lastPrimaryKeyValueOptional.isPresent()) {
            Restoran restoran = lastPrimaryKeyValueOptional.get();
            return restoran.getSifra() + 1;
        }
        else {
            return 1L;
        }
    }


}
