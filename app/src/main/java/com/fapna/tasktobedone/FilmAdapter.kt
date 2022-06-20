package com.fapna.tasktobedone

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.fapna.tasktobedone.databinding.FilmListItemBinding
import com.fapna.tasktobedone.model.Film
import kotlinx.android.synthetic.main.film_list_item.view.*

class FilmAdapter(private val filmList: List<Film>): RecyclerView.Adapter<FilmAdapter.FilmViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder {
        return FilmViewHolder(
            FilmListItemBinding.inflate(LayoutInflater.from(parent.context), parent,false )
        )
    }

    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
        holder.bind(filmList[position])
    }

    override fun getItemCount(): Int {
        return filmList.size
    }

    class FilmViewHolder(itemView: FilmListItemBinding) : RecyclerView.ViewHolder(itemView.root) {
        fun bind(film: Film){

            itemView.apply {
                Glide.with(context!!)
                    .load(film.Poster)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(poster!!)
                title.text = film.Title
            }
        }
    }
}