/**
@author: Josué Santana
*/

import java.util.*;

public class Almacen {
	
	//Objetos
	static Almacen almacen= new Almacen();
	static Scanner sc = new Scanner(System.in);
	static List<Producto> productos;
			
	//Variables
	static String codigo;
	static String marca;
	static String modelo;
	static int cantidadDisponible;
	static int opcion;

	public Almacen() {
		productos = new ArrayList<Producto>();
	}
		
		
	
	public void altaProducto(Producto producto) {
		productos.add(producto);
	}
	
	public void bajaProducto(String codigo) {
		for (Producto producto : productos) {
			if (producto.getCodigo().equals(codigo)) {
				productos.remove(producto);
				break;
			}
		}
	}
	
	public void editarProducto(String codigo, String marca, String modelo, int cantidadDisponible) {
		for (Producto producto : productos) {
			if (producto.getCodigo().equals(codigo)) {
				producto.setMarca(marca);
				producto.setModelo(modelo);
				producto.setCantidadDisponible(cantidadDisponible);
				break;
			}
		}
	}
	
	public void disminuirCantidadDisponible(String codigo, int cantidadDisponible) {
		for (Producto producto : productos) {
			if (producto.getCodigo().equals(codigo)) {
				producto.setCantidadDisponible(producto.getCantidadDisponible() - cantidadDisponible);
				break;
			}
		}
	}
	
	public void aumentarCantidadDisponible(String codigo, int cantidadDisponible) {
		for (Producto producto : productos) {
			if (producto.getCodigo().equals(codigo)) {
				producto.setCantidadDisponible(producto.getCantidadDisponible() + cantidadDisponible);
				break;
			}
		}
	}
	
	public List<Producto> buscarPorMarca(String marca) {
		List<Producto> query = new ArrayList<Producto>();
		for (Producto producto : productos) {
			if (producto.getMarca().equals(marca)) {
				query.add(producto);
			}
		}
		return query;
	}
	
	public List<Producto> buscarPorModelo(String modelo) {
		List<Producto> query = new ArrayList<Producto>();
		for (Producto producto : productos) {
			if (producto.getModelo().equals(modelo)) {
				query.add(producto);
			}
		}
		return query;
	}
	
	public Producto buscarPorCodigo(String codigo) {
		for (Producto producto : productos) {
			if (producto.getCodigo().equals(codigo)) {
				return producto;
			}
		}
		return null;
	}
	
	public List<Producto> verListaProductos() {
		Collections.sort(productos, new Comparator<Producto>() {
			public int compare(Producto primero, Producto segundo) {
				return primero.getMarca().compareTo(segundo.getMarca());
			}
		});
		return productos;
	}
	
	///////////////////////////////////////////////////////////////////
	
	// Funciones del menú y submenú
	
	
	
	public static void verSubmenu() {
		
		System.out.println("\n");
		System.out.println("-------------------------------");
		System.out.println("|     SUBMENÚ DE OPCIONES     |");
		System.out.println("-------------------------------");
		System.out.println("| a. Buscar por marca         |");
		System.out.println("| b. Busacr por modelo        |");
		System.out.println("| c. Buscar por código        |");
		System.out.println("| d. Volver al menú principal |");
		System.out.println("-------------------------------");
		
		System.out.println("\n");
		System.out.println("Escoge la opción de búsqueda:");
		List<Producto> busqueda;
		
		char opcion = sc.next().charAt(0);
		if (opcion == 'a') {
			System.out.print("Introduce la marca: ");
			marca = sc.next();
			busqueda = almacen.buscarPorMarca(marca);
			System.out.println("Productos de la marca " + marca + ":");
			for (Producto producto : busqueda) {
				System.out.println("| Código: " + producto.getCodigo() + " | Marca: " + producto.getMarca() + " | Modelo: " + producto.getModelo() + " | Cantidad: " + producto.getCantidadDisponible() + " |");
				}
		} else if (opcion == 'b') {
			System.out.print("Introduce el modelo: ");
			modelo = sc.next();
			busqueda = almacen.buscarPorModelo(modelo);
			System.out.println("Productos del modelo " + modelo + ":");
			for (Producto producto : busqueda) {
				System.out.println("| Código: " + producto.getCodigo() + " | Marca: " + producto.getMarca() + " | Modelo: " + producto.getModelo() + " | Cantidad: " + producto.getCantidadDisponible() + " |");
				}
		} else if (opcion == 'c') {
			System.out.print("Introduce el código del producto: ");
			codigo = sc.next();
			Producto producto = almacen.buscarPorCodigo(codigo);
			if (producto != null) {
				System.out.println("| Código: " + producto.getCodigo() + " | Marca: " + producto.getMarca() + " | Modelo: " + producto.getModelo() + " | Cantidad: " + producto.getCantidadDisponible() + " |");
				} else {
				System.err.println("El producto no fue encontrado en la base de datos.");
			}
		}
		
		else if(opcion == 'd') {
			verMenu2();
		}
	}
	
