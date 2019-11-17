package com.example.finalexam07600650.DB;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "ledger")
public class LedgerItem {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "fullname")
    public String fullname;

    @ColumnInfo(name = "username")
    public String username;

    @ColumnInfo(name = "password")
    public String password;

    public LedgerItem(int id, String fullname, String username,String password) {
        this.id = id;
        this.fullname = fullname;
        this.username = username;
        this.password = password;
    }
}
