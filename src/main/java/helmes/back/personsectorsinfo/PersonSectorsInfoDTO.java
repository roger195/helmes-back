package helmes.back.personsectorsinfo;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Map;

public record PersonSectorsInfoDTO(
        @NotNull
        @NotBlank(message = "Name cannot be blank")
        String name,
        @NotNull
        Map<Integer, Boolean> selectedSectors,
        @AssertTrue
        Boolean isTermsAccepted) {
}
