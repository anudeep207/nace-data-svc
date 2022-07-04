package co.luxoft.nace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.luxoft.nace.model.entity.NaceDataInfo;

/**
 * Nace details Repository
 *
 */
@Repository
public interface NaceDetailsRepository extends JpaRepository<NaceDataInfo, Integer> {

}
