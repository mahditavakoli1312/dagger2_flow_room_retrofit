package com.example.dagger_with_room_retrofit_base_on_reqres.core.networkUtils

import retrofit2.Response

fun <T> Response<T>.bodyOrThrow(): T? {
    if (isSuccessful) {
        return body()
    } else {
        throw ServerException(serverMessage = errorBody().toString(), code = code())
    }
}