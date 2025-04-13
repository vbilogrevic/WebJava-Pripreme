package hr.tvz.bilogrevic.njamapp.repository;

import hr.tvz.bilogrevic.njamapp.model.Restoran;

import java.util.List;
import java.util.Optional;

public interface RestoranRepository {

    List<Restoran> findAll();
    Optional<Restoran> findRestoranByID(Long id);
}
