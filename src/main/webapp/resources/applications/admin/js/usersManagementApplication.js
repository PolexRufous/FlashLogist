define(['user', 'users', 'userrow', 'allusers'], function (UserModel, UsersCollection, UserRowView, AllUsersView) {
    return {
        start: function () {
            new AllUsersView({model: new UserModel()}).render();
        }
    };
});
