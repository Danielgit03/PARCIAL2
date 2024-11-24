 Definir la clase EspacioRecreacional
La clase EspacioRecreacional representa un espacio disponible para uso recreativo, como una cancha deportiva o una sala de juegos. A continuación, se describen sus atributos y métodos.

192358-192420
Atributos:
nombre: El nombre del espacio (por ejemplo, "Cancha 1", "Sala de Juegos").
tipo: El tipo de espacio, que puede ser "cancha", "sala de juegos", o cualquier otro tipo de espacio recreativo.
capacidad: La cantidad máxima de personas que pueden usar el espacio al mismo tiempo.
horariosDisponibles: Una lista o conjunto de horarios en los que el espacio está disponible para ser reservado.
reservas: Un registro de las reservas realizadas, que puede estar en forma de un diccionario donde las claves son los horarios y los valores son las listas de estudiantes que han reservado en esos horarios.
Métodos:
reservar(horario, estudiante): Este método verifica si un estudiante puede reservar el espacio en el horario solicitado. Si el horario está disponible y la capacidad del espacio no se ha alcanzado, la reserva se realiza.
mostrarDisponibilidad(): Este método muestra los horarios en los que el espacio está disponible para reservar, es decir, aquellos horarios que no han sido ocupados.
Paso 2: Definir la clase Estudiante
La clase Estudiante representa a los usuarios que pueden interactuar con el sistema para hacer reservas. Cada estudiante tiene un nombre y un identificador único (ID).

Atributos:
nombre: El nombre del estudiante.
id: Un identificador único para cada estudiante (puede ser un número o cadena).
Métodos:
reservarEspacio(espacio, horario): Este método permite al estudiante reservar un espacio recreacional en un horario específico. El estudiante debe especificar el espacio y el horario que desea reservar.
Paso 3: Definir la clase GestionRecreacional
La clase GestionRecreacional es responsable de gestionar las reservas de los espacios recreativos. Permite registrar nuevos espacios, verificar la disponibilidad de los mismos y cancelar reservas.

Atributos:
espacios: Una lista o conjunto de espacios recreacionales que están registrados en el sistema.
Métodos:
registrarEspacio(espacio): Permite registrar un nuevo espacio recreacional en el sistema.
verificarDisponibilidad(espacio): Muestra los horarios disponibles de un espacio específico.
cancelarReserva(espacio, horario): Permite cancelar una reserva previamente realizada. El espacio se libera para que otros estudiantes puedan reservarlo.
Paso 4: Crear un ejemplo de uso
Una vez que las clases están definidas, se puede usar el sistema de la siguiente manera:

Crear instancias de espacios recreacionales: Se crean objetos de la clase EspacioRecreacional para representar diferentes espacios que los estudiantes pueden reservar.
Registrar espacios en el sistema: Los espacios creados se agregan al sistema de gestión utilizando el método registrarEspacio() de la clase GestionRecreacional.
Crear estudiantes: Se crean instancias de la clase Estudiante con un nombre y un ID único.
Reservar un espacio: Los estudiantes pueden usar el método reservarEspacio() para solicitar una reserva en un horario disponible de un espacio recreacional.
Cancelar una reserva: Si un estudiante desea cancelar su reserva, puede hacerlo usando el método cancelarReserva() de la clase GestionRecreacional.
Verificar disponibilidad: Los estudiantes o el sistema pueden consultar los horarios disponibles de un espacio usando el método mostrarDisponibilidad() de la clase EspacioRecreacional.
Paso 5: Validaciones y consideraciones adicionales
Asegúrate de tener en cuenta los siguientes aspectos al implementar el sistema:

Validación de la capacidad: Antes de realizar una reserva, verifica que no se haya alcanzado el límite de capacidad del espacio. Si el número de reservas en un horario específico ya ha alcanzado la capacidad máxima, no se podrá realizar una nueva reserva para ese horario.
Verificación de disponibilidad: Siempre verifica que el espacio esté disponible antes de permitir la reserva.
Cancelación de reservas: Cuando un estudiante cancela una reserva, el horario vuelve a estar disponible para otros estudiantes.
Gestión de errores: Es importante manejar los posibles errores, como intentar reservar un horario que ya está ocupado o intentar cancelar una reserva que no existe.
Paso 6: Pruebas del sistema
Una vez que el sistema esté implementado, es fundamental realizar pruebas para verificar que todo funcione correctamente. Las pruebas deben incluir:

Verificar que los estudiantes puedan hacer reservas en horarios disponibles y que se respete la capacidad.
Probar que los estudiantes no puedan reservar un espacio si la capacidad ya ha sido alcanzada.
Asegurarse de que el sistema muestra correctamente los horarios disponibles.
Probar que las reservas puedan ser canceladas y que los horarios se liberen correctamente.
