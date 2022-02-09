package by.rom.restapi.service;


import by.rom.restapi.dto.BaseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *  Interface CRUD service.
 *
 * @param <DTO> DTO class.
 */
@Service
public interface BaseService< DTO extends BaseDTO>{

    DTO getById(Long id);

    List<DTO> getAll();

    DTO saveOrUpdate(DTO dto);

    void deleteById(Long id);
}
