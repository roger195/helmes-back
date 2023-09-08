package helmes.back.sectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SectorService {

    @Autowired
    private SectorRepository sectorRepository;

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

    private List<SectorDTO> subSectorMapper(Integer parentKey) {
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
