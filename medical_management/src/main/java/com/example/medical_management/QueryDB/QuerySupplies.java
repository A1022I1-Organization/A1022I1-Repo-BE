package com.example.medical_management.QueryDB;

public class QuerySupplies {
    public static final String FIND_OLD_SUPPLIES_PAGE = "SELECT * FROM medical_supplies WHERE import_date <= current_date() AND delete_flag  = 0 ORDER BY expiry ASC";

    public static final String FIND_NEW_SUPPLIES_PAGE = "SELECT * FROM medical_supplies WHERE import_date = current_date() AND delete_flag  = 0 ORDER BY expiry ASC";

    public static final String FIND_SUPPLY_TYPE = "SELECT * FROM medical_supplies WHERE category_id = :typeId AND delete_flag  = 0 ORDER BY expiry ASC";

    public static final String FIND_SUPPLIER = "SELECT * FROM medical_supplies WHERE supplier_id = :supplierId AND delete_flag  = 0 ORDER BY expiry ASC";

    public static final String FIND_EXPIRY_SUPPLY = "SELECT * FROM medical_supplies WHERE :fromDate <= expiry <= :toDate AND delete_flag  = 0 ORDER BY expiry ASC";

    public static final String FIND_SUPPLY_NAME = "SELECT * FROM medical_supplies WHERE name like '%:name%' AND delete_flag  = 0 ORDER BY expiry ASC";

    public static final String DELETE_SUPPLY = "UPDATE medical_supplies SET medical_supplies.delete_flag = 1 WHERE medical_supplies.medical_supplies_id = :supplyId";

    public static final String GET_EXPIRED_SUPPLIES = "SELECT * FROM `medical_management`.`medical_supplies`\n" +
            "WHERE `expiry` < CURDATE();";
}
