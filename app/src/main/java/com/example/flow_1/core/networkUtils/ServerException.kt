package com.example.dagger_with_room_retrofit_base_on_reqres.core.networkUtils

class ServerException constructor(val serverMessage: String, val code: Int) : Exception()