package com.rztechtunes.dagger2app.model

data class NidResponse(
    val data: List<NidPojo>,
    val message: String,
    val status: String
)