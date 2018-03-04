package elmeniawy.eslam.mvp.http;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * ApiModuleForName
 * <p>
 * Created by Eslam El-Meniawy on 04-Mar-2018.
 * CITC - Mansoura University
 */

@Module
public class ApiModuleForName {
    private final String API_KEY = "084f18e0d3ad3bd4f99dd98a07422acf";

    @Provides
    @Singleton
    OkHttpClient provideClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);

        return new OkHttpClient.Builder().addInterceptor(interceptor).addInterceptor(chain -> {
            Request request = chain.request();
            HttpUrl url = request.url().newBuilder().addQueryParameter("api_key", API_KEY).build();
            request = request.newBuilder().url(url).build();
            return chain.proceed(request);
        }).build();
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(String baseURL, OkHttpClient client) {
        return new Retrofit.Builder()
                .baseUrl(baseURL)
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    MovieApiService provideApiService() {
        String BASE_URL = "https://api.themoviedb.org/3/movie/";
        return provideRetrofit(BASE_URL, provideClient()).create(MovieApiService.class);
    }
}
