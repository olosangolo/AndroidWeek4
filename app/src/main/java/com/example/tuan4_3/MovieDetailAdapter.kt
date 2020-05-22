package com.example.tuan4_3

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatImageButton
import com.bumptech.glide.Glide
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.khtn.androidcamp.DataCenter

class MovieDetailAdapter : AppCompatActivity() {
    lateinit var imgMovie: ImageView
    lateinit var imgRating: ImageView
    var description: TextView? = null
    var title: TextView? = null
    lateinit var rating: RatingBar
    lateinit var btnFav: AppCompatImageButton

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail_adapter)
        btnFav = findViewById(R.id.favButton)
        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        toolbar.setNavigationOnClickListener(View.OnClickListener {
            finish()
        })
        var collapsing_toolbar = findViewById<CollapsingToolbarLayout>(R.id.collapsing_toolbar)

        var movie = intent.getSerializableExtra("movie") as Movie

        title = findViewById(R.id.detailMovie_tv_titleMovie)
        title?.text = movie.title

        imgMovie = findViewById<ImageView>(R.id.movieDetail_imageMovie)
        Glide.with(this).load("https://image.tmdb.org/t/p/w500/" + movie.poster_path).into(imgMovie)

        imgRating = findViewById(R.id.detailMovie_imgPoster)
        Glide.with(this).load("https://image.tmdb.org/t/p/w500/" + movie.poster_path).into(imgRating)

        description = findViewById(R.id.detailMovie_tv_description)
        description?.text = movie.overview.replace("\\", "")

        Log.v("tag", movie.overview)
        rating = findViewById(R.id.movieDetail_ratingBar)

        rating.rating = movie.vote_average.toFloat()

        btnFav.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                val builder = AlertDialog.Builder(this@MovieDetailAdapter);
                builder.setTitle("Thông báo");
                builder.setMessage("Bạn có muốn lưu phim này vào mục favorite không?");
                builder.setPositiveButton("YES"){dialog, which ->
                    if(!DataCenter.listFavoriteMovie.contains(movie)){
                        DataCenter.listFavoriteMovie.add(movie)
                        Toast.makeText(applicationContext, "Phim đã được thêm vào mục favorite.", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(applicationContext, "Phim đã có trong mục favorite.", Toast.LENGTH_SHORT).show();
                    }
                }
                builder.setNegativeButton("No"){dialog, which ->
                }

                builder.create();
                builder.show();
            }})

    }
}
