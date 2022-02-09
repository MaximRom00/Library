package by.rom.restapi.controller;

import by.rom.restapi.dto.BaseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
/**
 * Base class for all Controllers.
 * @param <DTO> DTO class.
 *
 */

public interface BaseController<DTO extends BaseDTO>{

    @GetMapping
    ResponseEntity<List<DTO>> getAll();

    @GetMapping("/{id}")
    ResponseEntity<DTO> getById(@PathVariable long id);

    @PostMapping
    ResponseEntity<DTO> save(@Valid @RequestBody DTO dto);

    @PutMapping
    ResponseEntity<DTO> update(@Valid @RequestBody DTO dto);

    @DeleteMapping("/{id}")
    ResponseEntity<String> delete(@PathVariable long id);
}
