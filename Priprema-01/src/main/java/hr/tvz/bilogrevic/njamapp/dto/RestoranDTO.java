package hr.tvz.bilogrevic.njamapp.dto;

import hr.tvz.bilogrevic.njamapp.model.Restoran;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Random;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestoranDTO {

    private Long sifra;
    private String ime;
    private String adresa;
    private Boolean otvoreno;
    private BigDecimal postotakOpterecenja;

    public RestoranDTO(Restoran restoran) {
        this.sifra = restoran.getSifra();
        this.ime = restoran.getIme();
        this.adresa = restoran.getAdresa();
        this.otvoreno = restoran.getOtvoreno();

        Random random = new Random();
        Integer postotak = random.nextInt(91, +10);
        this.postotakOpterecenja = BigDecimal.valueOf(postotak);
    }
}
