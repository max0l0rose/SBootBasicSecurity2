const pass_field = document.querySelector("#password");
if (pass_field) {
    pass_field.setAttribute("minlength", 5);
}

const show_btn = document.querySelector("#basic-addon");
//const i = document.getElementsByClassName("i");
const eye = document.querySelector("#eye");

// document.addEventListener("DOMContentLoaded", function(event) {
//     alert("eye = " + eye.getBoundingClientRect().width);
// });

// window.onload = function onload1() {
//     alert("eye window.onload = " + eye.getBoundingClientRect().width);
// }

// $(document).ready(function() {
//     //alert("eye $document.ready = " + $(eye).css("background-color"));
//     alert("eye $document.ready = " + $(eye).css("width"));
//     alert("eye $document.ready = " + eye.getBoundingClientRect().width);
// });

// var w = 0;
//
// var observer = new MutationObserver(function(mutations) {
//     mutations.forEach(function(mutationRecord) {
// //        alert('style changed!')
//         var a = $(eye).width();
//         if (w<a)
//             w = a;
//         console.log("eye style changed: " + w + ", " + a);
//     });
// });
// observer.observe(eye, { attributes : true }); //, attributeFilter : ['style']


// document.addEventListener("DOMContentLoaded", () => {
// //    alert("DOM готов!");
//     alert("eye = " + eye.getBoundingClientRect().width);
// });


// eye.addEventListener("loadend", () => {
// //    alert("DOM готов!");
// //    alert("eye = " + eye.getBoundingClientRect().width);
//     console.log("eye loaded = " + eye.getBoundingClientRect().width);
// });

// eye.onloadend = function () {
// }

if (show_btn) {
    show_btn.addEventListener("click", function() {
        //    alert("pass_field: " + pass_field);
        var w = $(eye).width();
        if (pass_field.type === "password") {
            //w = eye.getBoundingClientRect().width;
            // console.log("password: " + w);
            //alert("w = " + w);

            pass_field.type = "text";
            show_btn.classList.add("hide");

            eye.classList.remove("fa-eye");
            eye.classList.add("fa-eye-slash");
        } else {
            //w = eye.getBoundingClientRect().width;
            //console.log("else: " + w);

            pass_field.type = "password";
            show_btn.classList.remove("hide");

            eye.classList.remove("fa-eye-slash");
            eye.classList.add("fa-eye");
        }
        eye.style.width = w;
    });
}

//console.log("pass_field: " + pass_field);
//alert("2");
