package com.apirest.basic.apirest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.basic.apirest.model.producto;

import lombok.extern.slf4j.Slf4j;
//hoy aprendi algo que no sabia
@RestController
@Slf4j
public class testController {

    @GetMapping("/hello")
    public String hello() {

        return "hola mundo";

    }

    //aqui estamos provando el controlador con tipos de peticion get
    @GetMapping("/bye")
    public String bye() {

        return "chao mundo";

    }

    //con el @pathVariable podemos realizar una busqueda sobre la lista de productos que tenemos 
    @GetMapping("/productos/{id}")
    public producto getPrduc(@PathVariable Integer id){

        for (producto p: getProductos() ){
            if (p.getId().equals(id)){
                return p;
            }
        }
return null;
   
    }

    // aqui vemos como devolver un objeto
    @GetMapping("productos")
    public producto get() {
        return new producto(1, null, "es un televisor de 21 pulgadas", 1000);

    }
// aqui en este metodo retornamos la lista de clientes
    @GetMapping("/maquina")
    public List<producto> getProduct() {

        return getProductos();

    }

    //aqui en este metodo vamos a crear una lista la cual va a ser de tipo get
    // y vamos a retornar en el posterior metodo que se encuenta en la parte de arriba 
    public List<producto> getProductos() {
        List<producto> listaProducto = new ArrayList<>();
        listaProducto.add(new producto(2, "mauricio", "es un chico inteligente", 233));
        listaProducto.add(new producto(3, "marcos", "es un gran constructos", 3000));

        return listaProducto;

    }


//eñ metodo post nos sirve para insertar por primera vez una peticion al codigo 
    @PostMapping("/productos")
public String resiveProducto(@RequestBody producto producto){
    log.info("id de producto {}", producto.getId());

    return "producto_resivido";
}

}
