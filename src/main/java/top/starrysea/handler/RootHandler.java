package top.starrysea.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;
import top.starrysea.dto.Hello;
import top.starrysea.hateoas.StarryseaMediaType;
import top.starrysea.repository.HelloRepository;
import top.starrysea.vo.HelloResource;

@Component
public class RootHandler {

	@Autowired
	private HelloRepository helloRepository;

	public Mono<ServerResponse> hello(ServerRequest request) {
		Mono<Hello> hellos = helloRepository.findById(Long.parseLong(request.pathVariable("id")));
		Mono<HelloResource> helloResouce = hellos.map(HelloResource::of);
		return ServerResponse.ok().contentType(StarryseaMediaType.APPLICATION_JSON_STARRYSEA).body(helloResouce,
				HelloResource.class);
	}

}
