package hr.tvz.bilogrevic.njamapp.service;

import hr.tvz.bilogrevic.njamapp.command.RestoranCommand;
import hr.tvz.bilogrevic.njamapp.dto.RestoranDTO;

import java.util.List;
import java.util.Optional;

public interface RestoranService {

    List<RestoranDTO> findAll();
    RestoranDTO findRestoranByID(Long id);
    void deleteRestoranByID(Long id);
    List<RestoranDTO> findRestoranByName(String restoranName);
    Optional<RestoranCommand> saveRestoranDTO(RestoranCommand restoranCommand);

}
