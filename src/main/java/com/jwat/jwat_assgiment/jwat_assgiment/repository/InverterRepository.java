package com.jwat.jwat_assgiment.jwat_assgiment.repository;

import com.jwat.jwat_assgiment.jwat_assgiment.entity.Inverter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface InverterRepository extends JpaRepository<Inverter, Integer> {

    @Query("""
               
                FROM Inverter i
                WHERE (:inverterName IS NULL OR i.inverterName = :inverterName)
                AND (:inverterCode IS NULL OR i.inverterCode = :inverterCode)
                AND (:isFlag IS NULL OR i.isFlag = :isFlag)
            """)
    Page<Inverter> findAllWithFilter(@Param("inverterName") String inverterName
            , @Param("inverterCode") String inverterCode
            , @Param("isFlag") Boolean isFlag, Pageable pageable);
}
