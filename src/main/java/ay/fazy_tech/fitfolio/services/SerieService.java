package ay.fazy_tech.fitfolio.services;

import ay.fazy_tech.fitfolio.dto.serie.CreateSerieDto;
import ay.fazy_tech.fitfolio.dto.serie.FullSerieDto;

import java.util.List;

public interface SerieService {
    FullSerieDto createSerie(CreateSerieDto createSerieDto);
    List<FullSerieDto> getAll();
    FullSerieDto getById(String id);
    void updateSerie(CreateSerieDto updatedSerie, String id);
    void deleteSerie(String id);
}