$(document).ready(function () {
    $(".linkForHeadlineOfListOfTask").hide();
    $(".headlineOfListOfTask").change(function () {
        var elem = this.value;
        $(".linkForHeadlineOfListOfTask").attr('href', function () {
            $(".linkForHeadlineOfListOfTask").show();
            return this.href + elem;
        });
    });
});
$(document).ready(function () {
    $(".linkForHeadlineOfTask").hide();
    $(".headlineOfTask").change(function () {
        var elem = this.value;
        $(".linkForHeadlineOfTask").attr('href', function () {
            $(".linkForHeadlineOfTask").show();
            return this.href + elem;
        });
    });
});
$(document).ready(function () {
    $(".linkForTitleOfTask").hide();
    $(".titleOfTask").change(function () {
        var elem = this.value;
        $(".linkForTitleOfTask").attr('href', function () {
            $(".linkForTitleOfTask").show();
            return this.href + elem;
        });
    });
});