package helmes.back.personsectorsinfo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PersonSectorsInfoRepository extends JpaRepository<PersonSectorsInfo, Long> {

    List<PersonSectorsInfo> findAllByPersonId(Long personId);

    @Transactional
    void deleteAllByPersonId(Long personId);
}
