package hr.tvz.bilogrevic.njamapp.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Restoran {

    private Long sifra;
    private String ime;
    private String adresa;
    private String brojTelefona;
    private Map<String, String> radnoVrijeme;
    private Boolean otvoreno;
    private BigDecimal prosjecnoVrijemeDostave;
    private BigDecimal prosjecnaOcjenaKupca;
    private Integer maksimalniBrojNarudzbi;
}
