package com.rztechtunes.dagger2app.model

class UserProfileModel {
     var name: String
     var address: String
     var phone: String

    constructor(name: String, address: String, phone: String) {
        this.name = name
        this.address = address
        this.phone = phone
    }
}