	public static void verMenu2() {
		
		
		
		while (true) {
			System.out.println("\n");
			System.out.println("-----------------------------------------------");
			System.out.println("|              MENÚ DE OPCIONES               |");
			System.out.println("-----------------------------------------------");
			System.out.println("| 1. Alta producto                            |");
			System.out.println("| 2. Baja producto                            |");
			System.out.println("| 3. Editar producto                          |");
			System.out.println("| 4. Disminuir cantidad disponible            |");
			System.out.println("| 5. Aumentar cantidad disponible             |");
			System.out.println("| 6. Búsqueda de un producto determinado      |");
			System.out.println("| 7. Mostrar todos los productos (por marca)  |");
			System.out.println("| 8. Salir                                    |");
			System.out.println("-----------------------------------------------");
			
			System.out.println("\n");
			System.out.println("Elija la opción que desea ejecutar: ");
			opcion = sc.nextInt();
			
			if (opcion == 1) {
				System.out.print("Introducir el código del producto: ");
				codigo = sc.next();
				System.out.print("Introducir marca: ");
				marca = sc.next();
				System.out.print("Introducir modelo: ");
				modelo = sc.next();
				System.out.print("Introducir cantidad: ");
				cantidadDisponible = sc.nextInt();
				almacen.altaProducto(new Producto(codigo, marca, modelo, cantidadDisponible));
			} else if (opcion == 2) {
				System.out.print("Introducir el código del producto: ");
				codigo = sc.next();
				almacen.bajaProducto(codigo);
			} else if (opcion == 3) {
				System.out.print("Introducir el código del producto: ");
				codigo = sc.next();
				System.out.print("Introducir marca: ");
				marca = sc.next();
				System.out.print("Introducir modelo: ");
				modelo = sc.next();
				System.out.print("Introducir cantidad: ");
				cantidadDisponible = sc.nextInt();
				almacen.editarProducto(codigo, marca, modelo, cantidadDisponible);
			} else if (opcion == 4) {
				System.out.print("Introducir el código del producto: ");
				codigo = sc.next();
				System.out.print("Introduce la cantidad que quieres disminuir: ");
				cantidadDisponible = sc.nextInt();
				almacen.disminuirCantidadDisponible(codigo, cantidadDisponible);
			} else if (opcion == 5) {
				System.out.print("Introducir el código del producto: ");
				codigo = sc.next();
				System.out.print("Introduce la cantidad que quieres aumentar: ");
				cantidadDisponible = sc.nextInt();
				almacen.aumentarCantidadDisponible(codigo, cantidadDisponible);
			} else if (opcion == 6) {
				verSubmenu();
			} else if (opcion == 7) {
				List<Producto> productos = almacen.verListaProductos();
				System.out.println("Lista de productos (por marca):");
				for (Producto producto : productos) {
					System.out.println("| Código: " + producto.getCodigo() + " | Marca: " + producto.getMarca() + " | Modelo: " + producto.getModelo() + " | Cantidad: " + producto.getCantidadDisponible() + " |");
					}
			} else if (opcion == 8) {
				System.out.println("Adiós...");
				break;
	
			} else if (opcion > 8 || opcion < 1) {
				System.err.println("Opción inválida, inténtalo otra vez");
			}
		}
		sc.close();
	}
}
