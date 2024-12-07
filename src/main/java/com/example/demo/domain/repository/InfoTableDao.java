package com.example.demo.domain.repository;

import java.util.List;

import com.example.demo.domain.model.InfoTable;
import org.springframework.dao.DataAccessException;


public interface InfoTableDao 
{
    // InfoTableテーブルにデータを1件insert
    int insertOne(InfoTable infoTable) throws DataAccessException;

    // InfoTableテーブルのデータを1件取得
    InfoTable selectOne(int No) throws DataAccessException;

    // InfoTableテーブルの全データを取得
    List<InfoTable> selectMany() throws DataAccessException;

    // InfoTableテーブルを1件更新
    int updateOne(InfoTable infoTable) throws DataAccessException;

    // InfoTableテーブルを1件削除
    int deleteOne(String No) throws DataAccessException;
}
