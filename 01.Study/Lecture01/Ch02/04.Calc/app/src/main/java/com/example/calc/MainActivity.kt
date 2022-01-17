package com.example.calc

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.view.isVisible
import androidx.room.Room
import com.example.calc.model.History
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity() {

    private val expressionTextView : TextView by lazy{
        findViewById<TextView>(R.id.expressionTextView)
    }

    private val resultTextView : TextView by lazy{
        findViewById<TextView>(R.id.resultTextView)
    }

    private val historyLayout : View by lazy {
        findViewById<View>(R.id.historyLayout)
    }

    private val historyLinearLayout : LinearLayout by lazy {
        findViewById<LinearLayout>(R.id.historyLinearLayout)
    }

    lateinit var db : AppDatabase


    private var isOperator = false
    private var hasOperator = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db = Room.databaseBuilder(
                applicationContext,
                AppDatabase::class.java,
                "histroyDB"
        ).build()
    }

    @RequiresApi(Build.VERSION_CODES.M)
    fun buttonClicked(v: View){
        when(v.id){
            R.id.oneButton -> numberButtonClicked("1")
            R.id.twoButton -> numberButtonClicked("2")
            R.id.threeButton -> numberButtonClicked("3")
            R.id.fourButton -> numberButtonClicked("4")
            R.id.fiveButton -> numberButtonClicked("5")
            R.id.sixButton -> numberButtonClicked("6")
            R.id.sevenButton -> numberButtonClicked("7")
            R.id.eightButton -> numberButtonClicked("8")
            R.id.nineButton -> numberButtonClicked("9")
            R.id.zeroButton -> numberButtonClicked("0")
            R.id.plusButton ->  operatorButtonClicked("+")
            R.id.minusButton -> operatorButtonClicked("-")
            R.id.multiButton -> operatorButtonClicked("x")
            R.id.dividerButton -> operatorButtonClicked("÷")
            R.id.moduloButton -> operatorButtonClicked("%")
        }

    }

    private fun numberButtonClicked(number: String){

        if(isOperator){
            expressionTextView.append(" ")
        }

        isOperator = false

        val expressionText =  expressionTextView.text.split(" ")

        if(expressionText.isNotEmpty() && expressionText.last().length >= 15){
            Toast.makeText(this, "15자리 까지만 사용할 수 있습니다.", Toast.LENGTH_SHORT).show()
            return
        }
        else if(expressionText.last().isEmpty() && number == "0")
        {
            Toast.makeText(this, "0은 제일 앞에 올 수 없습니다.", Toast.LENGTH_SHORT).show()
            return
        }
        expressionTextView.append(number)
        resultTextView.text = calculateExpression()
        //TODO resultTextView 실시간으로 계산 결과를 넣아야 하는 기능
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun operatorButtonClicked(operator: String){
        if(expressionTextView.text.isEmpty()){
            return
        }

        when{
            isOperator ->{
                val text = expressionTextView.text.toString()
                expressionTextView.text = text.dropLast(1) + operator
            }
            hasOperator ->{
                Toast.makeText(this, "연산자는 한 번만 사용 할 수 있습니다.", Toast.LENGTH_SHORT).show()
                return
            }

            else -> {
                expressionTextView.append(" $operator")
            }
        }

        val ssb = SpannableStringBuilder(expressionTextView.text)
        ssb.setSpan(
            ForegroundColorSpan(getColor(R.color.green)),
            expressionTextView.text.length - 1,
            expressionTextView.text.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        expressionTextView.text = ssb

        isOperator = true
        hasOperator = true
    }

    fun resultButtonClicked(v: View){
        val expressionTexts = expressionTextView.text.split(" ")
        if(expressionTextView.text.isEmpty() || expressionTexts.size == 1)
        {
            return
        }

        if(expressionTexts.size != 3 && hasOperator){
            Toast.makeText(this, "아직 완성되지 않은 수식입니다.", Toast.LENGTH_SHORT).show()
            return
        }

        if(expressionTexts[0].isNumber().not() || expressionTexts[2].isNumber().not() )
        {
            Toast.makeText(this, "오류가 발생했습니다.", Toast.LENGTH_SHORT).show()
            return
        }

        val expressionText = expressionTextView.text.toString()
        val resultText = calculateExpression()

        // todo 디비에 넣어주는 부분
        Thread(Runnable {
            db.historyDao().insertHistory(History(null, expressionText, resultText))
        }).start()

        resultTextView.text = ""
        expressionTextView.text = resultText

        isOperator = false
        hasOperator = false

    }

    private fun calculateExpression() : String{
        val expressionText = expressionTextView.text.split(" ")
        if(hasOperator.not() || expressionText.size != 3)
        {
            return ""
        }
        else if(expressionText[0].isNumber().not() || expressionText[2].isNumber().not() )
        {
            return ""
        }

        val exp1 = expressionText[0].toBigInteger()
        val exp2 = expressionText[2].toBigInteger()
        val op = expressionText[1]

        return when(op) {
            "+" -> (exp1 + exp2).toString()
            "-" -> (exp1 - exp2).toString()
            "x" -> (exp1 * exp2).toString()
            "÷" -> (exp1 / exp2).toString()
            "%" -> (exp1 % exp2).toString()
            else -> ""
        }
    }

    fun clearButtonClicked(v: View){
        expressionTextView.text = ""
        resultTextView.text = ""
        isOperator = false
        hasOperator = false
    }

    fun historyButtonClicked(v: View){
        historyLayout.isVisible = true
        historyLinearLayout.removeAllViews()

        Thread(Runnable {
            db.historyDao().getAll().reversed().forEach {

                runOnUiThread{
                    val historyView = LayoutInflater.from(this).inflate(R.layout.history_row, null, false)
                    historyView.findViewById<TextView>(R.id.expressionTextView).text = it.expression
                    historyView.findViewById<TextView>(R.id.resultTextView).text = "= ${it.result}"

                    historyLinearLayout.addView(historyView)
                }
            }
        }).start()

        //TODO 디비에서 모든 기록 가져오기
        //TODO 뷰에 모든 기록 할당하기
    }

    fun closetHistoryButtonClicked(v: View){
        historyLayout.isVisible = false
    }

    fun historyClearButtonClicked(v: View){
        historyLinearLayout.removeAllViews()

        Thread(Runnable {
            db.historyDao().deleteAll()
        }).start()

        //TODO 디비에서 모든 기록 삭제
        //TODO 뷰에서 모든 기록 삭제
    }
}

fun String.isNumber() : Boolean{
    return try{
        this.toBigInteger()
        true
    }
    catch(e : NumberFormatException)
    {
        false
    }
}