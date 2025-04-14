package hr.tvz.bilogrevic.njamapp.service;

import hr.tvz.bilogrevic.njamapp.command.RestoranCommand;
import hr.tvz.bilogrevic.njamapp.dto.RestoranDTO;
import hr.tvz.bilogrevic.njamapp.model.Restoran;
import hr.tvz.bilogrevic.njamapp.repository.RestoranRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
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
    public void deleteRestoranByID(Long id) {
        restoranRepository.deleteRestoranByID(id);
    }

    @Override
    public List<RestoranDTO> findRestoranByName(String restoranName) {
        return restoranRepository.findRestoranByName(restoranName).stream()
                .map(this::convertToDTO).toList();
    }

    @Override
    public Optional<RestoranCommand> saveRestoranDTO(RestoranCommand restoranCommand) {
        Optional<Restoran> saveRestoran = restoranRepository.saveRestoran(convertCommandToRestoran(restoranCommand));
        return convertRestoranToCommand(saveRestoran);
    }

    private Optional<RestoranCommand> convertRestoranToCommand(Optional<Restoran> restoranOptional) {

        if(restoranOptional.isEmpty()) {
            return Optional.empty();
        }
        else {
            return Optional.of(new RestoranCommand(
                    restoranOptional.get().getSifra(),
                    restoranOptional.get().getIme(),
                    restoranOptional.get().getAdresa(),
                    restoranOptional.get().getBrojTelefona(),
                    restoranOptional.get().getRadnoVrijeme(),
                    restoranOptional.get().getOtvoreno(),
                    restoranOptional.get().getProsjecnoVrijemeDostave(),
                    restoranOptional.get().getProsjecnaOcjenaKupca(),
                    restoranOptional.get().getMaksimalniBrojNarudzbi(),
                    restoranOptional.get().getMichelinStar(),
                    restoranOptional.get().getKratakOpis()));
        }
    }

    private Restoran convertCommandToRestoran(RestoranCommand restoranCommand) {
        return new Restoran(
                restoranCommand.getSifra(),
                restoranCommand.getIme(),
                restoranCommand.getAdresa(),
                restoranCommand.getBrojTelefona(),
                restoranCommand.getRadnoVrijeme(),
                restoranCommand.getOtvoreno(),
                restoranCommand.getProsjecnoVrijemeDostave(),
                restoranCommand.getProsjecnaOcjenaKupca(),
                restoranCommand.getMaksimalniBrojNarudzbi(),
                restoranCommand.getMichelinStar(),
                restoranCommand.getKratakOpis());
    }

    private RestoranDTO convertToDTO(Restoran restoran) {
        return new RestoranDTO(
                restoran.getSifra(), restoran.getIme(), restoran.getAdresa(),
                restoran.getOtvoreno(), BigDecimal.valueOf(Math.random() * 100)
        );
    }
}
