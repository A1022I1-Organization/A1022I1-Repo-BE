package com.example.medical_management.repository.medical;

import com.example.medical_management.QueryDB.QuerySupplies;
import com.example.medical_management.dto.MedicalSuppliesDto;
import com.example.medical_management.model.medical_supplies.MedicalSupplies;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.parameters.P;

import java.util.Date;
import java.util.List;

import java.util.List;

public interface IMedicalRepository extends JpaRepository<MedicalSupplies, Long> {
    @Query(value = QuerySupplies.FIND_OLD_SUPPLIES_PAGE, nativeQuery = true)
    Page<MedicalSupplies> findOldSupplies(Pageable pageable);

    @Query(value = QuerySupplies.FIND_NEW_SUPPLIES_PAGE, nativeQuery = true)
    Page<MedicalSupplies> findNewSupplies(Pageable pageable);

    @Query(value = QuerySupplies.GET_ALL_BETWEEN_DAYS, nativeQuery = true)
    List<Object[]> findAllBetweenDays(@Param("lastDateInput") String lastDateInput);

    @Modifying
    @Query(value = QuerySupplies.DELETE_SUPPLY, nativeQuery = true)
    void deleteById(@Param("supplyId") long id);

    @Query(value = "SELECT * FROM medical_management.medical_supplies where category_id like concat ('%', :category ,'%') limit 0, :page ",nativeQuery = true )
    List<MedicalSupplies> getAllListWithPage(@Param("category")String category,@Param("page")int page);

    @Query(value = "SELECT * FROM medical_supplies ORDER BY medical_supplies_id DESC LIMIT 1",nativeQuery = true )
    MedicalSupplies getLastSupply();
}
