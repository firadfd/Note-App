package fd.firad.plan2do.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import fd.firad.plan2do.dataBase.MyDAO
import fd.firad.plan2do.dataBase.RoomDB
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HiltModules {

    @Singleton
    @Provides
    fun bindMyDao(roomDB: RoomDB): MyDAO = roomDB.myNotesDAO()

    @Provides
    @Singleton
    fun provideDatabaseInstance(@ApplicationContext context: Context): RoomDB =
        Room.databaseBuilder(context, RoomDB::class.java, "notes")
            .allowMainThreadQueries().build()


}