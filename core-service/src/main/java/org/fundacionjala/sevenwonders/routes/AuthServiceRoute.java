package org.fundacionjala.sevenwonders.routes;

import org.apache.camel.BeanInject;
import org.apache.camel.model.rest.RestBindingMode;
import org.apache.camel.spring.SpringRouteBuilder;
import org.fundacionjala.sevenwonders.beans.AuthService;
import org.fundacionjala.sevenwonders.beans.GameRoomService;
import org.fundacionjala.sevenwonders.core.rest.PlayerModel;

/**
 * Created by dwits on 24/08/2016.
 */
public class AuthServiceRoute extends SpringRouteBuilder {


    @BeanInject("authService")
    AuthService authService;


    @Override
    public void configure() throws Exception {


        restConfiguration().component("jetty")
                .bindingMode(RestBindingMode.json)
                .dataFormatProperty("prettyPrint", "true")
                .port(9999);


        rest("/login").description("Loguin rest service")
                .consumes("application/json").produces("application/json")

                .post().description("Create a player").type(PlayerModel.class)
                .to("bean:authService?method=login");
    }
}