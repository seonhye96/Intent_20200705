package kr.co.tjoeun.intent_20200705

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_first.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //    숫자 1000 대신 코드에 어떤 요청인지 읽기 쉽도록 하는 조치
    val REQ_CODE_FOR_NICKNAME = 1000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        moveToFirstBtn.setOnClickListener {

//            비행기 티켓 발권 (출발 / 도착)
            val myIntent =
                Intent(this, FirstActivity::class.java) //this:여기에서부터 시작할거야! 도착지는 FirstActivity!
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

//        닉네임 변경 버튼을 누르면
        changeNickBtn.setOnClickListener {

//            닉네임 변경 화면으로 가야함. Intent
            val myIntent = Intent(this, EditNickActivity::class.java)

//            화면으로 이동 => 단순 조회 이동 X
//            데이터를 받으러 (결과를 얻으러) 가는 이동 => 뭘 받으러 가는지 명시.
//            받을 데이터 (요청) 구별 고유 숫자 : reguestCode

//            어떤 결과? => 새 닉네임을 얻으러. (1000 : 새 닉네임)
            startActivityForResult(myIntent, REQ_CODE_FOR_NICKNAME)


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


//    오버라이드|MainActivity로 복귀하는 모든 시점에 실행되는 함수.
//    ex. 닉네임을 받으러갔다 => OK로 돌아와도 실행
//    ex. 닉네임을 받으러갔다 => 취소로 돌아와도 실행
//    ex. 비밀번호을 변경하러 갔다 => OK로 돌아와도 실행

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

//        어떤걸 가지러 다녀온건지 확인 (닉네임 인지)
        if (requestCode == 1000) {

//            완료를 누른게 맞는지 확인
            if (resultCode == Activity.RESULT_OK) {

//                결과로 받아온 닉네임을 텍스트뷰에 적용
                val newNickName = data?.getStringExtra("nick") // 널이 아닐때만 실행시켜주세요.

                nickNameTxt.text = newNickName

            }

        }


    }
}