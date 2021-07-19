/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
  listarSucursal();
  listarCliente();
    listarVenta();
});

let i = 0;

function listarSucursal() {
  let data = { "opc": 1 };
  $.get("TC", data, function (data) {
    let datos = JSON.parse(data);
    console.log(datos);
    let select = $("<select></select>").attr({"name": "sucursal", "id": "select1"});
    select.addClass("w-100 mt-2 p-1");
        select.append('<option disabled= "" selected="">Selecciona Sucursal</option>');
        //let fragment = document.createDocumentFragment();
        for (let dato of datos) {
            select.append('<option value=' + dato.id_s + '>' + dato.nombre + '</option>'); ;
        }
        $("#sucursal").append(select);
  });
}

function listarCliente() {
  let data = { "opc": 2 };
  $.get("TC", data, function (data) {
    let datos = JSON.parse(data);
    console.log(datos);
    let select = $("<select></select>").attr({"name": "sucursal", "id": "select2"});
        select.addClass("w-100 mt-2 p-1");
        select.append('<option disabled= "" selected="">Selecciona Cliente</option>');
        //let fragment = document.createDocumentFragment();
        for (let dato of datos) {
            select.append('<option value=' + dato.id_c + '>' +dato.nombre+" "+dato.apellidos +'</option>'); ;
        }
        $("#cliente").append(select);
  });
}


function listarVenta(){
    let data = { "opc": 1 };
  $.get("VC", data, function (data) {
    let x = JSON.parse(data);
    console.log(x);
     $("#tbd tr").remove();
     for (let i = 0; i < x.length; i++) {
            $("#tbd").append(
                  "<tr><td>" +
                    (i + 1) +
                    "</td><td>" +
                    x[i].sucursal +
                    "</td><td>" +
                    x[i].cliente +
                     "</td><td>" +
                    x[i].fecha +
                    "</td><td>" +
                     x[i].tipo_doc +
                    "</td><td class='d-flex'><a href='' onclick='editar(" +
                    x[i].id_v +
                    ")'><span class='material-icons-outlined'>description" +
                    "</span></a >" +                  
                    "<a href='' onclick='eliminar(" +
                    x[i].id_v +
                    ")'><span class='material-icons-outlined icon'>delete_outline" +
                    "</span></a></td></tr >");
        }
  });
}


$("#agregar").on("click",function (e){
    e.preventDefault();
   if (i===0) {
      let data = {"id_s":$("#select1").val(), "id_c": $("#select2").val(),"fecha":$("#fecha").val(),"tipo_doc":$("#tipo").val(), "opc": 2};
      console.log(data);
      $.get("VC", data, function (data) {
          alert(data);
          //limpiar();  
          listarVenta();
     });
    } 
});

function eliminar(id){
    event.preventDefault();
    alert(id);
    let data = {"id_v":id,"opc":3};
     $.get("VC", data, function (data) {
          alert(data);
          listarVenta();
     });
}


function limpiar(){
    $("#fecha").val("");
    $("#tipo").val("");
    $("#select1").val("");
    $("#select2").val("");
}
     
