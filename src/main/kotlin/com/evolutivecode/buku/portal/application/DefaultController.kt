package com.evolutivecode.buku.portal.application

import com.evolutivecode.buku.portal.core.domain.Movie
import com.evolutivecode.buku.portal.core.service.MovieService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class DefaultController(
        private val movieService: MovieService
        ){


    private final val logger: Logger = LoggerFactory.getLogger(DefaultController::class.java)

    @GetMapping("/")
    fun index(): List<Movie>{
        logger.info("catching the request")
        return movieService.searchByTitle("terminator")
    }

    @GetMapping("/search/{id}")
    fun getMovieDetails(@RequestParam id: Int): Movie{
        return movieService.getFilmByID(id)!!
    }
}