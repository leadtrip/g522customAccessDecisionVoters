Grails app with spring security enabled with a custom access decision voter

A table has been added that maps a user to a controller and comma separated list of actions that that user
is allowed to access.

The custom voter inspects this table for controllers/actions annotated with @Secured("hasRole('CUSTOM_ACCESS_ONLY')")

2 x users are bootstrapped, user1 and user2 with password = password

user1 can access custom controller actions index & create but not update & user2 can't access any actions