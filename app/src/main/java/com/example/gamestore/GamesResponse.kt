package com.example.gamestore

import com.google.gson.annotations.SerializedName

data class GamesResponse(
  @field:SerializedName("next")
  val next: String? = null,

  @field:SerializedName("previous")
  val previous: String? = null,

  @field:SerializedName("count")
  val count: Int? = null,

  @field:SerializedName("results")
  val results: List<Games> = listOf()
)