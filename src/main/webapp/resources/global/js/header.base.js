window.onload = function () {
    $('.menu-container').find('.parent-span').on('click', function (event) {
        var element = $(event.currentTarget);
        var showingMenu = $(element.siblings('.container')[0]);
        if (showingMenu.hasClass('current')) {
            showingMenu.removeClass('current');
        } else {
            showingMenu.addClass("current");
            slowAppear(showingMenu);
        }
    });

    $('body').on('click', function (event) {
        var element = $(event.target);
        if (element.parents('.parent').length == 0) {
            $('.container.current').removeClass('current');
        }
    });

    function slowAppear(jQElement) {
        jQElement.css('opacity', 0.0);
        var intervalId = setInterval(function () {
            var currentOpacity = jQElement.css('opacity');
            currentOpacity = parseFloat(currentOpacity);
            if (currentOpacity < 1.0) {
                jQElement.css('opacity', currentOpacity + 0.1);
            } else {
                clearInterval(intervalId);
            }
        }, 100);
    }
};
