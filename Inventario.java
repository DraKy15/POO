package com.mycompany.main;

import java.util.ArrayList;

public class Inventario {

    public ArrayList<Producto> listaProductos = new ArrayList<Producto>();
    public ArrayList<Categoria> listaCategorias = new ArrayList<Categoria>();

    public void registrarProducto(Producto producto) {
        this.listaProductos.add(producto);
    }

    public void registrarCategoria(Categoria categoria) {
        this.listaCategorias.add(categoria);
    }

    public boolean validarExistenciaDeCategorias() {
        return this.listaCategorias.size() > 0;
    }

    public void listarCategorias() {
        if (this.listaCategorias.size() == 0) {
            System.out.println("No existen categorías en el sistema.");
            return;
        } else {
            System.out.println("\n CATEGORÍAS ");
            for (Categoria categoria : listaCategorias) {
                System.out.println("ID: " + categoria.getId() + ", Nombre: " + categoria.getNombre());
            }
        }
    }

    public void listarCategoriasConProductos() {
        if (this.listaCategorias.size() == 0) {
            System.out.println("No existen categorías en el sistema.");
            return;
        } else {
            System.out.println("\n CATEGORÍAS ");
            for (Categoria categoria : listaCategorias) {
                System.out.println("ID: " + categoria.getId() + ", Nombre: " + categoria.getNombre());
            }
            System.out.println("\n PRODUCTOS DE LAS CATEGORÍAS ");
            for (Producto producto : listaProductos) {
                System.out.println("Nombre: " + producto.getNombre());
            }
        }

    }

    public void validarIDProducto(int idCategoria) {
        boolean idValido = false;

        for (Categoria categoria : listaCategorias) {
            if (categoria.getId() == idCategoria) {
                idValido = true;
                break;
            }
        }

        if (!idValido) {
            System.out.println("El ID ingresado no corresponde a una categoría. Intente de nuevo.");
        } else {
            System.out.println("ID de categoría válido.");
        }
    }

    public void eliminarProducto(int idProductoEliminar) {
        int longitudOriginal = this.listaProductos.size(); // 3

        if (longitudOriginal != this.listaProductos.size()) {
            System.out.println("Se eliminó el prodcuto con el ID: " + idProductoEliminar);
        } else {
            System.out.println("No existe un producto con el ID: " + idProductoEliminar);
        }
    }

    public void mostrarProductos() {
        System.out.println("\n PRODUCTOS");

        if (this.listaProductos.size() == 0) {
            System.out.println("\nNo existen productos en el sistema");
        } else {
            for (Producto producto : listaProductos) {
                System.out.println(producto);
            }
        }
    }

}
