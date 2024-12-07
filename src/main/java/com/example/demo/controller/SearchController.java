package com.example.demo.controller;

import java.util.List;

import com.example.demo.domain.model.InfoTable;
import com.example.demo.domain.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchController {
    @Autowired
    SearchService searchService;

    // 一件追加用メソッド
    @PostMapping("/insert")
    public String insert(@RequestBody InfoTable infotable)
    {
        String result = "";
        if (searchService.insert(infotable))
            result = "一件追加しました！";
        else
            result = "追加失敗しました！";
        return result;
    }

    // 全件取得用メソッド
    @GetMapping("/selectMany")
    public List<InfoTable> selectMany()
    {
        // 全件取得
        return searchService.selectMany();
    }

    // 1件取得用メソッド
    @GetMapping("/selectOne/{id:[0-9]+}")
    public InfoTable selectOne(@PathVariable("id") int No)
    {
        // selectOne実行
        return searchService.selectOne(No);
    }

    // 1件更新メソッド
    @PostMapping("/updateOne")
    public String updateOne(@RequestBody InfoTable infotable)
    {
        String result = "";
        if (searchService.updateOne(infotable))
            result = "一件更新しました！";
        else
            result = "更新失敗しました！";
        return result;
    }

    // 1件削除メソッド
    @PostMapping("/deleteOne/{id:.+}")
    public String deleteOne(@PathVariable("id") String No)
    {
        String result = "";
        if (searchService.deleteOne(No))
            result = "一件削除しました！";
        else
            result = "削除しました！";
        return result;
    }
}
