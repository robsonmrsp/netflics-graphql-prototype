package br.com.netflics.core.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;

import br.com.netflics.model.Group;
import br.com.netflics.model.Item;
import br.com.netflics.model.Permission;
import br.com.netflics.model.Role;
import br.com.netflics.model.User;

/**
 * generated by JSetup v0.95 :  at 1 de fev de 2023 23:43:21
 **/

@Named
@Transactional
public class AuthorizationServiceImp implements AuthorizationService {

	@Inject
	UserContext context;

	public Boolean authorizeRestServiceAccess(String method, String requestURI) {
		// por enquanto...
		if (requestURI.contains("rs/auth")) {
			return Boolean.TRUE;
		}

		if (requestURI.endsWith(".css") || requestURI.endsWith(".js") || requestURI.endsWith(".png") || requestURI.endsWith(".gif")) {
			return Boolean.TRUE;
		}

		if (requestURI.contains("swagger")) {
			return Boolean.TRUE;
		}
		if (requestURI.contains("api-docs")) {
			return Boolean.TRUE;
		}

		if (requestURI.contains("rs/crud/uploads")) {
			return Boolean.TRUE;
		}

		String operation = getType(method);
		String identifier = getIdentifier(requestURI);

		for (Permission permission : getAllPermissions()) {
			Item item = permission.getItem();

			if (permission.getOperation().equals(operation) && (identifier.matches(item.getIdentifier()) || identifier.equals(item.getIdentifier()))) {
				return Boolean.TRUE;
			}
		}

		return Boolean.FALSE;
	}

	public List<Permission> getAllPermissions() {
		User currentUser = context.getCurrentUser();

		List<Permission> permitions = new ArrayList<Permission>();

		for (Role role : currentUser.getRoles()) {
			for (Group group : role.getGroups()) {
				permitions.addAll(group.getPermissions());
			}
		}
		return permitions;
	}

	public Boolean authorizeWebComponentsAccess(final String type, final String identifier) {

		Boolean authorize = Boolean.FALSE;

		List<Permission> allPermissions = getAllPermissions();

		Predicate<Permission> predicate = new Predicate<Permission>() {
			@Override
			public boolean apply(Permission permission) {
				if (permission.getItem() != null && permission.getItem().getItemType() != null) {
					// System.out.println(permission.getItem().getName());
					return permission.getItem().getItemType().equalsIgnoreCase(type);
				} else
					return false;
			}
		};
		Collection<Permission> collectionPermissions = Collections2.filter(allPermissions, predicate);

		// if (type.equals("SCREEN")) {
		for (Permission permission : collectionPermissions) {
			Item item = permission.getItem();
			System.out.println(identifier + ' ' + item.getIdentifier());
			if (item != null && (identifier.equalsIgnoreCase(item.getIdentifier()) || identifier.matches(item.getIdentifier()))) {
				return Boolean.TRUE;
			}
		}
		// }

		return authorize;
	}

	private String getType(String requestMethod) {
		if (requestMethod.equals("GET"))
			return "LEITURA";
		if (requestMethod.equals("PUT"))
			return "ATUALIZACAO";
		if (requestMethod.equals("POST"))
			return "ESCRITA";
		if (requestMethod.equals("DELETE"))
			return "DELECAO";
		return "";
	}

	private String getIdentifier(String requestURI) {
		String identifier = "";
		try {
			identifier = requestURI.substring(requestURI.indexOf("rs/") + 3);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return identifier;
	}
}
