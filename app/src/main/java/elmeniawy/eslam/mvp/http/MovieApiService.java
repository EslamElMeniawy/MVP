package elmeniawy.eslam.mvp.http;

import elmeniawy.eslam.mvp.http.apimodel.TopRated;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * MovieApiService
 * <p>
 * Created by Eslam El-Meniawy on 04-Mar-2018.
 * CITC - Mansoura University
 */

public interface MovieApiService {
    @GET("top_rated")
    Observable<TopRated> getTopRatedMovies(@Query("page") Integer page);
}
