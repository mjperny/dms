import org.apache.shiro.SecurityUtils;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.util.Factory;
import org.apache.shiro.mgt.SecurityManager;

import play.*;

/**
 * The global settings are configured in this class. 
 * 
 * @author Gary Ye
 * @version 2014-06-07
 */
public class Global extends GlobalSettings {

  @Override
  public void onStart(Application app) {
    Logger.info("Application has started");
    
    // Creates a new security manager for the global SecurityUtils
    Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
    SecurityManager securityManager = factory.getInstance();
    SecurityUtils.setSecurityManager(securityManager);
  }
  
  @Override
  public void onStop(Application app) {
    Logger.info("Application shutdown...");
  }  
    
}