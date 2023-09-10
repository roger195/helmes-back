package helmes.back.sectors;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="sectors")
@Getter
@Setter
@NoArgsConstructor
public class Sector {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer key;
    private String label;
    private Integer parentSectorKey;

    public Sector(Integer key, String label, Integer parentSectorKey) {
        this.key = key;
        this.label = label;
        this.parentSectorKey = parentSectorKey;
    }
}
