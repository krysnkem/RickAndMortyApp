package com.example.rickandmortyapp.api

class Repository(private val apiService: ApiService) {

    suspend fun getCharactersInpage(page:String)= apiService.getCharactersInPage(page)
}