package com.example.medical_management.QueryDB;

public class QuerySupplies {
    public static final String FIND_OLD_SUPPLIES_PAGE = "SELECT * FROM medical_supplies WHERE import_date != current_date() ";

    public static final String FIND_NEW_SUPPLIES_PAGE = "SELECT * FROM medical_supplies WHERE import_date = current_date() ";
}
