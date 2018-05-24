//@file:JvmName("Utils") // 무조건 맨 첫줄에 들어가야 적용

package com.study.kotlinstudy.basic

import java.io.IOException
import java.io.ObjectStreamClass

// 프로퍼티의 Getter/Setter화 예시를 위한 클래스
class Member(val name: String, var address: String, var isAdult: Boolean)

// 기본 매개변수가 있는 함수 예시를 위한 클래스
class Movie @JvmOverloads constructor(
        var title: String = "", var year: String, var time : String="") {

    @JvmOverloads
    fun doSomething(rate: String, ticketprice: Int = 0) {

    }
}

// 패키지 단위 함수 / 변수 예시를 위한 함수 / 변수

const val YEAR = 2018

fun getYear() : Int {
    return 1990
}

// 동반 객체 및 싱글톤 예시를 위한 클래스
class Android {
    companion object {
        val OS = "Oreo"

        fun getVersion() {

        }
    }
}

//val OS = Android.OS
//Android.getVersion()

/**--------------------------------*/

class iOS {
    companion object {
        @JvmField
        val OS = "iOS 11.3.1"

        @JvmStatic
        fun getVersion() {

        }
    }
}

/**--------------------------------*/

class Pixel {
    companion object {
        const val Creater = "Google"
    }
}

/**--------------------------------*/

object Singleton_App {
    val VERSION = "2.4.9"

    fun LoadVersion() {

    }
}

/**--------------------------------*/

object Singleton_Web {
//    @JvmField
//    val VERSION = "1.1.7"
    const val VERSION = "1.1.7"

    @JvmStatic
    fun LoadVersion() {

    }
}

// Exception 체크 예시를 위한 클래스
class Run {
    fun doDebug() {

        throw IOException()
    }
}

/**--------------------------------*/

class BuildnRun {
    @Throws(IOException::class)
    fun doDebug() {

        throw IOException()
    }
}
