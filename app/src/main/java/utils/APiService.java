package utils;

import pojo.CoinResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by UTYLO on 11/3/2017.
 */

public interface APiService {
    @GET("data/pricemulti?")
    public Call<CoinResponse> getPrice(@Query("fsyms") String coins, @Query("tsyms") String currency);

}

