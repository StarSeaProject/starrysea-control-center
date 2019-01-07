package top.starrysea.vo;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

import top.starrysea.dto.Hello;

public class HelloResource extends ResourceSupport {

	private Long helloId;
	private String message;

	private HelloResource(Hello hello) {
		this.helloId = hello.getId();
		this.message = hello.getMessage();
		this.add(new Link("/next", "next"));
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
