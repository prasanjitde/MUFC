package com.pd.mufc.data.remote

import com.pd.mufc.data.entities.Matches
import com.pd.mufc.data.entities.Team
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface MUFCApiInterface {

    @GET("teams/{id}")
    fun getTeamDetail(
        @Path("id") id: Int
    ): Single<Team>

    @GET("teams/{id}/matches/")
    fun getTeamMatches(
        @Path("id") id: Int
    ): Observable<Matches>
}