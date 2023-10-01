package helmes.back.sectors;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SectorService {

    private final SectorRepository sectorRepository;

    public SectorService(SectorRepository sectorRepository) {
        this.sectorRepository = sectorRepository;
    }

    public List<SectorDTO> buildSectorHierarchy() {
        List<SectorDTO> rootSectorDTOs = new ArrayList<>();
        List<Sector> rootSectors = sectorRepository.findAllByParentSectorKey(null);
        rootSectors.forEach(
                sector -> rootSectorDTOs
                        .add(new SectorDTO(
                                sector.getKey(),
                                sector.getLabel(),
                                subSectorMapper(sector.getKey()))
                        )
        );
        return rootSectorDTOs;
    }

    List<SectorDTO> subSectorMapper(Integer parentKey) {
        List<Sector> subSectors = sectorRepository.findAllByParentSectorKey(parentKey);
        if(subSectors.isEmpty()) return null;

        List<SectorDTO> sectorDTOS = new ArrayList<>();
        for (Sector sector : subSectors) {
            SectorDTO sectorDTO = new SectorDTO(
                    sector.getKey(),
                    sector.getLabel(),
                    subSectorMapper(sector.getKey())
            );
            sectorDTOS.add(sectorDTO);
        }
        return sectorDTOS;
    }
}
