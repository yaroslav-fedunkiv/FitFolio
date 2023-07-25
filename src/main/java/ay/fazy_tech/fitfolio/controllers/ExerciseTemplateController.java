package ay.fazy_tech.fitfolio.controllers;

import ay.fazy_tech.fitfolio.dtos.exercise_template.ExerciseTemplateCreateDto;
import ay.fazy_tech.fitfolio.dtos.exercise_template.ExerciseTemplateFullDto;
import ay.fazy_tech.fitfolio.dtos.user.UserFullDto;
import ay.fazy_tech.fitfolio.exceptions.NoSuchUserFoundException;
import ay.fazy_tech.fitfolio.services.ExerciseTemplateService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * @author Anna Zelener
 */
@Log4j2
@RestController
@RequestMapping("/api/exercise_template")
public class ExerciseTemplateController {
    @Resource
    private ExerciseTemplateService exerciseTemplateService;

    @Operation(summary = "Create a new exercise template")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "A new exercise is created", content = @Content),
            @ApiResponse(responseCode = "400", description = "Invalid data is provided. Exercise template is not created.", content = @Content)})
    @PostMapping("/create")
    public ResponseEntity<Object> createExerciseTemplate(@io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Object Exercise Template is to be created") @RequestBody @Valid ExerciseTemplateCreateDto exerciseTemplateCreateDto) {
        log.info("Request to createExerciseTemplate :{}", exerciseTemplateCreateDto);
        exerciseTemplateService.createExerciseTemplate(exerciseTemplateCreateDto);
        return new ResponseEntity<>(": Exercise Template with a title --> " + exerciseTemplateCreateDto.getTitle() + " -- was created!", HttpStatus.OK);
    }


    @Operation(summary = "Get Exercise Template by its id")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Exercise Template is found", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = UserFullDto.class))}),
            @ApiResponse(responseCode = "400", description = "An invalid id is provided", content = @Content),
            @ApiResponse(responseCode = "404", description = "Exercise Template  is not found", content = @Content)})
    @GetMapping("/get/{id}")
    public ResponseEntity<Object> getExerciseTemplate(@Parameter(description = "Exercise Template's id to be searched") @PathVariable String id) {
        log.info("Request to getExerciseTemplate --> {}", id);
        try {
            if (exerciseTemplateService.getExerciseTemplate(id).isEmpty()) {
                log.warn("No user is found with a given title : {} !", id);
                return new ResponseEntity<>(id + " --> An invalid title provided!", HttpStatus.BAD_REQUEST);
            } else {
                Optional<ExerciseTemplateFullDto> exerciseTemplate = exerciseTemplateService.getExerciseTemplate(id);
                log.info("Request to get Exercise Template by id :{}", id);
                return new ResponseEntity<>(exerciseTemplate, HttpStatus.OK);
            }
        } catch (NoSuchElementException e) {
            log.error("Exercise Template with such an id {} doesn't exist", id);
            return new ResponseEntity<>(id + " -- Exercise Template with such an id {} doesn't exist!", HttpStatus.NOT_FOUND);
        }
    }
}
