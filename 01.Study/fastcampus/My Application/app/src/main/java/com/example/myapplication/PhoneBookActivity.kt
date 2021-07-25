package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView

class PhoneBookActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_book)

        val phoneBook = creatFakePhoneBook(30)
        createPhoneBookList(phoneBook)
    }

    fun creatFakePhoneBook(faskeNumber: Int = 10, PhoneBook: PhoneBook = PhoneBook()): PhoneBook {
        for (i in 0 until faskeNumber) {
            PhoneBook.addPerson(
                Person(name = "" + i + "번째 사람", number = "" + i + "번째 사람의 전화번호")
            )
        }
        return PhoneBook
    }

    fun createPhoneBookList(PhoneBook: PhoneBook) {
        val layouInflater = LayoutInflater.from(this@PhoneBookActivity)
        val container = findViewById<LinearLayout>(R.id.phone_list_container)
        for (i in 0 until PhoneBook.personList.size) {
            val view = layouInflater.inflate(R.layout.phonebook_item, null)
            val personNameView = view.findViewById<TextView>(R.id.person_name)
            personNameView.setText(PhoneBook.personList.get(i).name)
            addSetOnClickListener(PhoneBook.personList.get(i), view)
            container.addView(view)
        }

    }

    fun addSetOnClickListener(person: Person, view: View)
    {
        view.setOnClickListener {
            val intent = Intent(this@PhoneBookActivity, PhoneBookDetailActivity::class.java)
            intent.putExtra("name", person.name)
            intent.putExtra("number", person.number)
            startActivity(intent)
        }
    }
}

class PhoneBook() {
    // 전화 번호부
    val personList = ArrayList<Person>()

    fun addPerson(person: Person) {
        personList.add(person)
    }
}

class Person(val name: String, var number: String)
{

}

