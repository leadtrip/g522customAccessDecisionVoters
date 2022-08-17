Grails app with spring security enabled with a custom access decision voter

A table has been added that maps a user to a controller and comma separated list of actions that that user
is allowed to access.

The custom voter inspects this table for controllers/actions annotated with @Secured("hasRole('CUSTOM_ACCESS_ONLY')")

2 x users are bootstrapped, user1 and user2 with password = password

user1 can access custom controller actions index & create but not update & user2 can't access any actions

To get this all wired up:
* Class CustomAccessVoter implements AccessDecisionVoter & is annotated with @Component
* Class Application is annotated with @ComponentScan('wood.mike')
* The custom voter is added to a list with standard voters as a config item in application.groovygrails.plugin.springsecurity.voterNames = ['customAccessVoter'...

In addition to above
* A standard grails service is used in the CustomAccessVoter which must be annotated with @AutoWired
* Class CustomAccessVoter also implements WebAttributes to get hold of controller and action details