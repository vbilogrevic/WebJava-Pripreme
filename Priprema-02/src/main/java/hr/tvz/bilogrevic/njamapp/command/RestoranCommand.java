package hr.tvz.bilogrevic.njamapp.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Email;

import java.math.BigDecimal;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestoranCommand {

    @NotNull(message = "Šifra restorana ne smije biti null.")
    private Long sifra;

    @NotBlank(message = "Ime restorana je obavezno.")
    private String ime;

    @NotBlank(message ="Adresa restorana je obavezna.")
    private String adresa;

    @Pattern(
            regexp = "\\d{3,4}\\d{6,7}",
            message = "Broj telefona mora biti u formatu bez razmaka, npr. 014521564."
    )
    private String brojTelefona;

    @NotNull(message = "Radno vrijeme ne smije biti null.")
    private Map<String, String> radnoVrijeme;

    @NotNull(message = "Status radnog vremena mora biti naveden.")
    private Boolean otvoreno;

    @NotNull(message = "Prosjecno vrijeme dostave mora biti uneseno.")
    @PositiveOrZero(message = "Prosječno vrijeme dostave ne smije biti negativno.")
    private BigDecimal prosjecnoVrijemeDostave;

    @NotNull(message = "Prosjecno ocjena mora biti uneseno.")
    @PositiveOrZero(message = "Prosječno ocjena mora biti nula ili veća.")
    private BigDecimal prosjecnaOcjenaKupca;

    @NotNull(message = "Maksimalan broj narudžbi mora biti unesen.")
    @PositiveOrZero(message = "Maksimalan broj narudžbi mora biti nula ili veći.")
    private Integer maksimalniBrojNarudzbi;

    @PositiveOrZero(message = "Broj Michelin zvjezdica ne smije biti negativan.")
    private Integer michelinStar;

    @NotBlank(message = "Kratak opis je obavezan.")
    private String kratakOpis;

}
