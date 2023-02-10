package com.example.rickandmorty.data.repositories

import com.example.rickandmorty.data.Result
import com.example.rickandmorty.data.source.remote.RickAndMortyApi
import com.example.rickandmorty.data.source.remote.dto.toCharacter
import com.example.rickandmorty.data.source.remote.dto.toListCharacters
import com.example.rickandmorty.domain.model.Character
import com.example.rickandmorty.domain.model.Characters
import com.example.rickandmorty.domain.repositories.CharacterRepository
import java.io.IOException
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException

class CharacterRepositoryImpl @Inject constructor(
    private val api: RickAndMortyApi
): CharacterRepository{
    override fun getCharacters(page: Int): Flow<Result<List<Characters>>> = flow{
        emit(Result.Loading())
        try {
            val response = api.getCharacters(page).toListCharacters()
            emit(Result.Success(response))
        }catch (e: HttpException){
            emit(Result.Error(
                message = "Ups, algo malo ha sucedido",
                data = null
            ))
        }catch (e: IOException){
            emit(Result.Error(
                message = "Ups, no se podido encontrar el servidor, favor verificar conexión",
                data = null
            ))
        }
    }

    override suspend fun getCharacter(id: Int): Result<Character> {
    val response = try {
        api.getCharacter(id)
    }catch (e:Exception){
        return Result.Error(
            message = "Ups, algo malo ha sucedido"
        )
    }
        return Result.Success(response.toCharacter())
    }
}