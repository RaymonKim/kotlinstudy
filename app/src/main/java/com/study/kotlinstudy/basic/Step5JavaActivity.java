package com.study.kotlinstudy.basic;

import android.util.Log;

import java.io.IOException;

/**
 * 5. 자바와 함께 사용하기
 *
 * 5-2. 자바에서 코틀린 코드 사용하기
 */

public class Step5JavaActivity {

    void onCreate() {

        /** 프로퍼티의 Getter/Setter화 */

        Member m =  new Member("John Doe", "Somewhere",false); // class Member(val name: String, var address: String, var isAdult: Boolean)

        Log.i("ch5",String.format("Name: %s\nAddress: %s\nAdult: %b",m.getName(),m.getAddress(),m.isAdult()));
//        < Output >
//        Name: John Doe
//        Address: Somewhere
//        Adult: false

//        m.setName("Jane Doe");      // 오류: val로 선언 되었기 때문에 수정 불가
        m.setAddress("Nowhere");    // 성공!
        m.setAdult(true);           // 성공!

        /** 기본 매개변수가 있는 함수 */

        Movie mAvengers = new Movie("Avenger","2018");
        Movie mDeadPool = new Movie("DeadPool");

        mAvengers.doSomething("Great");
        mDeadPool.doSomething("Excellent",  12000);

        /** 패키지 단위 함수 / 변수 */

        int year;

        // 어노테이션 설정 전
        year = MemberKt.YEAR;         // year = 2018
        year = MemberKt.getYear();    // year = 1990

        // 어노테이션 설정 후
//        year = Utils.YEAR;          // year = 2018
//        year = Utils.getYear();     // year = 1990

        /** 동반 객체 및 싱글톤 : 동반 객체 */

        String OS;

        // 어노테이션 설정 전
        OS = Android.Companion.getOS();     // 프로퍼티 규칙에 의해 자동으로 Getter 형태로 변환
                                            // OS = Oreo
        Android.Companion.getVersion();

        // 어노테이션 설정 후
        OS = iOS.OS;                        // OS = iOS 11.3.1

        iOS.getVersion();

        // 자바 원시 타입 혹은 문자열 타입의 값 / 변수인 경우
        String Maker = Pixel.Creater;       // Maker = Google

        /** 동반 객체 및 싱글톤 : 싱글톤 */
        String Version;

        // 어노테이션 설정 전
        Version = Singleton_App.INSTANCE.getVERSION(); // Version = 2.4.9

        Singleton_App.INSTANCE.LoadVersion();

        // 어노테이션 설정 후

        Version = Singleton_Web.VERSION;               // Version = 1.1.7
        Singleton_Web.LoadVersion();

        /** Exception 체크 */
        // 어노테이션 설정 전
        Run run = new Run();
//
//        try {
//            run.doDebug();          // 예외 처리 해야 될 필요가 있다는 것을 명시하지 않아서
//        } catch (IOException e) {   // 컴파일 에러가 발생
//            Log.i("ch5",e.getMessage());
//        }

        // 어노테이션 설정 후
        BuildnRun bnr = new BuildnRun();

        try{
            bnr.doDebug();
        } catch (IOException e) {
            Log.i("ch5",e.getMessage());
        }












    }
}
