<%-- 
    Document   : RegistrarVenta
    Created on : 2/05/2024, 6:30:20 p. m.
    Author     : dell
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ventas</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
        <style>
            @media print{
                .parte01, .btn, .accion{
                    display: none;
                }
            }
        </style>
    </head>
    <body>
        <div class="d-flex">
            <div class="col-lg-5 parte01">
                <div class="card">
                    <form action="Controlador?menu=Nueva Venta" method="POST">
                    <div class="card-body">
                        <div class="form-group">
                            <label>Datos del Cliente</label>
                        </div>
                        <div class="form-group d-flex">
                            <div class="col-sm-6 d-flex">
                                <input type="text" name="codigoclientes" value="${clientes.getDni()}" class="form-control" placeholder="codigo">
                                <input type="submit" name="accion" value="BuscarClientes" class="btn btn-outline-info">
                            </div>
                            <div class="col-sm-6">
                                <input type="text" name="nombrescliente" value="${clientes.getNombres()}" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <label>Datos Productos</label>
                        </div>
                        <div class="form-group d-flex">
                            <div class="col-sm-6 d-flex">
                                <input type="text" name="codigoproducto" value="${producto.getId()}" class="form-control" placeholder="codigo">
                                <button type="submit" name="accion" value="BuscarProducto" class="btn btn-outline-info">Buscar</button>
                            </div>
                            <div class="col-sm-6">
                                <input type="text" name="nomproducto" value="${producto.getNombre()}" class="form-control">
                            </div>
                        </div>
                        </div>
                        <div class="form-group d-flex">
                            <div class="col-sm-6 d-flex">
                                <input type="text" name="precio" value="${producto.getPrecio()}" class="form-control" placeholder="codigo">
                            </div>
                            <div class="col-sm-3">
                                <input type="number" name="cant" value="1" class="form-control" placeholder="Datos Producto">
                            </div>
                            <div class="col-sm-3">
                                <input type="text" name="stock" value="${producto.getStock()}" class="form-control" placeholder="Datos Producto">
                            </div>
                        </div>
                        <div class="form-group">
                            <button type="submit" name="accion" value="Agregar" class="btn btn-outline-info">Agregar Producto</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
            <div class="col-sm-7">
                <div class="card">
                    <div class="card-body">
                        <div class="d-flex col-sm-6 ml-auto">
                            <label>NumeroSerie</label>
                            <input type="text" name="NroSerie" value="${nserie}" class="form-control">
                        </div>
                        <br>
                        <table class="table table-hover">
                                <thead>
                                    <tr>
                                        <th>Nro</th>
                                        <th>Codigo</th>
                                        <th>Descripcion</th>
                                        <th>Precio</th>
                                        <th>Cantidad</th>
                                        <th>Subtotal</th>
                                        <th class="accion">Acciones</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="list" items="${lista}">
                                    <tr>
                                        <th>${list.getItem()}</th>
                                        <th>${list.getIdproducto()}</th>
                                        <th>${list.getDescripcion()}</th>
                                        <th>${list.getPrecio()}</th>
                                        <th>${list.getCantidad()}</th>
                                        <th>${list.getSubtotal()}</th>
                                        <th class="d-flex"> 
                                            <a href="#" class="btn btn-warning">Editar</a>
                                            <a href="#" class="btn btn-danger" style="margin-left: 10px">Delete</a>
                                        </th>
                                    </tr>
                                 </c:forEach>   
                                </tbody>
                            </table>
                    </div>  
                    <div class="card-footer">
                        <div class="col-sm-6">
                            <a href="Controlador?menu=NuevaVenta&accion=GenerarVenta" onclick="print()" class="btn btn-success">Generar Venta</a>
                            <input type="submit" name="accion" value="Cancelar" class="btn btn-danger">
                        </div>
                        <div class="col-sm-3 ml-auto">
                            <input type="text" name="txtTotal" value="${totalpagar}" class="form-control">
                        </div>
                    </div>
                </div>
                
            </div>
        </div>
        
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
    </body>
</html>
