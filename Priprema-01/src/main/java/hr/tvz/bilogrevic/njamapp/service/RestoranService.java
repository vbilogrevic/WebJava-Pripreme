package hr.tvz.bilogrevic.njamapp.service;

import hr.tvz.bilogrevic.njamapp.dto.RestoranDTO;

import java.math.BigDecimal;
import java.util.List;

public interface RestoranService {

    List<RestoranDTO> findAll();
    RestoranDTO findRestoranByID(Long id);
    List<RestoranDTO> findNajblizi(String adresa);
    List<RestoranDTO> findNajbolji(BigDecimal ocjena);

}
