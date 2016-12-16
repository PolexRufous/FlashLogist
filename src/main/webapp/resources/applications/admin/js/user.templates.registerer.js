define(['text!user_templ', 'text!user_edit_templ', 'text!users_templ', 'config'], function (user, useredit, users, config) {
    define.amd.dust = true;
    var userTempl = user;
    var userEditTempl = useredit;
    var usersTempl = users;

    require(['dust'], function (dust) {
        console.log(dust);
        if (!dust) {
            setTimeout(2000, function () {
               compileAndLoad(dust);
            });
        } else {
            compileAndLoad(dust);
        }
    });

    function compileAndLoad(dust) {
        //if templates is not already compiled
        if (true) {
            dust.compile(config.templates.userrow, user);
            dust.compile(config.templates.useredit, useredit);
            dust.compile(config.templates.users, users);
        }

        dust.loadSource(userTempl);
        dust.loadSource(userEditTempl);
        dust.loadSource(usersTempl);
    }
});
