package fd.firad.plan2do.models

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "notes")
data class Notes(

    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,

    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "notes")
    var notes: String,

    @ColumnInfo(name = "date")
    var date: String,

    @ColumnInfo(name = "pinned")
    var priority: String
) : Parcelable
