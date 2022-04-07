package com.gato.foody.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.gato.foody.data.database.entities.FavoritesEntity
import com.gato.foody.data.database.entities.FoodJokeEntity
import com.gato.foody.data.database.entities.RecipesEntity
import com.gato.foody.models.FoodJoke
import com.gato.foody.util.Constants
import com.gato.foody.util.Constants.Companion.FAVORITE_RECIPES_TABLE
import com.gato.foody.util.Constants.Companion.FOOD_JOKE_TABLE
import com.gato.foody.util.Constants.Companion.RECIPES_TABLE
import kotlinx.coroutines.flow.Flow

@Dao
interface RecipesDao {

    @Insert(onConflict = REPLACE)
    suspend fun insertRecipes(recipesEntity: RecipesEntity)

    @Insert(onConflict = REPLACE)
    suspend fun insertFavoriteRecipes(favoritesEntity: FavoritesEntity)

    @Insert(onConflict = REPLACE)
    suspend fun insertFoodJoke(foodJokeEntity: FoodJokeEntity)

    @Query("SELECT * FROM $RECIPES_TABLE ORDER BY id ASC")
    fun readRecipes(): Flow<List<RecipesEntity>>

    @Query("SELECT * FROM $FAVORITE_RECIPES_TABLE ORDER BY id ASC")
    fun readFavoriteRecipes(): Flow<List<FavoritesEntity>>

    @Query("SELECT * FROM $FOOD_JOKE_TABLE ORDER BY id ASC")
    fun readFoodJoke(): Flow<List<FoodJokeEntity>>

    @Delete
    suspend fun deleteFavoriteRecipe(favoritesEntity: FavoritesEntity)

    @Query("DELETE FROM $FAVORITE_RECIPES_TABLE")
    suspend fun deleteAllFavoriteRecipes()


}