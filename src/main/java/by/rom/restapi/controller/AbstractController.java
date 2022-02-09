package by.rom.restapi.controller;

import by.rom.restapi.dto.BaseDTO;
import by.rom.restapi.service.BaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * Here we implement all methods from base interface.
 * And after that we get all logic and rules for all controller entities.
 *
 * @param <DTO>
 * @param <SERVICE>
 */
public abstract class AbstractController<DTO extends BaseDTO, SERVICE extends BaseService<DTO>>
        implements BaseController<DTO> {

   private final SERVICE service;

    public AbstractController(SERVICE service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<List<DTO>> getAll() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<DTO> getById(long id) {
        return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<DTO> save(DTO dto) {
        return new ResponseEntity<>(service.saveOrUpdate(dto), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<DTO> update(DTO dto) {
        return new ResponseEntity<>(service.saveOrUpdate(dto), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> delete(long id) {
        service.deleteById(id);
        return new ResponseEntity<>("Delete was successful", HttpStatus.OK);
    }
}
