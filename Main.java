package iria;

public class Main {

    @SuppressWarnings("static-access")
	public static void main(String[] args)
    {
    	Almacen almacen= new Almacen();
    	almacen.altaProducto(new Producto("132", "Ferrari", "murciélago", 2));
    	almacen.altaProducto(new Producto("123", "Audi", "R8", 4));
    	almacen.altaProducto(new Producto("321", "Bugatti", "Bairon", 1));
		almacen.verMenu2();
    }

}