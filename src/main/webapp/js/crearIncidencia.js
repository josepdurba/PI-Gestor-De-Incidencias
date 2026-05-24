const formulario =
document.getElementById("incidenciaForm");

if(formulario){

    const descripcion =
    document.getElementById("descripcion");

    const mensajeError =
    document.getElementById("mensajeError");


    formulario.addEventListener(
    "submit",
    function(e){

        let correcto = true;

        mensajeError.textContent = "";

   
        descripcion.classList.remove("error");
    


        // Campos obligatorios

        if(descripcion.value.trim()===""){

            descripcion.classList.add("error");
            correcto=false;

        }


        // descripción mínima

        if(
        descripcion.value.trim().length>0
        &&
        descripcion.value.trim().length<10
        ){

            descripcion.classList.add("error");

            mensajeError.textContent=
            "La descripción debe tener mínimo 10 caracteres";

            correcto=false;

        }


        if(!correcto){

            e.preventDefault();

            if(
            mensajeError.textContent===""
            ){

                mensajeError.textContent=
                "Completa los campos obligatorios";

            }

        }

    });

    descripcion.addEventListener(
    "input",
    limpiarErrores
    );


    function limpiarErrores(){

        this.classList.remove(
        "error"
        );

        mensajeError.textContent="";

    }

}