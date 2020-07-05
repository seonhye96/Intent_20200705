package kr.co.tjoeun.intent_20200705

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_edit_nick.*
import kotlinx.android.synthetic.main.activity_main.*

class EditNickActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_nick)

//        완료버튼을 눌러야 완료.
        okBtn.setOnClickListener {
//            새 닉네임이 뭔지 값으로 저장.
            val newNickName = newNickNameEdt.text.toString()

//            복귀에 사용할 Intent (결과를 담기 위한 용도)
//            출발지 / 목적지 기재 X
            val resultIntent = Intent()

//            입력한 값을 결과용 Intent에 첨부
            resultIntent.putExtra("nick", newNickName)

//            이 화면의 최종 결과 => OK를 눌렀다. + resultIntent 데이터라고 명시
//            가지고 갈 짐
            setResult(Activity.RESULT_OK, resultIntent)

//            기존화면으로 복귀
            finish()

        }
    }

//    오버라이드|MainActivity로 복귀하는 모든 시점에 실행되는 함수.
//    ex. 닉네임을 받으러갔다 => OK로 돌아와도 실행
//    ex. 닉네임을 받으러갔다 => 취소로 돌아와도 실행
//    ex. 비밀번호을 변경하러 갔다 => OK로 돌아와도 실행

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

//        어떤걸 가지러 다녀온건지 확인 (닉네임 인지)
        if (requestCode == 1000){

//            완료를 누른게 맞는지 확인
            if (resultCode == Activity.RESULT_OK){

//                결과로 받아온 닉네임을 텐스트뷰에 적용
                val newNickName = data?.getStringExtra("nick") // 널이 아닐때만 실행시켜주세요.

                nickNameTxt.text = newNickName

            }

        }


    }

}