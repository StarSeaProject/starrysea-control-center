package top.starrysea.vo;

import java.util.HashMap;
import java.util.Map;

import top.starrysea.dto.Hello;
import top.starrysea.hateoas.Link;
import top.starrysea.hateoas.Method;
import top.starrysea.hateoas.Resource;

public class HelloResource extends Resource {

	private Long helloId;
	private String message;

	private HelloResource(Hello hello) {
		this.helloId = hello.getId();
		this.message = hello.getMessage();
		Map<String,Object> args=new HashMap<>();
		args.put("key1", "value1");
		args.put("key2", "value2");
		this.addLink(new Link("/next", Method.GET, args));
	}

	public static HelloResource of(Hello hello) {
		return new HelloResource(hello);
	}

	public Long getHelloId() {
		return helloId;
	}

	public void setHelloId(Long helloId) {
		this.helloId = helloId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
