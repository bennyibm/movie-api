package com.evolutivecode.buku.portal.core.domain

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.util.*


@JsonIgnoreProperties(ignoreUnknown = true)
class Movie(var id: Int, var original_title: String, var title: String, var release_date: Date, var adulte: Boolean, var overview: String) {

    override fun toString(): String {
        return String.format("id: $id \t\t original title: $original_title \t\t annee de sortie: $release_date")
    }
}