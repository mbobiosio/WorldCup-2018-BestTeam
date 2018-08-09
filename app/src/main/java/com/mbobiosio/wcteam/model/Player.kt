package com.mbobiosio.wcteam.model

import android.os.Parcelable
import org.parceler.Parcel
import java.io.Serializable

/**
 * Created by Mbuodile Obiosio on 7/19/18
 * cazewonder@gmail.com
 */
@Parcel
class Player(var id: Int, var name: String, var nationality: String, var role: String, var club: String, var profile: String, var avi: String, var aviThumb: String) : Serializable, Parcelable {

    constructor(parcel: android.os.Parcel) : this(
            parcel.readInt(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString())

    override fun writeToParcel(parcel: android.os.Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(name)
        parcel.writeString(nationality)
        parcel.writeString(role)
        parcel.writeString(club)
        parcel.writeString(profile)
        parcel.writeString(avi)
        parcel.writeString(aviThumb)
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun toString(): String {
        return "Player(id=$id, name='$name', nationality='$nationality', role='$role', club='$club', profile='$profile', avi='$avi', aviThumb='$aviThumb')"
    }


    companion object CREATOR : Parcelable.Creator<Player> {
        override fun createFromParcel(parcel: android.os.Parcel): Player {
            return Player(parcel)
        }

        override fun newArray(size: Int): Array<Player?> {
            return arrayOfNulls(size)
        }
    }
}
