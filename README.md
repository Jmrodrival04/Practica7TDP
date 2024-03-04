Este es mi repositorio en github: https://github.com/Jmrodrival04/Practica7TDP.git

"Ejercicio 1"

Clase DadoIA: Representa un dado que puede lanzarse y ajusta las probabilidades de cada cara basándose en los resultados anteriores.

1.Variables Principales:
caras: Número de caras del dado.
historialLanzamientos: Registro de cuántas veces ha salido cada cara.
random: Utilizado para generar números aleatorios, es decir, lanzamientos del dado.
Constructor: Inicializa el dado con un número específico de caras. Prepara el historial de lanzamientos con cada cara teniendo cero lanzamientos inicialmente.
Método lanzar: Realiza un lanzamiento del dado, actualiza el historial de lanzamientos, y opcionalmente, recalcula las probabilidades de cada cara.
2.Clase SimulacionDadoIA: Usa la clase DadoIA para simular lanzamientos con dados de diferentes números de caras y observar cómo se comportan en conjunto.
Método main: Crea tres dados con diferente número de caras, realiza lanzamientos mientras la suma de los resultados sea menor que 20, e imprime los resultados de cada lanzamiento.

"Ejercicio 2"

1,Inicialización: Se inicia el sistema, preparando estructuras para almacenar la información de clientes y libros disponibles.
2.Agregar Clientes: A través de la interfaz de línea de comandos, se pueden añadir clientes al sistema, ingresando sus datos como nombre e ID.
3.Registrar Compras: Para cada cliente, se pueden registrar compras de libros, actualizando su historial de compras con los títulos adquiridos.
4.Generar Recomendaciones: Basándose en el historial de compras de un cliente, el sistema analiza los géneros más frecuentes y sugiere nuevos libros que coincidan con estas preferencias, excluyendo aquellos ya comprados.
5.Mostrar Recomendaciones: Las recomendaciones generadas se muestran al cliente, ofreciendo opciones personalizadas basadas en sus gustos.

"Ejercicio 3"

1.Inicio del Juego: Al empezar, se crean dos tableros: uno para el jugador y otro para la IA. En cada tablero, se colocan barcos de manera aleatoria.
2.Juego: El jugador y la IA se turnan para atacar el tablero del otro, intentando adivinar dónde están los barcos. Se ingresa o genera una coordenada (x, y) para atacar. Si un ataque acierta en un barco, se marca como impacto; si no, como fallo.
3.Efectos Climáticos: Después de cada turno, el juego cambia el clima, lo que puede revelar partes del tablero o tener otros efectos. Por ejemplo, una tormenta puede revelar la posición de algunos barcos.
4.Fin del Juego: El juego termina cuando todos los barcos de uno de los tableros son hundidos. Si el jugador hunde todos los barcos de la IA primero, gana el jugador; si la IA hunde todos los barcos del jugador primero, gana la IA.

"Ejercicio 4"

1.El programa se estructura en tres clases principales: Cuadricula, CuadriculaConIA, y BatallaNaval, manejando el tablero de juego, la lógica de la IA, y el flujo del juego, respectivamente.
2.Al comenzar, se crea una instancia de BatallaNaval, la cual a su vez inicializa dos instancias de CuadriculaConIA para el jugador y la IA, colocando barcos de manera aleatoria en ambos tableros.
3.La colocación de los barcos se hace asegurando que no se solapen entre sí ni se extiendan fuera de los límites del tablero, utilizando métodos que intentan colocar los barcos tanto horizontal como verticalmente.
4.El juego procede en un bucle donde el jugador y la IA se turnan para atacar. El jugador introduce coordenadas de ataque, y la IA selecciona sus coordenadas basándose en una estrategia que prioriza atacar alrededor del último acierto.
5.Cuando la IA logra un acierto, planea ataques adyacentes alrededor del golpe exitoso para intentar hundir el barco atacado, utilizando una cola para almacenar y gestionar estos ataques planificados.
6.Cada ataque se registra en el tablero del oponente, marcando los aciertos, los fallos y actualizando el estado del tablero después de cada turno.
7.Se verifica constantemente si alguno de los jugadores ha hundido todos los barcos del oponente para determinar el fin del juego.
8.El juego concluye anunciando quién ha ganado, basado en quién hundió todos los barcos del oponente primero.

