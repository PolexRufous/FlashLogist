window.onload = function () {
    $('.menu-container').find(' .parent').on('click', function (event) {
        var element = event.currentTarget;
        element = $(element).find('.container');
        if (element.is(':visible')) {
            //element.hide();
        } else {
            element.show();
        }
    });

   /* $('body').on('click', function (event) {
        var element = $(event.currentTarget);
        $('.menu-container').find('.parent').find('.container').each(function () {
            if (element != this) {
                if ($(this).is(':visible')) {
                    $(this).hide();
                }
            }
        });
    });*/
};
