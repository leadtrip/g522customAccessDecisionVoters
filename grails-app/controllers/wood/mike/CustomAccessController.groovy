package wood.mike

import grails.plugin.springsecurity.annotation.Secured

@Secured("hasRole('CUSTOM_ACCESS_ONLY')")
class CustomAccessController {

    def index() {
        render 'You have custom access'
    }
}
