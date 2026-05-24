const formulario = document.getElementById("loginForm");

if (formulario) {

    const usuarioInput = document.getElementById("usuario");
    const passwordInput = document.getElementById("password");
    const mensajeError = document.getElementById("mensajeError");
    const botonVerPass = document.getElementById("verPass");

    
    const params = new URLSearchParams(window.location.search);
    const error = params.get("error");

    
    if (error === "1") {
        mensajeError.textContent = "Usuario o contraseña incorrectos";
        
        usuarioInput.classList.add("error");
        passwordInput.classList.add("error");

         if (error) {
        window.history.replaceState({}, document.title, "login.html");
        }
    }


    formulario.addEventListener("submit", function(e){

        let usuario = usuarioInput.value.trim();
        let password = passwordInput.value.trim();

        mensajeError.textContent = "";


        if(usuario === "" || password === ""){

            e.preventDefault();

            mensajeError.textContent = "Debes completar todos los campos";

            usuarioInput.classList.remove("error");
            passwordInput.classList.remove("error");


            if(usuario === ""){
                usuarioInput.classList.add("error");
            }

            if(password === ""){
                passwordInput.classList.add("error");
            }
        }

    });


    usuarioInput.addEventListener("input", limpiarError);

    passwordInput.addEventListener("input", limpiarError);


    function limpiarError(){

        this.classList.remove("error");

        mensajeError.textContent="";


    }


    botonVerPass.addEventListener("click", function(){

        if(passwordInput.type === "password"){

            passwordInput.type = "text";

            botonVerPass.textContent = "🙈";

        }else{

            passwordInput.type = "password";

            botonVerPass.textContent = "👁";

        }

    });
}