package wood.mike

import grails.plugin.springsecurity.annotation.Secured

@Secured("hasRole('CUSTOM_ACCESS_ONLY')")
class CustomAccessController {

    def index() {
        render 'You have index access'
    }

    def create() {
        render 'You have create access'
    }

    def update() {
        render 'You have update access'
    }
}
