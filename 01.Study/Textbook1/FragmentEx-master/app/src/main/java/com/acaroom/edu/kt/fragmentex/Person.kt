package com.acaroom.edu.kt.fragmentex

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

// 1. Parcelable 구현하기
//data class Person(val name: String, val age: Int) : Parcelable {
//    constructor(source: Parcel) : this(
//            source.readString(),
//            source.readInt()
//    )
//
//    override fun describeContents() = 0
//
//    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
//        writeString(name)
//        writeInt(age)
//    }
//
//    companion object {
//        @JvmField
//        val CREATOR: Parcelable.Creator<Person> = object : Parcelable.Creator<Person> {
//            override fun createFromParcel(source: Parcel): Person = Person(source)
//            override fun newArray(size: Int): Array<Person?> = arrayOfNulls(size)
//        }
//    }
//}


// 2. 랩핑된 KParcelable을 사용해 보기
//class Person(val name: String, val age: Int) : KParcelable {
//
//    private constructor(p: Parcel) : this(
//            name = p.readString(),
//            age = p.readInt())
//
//    override fun writeToParcel(dest: Parcel, flags: Int) {
//        dest.writeString(name)
//        dest.writeInt(age)
//    }
//
//    companion object {
//        @JvmField val CREATOR = parcelableCreator(::Person)
//    }
//}

// 3. 어노테이션 사용하기

@Parcelize
data class Person(val name: String, val age: Int): Parcelable