package kr.co.tjoeun.intent_20200705

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_android_intent_20200705.*

class AndroidIntent_20200705 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_android_intent_20200705)

//        다이얼버튼 이벤트
        dialBtn.setOnClickListener {

//            입력된 전화번호를 받아오자.
            val inputPhoneNum = phoneNumEdt.text.toString()

//            안드로이드에게, 어디에 전화걸지 정보 전달 => Uri class
//            전화 Uri 양식 - tel:010-0000-0000
            val myUri = Uri.parse("tel:${inputPhoneNum}")

//            Log.d("String 가공확인", "tel:${inputPhoneNum}")

//            전화 화면으로 이동하는 Intent
            val myIntent = Intent(Intent.ACTION_DIAL, myUri)

            startActivity(myIntent)


        }
    }
}