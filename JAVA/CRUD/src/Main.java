import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int selectedOption;

		do {
			System.out.println("1. Select");
			System.out.println("2. Insert");
			System.out.println("3. Update");
			System.out.println("4. Delete");
			System.out.println("5. Exit");
			selectedOption = sc.nextInt();

			switch (selectedOption) {
			case 1: {
				selectAll();
				break;
			}
			case 2: {
				insert();
				break;
			}
			case 3: {
				update();
				break;
			}
			case 4: {
				delete();
				break;
			}
			case 5: {
				System.out.println("Adios...");
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + selectedOption);
			}

		} while (selectedOption != 5);

	}

	private static void delete() {
		Connection conn = DBConnect.getConn();
		Scanner sc = new Scanner(System.in);

		System.out.println("id: ");
		int id = sc.nextInt();

		try {
			PreparedStatement stmt = conn.prepareStatement("DELETE FROM usuarios WHERE id_usuarios = ?");
			stmt.setInt(1, id);

			int deleted = stmt.executeUpdate();

			if (deleted == 1) {
				System.out.println("Usuario borrado correctamente");
			} else {
				System.out.println("No se ha podido borrar el usuario");
			}

			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void update() {
		Connection conn = DBConnect.getConn();
		Scanner sc = new Scanner(System.in);

		System.out.println("id: ");
		int id = sc.nextInt();

		System.out.println("nombre: ");
		String nombre = sc.next();

		System.out.println("edad: ");
		int edad = sc.nextInt();

		System.out.println("nacionalidad: ");
		String nacionalidad = sc.next();

		try {
			PreparedStatement stmt = conn.prepareStatement(
					"UPDATE usuarios SET nombre = ?, edad = ?, nacionalidad = ? WHERE id_usuarios = ?");
			stmt.setString(1, nombre);
			stmt.setInt(2, edad);
			stmt.setString(3, nacionalidad);
			stmt.setInt(4, id);

			int updated = stmt.executeUpdate();

			if (updated == 1) {
				System.out.println("Usuario actualizado correctamente");
			} else {
				System.out.println("No se ha podido actualizar el usuario");
			}

			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void insert() {
		Connection conn = DBConnect.getConn();
		Scanner sc = new Scanner(System.in);

		System.out.println("nombre: ");
		String nombre = sc.next();

		System.out.println("edad: ");
		int edad = sc.nextInt();

		System.out.println("nacionalidad: ");
		String nacionalidad = sc.next();

		try {
			PreparedStatement stmt = conn
					.prepareStatement("INSERT INTO usuarios (nombre, edad, nacionalidad) VALUES (?, ?, ?)");
			stmt.setString(1, nombre);
			stmt.setInt(2, edad);
			stmt.setString(3, nacionalidad);

			int inserted = stmt.executeUpdate();

			if (inserted == 1) {
				System.out.println("Usuario insertado correctamente");
			} else {
				System.out.println("No se ha podido insertar el usuario");
			}

			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void selectAll() {
		Connection conn = DBConnect.getConn();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM usuarios");

			System.out.printf("%10s %10s %10s %15s %n", "id", "nombre", "edad", "nacionalidad");
			while (rs.next()) {
				System.out.printf("%10d %10s %10s %15s %n", rs.getInt("id_usuarios"), rs.getString("nombre"),
						rs.getInt("edad"), rs.getString("nacionalidad"));

			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
