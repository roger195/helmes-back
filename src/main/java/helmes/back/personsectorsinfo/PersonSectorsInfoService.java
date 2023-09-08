package helmes.back.personsectorsinfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PersonSectorsInfoService {

    @Autowired
    private PersonSectorsInfoRepository personSectorsInfoRepository;
    @Autowired
    private PersonInfoRepository personInfoRepository;

    public PersonSectorsInfoDTO getPersonSectorsInfo(String sessionId) {
        PersonInfo personInfo = personInfoRepository.findBySessionId(sessionId);
        if (personInfo == null) {
            return new PersonSectorsInfoDTO("", null, false);
        }
        List<PersonSectorsInfo> personSectorsInfos = personSectorsInfoRepository.findAllByPersonId(personInfo.getId());
        return new PersonSectorsInfoDTO(
                personInfo.getName(),
                mapSelectedSectors(personSectorsInfos),
                personInfo.getIsTermsAccepted()
        );
    }

    private Map<Integer, Boolean> mapSelectedSectors(List<PersonSectorsInfo> PersonSectorsInfos) {
        Map<Integer, Boolean> selectedSectorsMap = new HashMap<>();
        for (PersonSectorsInfo personSectorsInfo : PersonSectorsInfos) {
            selectedSectorsMap.put(personSectorsInfo.getSectorKey(), true);
        }
        return selectedSectorsMap;
    }

    public void savePersonSectorsInfo(PersonSectorsInfoDTO personSectorsInfoDTO, String sessionId) {
        PersonInfo personInfo = personInfoRepository.findBySessionId(sessionId);
        if (personInfo != null) {
            personInfo.setName(personSectorsInfoDTO.name());
            personInfo.setIsTermsAccepted(personSectorsInfoDTO.isTermsAccepted());
            personInfoRepository.save(personInfo);
            personSectorsInfoRepository.deleteAllByPersonId(personInfo.getId());
            savePersonSectorsInfo(personSectorsInfoDTO.selectedSectors(), personInfo.getId());
        }
        else {
            saveNewPersonInfo(personSectorsInfoDTO, sessionId);
            Long personId = personInfoRepository.findBySessionId(sessionId).getId();
            savePersonSectorsInfo(personSectorsInfoDTO.selectedSectors(), personId);
        }
    }

    private void savePersonSectorsInfo(Map<Integer, Boolean> selectedSectors, Long personId) {
        selectedSectors.forEach((sectorKey, selected) -> {
            personSectorsInfoRepository.save(new PersonSectorsInfo(personId, sectorKey));
        });
    }

    private void saveNewPersonInfo(PersonSectorsInfoDTO personSectorsInfoDTO, String sessionId){
        PersonInfo newPersonInfo = new PersonInfo(
                personSectorsInfoDTO.name(),
                sessionId,
                personSectorsInfoDTO.isTermsAccepted());
        personInfoRepository.save(newPersonInfo);
    }
}
