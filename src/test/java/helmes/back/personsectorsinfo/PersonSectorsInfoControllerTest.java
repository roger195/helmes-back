package helmes.back.personsectorsinfo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Map;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(PersonSectorsInfoController.class)
public class PersonSectorsInfoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PersonSectorsInfoService personSectorsInfoService;

    @Test
    public void testGetPersonSectorsInfo() throws Exception {
        String sessionId = "sampleSessionId";
        PersonSectorsInfoDTO expectedDTO = new PersonSectorsInfoDTO("John Doe", Map.of(1, true, 2, true), true);

        when(personSectorsInfoService.getPersonSectorsInfo(sessionId)).thenReturn(expectedDTO);

        mockMvc.perform(get("/person-sectors-info")
                        .header("SessionId", sessionId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value("John Doe"))
                .andExpect(jsonPath("$.isTermsAccepted").value(true));
    }

    @Test
    public void testSavePersonSectorsInfo() throws Exception {
        String sessionId = "sampleSessionId";
        PersonSectorsInfoDTO dtoToSave = new PersonSectorsInfoDTO("Jane Doe", Map.of(3, true, 4, true), true);

        mockMvc.perform(post("/person-sectors-info")
                        .header("SessionId", sessionId)
                        .content(asJsonString(dtoToSave))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    private String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
