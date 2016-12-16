define(['user', 'users', 'userrow', 'allusers'], function (UserModel, UsersCollection, UserRowView, AllUsersView) {
    define.amd.dust = true;
    return {

        start: function () {
            AllUsersView.render();
        }
    };
});
