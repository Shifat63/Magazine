$(document).ready(function(){
    (function($) {
        "use strict";

        // validate contactForm form
        $(function() {
            $('#contactForm').validate({
                rules: {
                    name: {
                        required: true,
                        minlength: 1,
                        maxlength: 100
                    },
                    email: {
                        required: true,
                        email: true
                    },
                    description: {
                        required: true,
                        minlength: 1,
                        maxlength: 2000
                    }
                },
                messages: {
                    name: {
                        required: "Please enter your name",
                        minlength: "Your name must contain at least 1 character",
                        maxlength: "Your name must contain at most 100 character"
                    },
                    email: {
                        required: "Please enter your email",
                        email: "Please enter a valid email address"
                    },
                    description: {
                        required: "Please enter your message",
                        minlength: "Message must contain at least 1 character",
                        maxlength: "Message must contain at most 2000 character"
                    }
                }
            })
        })
    })(jQuery)
 })