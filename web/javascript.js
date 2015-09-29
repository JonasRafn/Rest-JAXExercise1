$(document).ready(function () {
    createQuote("Friends are kisses blown to us by angels");
    createQuote("Do not take life too seriously. You will never get out of it alive");
    createQuote("Behind every great man, is a woman rolling her eyes");
    updateQuote();
});

$('#newQuote').on('click', function () {
    $('#qouteOfTheDay').empty();
    updateQuote();
});

$('#createQuotebutton').on('click', function () {
    createQuote($('#createQuoteInput').val());
    $('#createQuoteInput').val('');
});

$('#editQuoteButton').on('click', function () {
    var input = $('#editQuoteInput').val();
    var id = $('#editQuoteID').val();
    editQuote(input, id);
    $('#editQuoteInput').val('');
    $('#editQuoteID').val('');
});

$('#deleteQuoteButton').on('click', function () {
    var id = $('#deleteQouteID').val();
    deleteQuote(id);
    $('#deleteQouteID').val('');
});

function updateQuote() {
    var url = "/Rest-JAXExercise1/api/qoute";
    $.getJSON(url, function (qoute) {
        $('#qouteOfTheDay').append('<p>' + qoute + '</p>');
    });
}

function createQuote(input) {
    var url = "/Rest-JAXExercise1/api/qoute";
    $.ajax({
        url: url,
        method: 'POST',
        data: JSON.stringify({qoute: input}),
        contentType: 'application/json',
        processData: false
    });
}

function editQuote(input, id) {
    var url = "/Rest-JAXExercise1/api/qoute/" + id;
    $.ajax({
        url: url,
        method: 'PUT',
        data: JSON.stringify({qoute: input}),
        contentType: 'application/json',
        processData: false
    });
}

function deleteQuote(id) {
    var url = "/Rest-JAXExercise1/api/qoute/" + id;
    $.ajax({
        url: url,
        method: 'DELETE'
    });
}