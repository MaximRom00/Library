package by.rom.restapi.repository;

import by.rom.restapi.entity.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
/**
 * Base class for all repositories.
 * @param <ENTITY> Entity class.
 *
 */
@NoRepositoryBean
public interface BaseRepository <ENTITY extends BaseEntity> extends JpaRepository<ENTITY, Long> {

}
