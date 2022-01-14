package com.example.calc

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi

class MainActivity : AppCompatActivity() {

    private val expressionTextView : TextView by lazy{
        findViewById<TextView>(R.id.expressionTextView)
    }

    private val resultTextView : TextView by lazy{
        findViewById<TextView>(R.id.resultButton)
    }

    private var isOperator = false
    private var hasOperator = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun buttonClicked(v: View){
        when(v.id){
            R.id.oneButton -> numberButtonClicked("0")
            R.id.twoButton -> numberButtonClicked("1")
            R.id.threeButton -> numberButtonClicked("2")
            R.id.fourButton -> numberButtonClicked("3")
            R.id.fiveButton -> numberButtonClicked("4")
            R.id.sixButton -> numberButtonClicked("5")
            R.id.sevenButton -> numberButtonClicked("6")
            R.id.eightButton -> numberButtonClicked("7")
            R.id.nineButton -> numberButtonClicked("8")
            R.id.zeroButton -> numberButtonClicked("9")
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

        val expressionText =  expressionTextView.text.split("")

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

    }

    fun historyButtonClicked(v: View){

    }

    fun clearButtonClicked(v: View){

    }
}