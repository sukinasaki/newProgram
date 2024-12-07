package com.example.demo.domain.repository.jdbc;

import com.example.demo.domain.model.InfoTable;
import com.example.demo.domain.repository.InfoTableDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository("InfoTableDaoJdbc")
public class InfoTableDaoJdbc implements InfoTableDao
{
    @Autowired
    JdbcTemplate jdbc;

    // InfoTableテーブルにデータを1件insert.
    @Override
    public int insertOne(InfoTable infoTable) throws DataAccessException
    {
        // 1件登録
        int rowNumber = jdbc.update(
                "INSERT INTO infoTable(No," + " Title," + " Gensaku," + " Sakuga," + " Other)"
                        + " VALUES(?, ?, ?, ?, ?)",
                infoTable.getNo(), infoTable.getTitle(), infoTable.getGensaku(), infoTable.getSakuga(), infoTable.getOther());
        return rowNumber;
    }

    // InfoTableテーブルのデータを1件取得
    @Override
    public InfoTable selectOne(int infoTableId) throws DataAccessException
    {
        // 1件取得
        Map<String, Object> map = jdbc.queryForMap("SELECT * FROM infoTable" + " WHERE No = ?", infoTableId);
        // 結果返却用の変数
        InfoTable infoTable = new InfoTable();
        // 取得したデータを結果返却用の変数にセットしていく
        infoTable.setNo((Integer) map.get("No"));
        infoTable.setTitle((String) map.get("Title"));
        infoTable.setGensaku((String) map.get("Gensaku"));
        infoTable.setSakuga((String) map.get("Sakuga"));
        infoTable.setOther((String) map.get("Other"));
        return infoTable;
    }

    // InfoTableテーブルの全データを取得
    @Override
    public List<InfoTable> selectMany() throws DataAccessException
    {
        // INFOTABLEテーブルのデータを全件取得
        List<Map<String, Object>> getList = jdbc.queryForList("SELECT * FROM infoTable");
        // 結果返却用の変数
        List<InfoTable> infoTableList = new ArrayList<>();
        // 取得したデータを結果返却用のListに格納していく
        for (Map<String, Object> map : getList) {
            // InfoTableインスタンスの生成
            InfoTable infoTable = new InfoTable();
            // InfoTableインスタンスに取得したデータをセットする
            infoTable.setNo((Integer) map.get("No")); // ユーザーID
            infoTable.setTitle((String) map.get("Title")); // パスワード
            infoTable.setGensaku((String) map.get("Gensaku")); // ユーザー名
            infoTable.setSakuga((String) map.get("Sakuga")); // 年齢
            infoTable.setOther((String) map.get("Other")); // ロール
            // 結果返却用のListに追加
            infoTableList.add(infoTable);
        }
        return infoTableList;
    }

    // InfoTableテーブルを1件更新.
    @Override
    public int updateOne(InfoTable infoTable) throws DataAccessException
    {
        // 1件更新
        int rowNumber = jdbc.update(
                "UPDATE infoTable" + " SET" + " Title = ?," + " Gensaku = ?," + " Sakuga = ?" + " WHERE No = ?",
                infoTable.getTitle(), infoTable.getGensaku(), infoTable.getSakuga(), infoTable.getNo());
        return rowNumber;
    }

    // InfoTableテーブルを1件削除
    @Override
    public int deleteOne(String No) throws DataAccessException
    {
        // 1件削除
        int rowNumber = jdbc.update("DELETE FROM infoTable WHERE No = ?", No);
        return rowNumber;
    }
}