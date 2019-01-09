package top.starrysea;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import top.starrysea.handler.RootHandler;
import top.starrysea.hateoas.HttpMethod;
import top.starrysea.hateoas.UrlInfo;

@Configuration
public class Router {

	@Autowired
	private RootHandler rootHandler;

	@Bean
	public RouterFunction<ServerResponse> routerFunction() {
		return StarryseaRouterFunctions.route(
				RequestPredicates.GET("/hello/{id}").and(RequestPredicates.accept(MediaType.TEXT_PLAIN)),
				rootHandler::hello, UrlInfo.of(rootHandler.getClass(), "hello", HttpMethod.GET, "/hello/{id}"));
	}
}
