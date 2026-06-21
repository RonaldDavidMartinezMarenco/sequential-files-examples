from csv import DictReader
from pathlib import Path
import sys


def leer_ganador(csv_path: Path):
    ganador = None
    mayor_promedio = float("-inf")

    with csv_path.open(newline="", encoding="utf-8") as archivo:
        lector = DictReader(archivo)

        for fila in lector:
            promedio = float(fila["Promedio"].replace(",", "."))

            if promedio > mayor_promedio:
                mayor_promedio = promedio
                ganador = fila

    return ganador, mayor_promedio


def main():
    ruta_csv = Path(sys.argv[1]) if len(sys.argv) > 1 else Path("candidatos.csv")

    try:
        ganador, mayor_promedio = leer_ganador(ruta_csv)
    except FileNotFoundError:
        print(f"No se encontro el archivo: {ruta_csv}")
        return
    except KeyError as error:
        print(f"Falta la columna requerida en el CSV: {error}")
        return
    except ValueError as error:
        print(f"Error al leer un promedio numerico: {error}")
        return

    if ganador is None:
        print("El CSV esta vacio.")
        return

    print("Candidato con mayor promedio")
    print(f"Nombre: {ganador['Nombre_Candidato']}")
    print(f"Telefono: {ganador['Tel']}")
    print(f"Direccion: {ganador['Dir']}")
    print(f"Nro Candidato: {ganador['NroCandidato']}")
    print(f"Promedio: {mayor_promedio}")


if __name__ == "__main__":
    main()
