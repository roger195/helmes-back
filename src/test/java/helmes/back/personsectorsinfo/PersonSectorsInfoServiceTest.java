package helmes.back.personsectorsinfo;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@SpringBootTest
public class PersonSectorsInfoServiceTest {

    @Mock
    private PersonSectorsInfoRepository personSectorsInfoRepository;

    @Mock
    private PersonInfoRepository personInfoRepository;

    @InjectMocks
    private PersonSectorsInfoService personSectorsInfoService;

    @Test
    public void testGetPersonSectorsInfo() {
        String sessionId = "sampleSessionId";
        PersonInfo personInfo = new PersonInfo("John Doe", sessionId, true);
        List<PersonSectorsInfo> personSectorsInfos = List.of(
                new PersonSectorsInfo(personInfo.getId(), 1),
                new PersonSectorsInfo(personInfo.getId(), 2)
        );

        when(personInfoRepository.findBySessionId(sessionId)).thenReturn(personInfo);
        when(personSectorsInfoRepository.findAllByPersonId(personInfo.getId())).thenReturn(personSectorsInfos);

        PersonSectorsInfoDTO resultDTO = personSectorsInfoService.getPersonSectorsInfo(sessionId);

        assertEquals("John Doe", resultDTO.name());
        assertTrue(resultDTO.isTermsAccepted());
        assertEquals(Map.of(1, true, 2, true), resultDTO.selectedSectors());
    }

    @Test
    public void testSavePersonSectorsInfo() {
        String sessionId = "sampleSessionId";
        PersonSectorsInfoDTO dtoToSave = new PersonSectorsInfoDTO("Jane Doe", Map.of(3, true, 4, true), true);

        PersonInfo existingPersonInfo = new PersonInfo("Existing Person", sessionId, true);
        when(personInfoRepository.findBySessionId(sessionId)).thenReturn(existingPersonInfo);

        personSectorsInfoService.savePersonSectorsInfo(dtoToSave, sessionId);

        verify(personInfoRepository, times(1)).findBySessionId(sessionId);
        verify(personInfoRepository, times(1)).save(existingPersonInfo);
        verify(personSectorsInfoRepository, times(1)).deleteAllByPersonId(existingPersonInfo.getId());
        verify(personSectorsInfoRepository, times(2)).save(any(PersonSectorsInfo.class));
    }
}