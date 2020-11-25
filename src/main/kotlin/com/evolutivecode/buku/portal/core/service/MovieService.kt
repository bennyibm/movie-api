package com.evolutivecode.buku.portal.core.service

import com.evolutivecode.buku.portal.core.domain.Movie

interface MovieService {
    fun searchByTitle(title: String): List<Movie>
    fun getFilmByID(id: Int): Movie?
    fun getTagsForFilm(filmID: Int): String
}