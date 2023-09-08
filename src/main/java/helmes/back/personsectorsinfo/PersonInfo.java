package helmes.back.personsectorsinfo;

import jakarta.persistence.*;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="person_info")
@Getter
@Setter
@NoArgsConstructor
public class PersonInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String sessionId;
    private Boolean isTermsAccepted;

    public PersonInfo(String name, String sessionId, Boolean isTermsAccepted) {
        this.name = name;
        this.sessionId = sessionId;
        this.isTermsAccepted = isTermsAccepted;
    }
}
