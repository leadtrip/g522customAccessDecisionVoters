package wood.mike

import grails.core.GrailsControllerClass
import grails.web.api.WebAttributes
import groovy.util.logging.Slf4j
import org.springframework.security.access.AccessDecisionVoter
import org.springframework.security.access.ConfigAttribute
import org.springframework.security.core.Authentication

@Slf4j
class CustomAccessVoter implements AccessDecisionVoter<Object>, WebAttributes{

    static final CUSTOM_ACCESS_ONLY = 'CUSTOM_ACCESS_ONLY'

    ControllerActionPermissionService controllerActionPermissionService

    @Override
    boolean supports(ConfigAttribute attribute) {
        return attribute != null && String.valueOf(attribute).contains(CUSTOM_ACCESS_ONLY)
    }

    @Override
    boolean supports(Class<?> clazz) {
        return true
    }

    @Override
    int vote(Authentication authentication, Object object, Collection<ConfigAttribute> attributes) {
        for (ConfigAttribute configAttribute : attributes) {
            if (supports(configAttribute)) {

                GrailsControllerClass controllerClass = getControllerClass()

                if (controllerClass == null) {
                    log.debug("Unable to approve user for action because Controller Class is not yet known")
                    return ACCESS_DENIED
                }

                String destController = getControllerName()
                String destAction = getActionName() ?: controllerClass.defaultAction

                if( controllerActionPermissionService.isAllowed( authentication.principal.username, destController, destAction ) ) {
                    return ACCESS_GRANTED
                }

                return ACCESS_DENIED
            }
        }
        return ACCESS_ABSTAIN
    }
}
