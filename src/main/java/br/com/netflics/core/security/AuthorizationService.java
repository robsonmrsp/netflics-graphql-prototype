package br.com.netflics.core.security;

import java.util.List;

import br.com.netflics.model.Item;
import br.com.netflics.model.Permission;
import br.com.netflics.model.Role;
import br.com.netflics.model.User;

/**
*  generated by JSetup v0.95 :  at 1 de fev de 2023 23:43:21
**/

public interface AuthorizationService {


	public Boolean authorizeRestServiceAccess(String method, String requestURI);

	public List<Permission> getAllPermissions();

	public Boolean authorizeWebComponentsAccess(final String type, final String identifier);

	
}
