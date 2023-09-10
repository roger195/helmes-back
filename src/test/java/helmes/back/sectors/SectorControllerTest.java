package helmes.back.sectors;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.List;

@WebMvcTest(SectorController.class)
public class SectorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SectorService sectorService;

    @Test
    public void testGetSectors() throws Exception {
        List<SectorDTO> mockSectors = List.of(
                new SectorDTO(1, "Sector A", null),
                new SectorDTO(2, "Sector B", null)
        );

        when(sectorService.buildSectorHierarchy()).thenReturn(mockSectors);

        mockMvc.perform(get("/sectors")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].key").value(1))
                .andExpect(jsonPath("$[0].label").value("Sector A"))
                .andExpect(jsonPath("$[1].key").value(2))
                .andExpect(jsonPath("$[1].label").value("Sector B"));
    }
}