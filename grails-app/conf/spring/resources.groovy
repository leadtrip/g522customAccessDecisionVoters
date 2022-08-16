import wood.mike.CustomAccessVoter
import wood.mike.UserPasswordEncoderListener
// Place your Spring DSL code here
beans = {
    userPasswordEncoderListener(UserPasswordEncoderListener)

    customAccessVoter(CustomAccessVoter){
        controllerActionPermissionService = ref('controllerActionPermissionService')
    }
}
