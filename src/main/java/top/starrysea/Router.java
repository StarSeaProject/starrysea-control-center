package top.starrysea;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import top.starrysea.handler.RootHandler;

@Configuration
public class Router {

	@Autowired
	private RootHandler rootHandler;

	@Bean
	public RouterFunction<ServerResponse> routerFunction() {
		return RouterFunctions.route(
				RequestPredicates.GET("/hello").and(RequestPredicates.accept(MediaType.TEXT_PLAIN)),
				rootHandler::hello);
	}
}
