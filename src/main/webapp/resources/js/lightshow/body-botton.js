// Drag and Drop
var countTrack; // кол-во дорожек

$(function() {
    $('#nameEffectLabel').draggable({
        helper: "clone",
        snap: "#show-track-1",
        snapMode: "inner" // привязка к внутренним краям
    });
    $('#show-track-1').droppable({
        drop: function() { // перетащено
            draggedEffect();
        },
        activate: function() {
            $('#show-track-1').css({
                border: "medium double green"
            });
        },
        deactivate: function() {
            $('#show-track-1').css({
                border: "1px solid #fffc16"
            });
        }
    });
});

// эффект перетащен
function draggedEffect() {

}