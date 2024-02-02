package com.example.na_data_2023_app;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class DBmanage extends AppCompatActivity {

    SQLiteDatabase sqlDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SQLiteHelper sqLiteHelper = new SQLiteHelper(this);

        // 데이터 추가
        sqLiteHelper.insertData("두번째 질문");

        // 데이터 삭제
        //sqLiteHelper.deleteData("7");

        // 데이터 조회
        Cursor cursor;
        cursor = sqLiteHelper.getAllData();
        if(cursor.getCount() == 0){
            System.out.println("데이터 없음");
            return;
        }
        StringBuffer buffer = new StringBuffer();
        while(cursor.moveToNext()){
            buffer.append("Id : "+ cursor.getString(0) + "\n");
            buffer.append("Question : "+ cursor.getString(1) + "\n");
        }
        System.out.println(buffer);

        cursor.close();
        //sqlDB.close(); // App Inspection 탭에서 db가 closed

    }
}