package com.gato.foody.data

import com.gato.foody.data.database.LocalDataSource
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class Repository @Inject constructor(
    remoteDataSource: RemoteDataSource,
    localdataSource: LocalDataSource
) {

    val remote = remoteDataSource
    val local = localdataSource

}