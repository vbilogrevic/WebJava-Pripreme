package hr.tvz.bilogrevic.njamapp.controller;

import hr.tvz.bilogrevic.njamapp.command.RestoranCommand;
import hr.tvz.bilogrevic.njamapp.dto.RestoranDTO;
import hr.tvz.bilogrevic.njamapp.service.RestoranService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/id/{id}")
    public RestoranDTO getRestoranById(@PathVariable Long id) {
        log.info("getRestoranById called");
        return restoranService.findRestoranByID(id);
    }

    @GetMapping("/name/{name}")
    public List<RestoranDTO> getRestoranByName(@PathVariable String name) {
        log.info("getRestoranByName called");
        return restoranService.findRestoranByName(name);
    }

    @PostMapping("/add")
    public ResponseEntity<RestoranCommand> saveNewRestoran(@RequestBody @Valid RestoranCommand restoranCommand) {
        Optional<RestoranCommand> saveRestoranController = restoranService.saveRestoranDTO(restoranCommand);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveRestoranController.get());
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/delete/{id}")
    public void deleteRestoranByID(@PathVariable Long id) {
        log.info("deleteRestoranByID called");
        restoranService.deleteRestoranByID(id);
    }


}
