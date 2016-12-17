define(['dust', 'text!user_templ', 'text!user_edit_templ', 'text!users_templ', 'config'], function (dust, user, useredit, users, config) {
    var userTempl = user;
    var userEditTempl = useredit;
    var usersTempl = users;

        //if templates is not already compiled
        if (true) {
            userTempl = dust.compile(user, config.templates.userrow);
            userEditTempl = dust.compile(useredit, config.templates.useredit);
            usersTempl = dust.compile(users, config.templates.users);
        }

        dust.loadSource(userTempl);
        dust.loadSource(userEditTempl);
        dust.loadSource(usersTempl);
});
