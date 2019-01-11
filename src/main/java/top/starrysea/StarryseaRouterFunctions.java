package top.starrysea;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.RequestPredicate;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import top.starrysea.hateoas.StarryseaControllerHandle;
import top.starrysea.hateoas.UrlInfo;

@Component
public class StarryseaRouterFunctions {

	private StarryseaRouterFunctions() {
	}

	private static RouterFunction<ServerResponse> routerFunction;

	private static Map<StarryseaControllerHandle, UrlInfo> handlerMapping = new HashMap<>();

	public static RouterFunction<ServerResponse> route(RequestPredicate predicate,
			HandlerFunction<ServerResponse> handlerFunction, UrlInfo urlInfo) {
		handlerMapping.put(urlInfo.getHandle(), urlInfo);
		if (routerFunction == null) {
			routerFunction = RouterFunctions.route(predicate, handlerFunction);
		}
		return routerFunction;
	}

	@Bean
	public static Map<StarryseaControllerHandle, UrlInfo> getHandlerMapping() {
		return handlerMapping;
	}
}
