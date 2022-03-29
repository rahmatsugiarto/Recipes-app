package com.gato.foody.data

import com.gato.foody.data.database.LocalDataSource
import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Inject

@ActivityRetainedScoped
class Repository @Inject constructor(
    remoteDataSource: RemoteDataSource,
    localdataSource: LocalDataSource
) {

    val remote = remoteDataSource
    val local = localdataSource

}