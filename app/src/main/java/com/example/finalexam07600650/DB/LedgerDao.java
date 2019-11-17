package com.example.finalexam07600650.DB;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface LedgerDao {

    @Query("SELECT * FROM ledger")
    List<LedgerItem> getAll();


    @Query("select * from ledger where username = :username and password = :password")
    List<LedgerItem> getAll(String username,String password);


    @Insert
    void insert(LedgerItem ledgerItem);
}
