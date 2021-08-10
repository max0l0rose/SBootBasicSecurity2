const pass_field = document.querySelector("#password");
if (pass_field) {
    pass_field.setAttribute("minlength", 5);
}

const show_btn = document.querySelector("#basic-addon");

if (show_btn) {
    show_btn.addEventListener("click", function() {
    //    alert("pass_field: " + pass_field);
      if (pass_field.type === "password") {
            pass_field.type = "text";
            show_btn.classList.add("hide");
        } else {
            pass_field.type = "password";
            show_btn.classList.remove("hide");
        }
    });
}

console.log("pass_field: " + pass_field);
//alert("2");
