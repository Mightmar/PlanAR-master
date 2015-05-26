package com.example.michal.myapplication;

import com.example.michal.myapplication.Data.EmailAndPassword;
import com.example.michal.myapplication.Data.KomentarzProwadzacy;
import com.example.michal.myapplication.Data.KomentarzWydarzenie;
import com.example.michal.myapplication.Data.User;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.rest.RestService;

/**
 * Created by Mariusz on 2015-05-25.
 */
@EBean
public class RestBackgroundTask {

    @RootContext
    LoginActivity activity;

    @RestService
    PlanArRestClient restClient;

    @Background
     void addComWydarzenie(EmailAndPassword emailAndPassword) {
        try {
            restClient.setHeader("X-Dreamfactory-Application-Name", "PlanAR_AiB");
            KomentarzWydarzenie komentarzWydarzenie = restClient.addComWydarzenie(emailAndPassword);
        } catch (Exception e) {
            publishError(e);
        }
    }

    @Background
    void addComProwadzacy(EmailAndPassword emailAndPassword) {
        try {
            restClient.setHeader("X-Dreamfactory-Application-Name", "PlanAR_AiB");
            KomentarzProwadzacy komentarzProwadzacy = restClient.addComProwadzacy(emailAndPassword);
        } catch (Exception e) {
            publishError(e);
        }
    }

    @UiThread
    void publishResult(User user) {
        activity.loginSuccess(user);
    }

    @UiThread
    void publishError(Exception e) {
        activity.showError(e);
    }

}