package top.starrysea.hateoas;

import java.util.Map;

public class Link {

	private String href;
	private Method method;
	private Map<String, Object> template;

	public Link(String href) {
		this.href = href;
		this.method = Method.GET;
	}

	public Link(String href, Method method) {
		this.href = href;
		this.method = method;
	}

	public Link(String href, Method method, Map<String, Object> template) {
		this.href = href;
		this.method = method;
		this.template = template;
	}

	public String getHref() {
		return href;
	}

	public Method getMethod() {
		return method;
	}

	public Map<String, Object> getTemplate() {
		return template;
	}

}
