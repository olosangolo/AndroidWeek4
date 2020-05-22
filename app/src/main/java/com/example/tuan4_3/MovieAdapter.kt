package com.example.tuan4_3

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import java.util.ArrayList

class MovieAdapter (
    moviesList: ArrayList<Movie>,
    context: Context,
    isGrid: Boolean) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {
        var moviesList = ArrayList<Movie>()
        var context : Context
        var isGrid : Boolean = false

        init {
            if (moviesList != null) {
                this.moviesList = moviesList
            }
            this.context = context
            this.isGrid = isGrid
        }

        class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            var title : TextView
            var content : TextView
            var image : ImageView
            init {
                title = itemView.findViewById(R.id.movie_title)
                content = itemView.findViewById(R.id.movie_content)
                image = itemView.findViewById(R.id.imageView)
            }
            fun bind(movie:Movie) {
                itemView.setOnClickListener(View.OnClickListener {
                    Toast.makeText(itemView.context,
                        movie.title,
                        Toast.LENGTH_LONG).show()
                    val intent =
                        Intent(itemView.context,MovieDetailAdapter::class.java).putExtra("movie",movie)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                    itemView.context.startActivity(intent)
                })

            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            var inflater = LayoutInflater.from(context)
            var view = inflater.inflate(R.layout.list, parent,false)
            if(isGrid) {
                view = inflater.inflate(R.layout.grid, parent,false)
            }
            return ViewHolder(view)
        }

        override fun getItemCount(): Int {
            return moviesList.size
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            var curMovie = moviesList.get(position)
            holder.bind(curMovie)
            holder.title?.text = curMovie.title.replace("\\", "")
            holder.content?.text = curMovie.overview.replace("\\", "")
            Glide.with(context).load("https://image.tmdb.org/t/p/w500/" + curMovie.poster_path).into(holder.image)
        }
}