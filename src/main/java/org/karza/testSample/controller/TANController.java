package org.karza.testSample.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.data.rest.webmvc.BasePathAwareController;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.util.UriComponents;

@BasePathAwareController
public class TANController {

	private static String BROWSER = "/browser";
	private static String INDEX = "/index.html";

	@RequestMapping(value = { "/", "" }, method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
	public View index(HttpServletRequest request) {
		return getRedirectView(request, false);
	}

	/**
	 * Redirects to the actual {@code index.html}.
	 * 
	 * @return
	 */
	@RequestMapping(value = "/browser", method = RequestMethod.GET)
	public View browser(HttpServletRequest request) {
		return getRedirectView(request, request.getRequestURI().endsWith("/browser"));
	}

	/**
	 * Returns the View to redirect to to access the HAL browser.
	 * 
	 * @param request
	 *            must not be {@literal null}.
	 * @param browserRelative
	 * @return
	 */
	private View getRedirectView(HttpServletRequest request, boolean browserRelative) {

		ServletUriComponentsBuilder builder = ServletUriComponentsBuilder.fromRequest(request);

		UriComponents components = builder.build();
		String path = components.getPath() == null ? "" : components.getPath();

		if (!browserRelative) {
			builder.path(BROWSER);
		}

		builder.path(INDEX);
		builder.fragment(browserRelative ? path.substring(0, path.lastIndexOf("/browser")) : path);

		return new RedirectView(builder.build().toUriString());
	}
}
