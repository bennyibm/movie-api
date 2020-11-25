package com.evolutivecode.buku.portal.core.service.manager

import com.evolutivecode.buku.portal.core.domain.Movie
import com.evolutivecode.buku.portal.core.service.MovieService
import com.evolutivecode.buku.portal.infra.MovieExternalService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class MovieManager(private val movieExternalService: MovieExternalService) : MovieService {

    private final val logger: Logger = LoggerFactory.getLogger(MovieManager::class.java)
    override fun searchByTitle(title: String) : List<Movie>{
        logger.info("in the manager, try to ask for the externalServiceManager")
        return movieExternalService.searchMovies(title)
    }

    override fun getFilmByID(id: Int): Movie? {
        return movieExternalService.searchMovie(id)
    }

    override fun getTagsForFilm(filmID: Int): String {
        TODO("Not yet implemented")
    }

}