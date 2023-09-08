package helmes.back.personsectorsinfo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonInfoRepository extends JpaRepository<PersonInfo, Long> {

    PersonInfo findBySessionId(String sessionId);
}
