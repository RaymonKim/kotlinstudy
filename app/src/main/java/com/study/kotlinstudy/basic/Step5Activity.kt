package com.study.kotlinstudy.basic

import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Button
import com.study.kotlinstudy.R
import kotlin.reflect.KClass

/**
 * 5. 자바와 함께 사용하기
 *
 * 5-1. 코틀린에서 자바 코드 사용하기
 */
class Step5Activity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_step5)


        /** Getter/Setter의 프로퍼티 화 */
        val person = Person("John Doe", "Somewhere")
        Log.i("kdj","Name : ${person.name} \n Address : ${person.address}")
//        < Output >
//        Name : John Doe
//        Address : Somewhere

//        person.name = "Jane Doe"            // 오류: setName() 메소드가 없어서 사용 불가

        person.phoneNum = "010-1234-1234"   // 변수 이름은 pNum이지만 프로퍼티 명은 phoneNum으로 취급

        person.address = "Nowhere"          // 성공!


        /** 가변 인자를 받는 메소드 */
        val a = ArrayTest()

        val intArgs = intArrayOf(1, 2, 3, 4, 5)       // 원시타입

        val integerArgs : Array<Int> = arrayOf(6, 7, 8, 9, 10)  // 래퍼타입

        a.doSomething(*intArgs)         // doSomething(int ... args)
//        a.doSomething(*integerArgs)     // doSomething(Integer ...args)

        val strArgs = arrayOf("Lorem", "ipsum", "dolor", "sit", "amet" )    // 일반 배열

        a.doNothing(*strArgs)                                               // 성공!

        /** Object 클래스 내 메소드 */
        val str = "Lorem ipsum"

        // Any 클래스에서 지원하는 멤버 함수
        str.toString()

        str.hashCode()

        str.equals(str)

        /**---------------------------------------------*/

        // 자바의 Object 클래스의 확장 함수의 형태로 지원
        (str as java.lang.Object).wait()    // wait() 호출

        (str as java.lang.Object).notify()  // notify() 호출

        /**---------------------------------------------*/

        // getClass() 메소드 예시
        // Kotlin 클래스 반환
        val kotlinClass : KClass<out String> = str :: class

        // 자바 클래스 반환
        val javaClass : Class<out String> = str :: class.java
        /**---------------------------------------------*/

        // clone() 메소드 예시
        val myBeagle = Dog("Beagle")
        val myPoodle = myBeagle.clone() as Dog

        Log.i("ch5","Type of This ${myPoodle.javaClass.simpleName} Is ${myPoodle.type}")

        myPoodle.type = "Poodle"

        Log.i("ch5","Type of This ${myPoodle.javaClass.simpleName} Is ${myPoodle.type}")
//        < Output >
//        Type of This Dog Is Beagle
//        Type of This Dog Is Poodle

        /**---------------------------------------------*/

        // finalize() 메소드 예시
        val John = Student(12)
//        John.finalize()

        /**---------------------------------------------*/

        /** SAM 변환 */

//        < Java >
//        Button btn = (Button) findViewById(R.id.btn1);
//
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });

//        < Kotlin >
//        val btn1 = findViewById(R.id.button) as Button
        val btn2 = findViewById<Button>(R.id.button)
        val btn3 by lazy {
            findViewById<Button>(R.id.button)
        }
        /**---------------------------------------------*/

//        btn1.setOnClickListener(object: View.OnClickListener {
//            override fun onClick(p0: View?) {
//                btn1.setBackgroundColor(ContextCompat.getColor(this@Step5Activity, R.color.colorPrimary))
//            }
//        })

        /**---------------------------------------------*/

        btn2.setOnClickListener({ view: View -> Unit
            btn2.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimary))
        })

        /**---------------------------------------------*/

        btn3.setOnClickListener{
            btn3.setBackgroundColor(ContextCompat.getColor(this,R.color.colorPrimary))
        }

        /**---------------------------------------------*/

    }

    // clone() 메소드 예시를 위한 클래스
    class Dog(var type: String) : Cloneable {

        override public fun clone(): Any {
            return super.clone()
        }
    }

    // finalize() 메소드 예시를 위한 클래스
    class Student(val age: Int){

//        protected fun finalize() {  // 허용 O
//
//        }
//
//        public fun finalize() {     // 허용 O
//
//        }
//
//        private fun finalize() {    // 허용 X
//
//        }
    }

    override fun onClick(v: View?) { }

}