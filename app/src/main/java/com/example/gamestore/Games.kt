package com.example.gamestore

import com.google.gson.annotations.SerializedName

data class Games (
  @field: SerializedName("id")
  val id: Int? = null,
  @field: SerializedName("released")
  val released: String? = null,
  @field: SerializedName("background_image")
  val background_image: String? = null,
  @field: SerializedName("background_image_additional")
  val background_image_additional: String? = null,
  @field: SerializedName("name")
  val name: String? = null,
  @field: SerializedName("description")
  val description: String? = null
)