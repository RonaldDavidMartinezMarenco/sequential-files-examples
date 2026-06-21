package sequentialfiles;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CandidatoMayorPromedio {
    public static void main(String[] args) {
        String archivo = "sequentialfiles/candidatos.txt";
        String nombreGanador = "";
        String direccionGanador = "";
        String telefonoGanador = "";
        String nroCandidatoGanador = "";
        double mayorPromedio = -1;

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                String[] campos = linea.split("\t");

                if (campos.length < 5) {
                    continue;
                }

                String nombre = campos[0];
                String direccion = campos[1];
                String telefono = campos[2];
                double promedio = Double.parseDouble(campos[3].replace(",", "."));
                String nroCandidato = campos[4];

                if (promedio > mayorPromedio) {
                    mayorPromedio = promedio;
                    nombreGanador = nombre;
                    direccionGanador = direccion;
                    telefonoGanador = telefono;
                    nroCandidatoGanador = nroCandidato;
                }
            }

            if (mayorPromedio < 0) {
                System.out.println("El archivo no tiene candidatos validos.");
                return;
            }

            System.out.println("Candidato con mayor promedio");
            System.out.println("Nombre: " + nombreGanador);
            System.out.println("Telefono: " + telefonoGanador);
            System.out.println("Direccion: " + direccionGanador);
            System.out.println("Nro Candidato: " + nroCandidatoGanador);
            System.out.println("Promedio: " + mayorPromedio);
        } catch (IOException ex) {
            System.out.println("No se encontro el archivo: " + archivo);
        } catch (NumberFormatException ex) {
            System.out.println("Hay un promedio invalido en el archivo.");
        }
    }
}