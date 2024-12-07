package com.example.demo.domain.service;

import com.example.demo.domain.model.InfoTable;
import com.example.demo.domain.repository.InfoTableDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class SearchService
{
    @Autowired
    @Qualifier("InfoTableDaoJdbc")
    InfoTableDao dao;

    // 一件追加用メソッド
    public boolean insert(InfoTable infoTable)
    {
        // insert実行
        int rowNumber = dao.insertOne(infoTable);
        // 判定用変数
        boolean result = false;
        if (rowNumber > 0)
        {
            // insert成功
            result = true;
        }
        return result;
    }

    // 全件取得用メソッド
    public List<InfoTable> selectMany()
    {
        // 全件取得
        return dao.selectMany();
    }

    // 1件取得用メソッド
    public InfoTable selectOne(int No)
    {
        // selectOne実行
        return dao.selectOne(No);
    }

    // 1件更新メソッド
    public boolean updateOne(InfoTable infoTable)
    {
        // 1件更新
        int rowNumber = dao.updateOne(infoTable);
        // 判定用変数
        boolean result = false;
        if (rowNumber > 0)
        {
            // update成功
            result = true;
        }
        return result;
    }

    // 1件削除メソッド
    public boolean deleteOne(String infoTableId)
    {
        // 1件削除
        int rowNumber = dao.deleteOne(infoTableId);
        // 判定用変数
        boolean result = false;
        if (rowNumber > 0)
        {
            // delete成功
            result = true;
        }
        return result;
    }
}
