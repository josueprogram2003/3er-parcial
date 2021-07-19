<%-- 
    Document   : index
    Created on : 19 jul. 2021, 13:12:46
    Author     : jdomi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Parcial</title>
    <link rel="stylesheet" href="recursos/css/bootstrap.min.css" />
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Material+Icons+Outlined"/>
    <link rel="stylesheet" href="recursos/css/style.css" />
  </head>
  <body>
    <div class="container-sm">
      <div class="row">
        <div class="col-12">
          <div class="d-flex justify-content-center flex-column">
            <div class="bg-primary">
              <h1 class="text-white mx-2">Ventas</h1>
            </div>
            <form class="d-flex flex-column border border-primary">
              <div class="m-2 p-1" id="sucursal"></div>
              <div class="m-2 p-1" id="cliente"></div>
              <input class="m-2 p-1" id="fecha" type="date" />
              <select class="m-2 p-1" name="documento" id="tipo">
                <option value="0" disabled>Seleccion tipo de documento</option>
                <option value="Boleta">Boleta</option>
                <option value="Factura">Factura</option>
              </select>
              <button class="btn btn-primary w-25 mx-3 my-1" id="agregar">Agregar</button>
            </form>
          </div>
        </div>
      </div>
      <div class="row mt-4">
        <table class="table">
          <thead class="table-primary">
            <tr>
              <th scope="col">#</th>
              <th scope="col">Sucursal</th>
              <th scope="col">Cliente</th>
              <th scope="col">Fecha</th>
              <th scope="col">Documento</th>
              <th scope="col">Accion</th>
            </tr>
          </thead>
          <tbody id="tbd">
            <tr></tr>
          </tbody>
        </table>
      </div>
    </div>
      
      <script src="recursos/js/jquery.js"></script>
      <script src="recursos/js/bootstrap.min.js"></script>
      <script src="recursos/js/venta.js"></script>
  </body>
</html>
