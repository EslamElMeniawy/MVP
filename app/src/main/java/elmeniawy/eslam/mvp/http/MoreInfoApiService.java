package elmeniawy.eslam.mvp.http;

import elmeniawy.eslam.mvp.http.apimodel.OmdbApi;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * MoreInfoApiService
 * <p>
 * Created by Eslam El-Meniawy on 04-Mar-2018.
 * CITC - Mansoura University
 */

public interface MoreInfoApiService {
    @GET("/")
    Observable<OmdbApi> getCountry(@Query("t") String title);
}
