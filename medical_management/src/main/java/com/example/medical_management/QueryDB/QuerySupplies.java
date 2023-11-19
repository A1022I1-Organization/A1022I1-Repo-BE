package com.example.medical_management.QueryDB;

public class QuerySupplies {
    public static final String FIND_OLD_SUPPLIES_PAGE = "SELECT * FROM medical_supplies WHERE import_date != current_date() AND delete_flag  = 0 ";

    public static final String FIND_NEW_SUPPLIES_PAGE = "SELECT * FROM medical_supplies WHERE import_date = current_date() AND delete_flag  = 0 ";

    public static final String DELETE_SUPPLY = "UPDATE medical_supplies SET medical_supplies.delete_flag = 1 WHERE medical_supplies.medical_supplies_id = :supplyId";

//    public static final String GET_EXPIRED_SUPPLIES = "SELECT * FROM `medical_management`.`medical_supplies`\n" +
//            "WHERE `expiry` < CURDATE();";

    public static final String GET_ALL_BETWEEN_DAYS = "SELECT code, expiry, import_date, name, quantity\n" +
            "FROM medical_management.medical_supplies\n" +
            "WHERE import_date < STR_TO_DATE(:lastDateInput, '%Y-%m-%d');";

//    public static final String GET_ALL_BETWEEN_DAYS = "SELECT *, CASE WHEN expiry > STR_TO_DATE(:firstDateInput, '%Y-%m-%d') THEN quantity ELSE NULL END AS expired_product_quantity\n" +
//            "FROM medical_management.medical_supplies\n" +
//            "WHERE import_date BETWEEN STR_TO_DATE(:firstDateInput, '%Y-%m-%d') AND STR_TO_DATE(:lastDateInput, '%Y-%m-%d');";
}
