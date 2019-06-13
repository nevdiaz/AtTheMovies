package edu.cnm.deepdive.atthemovies.model.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import edu.cnm.deepdive.atthemovies.model.Movie;

import java.util.List;

@Dao
public interface MovieDao {

  @Insert
  void insert(Movie movie);

  @Query("SELECT * FROM movie")
  List<Movie> getAll();

}
