package com.example.medical_management.repository.medical;

import com.example.medical_management.QueryDB.QuerySupplies;
import com.example.medical_management.dto.MedicalSuppliesDto;
import com.example.medical_management.model.medical_supplies.MedicalSupplies;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.parameters.P;

import java.sql.Date;
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

    @Query(value = QuerySupplies.FIND_SUPPLY_TYPE, nativeQuery = true)
    Page<MedicalSupplies> findByType(Pageable pageable, @Param("typeId") long id);

    @Query(value = QuerySupplies.FIND_SUPPLY_NAME, nativeQuery = true)
    Page<MedicalSupplies> findByName(Pageable pageable, @Param("name") String name);

    @Query(value = QuerySupplies.FIND_SUPPLIER, nativeQuery = true)
    Page<MedicalSupplies> findBySupplier(Pageable pageable, @Param("supplierId") long id);

    @Query(value = QuerySupplies.FIND_EXPIRY_SUPPLY, nativeQuery = true)
    Page<MedicalSupplies> findByExpiry(Pageable pageable, @Param("fromDate") Date fromDate, @Param("toDate") Date toDate);

//    @Query(value = QuerySupplies.GET_EXPIRED_SUPPLIES, nativeQuery = true)
//    List<MedicalSupplies> findExpiredSupplies();


    @Query(value = "SELECT * FROM medical_management.medical_supplies where category_id like concat ('%',:category,'%') ",nativeQuery = true )
//    @Query(value = "SELECT ms FROM MedicalSupplies ms where ms.category.id like concat ('%',:category,'%') " )
    List<MedicalSupplies> getAllListWithPage(@Param("category")String category ,  Pageable  sort );

    @Query(value = "SELECT * FROM medical_supplies ORDER BY medical_supplies_id DESC LIMIT 1",nativeQuery = true )
    MedicalSupplies getLastSupply();
}
