package com.example.and0806_httpconnection_with_volley_with_gson;

import java.util.ArrayList;

public class MovieListResult {
    // 박스오피스 검색 결과 전체 저장
    String boxofficeType; // 박스 오피스
    String showRange; // 날짜 범위
    ArrayList<Movie> dailyBoxOfficeList = new ArrayList<Movie>(); // 영화 정보 목록
}
