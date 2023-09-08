package helmes.back.personsectorsinfo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="person_sectors_info")
@Getter
@Setter
@NoArgsConstructor
public class PersonSectorsInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long personId;
    private Integer sectorKey;

    public PersonSectorsInfo(Long personId, Integer sectorKey) {
        this.personId = personId;
        this.sectorKey = sectorKey;
    }
}
