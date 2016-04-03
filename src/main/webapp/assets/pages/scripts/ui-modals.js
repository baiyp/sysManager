var UIModals = function () {
    var handleModals = function () {
        $("#draggable").draggable({
            handle: ".modal-header"
        });
    }
    return {
        init: function () {
            handleModals();
        }
    };
}();

jQuery(document).ready(function() {    
   UIModals.init();
});