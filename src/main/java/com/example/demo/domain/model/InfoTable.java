package com.example.demo.domain.model;

import lombok.Data;

@Data
public class InfoTable
{
    private int No;                 // ユーザーID
    private String Title;           // パスワード
    private String Gensaku;         // ユーザー名
    private String Sakuga;          // 年齢
    private String Other;           // ロール
}