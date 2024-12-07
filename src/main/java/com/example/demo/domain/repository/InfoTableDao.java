package com.example.demo.domain.repository;

import java.util.List;

import com.example.demo.domain.model.InfoTable;
import org.springframework.dao.DataAccessException;


public interface InfoTableDao 
{
    // InfoTableテーブルにデータを1件insert
    public int insertOne(InfoTable infoTable) throws DataAccessException;

    // InfoTableテーブルのデータを1件取得
    public InfoTable selectOne(String No) throws DataAccessException;

    // InfoTableテーブルの全データを取得
    public List<InfoTable> selectMany() throws DataAccessException;

    // InfoTableテーブルを1件更新
    public int updateOne(InfoTable infoTable) throws DataAccessException;

    // InfoTableテーブルを1件削除
    public int deleteOne(String No) throws DataAccessException;
}
