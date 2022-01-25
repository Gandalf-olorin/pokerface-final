# Examen Fundamentos Java 3 (04-02-2021)

Vamos a crear algunas partes del código de un juego de cartas. Se tendrá muy en cuenta **observar la [guía de estilo](https://google.github.io/styleguide/javaguide.html)** marcada para el curso, **pudiéndole penalizar hasta en un punto sobre diez la calificación final**.

Para poder realizar el examen es necesario usar el proyecto alojado en este repositorio. Haga un fork de este proyecto, póngalo con **visibilidad privado** y compruebe que está el repositorio correctamente en local. No siga hasta que haya puesto el repositorio en privado.

**Los puntos evaluables, y ponderados con el valor entre paréntesis, son**:

1. (1 punto) Todo el código que implemente pertenecerá al paquete `es.lanyu.cartas` excepto el que contenga el `main` que estará en la clase `com.tute.Juego`.
   Creo los paquetes es.lanyu.cartas y com.tute 
   Creo la clase Juego en com.tute 





2. (2 punto) Crear la clase `Carta` para guardar un palo y un número de carta. Tenga en cuenta que se usará para distintos tipos de baraja (española, americana, familias, etc...).
Creo la clase carta en es.lanyu.cartas



   Añado los campos:
      private static String palos con los palos de la baraja espaloña
      private int palo 
      private int numero
      creo los geters
      Creo constructor con palo y numero (ambos son int)





3. (3 punto) También cree las clases `Mano` y `Baraja` para tener un grupo de cartas (parcial o baraja completa respectivamente). Se valorará la reutilización máxima del código. Se pide que `Baraja` y `Mano` **NO tengan una relación jerárquica entre ellas** ya que representan conceptos distintos aunque los dos sean grupos de cartas.

   Creo las clases baraja y Mano.





4. (2 puntos) Creese una baraja con todas las cartas de la baraja española e imprímalas por consola para que se vea así:
   > `As de OROS`  
   `2 de OROS`  
   `3 de OROS`  
   ...continua y termina...  
   `Rey de BASTOS`  
   > *NOTA: Las clases creadas hasta ahora no son definitivas y tendrá que refactorizarlas a lo largo del examen según se vayan añadiendo mejoras y hará falta extraer una o varias interfaces de `Carta` por ejemplo.*
   
      En la clase carta creo un metodo para pasar el int de numero en string ademas de añadirles los casos especiales de si es AS Sota Caballo o rey.
      Creo por otro lado el metodo para pasar de un int palo a un string, basandome en getpalos y haciendo referencia a int palo. De este modo tengo "stringizados" los palos y los numetos.
      Por otro lado hago el metodo toString haciendo referencia a getToStringNumero y getToStringPalo.
      En Baraja creo una lista de la Clase Carta de cartas.
      Hago el getter correspondiente
      Por ultimo, en el main, defino que los palos de la baraja 1 es Carta.getPalos()
      Indico el numero maximo de la baraja... en este caso 10 cartas. y procedo a recorrer todos los palos y todos los numeros.





5. (4 puntos) Vamos a añadir funcionalidad:  
    * (2 punto) Cree un método que permita barajar (mezclar, desordenar) un grupo de cartas (`Mano` y `Baraja`). **Siempre tenga en cuenta la mayor reutilización y flexibilidad de código posible**. El método se llamará `barajar` y no admitirá argumentos. El resultado final será tener otro orden aleatorio en el grupo de cartas (puede usar cualquier método para generar números aleatorios, no se evalúa la eficacia en la generación de la aleatoriedad si no la capacidad de alterar el orden de un grupo de elementos).

      Uso Collections.shuffle para hacer el metodo. como tiene que pernetecer a mano y baraja, elevo todo a una super clase llamada Mazo.





    * (1 punto) Cree un método para robar una carta de un grupo de cartas llamado `robar` que admita como argumento la carta que se quiere robar (no tiene por qué ser la misma instancia si no un objeto igual que el que se quiere robar) y que devuelva la carta robada. Si se pasa como argumento `null` robará la primera carta. Si no quedan cartas o la carta buscada no se encuentra en el grupo devolverá `null`.

      





    * (1 punto) Cree un método que me diga si una carta pasada como argumento se encuentra dentro de un grupo de cartas (simplemente devolverá `true` si encuentra la carta en el grupo y `false` en cualquier otro caso). Se consideran cartas **iguales** tener el mismo palo y número (no hace falta que sea **la misma** carta).
6. (2 puntos) Implemente un **orden natural** en las cartas: primero por palos (no importa el orden concreto de los palos: da igual si se empieza por copas o espadas, pero se mantendrá cuando se ordene) y luego por el número en sentido ascendente. Desordene una baraja (con el método `barajar`) y luego ordénela naturalmente para comprobar que los métodos funcionan bien.
71. (3 punto) Compruebe ahora el funcionamiento de sus métodos con una librería externa. Utilice la clase `com.github.cards.Card` para generar cartas de la baraja americana y compruebe que puede integrarla con sus métodos generando una instancia de tipo `Baraja` de `CartaExterna`s. **NO ESTÁ PERMITIDO** que ninguno de los tipos del paquete `com.github.cards` forme parte de la jerarquía de las clases implementadas hasta ahora. Nuevas puede crear las que considere oportunas (le hará falta diseñar en base a interfaces si no lo ha hecho ya).
   > *NOTA: `suit` se refiere a palo y `rank` a número.*  
8. (4 puntos) Cree un comparador para ordenar varias manos en función del número mayor de cartas del mismo palo que tenga. Sólo se tiene en cuenta el palo con mayor repetición de cartas, en caso de empate se consideran iguales en lo referente al orden independientemente del resto de cartas.
9. (5 puntos) Se quiere que los palos puedan ser de cualquier tipo `Comparable` y que las cartas tengan el método `getNumeroString()` y `getPaloString()` (que devuelvan la representación de tipo `String` del número y del palo respectivamente) para asegurar poder construir el método `toString()`. Pruébelo con una baraja de las familias donde haya familias de esquimales y europeos cada una con madre, padre, hijo e hija. El tipo del palo de estas cartas debe ser `String`. El orden natural de las cartas de familia debe ser como se han nombrado (empieza en madre esquimal y termina en hija europea)
   > PISTA: Haga una prueba cargando las cartas al revés para comprobar que al ordenarlas funciona correctamente.

<hr>

## Entrega de examen
Acuérdese de hacer al menos un **commit con el mensaje `Entrega examen`** con el último estado a guardar. Éste commit debe tener los ficheros necesarios sólo, añadir binarios por ejemplo será considerado una mala práctica penalizable. Compruebe que su commit está subido a su fork. Además añada su grabación de video en formato `.mkv` como se le ha indicado antes de comenzar el examen. En su grabación debe verse tanto el inicio del examen (se iniciará por mensaje en el chat de la comunidad) como el fin (realizar el commit final y comprobar que está subido).