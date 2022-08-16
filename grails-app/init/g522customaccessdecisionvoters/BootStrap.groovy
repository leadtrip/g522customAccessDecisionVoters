package g522customaccessdecisionvoters

import grails.gorm.transactions.Transactional
import wood.mike.ControllerActionPermission
import wood.mike.Role
import wood.mike.User
import wood.mike.UserRole

class BootStrap {

    def init = {
        addTestUsers()
    }

    @Transactional
    void addTestUsers() {
        def adminRole = new Role(authority: 'ROLE_ADMIN').save()
        def user1 = new User(username: 'user1', password: 'password').save()
        def user2 = new User(username: 'user2', password: 'password').save()

        UserRole.create user1, adminRole
        UserRole.create user2, adminRole

        new ControllerActionPermission(user: user1, controller: 'customAccess', actions: 'index' ).save()
    }

    def destroy = {
    }
}
