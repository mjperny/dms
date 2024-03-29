package security;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

import models.Permission;
import models.Role;
import models.User;

import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.subject.PrincipalCollection;


/**
 * This realm is based on the Hibernate ORM technology to retrieve the data.
 * http://shiro.apache.org/static/1.2.3/xref/org/apache/shiro/realm/jdbc/JdbcRealm.html#338
 * @author Gary Ye
 * @version 2014-06-07
 */
public class MyRealm extends JdbcRealm {
	/**
	 * @see JdbcRealm#doGetAuthenticationInfo()
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) {
		UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
		String username = usernamePasswordToken.getUsername();
		String password = null;
		
		if (username == null)
			throw new AccountException(
					"Null usernames not allowed by this realm.");
		User user = User.find("byName", username).first();
		password = user.getPassword();
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(username,
				password, getName());
		return info;
	}
	
	/**
	 * @see JdbcRealm#doGetAuthorizationInfo()
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals){
		String username = (String) getAvailablePrincipal(principals);
		
		User user = User.find("byName", username).first();
		
		Set<String> roleNames = new LinkedHashSet<String>();
		Set<String> permissionNames = new LinkedHashSet<String>();
		for(Role role: user.getRoles()){
			roleNames.add(role.getRoleName());
			for(Permission permission: role.getPermissions()){
				permissionNames.add(permission.getPermissionName());
			}
		}
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roleNames);
	    info.setStringPermissions(permissionNames);
		return info;
	}

}
