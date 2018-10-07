package com.quicksilver.moviesapp.repositories;

import com.quicksilver.moviesapp.http.HttpRequester;
import com.quicksilver.moviesapp.models.User;
import com.quicksilver.moviesapp.parsers.base.JsonParser;
import com.quicksilver.moviesapp.repositories.base.UserRepository;

import java.io.IOException;

public class HttpUsersRepository implements UserRepository {

    private final HttpRequester mHttpRequester;
    private final JsonParser<User> mJsonParser;
    private final String mLoginUrl;
    private final String mRegisterUrl;

    public HttpUsersRepository(HttpRequester httpRequester, JsonParser<User> jsonParser, String serverUrl) {
        this.mHttpRequester = httpRequester;
        this.mJsonParser = jsonParser;
        this.mLoginUrl = serverUrl + "/login";
        this.mRegisterUrl = serverUrl + "/users/register";
    }

    @Override
    public User login(User item) throws IOException {
        String requestBody = mJsonParser.toJson(item);
        String responseBody = mHttpRequester.post(mLoginUrl, requestBody);

        return mJsonParser.fromJson(responseBody);
    }

    @Override
    public User register(User item) throws IOException {
        String requestBody = mJsonParser.toJson(item);
        String responseBody = mHttpRequester.post(mRegisterUrl, requestBody);

        return mJsonParser.fromJson(responseBody);
    }
}
