package hr.tvz.bilogrevic.njamapp.controller;

import hr.tvz.bilogrevic.njamapp.dto.RestoranDTO;
import hr.tvz.bilogrevic.njamapp.repository.RestoranRepository;
import hr.tvz.bilogrevic.njamapp.service.RestoranService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/restoran")
@Slf4j
public class RestoranController {

    private RestoranService restoranService;

    public RestoranController(RestoranService restoranService) {
        this.restoranService = restoranService;
    }

    @GetMapping("/all")
    public List<RestoranDTO> getAllRestorans() {
        log.info("getAllRestorans called");
        return restoranService.findAll();
    }

    @GetMapping("/{id}")
    public RestoranDTO getRestoranById(@PathVariable Long id) {
        log.info("getRestoranById called");
        return restoranService.findRestoranByID(id);
    }
}
