window.onload = function () {
    $('.menu-container').find(' .parent').on('click', function (event) {
        var element = event.currentTarget;
        element = $(element).find('.container');
        element.addClass("current");
    });

    $('body').on('click', function (event) {
        if (!$(event.target).hasClass('menu-span')) {
            $('.container.current').removeClass('current');
        }
    });
};
