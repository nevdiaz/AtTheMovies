package edu.cnm.deepdive.atthemovies;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import edu.cnm.deepdive.atthemovies.model.Movie;
import edu.cnm.deepdive.atthemovies.model.dao.MovieDao;

@Database(entities = {Movie.class}, version = 1)
public abstract class MoviesDatabase extends RoomDatabase {

  public abstract MovieDao movieDao();

  private static MoviesDatabase INSTANCE;

  static MoviesDatabase getInstance(Context context){
    if (INSTANCE == null){
      INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
          MoviesDatabase.class, "movies_room").build();
    }
    return INSTANCE;
  }

}
