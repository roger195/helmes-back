package helmes.back.sectors;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class SectorServiceTest {

    @Mock
    private SectorRepository sectorRepository;

    @InjectMocks
    private SectorService sectorService;

    @Test
    public void testBuildSectorHierarchy() {
        // Prepare mock data
        List<Sector> mockSectors = List.of(
                new Sector(1, "Sector A", null),
                new Sector(2, "Sector B", null)
        );

        when(sectorRepository.findAllByParentSectorKey(null)).thenReturn(mockSectors);

        List<SectorDTO> result = sectorService.buildSectorHierarchy();

        assertEquals(2, result.size());
        assertEquals("Sector A", result.get(0).getLabel());
        assertEquals("Sector B", result.get(1).getLabel());
    }

    @Test
    public void testSubSectorMapper() {
        List<Sector> mockSubSectors = List.of(
                new Sector(3, "Subsector 1", 1),
                new Sector(4, "Subsector 2", 1)
        );

        when(sectorRepository.findAllByParentSectorKey(1)).thenReturn(mockSubSectors);

        List<SectorDTO> result = sectorService.subSectorMapper(1);

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Subsector 1", result.get(0).getLabel());
        assertEquals("Subsector 2", result.get(1).getLabel());
    }
}