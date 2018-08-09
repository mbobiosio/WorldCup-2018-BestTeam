/*
package com.mbobiosio.sqlitedbasset.model

import android.os.Parcelable
import org.parceler.Parcel
import java.io.Serializable

*/
/**
 * Created by Mbuodile Obiosio on 4/2/18.
 *
 *//*

@Parcel
class Car(var id: Long, var model: String?, var manufacturer: String, var thumbnailSmall: String?, var thumbnailLarge: String?, var engineSize: Int, var speed: Int, var acceleration: Int) : Serializable, Parcelable {


    constructor(parcel: android.os.Parcel) : this(
            parcel.readLong(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt())

    override fun toString(): String {
        return "Car{" +
                "id=" + id +
                ", model='" + model + '\''.toString() +
                ", manufacturer='" + manufacturer + '\''.toString() +
                ", thumbnailSmall='" + thumbnailSmall + '\''.toString() +
                ", thumbnailLarge='" + thumbnailLarge + '\''.toString() +
                ", engineSize=" + engineSize +
                ", speed=" + speed +
                ", acceleration=" + acceleration +
                '}'.toString()
    }

    override fun writeToParcel(parcel: android.os.Parcel, flags: Int) {
        parcel.writeLong(id)
        parcel.writeString(model)
        parcel.writeString(manufacturer)
        parcel.writeString(thumbnailSmall)
        parcel.writeString(thumbnailLarge)
        parcel.writeInt(engineSize)
        parcel.writeInt(speed)
        parcel.writeInt(acceleration)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Car> {
        override fun createFromParcel(parcel: android.os.Parcel): Car {
            return Car(parcel)
        }

        override fun newArray(size: Int): Array<Car?> {
            return arrayOfNulls(size)
        }
    }
}
*/
