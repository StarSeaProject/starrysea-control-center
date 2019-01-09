package top.starrysea.hateoas;

import java.util.Map;

import top.starrysea.StarryseaRouterFunctions;
import top.starrysea.UrlInfo;

public class LinkBinding {

	private LinkBinding() {
	}

	public static Link linkTo(Class<?> clazz, String method) {
		Map<StarryseaControllerHandle, UrlInfo> handlerMapping = StarryseaRouterFunctions.getHandlerMapping();
		UrlInfo urlInfo = handlerMapping.get(StarryseaControllerHandle.of(clazz, method));
		return new Link(urlInfo.getUrl(), urlInfo.getMethod());
	}

	public static Link linkTo(Class<?> clazz, String method, Map<String, Object> template) {
		Map<StarryseaControllerHandle, UrlInfo> handlerMapping = StarryseaRouterFunctions.getHandlerMapping();
		UrlInfo urlInfo = handlerMapping.get(StarryseaControllerHandle.of(clazz, method));
		String url = urlInfo.getUrl();
		Map<String, Object> templateTemp = template;
		for (Map.Entry<String, Object> entry : template.entrySet()) {
			if (url.contains(entry.getKey())) {
				url = url.replaceAll("\\{" + entry.getKey() + "\\}", (String) entry.getValue());
				urlInfo.setUrl(url);
				templateTemp.remove(entry.getKey());
			}
		}
		return new Link(urlInfo.getUrl(), urlInfo.getMethod(), templateTemp);
	}
}
