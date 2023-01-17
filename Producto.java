/**
@author: Josué Santana
*/

class Producto {
	private String codigo;
	private String marca;
	private String modelo;
	private int cantidadDisponible;

	public Producto(String codigo, String marca, String modelo, int cantidadDisponible) {
		this.codigo = codigo;
		this.marca = marca;
		this.modelo = modelo;
		this.cantidadDisponible = cantidadDisponible;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getCantidadDisponible() {
		return cantidadDisponible;
	}

	public void setCantidadDisponible(int cantidadDisponible) {
		this.cantidadDisponible = cantidadDisponible;
	}

	
}
