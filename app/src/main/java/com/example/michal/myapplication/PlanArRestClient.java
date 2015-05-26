package com.example.michal.myapplication;

import com.example.michal.myapplication.Data.EmailAndPassword;
import com.example.michal.myapplication.Data.KomentarzProwadzacy;
import com.example.michal.myapplication.Data.KomentarzWydarzenie;
import com.example.michal.myapplication.Data.Plan;
import com.example.michal.myapplication.Data.Prowadzacy;
import com.example.michal.myapplication.Data.Termin;
import com.example.michal.myapplication.Data.User;
import com.example.michal.myapplication.Data.Wydarzenie;

import org.androidannotations.annotations.rest.Get;
import org.androidannotations.annotations.rest.Post;
import org.androidannotations.annotations.rest.RequiresHeader;
import org.androidannotations.annotations.rest.Rest;
import org.androidannotations.api.rest.RestClientHeaders;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

/**
 * Created by Mariusz on 2015-05-25.
 */
@Rest(rootUrl = "https://dsp-planar.cloud.dreamfactory.com:443/rest",
        converters = { MappingJackson2HttpMessageConverter.class })
@RequiresHeader({"X-Dreamfactory-Application-Name"})
public interface PlanArRestClient extends RestClientHeaders {

    @Post("/user/session")
    User login(EmailAndPassword emailAndPassword);

    @Post("/user/register/?login=true")
    User register(EmailAndPassword emailAndPassword);

    @Post("/db/komentarzWydarzenie")//komentWydrzenie
    KomentarzWydarzenie addComWydarzenie(EmailAndPassword emailAndPassword);

    @Get("/db/komentarzWydarzenie?filter={path}")
    KomentarzWydarzenie getComWydarzenie(String path);

    @Post("/db/komentarzProwadzacy")//komentPro
    KomentarzProwadzacy addComProwadzacy(EmailAndPassword emailAndPassword);
    @Get("/db/komentarzProwadzacy?filter={path}")
    KomentarzProwadzacy getComProwadzacy(String path);

    @Get("/db/wydarzenie?filter={path}") //wydarzenie
    Wydarzenie getWydarzenie(String path);

    @Get("/db/termin?filter={path}") //termin
    Termin getTermin(String path);

    @Get("/db/prowadzacy?filter={path}") //prowadzacy
    Prowadzacy getProwadzacy(String path);

    @Get("/db/plan?filter={path}") //plan
    Plan getPlan(String path);
}
