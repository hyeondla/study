package com.example.and0806_httpconnection_with_volley_with_gson;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    /*
    Volley를 활용한 Http 연결
    dependency 항목에 gson 라이브러리(의존성 패키지) 추가 필요
    1) build.gradle 파일의 dependencies 블록에 다음 내용 추가
       implementation 'com.google.code.gson:gson:2.8.7'
    2) File - Project Structure - Dependencies - All dependencies - '+' 버튼 - Library
       - com.google.gson* 검색 - 라이브러리 추가 - apply
     */

    Button btnRequest;
    TextView tvResponseData;

    // HTTP 요청 (Request) 객체를 저장할 RequestQueue 타입 변수 선언
    // 한 번 생성하면 재사용하기 위해 static 선언
    static RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRequest = findViewById(R.id.btnRequest);
        tvResponseData = findViewById(R.id.tvResponseData);

        // TextView 위젯에 스크롤 기능 추가
        tvResponseData.setMovementMethod(new ScrollingMovementMethod());

        btnRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeRequest();
            }
        });

        // 요청큐 객체가 비어있을 경우 객체 생성
        if(requestQueue == null) {
            // Volley 객체의 newRequestQueue 호출하여 객체 리턴받음
            // -> 파라미터로 현재 액티비티(컨텍스트 객체) 전달
            requestQueue = Volley.newRequestQueue(this);


        }

    }

    // 요청 정보를 생성하여 요청 큐에 담아 요청 수행
    private void makeRequest() {
        // 요청에 사용할 URL
        String strUrl = "http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=f5eef3421c602c6cb7ea224104795888&targetDt=20210805";
//        String strUrl = "http://www.itwillbs.co.kr";
        // 요청 정보 생성 -> StringRequest 객체 사용
        // 파라미터
        // 1. int method : 요청 방식 - GET / POST (Request.Method.XXX 상수 지원)
        // 2. String url : 요청 URL
        // 3. Listener<String> Listener : 정상적인 응답을 수행할 리스너 객체 = 응답 리스너
        //    -> Response.Listener 구현체 전달
        // 4. ErrorListener errorListener : 오류에 관련된 응답을 수행할 리스너 객체 = 에러 리스너
        //    -> Response.ErrorListener 구현체 전달

        // 응답 리스너를 별도로 구현하는 경우
        Response.Listener listener = new Response.Listener() {
            @Override
            public void onResponse(Object response) { // 응답 전달시 자동으로 호출됨
//                tvResponseData.setText("응답데이터 : " + response);
//                showMessage(response.toString());

                // Json 데이터 처리
                procesResponse(response.toString());
            }

            // 응답 결과에 대한 데이터 후처리 (JSON -> Gson 라이브러리로 관리)
            // 사용자 정의 메서드
            // 응답결과가 전달되면 한꺼번에 처리 -> Response.Listener 구현체 내부에 정의
            public void procesResponse(String response) {
                // JSON 문자열 데이터를 Gson 객체로 관리 -> Gson 객체 생성
                Gson gson = new Gson();
                // 해당 문자열을 파싱하기 위한 클래스 생성 필요
                // Gson 객체의 fromJson() 호출 -> 원하는 객체로 JSON 데이터를 파싱하여 리턴받기
                // -> 파라미터 : 응답객체, 응답데이터를 파싱하여 저장할 클래스
                //     => 저장할 클래스는 클래스명.class 지정 필수
                MovieList movieList = gson.fromJson(response, MovieList.class); // 자동 파싱 저장

//                showMessage("조회된 영화 목록 갯수 : " + movieList.boxOfficeResult.dailyBoxOfficeList.size());
                for(Movie movie : movieList.boxOfficeResult.dailyBoxOfficeList) {
                    showMessage("영화 제목 : " + movie.movieNm);
                    showMessage("박스오피스 순위 : " + movie.rank);
                    showMessage("개봉일 : " + movie.openDt);
                    showMessage("누적관객 수 : " + movie.audiAcc);
                    showMessage("-------------------------------");
                }
            }
        };
        // 에러 리스너를 별도로 구현하는 경우
        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
//                tvResponseData.setText("에러데이터 : " + error.getMessage());
                showMessage(error.getMessage() + "\n");
            }
        };

        StringRequest request = new StringRequest(
                Request.Method.GET, // 요청 방식 - GET 지정
                strUrl, // 요청 URL
                listener, // 응답 리스너 객체
                errorListener // 에러 리스너 객체
        ){
            // getParams() 오버라이딩
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                // HashMap 객체 생성
                Map<String, String> params = new HashMap<String, String>();
//                params.put("key", "f5eef3421c602c6cb7ea224104795888"); // key 파라미터
//                params.put("targetDt", "20210805"); // targetDt 파라미터

                return params;
            }
        };

        // 요청 객체(StringRequest) 생성 완료 후 요청큐에 객체 추가
        requestQueue.add(request);
        showMessage("요청 완료");

    }

    private void showMessage(String msg) {
        // 기존 TextView 위젯에 표시된 내용에 전달받은 메시지 추가
        tvResponseData.append(msg + "\n");
    }

}