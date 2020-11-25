package com.evolutivecode.buku.portal.infra

import com.evolutivecode.buku.portal.common.Constant
import com.evolutivecode.buku.portal.core.domain.Movie
import com.evolutivecode.buku.portal.core.domain.TMDBResult
import com.fasterxml.jackson.annotation.JsonAlias
import org.apache.http.HttpEntity
import org.json.JSONObject
import org.omg.CORBA.Object
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.http.HttpMethod
import org.springframework.http.ResponseEntity
import org.springframework.retry.RetryCallback
import org.springframework.retry.support.RetryTemplate
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForEntity

@Component
class MovieExternalService(
        @Value("\${service.movies.search.title.url}") private val searchMovieByTitleUrl: String,
        @Value("\${service.movies.search.id.url}") private val searchMovieBYId: String,
        private var restTemplate: RestTemplate
        )
{



    private final val logger: Logger = LoggerFactory.getLogger(MovieExternalService::class.java)

    fun searchMovies(movieTitle: String) : List<Movie>{

        logger.info("in the external service class, loking for the title : $movieTitle")

        var movies : MutableList<Movie>


        var tmdbResult : TMDBResult? =
                restTemplate.getForObject(
                        String.format(searchMovieByTitleUrl, Constant.API_KEY, movieTitle),
                        TMDBResult::class.java)



        logger.info("taste the reste : \t total results : ${tmdbResult!!.total_pages}")

        for(movie: Movie in tmdbResult!!.results){
            logger.info(movie.toString())
        }

        return tmdbResult!!.results
    }
    fun searchMovie(movieId: Int) : Movie?{
        return restTemplate.getForObject(
                String.format(searchMovieByTitleUrl, movieId, Constant.API_KEY)
                        , Movie::class.java
        )
    }
}