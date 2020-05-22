package com.example.tuan4_3


import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

data class Movie constructor(val popularity: Double, val vote_count:Int, val video:Boolean, val poster_path:String, val backdrop_path: String,
                 val id:Int, val original_title:String, val title:String, val vote_average: Double,
                             val overview:String, val favorite: Boolean): Serializable{

//    val popularity: Double,
//    var vote_count: Int,
//    var video: Boolean,
//    var poster_path: String,
//    var id: Int,
//    //var adult: Boolean,
//    //var backdrop_path: String,
//   // var original_language: String,
//    var original_title: String,
//    //var genre_ids: List<Int>,
//    var title: String,
//    var vote_average: Double,
//    var overview: String
//   // var release_date: String

}
