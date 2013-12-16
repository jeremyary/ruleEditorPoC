/*
   JavaScript file for editor.jsp [EntryController]

   author jary
   since Dec/12/2013
*/
$(function () {
    $(".ruleBox").each(function () {

        var $this = $(this);

        // hang on to the original position so that we can restore it
        $this.data({
            'originalLeft': $this.css('left'),
            'originalTop': $this.css('top')
        });

        $this.draggable({
            stop: function (event, ui) {

                var $leftBar = $('#leftBar');

                // if the rule type has entered the stage, fade out move it  back to original position, show it
                if ($this.position().left > ($leftBar.position().left + $leftBar.width())) {
                    $this.fadeOut(function () {
                        $this.css({
                            'left': $this.data('originalLeft'),
                            'top': $this.data('originalTop')
                        });
                        $this.fadeIn();

                        // get the markup for the rule type selected and put it on stage
                        $.post(url.ruleTypeTarget, {ruleType: $this.attr('data-ruleType')}, function(data) {
                            $('#ruleStageContainer').append(data);

                            // wire up cancel/accept buttons on rule instance
                            $('#ruleStageContainer > .ruleStage:last-child > .cancel').click(function () {
                                $(this).parent().fadeOut(function () {
                                    $(this).css('display', 'none');
                                })
                            });
                            $('#ruleStageContainer > .ruleStage:last-child > .accept').click(function () {

                                var $form = $(this).parent().find('.ruleForm');
                                $.post(url.process, $form.serialize(), function(data) {

                                    $('.ruleResult').html("<pre>" + data + "</pre>");
                                    $form.parent('.ruleStage').fadeOut(function () {
                                        $(this).css('display', 'none');
                                    })
                                });
                            });

                            // show the rule instance
                            $('#ruleStageContainer > .ruleStage:last-child').fadeIn();
                        });
                    });
                }
            }
        });
    });
});