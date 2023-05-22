package ay.fazy_tech.fitfolio.services;

import ay.fazy_tech.fitfolio.dtos.serie.SerieCreateDto;
import ay.fazy_tech.fitfolio.dtos.serie.SerieFullDto;

import java.util.List;

public interface SerieService {
    SerieFullDto createSerie(SerieCreateDto serieCreateDto);
    List<SerieFullDto> getAll();
    SerieFullDto getById(String id);
    void updateSerie(SerieCreateDto updatedSerie, String id);
    void deleteSerie(String id);
}