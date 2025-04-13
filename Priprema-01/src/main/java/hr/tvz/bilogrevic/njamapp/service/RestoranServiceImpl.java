package hr.tvz.bilogrevic.njamapp.service;

import hr.tvz.bilogrevic.njamapp.dto.RestoranDTO;
import hr.tvz.bilogrevic.njamapp.model.Restoran;
import hr.tvz.bilogrevic.njamapp.repository.RestoranRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestoranServiceImpl implements RestoranService {

    private RestoranRepository restoranRepository;

    public RestoranServiceImpl(RestoranRepository restoranRepository) {
        this.restoranRepository = restoranRepository;
    }

    @Override
    public List<RestoranDTO> findAll() {
        return restoranRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public RestoranDTO findRestoranByID(Long id) {
        return restoranRepository.findRestoranByID(id).stream().map(this::convertToDTO).findFirst().orElse(null);
    }

    @Override
    public List<RestoranDTO> findNajblizi(String adresa) {
        return restoranRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public List<RestoranDTO> findNajbolji(BigDecimal ocjena) {
        return restoranRepository.findAll().stream().filter(r -> r.getProsjecnaOcjenaKupca().compareTo(ocjena) >= 0).map(this::convertToDTO).collect(Collectors.toList());
    }

    private RestoranDTO convertToDTO(Restoran restoran) {
        return new RestoranDTO(
                restoran.getSifra(), restoran.getIme(), restoran.getAdresa(),
                restoran.getOtvoreno(), BigDecimal.valueOf(Math.random() * 100)
        );
    }
}
