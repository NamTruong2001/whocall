package com.truong.whocall;

import io.javalin.Javalin;
import static io.javalin.apibuilder.ApiBuilder.*;

import com.truong.whocall.ApiHandler.UserHandler;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        var app = Javalin.create(config -> {
            config.router.apiBuilder(() -> {
                path("/users", () -> {
                    get(UserHandler::getAllUsers);
                    put(ctx -> {
                        UserHandler.connectApplication(ctx, ctx.queryParam("username"));
                    });
                    delete(ctx -> {
                        UserHandler.leaveApplication(ctx, ctx.queryParam("username"));
                    });
                });
            });
        })
                .get("/", ctx -> ctx.result("Hello World"))
                .start(7070);
        app.get("/test", ctx -> {
            System.out.println(ctx.cookieMap());
            ctx.result("Hello " + ctx.host() + " " + ctx.ip());
        });

    }
}
