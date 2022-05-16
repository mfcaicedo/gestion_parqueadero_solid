package unicauca.parkinglot.access;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import unicauca.parkinglot.domain.TypeEnum;
import unicauca.parkinglot.domain.Vehicle;
import unicauca.parkinglot.domain.service.Service;

/**
 *
 * @author Milthon F Caicedo, Brandon Nicolas 
 */
public class VehicleRepository implements IVehicleRepository {
    private Connection conn;

    public VehicleRepository(){
        initDatabase();
    }

    /**
     * Guarda en la base de datos el vehículo
     * @param newVehicle
     * @return retorna un true si el guardado fue exitoso y un false en caso de tener error
     */
    
    @Override
    public boolean saveProduct(Vehicle newVehicle) {

        try {
            //Validate product
            if (newVehicle == null || newVehicle.getPlaca().isEmpty() || newVehicle.getType().equals("")) {
                return false;
            }
            this.connect();

            String sql = "INSERT INTO Vehicle ( veh_placa, veh_tipo) "
                    + "VALUES ( ?, ?)";

            String auxTipo = newVehicle.getType().toString();
            
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, newVehicle.getPlaca());
            pstmt.setString(2, auxTipo);
            pstmt.executeUpdate();
            pstmt.close();
            this.disconnect();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    /**
     * Hace la consulta en la base de datos de los vehículos guardados
     * @return  lista de los vehículos
     */
    
    @Override
    public List<Vehicle> listVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();
        try {

            String sql = "SELECT veh_placa, veh_tipo FROM Vehicle";
            this.connect();

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Vehicle newVehicle = new Vehicle();
                newVehicle.setPlaca(rs.getString("veh_placa"));
                
                String auxTipo = rs.getString("veh_tipo");
                TypeEnum auxEnum = TypeEnum.valueOf(auxTipo);
                newVehicle.setType(auxEnum);

                vehicles.add(newVehicle);
            }
            this.disconnect();

        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vehicles;
    }

    /**
     * Inicializa la base de datos y crea las tablas correspondientes
     */
    
    private void initDatabase(){
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS Vehicle (\n"
                + "	veh_id integer PRIMARY KEY autoincrement,\n"
                + "     veh_placa varchar,\n"
                + "	veh_tipo varchar NOT NULL\n"
                + ");";

        try {
            this.connect();
//            Class.forName("org.sqlite.JDBC");
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            //this.disconnect();

        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Conecta la base de datos. 
     */
    public void connect(){
        String url = "jdbc:sqlite:./mydatabase.db";
        try {
            conn = DriverManager.getConnection(url);

        } catch (SQLException ex) {
            System.out.println("Error: " + Service.class.getName());
        }
    }
    
    /**
     * Desconecta la base datos 
     */
    public void disconnect() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
