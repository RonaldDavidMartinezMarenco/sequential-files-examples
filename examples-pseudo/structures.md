# Presentamos estructuras y sintaxis seguida para construccion de archivos secuenciales.


1. **Declaracion de archivo**

Inicio

    Buffer **Palabra clave reservada para la construccion de file**
    
        Nombre de archivo
        Dispositivo (Disco HDD)
        Nombre de Registro (Estructura logica)
        
        Campo1      TipoDeDato [Longitud]
        
        Campo_N     TipoDeDato [Longitud]
    FinBuffer
Fin

2. **Tipo de datos usados**

    Cadena [N], S[N], X[N]

    Entero [N], Numerico [N.M], N[X]

    Logico [1 BYTE SIEMPRE TRUE/FALSE ACTIVO/DESACTIVO 1/0]

    Tipos compuestos [ARRAY / Registro]

3. **Operaciones entre archivos**

    - **Abrir ArchivoNombre(Metodo SALIDA/ENTRADA)** 
    Para definir si es de entrada o salida, conviene preguntar: Vamos a escribir o crear archivo? (Salida) Vamos a consultar o extraer informacion? (Entrada). Esto con base en I/0 Modules. 

    - **Cerrar ArchivoNombre** #Liberas recursos y permites que otros canales puedan acceder a ese archivo. Cerrar siempre despues de cualquier operacion. Despues del MQ

    - **Borrar ArchivoNombre**

    - **CambiarNombre** ArchivoNombre ArchivoNuevo
    - **Grabar (Archivo, Registro)** queda guardado datos en X registro

4. **Operaciones con Registros** 

    - Leer (Archivo,NombreDeRegistro)
    - Escriba NombreDeRegistro
    - EOF(Nombre de Archivo) --> Condicion que determina a la libreria de buffer que se llego al final del file con base en el size de los bytes correspondidos en los metadatos
    -  RegistroN <- RegistroM  # Esto es una asignacion que solo se puede realizar si son iguales en cuanto estructura los registros. 

5. Sintaxis clave usada 

    TIPO DATO: Variable a crear
    Variable <- dato a asignarle
    MQ --> MIENTRAS QUE
    IMPRIMIR "ALGO"
    LEER ALGO


6. Metodos usados segun tarea

    - Crear archivos:
        - Abrir Archivo(modo entrada/salida)
        - Grabar (Archivo, Registro)
        - Cerrar Archivo
        
    - Consultar Archivos:
        - Abrir Archivo(modo entrada/salida)
        - Leer (Archivo, Registro)
        - Cerrar Archivo

    - Modificar Archivos:
        - Crear dos archivos. Maestro (original) y novedades. 
        - Abrir archivo (modo entrada/salida X2)
        - Leer (archivo, registro) -> lees las filas del maestro
        - Cerrar Archivo X2
        - Grabar (archivo, registro) para el archivo de novedades

    - Agregar registros
        - Leer (archivo, registro)
        - Se copian registros tal cual si registro se llama MOVIE se copia MOVIE A MOVIE_NEW
        - Grabar (ARCHIVO_NEW, REGISTRO_NEW)




