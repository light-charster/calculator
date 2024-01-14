package com.example.helloworld

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.helloworld.Calculate.c

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private var text: TextView?=null
    private val array = arrayOf("+","-","*","/","%",".")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val zero = findViewById<Button>(R.id.zero)
        val one = findViewById<Button>(R.id.one)
        val two = findViewById<Button>(R.id.two)
        val three = findViewById<Button>(R.id.three)
        val four = findViewById<Button>(R.id.four)
        val five = findViewById<Button>(R.id.five)
        val six = findViewById<Button>(R.id.six)
        val seven = findViewById<Button>(R.id.seven)
        val eight = findViewById<Button>(R.id.eight)
        val nine = findViewById<Button>(R.id.nine)
        val add = findViewById<Button>(R.id.add)
        val subtraction = findViewById<Button>(R.id.subtraction)
        val multiply = findViewById<Button>(R.id.multiply)
        val division = findViewById<Button>(R.id.division)
        val point = findViewById<Button>(R.id.point)
        val equal = findViewById<Button>(R.id.equal)
        val ac = findViewById<Button>(R.id.AC)
        val mod = findViewById<Button>(R.id.mod)
        val zhengfu = findViewById<Button>(R.id.jiahuojian)
        text = findViewById(R.id.text)
        zero.setOnClickListener(this)
        one.setOnClickListener(this)
        two.setOnClickListener(this)
        three.setOnClickListener(this)
        four.setOnClickListener(this)
        five.setOnClickListener(this)
        six.setOnClickListener(this)
        seven.setOnClickListener(this)
        eight.setOnClickListener(this)
        nine.setOnClickListener(this)
        add.setOnClickListener(this)
        subtraction.setOnClickListener(this)
        multiply.setOnClickListener(this)
        division.setOnClickListener(this)
        point.setOnClickListener(this)
        equal.setOnClickListener(this)
        ac.setOnClickListener(this)
        mod.setOnClickListener(this)
        zhengfu.setOnClickListener(this)
    }

    @SuppressLint("SetTextI18n")
    override fun onClick(v: View?) {
        when (v?.id){
            R.id.zero->{
                val toString = text?.text.toString()
                if (toString.isZero()){
                    text?.text = toString.setZero("0")
                }
                else if (toString != "0"){
                    text?.text = toString+"0"
                }
            }
            R.id.one->{
                val toString = text?.text.toString()
                if (toString.isZero()){
                    text?.text = toString.setZero("1")
                }
                else if (toString != "0"){
                    text?.text = toString+"1"
                }
                else{
                    text?.text = "1"
                }

            }
            R.id.two->{
                val toString = text?.text.toString()
                if (toString.isZero()){
                    text?.text = toString.setZero("2")
                }
                else if (toString != "0"){
                    text?.text = toString+"2"
                }
                else{
                    text?.text = "2"
                }
            }
            R.id.three->{
                val toString = text?.text.toString()
                if (toString.isZero()){
                    text?.text = toString.setZero("3")
                }
                else if (toString != "0"){
                    text?.text = toString+"3"
                }
                else{
                    text?.text = "3"
                }
            }
            R.id.four->{
                val toString = text?.text.toString()
                if (toString.isZero()){
                    text?.text = toString.setZero("4")
                }
                else if (toString != "0"){
                    text?.text = toString+"4"
                }
                else{
                    text?.text = "4"
                }
            }
            R.id.five->{
                val toString = text?.text.toString()
                if (toString.isZero()){
                    text?.text = toString.setZero("5")
                }
                else if (toString != "0"){
                    text?.text = toString+"5"
                }
                else{
                    text?.text = "5"
                }
            }
            R.id.six->{
                val toString = text?.text.toString()
                if (toString.isZero()){
                    text?.text = toString.setZero("6")
                }
                else if (toString != "0"){
                    text?.text = toString+"6"
                }
                else{
                    text?.text = "6"
                }
            }
            R.id.seven->{
                val toString = text?.text.toString()
                if (toString.isZero()){
                    text?.text = toString.setZero("7")
                }
                else if (toString != "0"){
                    text?.text = toString+"7"
                }
                else{
                    text?.text = "7"
                }
            }
            R.id.eight->{
                val toString = text?.text.toString()
                if (toString.isZero()){
                    text?.text = toString.setZero("8")
                }
                else if (toString != "0"){
                    text?.text = toString+"8"
                }
                else{
                    text?.text = "8"
                }
            }
            R.id.nine->{
                val toString = text?.text.toString()
                if (toString.isZero()){
                    text?.text = toString.setZero("9")
                }
                else if (toString != "0"){
                    text?.text = toString+"9"
                }
                else{
                    text?.text = "9"
                }
            }
            R.id.add->{
                val toString = text?.text.toString()
                val cha = toString.lastChar()
                if (cha !in array) {
                    text?.text = "$toString+"
                }else if (cha in array){
                    val change=toString.deleteLast()
                    text?.text = "$change+"
                }
            }
            R.id.subtraction->{
                val toString = text?.text.toString()
                val cha = toString.lastChar()
                if (cha !in array) {
                    text?.text = "$toString-"
                }else if (cha in array){
                    val change=toString.deleteLast()
                    text?.text = "$change-"
                }
            }
            R.id.multiply->{
                val toString = text?.text.toString()
                val cha = toString.lastChar()
                if (cha !in array) {
                    text?.text = "$toString*"
                }else if (cha in array){
                    val change=toString.deleteLast()
                    text?.text = "$change*"
                }
            }
            R.id.division->{
                val toString = text?.text.toString()
                val cha = toString.lastChar()
                if (cha !in array) {
                    text?.text = "$toString/"
                }else if (cha in array){
                    val change=toString.deleteLast()
                    text?.text = "$change/"
                }
            }
            R.id.point->{
                val toString = text?.text.toString()
                val cha = toString.lastChar()
                if (cha !in array) {
                    text?.text = "$toString."
                }else if (cha in array){
                    val change=toString.deleteLast()
                    text?.text = "$change."
                }
            }
            R.id.equal->{
                val toString = text?.text.toString()
                val s=c(toString)
                text?.text = s
            }
            R.id.AC->{
                text?.text = "0"
            }
            R.id.mod->{
                val toString = text?.text.toString()
                val cha = toString.lastChar()
                if (cha !in array) {
                    text?.text = "$toString%"
                }else if (cha in array){
                    val change=toString.deleteLast()
                    text?.text = "$change%"
                }
            }
            R.id.jiahuojian->{
                val toString = text?.text.toString()
                toString.jiajian()
                text?.text = toString
            }
        }
    }
    private fun String.lastChar(): String {
        return this[this.length - 1].toString()
    }
    private fun String.secondChar(): String {
        return this[this.length - 2].toString()
    }
    private fun String.deleteLast(): String {
        return this.substring(0,this.length-1)
    }
    private fun String.isZero(): Boolean {
        val array = arrayOf("+","-","*","/","%")
        if(this.length>=2){
            if(this.lastChar() == "0" && this.secondChar() in array){
                return true
            }
        }
        return false
    }
    private fun String.setZero(s:String): String {
        var c=this.substring(0,this.length-1)
        c += s
        return c
    }
    private fun String.jiajian(): String {
        if(this[0].toString() == "-"){
            return this.substring(1,this.length-1)
        }
        return "-$this"
    }
}
