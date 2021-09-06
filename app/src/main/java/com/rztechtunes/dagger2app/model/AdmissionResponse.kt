package com.rztechtunes.dagger2app.model

data class AdmissionResponse(
    val `data`: List<AdmissionModel>,
    val message: String,
    val status: String
)