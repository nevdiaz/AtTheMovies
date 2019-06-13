package edu.cnm.deepdive.atthemovies.viewmodel;

import android.app.Application;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import edu.cnm.deepdive.atthemovies.MoviesDatabase;
import edu.cnm.deepdive.atthemovies.model.Actor;
import edu.cnm.deepdive.atthemovies.model.Movie;
import java.util.List;

public class MoviesViewModel extends AndroidViewModel {

  private LiveData<List<Movie>> movies;
  private LiveData<List<Actor>> actors;


  public MoviesViewModel(@NonNull Application application) {
    super(application);
    MoviesDatabase db = MoviesDatabase.getInstance(application);
    movies = db.movieDao().getAll();
  }
  public LiveData<List<Movie>> getMoviesLiveData() {
    return movies;
  }

  public LiveData<List<Actor>> getActorsLiveData() {
    return actors;
  }

  public void addMovie(final Movie movie) {
    new Thread(new Runnable() {
      @Override
      public void run() {
        MoviesDatabase db = MoviesDatabase.getInstance(getApplication());
        db.movieDao().insert(movie);
      }
    }).start();
  }

  public void addActor(final Actor actor){
    new Thread(new Runnable() {
      @Override
      public void run() {
        MoviesDatabase db = MoviesDatabase.getInstance(getApplication());
      }
    }).start();
  }
  public LiveData<Movie> getMovie(Long id, Context context){
    MoviesDatabase db = MoviesDatabase.getInstance(getApplication());
    return db.movieDao().findById(id);

  }
}
