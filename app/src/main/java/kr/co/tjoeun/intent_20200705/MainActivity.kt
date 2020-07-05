package kr.co.tjoeun.intent_20200705

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_first.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        moveToFirstBtn.setOnClickListener {

//            비행기 티켓 발권 (출발 / 도착)
            val myIntent = Intent(this, FirstActivity::class.java) //this:여기에서부터 시작할거야! 도착지는 FirstActivity!
//            실제로 출발
            startActivity(myIntent)

        }

//        두번째 화면 버튼 누르면
        sendToSecondBtn.setOnClickListener {

//            입력한 메세지 받아오기
            val inputMessage = msgEdt.text.toString()

//            두번째 화면으로 이동하기
            val myIntent = Intent(this, SecondActivity::class.java)
            //myintent에 데이터 붙여주기
            myIntent.putExtra("message", inputMessage)
            startActivity(myIntent)

        }

//        moveToBackBtn.setOnClickListener {
//에러가 나는데 왜 날까...?
//        //돌아갈때는 Intent 사용X
//        //val myIntent = Intent(this, MainActivity::class.java)
//        //startActivity(myIntent)
//
////            지금 보는 액티비티를 종료 => 이전화면으로 돌아감
//            finish()
//
//        }
    }
}