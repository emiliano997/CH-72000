# Objetos 1

## Clase Object y Herencia

Todo código Java se define en una clase.

Toda clase Java definida, tiene una clase “padre” de la que hereda el comportamiento básico.
Esa clase padre es la clase Object.

Veamos esto usando el ejemplo anterior.
En la siguiente imagen podemos ver los métodos definidos en la clase object que son heredados por todas las clases que se crean

### Herencia

Es un mecanismo que permite a una clase obtener propiedades y/o comportamiento de otra clase superior.

En los paradigmas orientados a objetos existe la herencia múltiple pero no aplica a Java.

- Se agrupa el comportamiento compartido por todas las clases en una clase superior.
- Las clases inferiores "Heredan" dicho comportamiento.
- Se establece un contrato que define un protocolo común para un grupo de clases.

Es necesario establecer las relaciones entre las clases para diseñar el árbol de herencia.
Podemos tomar cómo ejemplo de árbol de herencia el que usamos en la clase 3 cuando vimos el tema de listas.

- Único punto para realizar cambios en el comportamiento.
- Código reusable
- Posibilita el uso del polimorfismo

### Polimorfismo

Polimorfismo significa muchas formas, es la capacidad que tiene un objeto de responder de distinta forma dependiendo de su implementación.

Es un concepto muy importante de los paradigmas orientados a objetos.

Cuando existe comportamiento común en varias clases y cuando una clase es más específica que otra:
Jacarandá es un tipo más específico que árbol

Usamos el test IS-A.
Si pasa el Test estamos por buen camino.

Ej: Gato IS-A Felino
Cirujano IS-A Doctor

Retomamos, ¿bañadera pasa el IS-A test en relación con el baño?
Tiene sentido, ¿no?. Pero una bañadera ¿IS-A baño?
¿Al revés? ¿Baño IS-A bañadera?
No…¿entonces?

Tienen una relación de HAS-A, que es una relación de composición, pero no es de herencia. El baño HAS-A bañadera, es decir el baño está compuesto por una bañadera.

**¿Cuándo no aplica el uso de herencia?**

- No se usa para solamente reusar código
- No pasa el IS-A test

## Equals y HashCode

La igualdad entre dos objetos se puede analizar de dos maneras:

- Igualdad referencial: dos variables distintas que hacen referencia al mismo objeto.
  La comparación se realiza usando el operador ==
- Igualdad de objetos: dos variables distintas que hacen referencia a dos objetos distintos pero que desde el punto de vista de la lógica son considerados iguales.

Para realizar esta comparación es obligatorio sobreescribir los métodos hashCode() y equals() heredados de la clase Object.

Se crea una objeto de la clase perro y se asigna a una variable. Luego se define otra variable de tipo perro y se asigna el mismo objeto.

<code>
public static void main(String[] args) throws CloneNotSupportedException {
   Perro unPerro = new Perro();
   unPerro.setNombre("Boby");
   unPerro.setRaza("Callejero");
   unPerro.setTamanio(2);

Perro otroPerro = unPerro;

if ( unPerro == otroPerro){
System.out.println("Los dos objetos tienen igualdad referencial");
} else {
System.out.println("Los dos objetos son distintos");
}
}
Los dos objetos tienen igualdad referencial

</code>

El hashcode es un identificador que se asigna a cada objeto que se crea y se almacena en un HASH en las instancia de la clase.

Su comportamiento por defecto es usar el hashcode asignado por la clase Object (todas las clases heredan comportamiento).

**¿Por qué sobreescribir estos métodos?**
Porque el comportamiento por default heredado de Object hace que a cada objeto que crea la JVM le asigne un hashcode único.

Por este motivo es necesario sobreescribir el método hashcode() para poder garantizar que dos objetos equivalentes son iguales.

También es necesario sobreescribir el método equals() de modo que si llama a cualquiera de los objetos pasando el otro objeto, siempre devuelve verdadero.

**Ejemplo**
Se crean dos objetos perro con las mismas características: nombre, raza, tamaño pero en la clase perro no se sobreescriben los métodos hashcode() y equals()
Podemos ver que tienen distinto hashcode

<code>
public static void main(String[] args) throws CloneNotSupportedException {
   Perro unPerro = new Perro();
   unPerro.setNombre("Boby");
   unPerro.setRaza("Callejero");
   unPerro.setTamanio(2);

Perro otroPerro = new Perro();
otroPerro.setNombre("Boby");
otroPerro.setRaza("Callejero");
otroPerro.setTamanio(2);

if ( unPerro.equals(otroPerro)){
System.out.println("Hashcode del objeto unPerro " + unPerro.hashCode());
System.out.println("Hashcode del objeto otroPerro " + otroPerro.hashCode());
System.out.println("Los dos objetos tienen igualdad de objetos");
} else {
System.out.println("Hashcode del objeto unPerro " + unPerro.hashCode());
System.out.println("Hashcode del objeto otroPerro " + otroPerro.hashCode());
System.out.println("Los dos objetos son distintos");
}
}
Hashcode del objeto unPerro 1057941451
Hashcode del objeto otroPerro 434091818
Los dos objetos son distintos

</code>

Los perros se llaman igual y son de la misma raza y tienen el mismo tamaño ¿No deberían ser iguales?
Para que sean iguales tenemos que sobreescribir los métodos hashcode() y equals().
Primero vamos a la clase Perro a sobreescribir dichos métodos

Clase Perro
<code>
@Override
public boolean equals(Object o) {
if (this == o) return true;
if (o == null || getClass() != o.getClass()) return false;
Perro perro = (Perro) o;
return tamanio == perro.tamanio && Objects.equals(nombre, perro.nombre) && Objects.equals(raza, perro.raza);
}

@Override
public int hashCode() {
return Objects.hash(tamanio, nombre, raza);
}
</code>

Cómo podemos ver ambos métodos usan los valores de las variables del objeto para generar un nuevo hash en el método hashcode() y para comparar un objeto con otro en el método equals()

Ejecutamos el mismo código nuevamente.
Prestar atención que en el método main() no se modificó nada.
La modificación se realizó en la clase Perro

<code>
public static void main(String[] args) throws CloneNotSupportedException {
   Perro unPerro = new Perro();
   unPerro.setNombre("Boby");
   unPerro.setRaza("Callejero");
   unPerro.setTamanio(2);

Perro otroPerro = new Perro();
otroPerro.setNombre("Boby");
otroPerro.setRaza("Callejero");
otroPerro.setTamanio(2);

if ( unPerro.equals(otroPerro)){
System.out.println("Hashcode del objeto unPerro " + unPerro.hashCode());
System.out.println("Hashcode del objeto otroPerro " + otroPerro.hashCode());
System.out.println("Los dos objetos tienen igualdad de objetos");
} else {
System.out.println("Hashcode del objeto unPerro " + unPerro.hashCode());
System.out.println("Hashcode del objeto otroPerro " + otroPerro.hashCode());
System.out.println("Los dos objetos son distintos");
}
}

Hashcode del objeto unPerro 1027534268
Hashcode del objeto otroPerro 1027534268
Los dos objetos tienen igualdad de objetos
</code>

**Sobreescribir los métodos**

1. En el Intellij los pasos son los siguientes: Dentro de la clase, botón derecho y cuando aparece el menú se elige Generate
2. Podemos ver que el menú nos ofrece generar de manera automática equals() and hashcode()
3. Seleccionamos las variables que van a ser usadas dentro de ambos métodos. Se pueden seleccionar diferentes variables para cada método pero en general se usan las mismas.
4. Cuando finalizamos la operación tenemos ambos métodos sobreescritos

**Leyes para hashCode() y equals()**

- Si dos objetos son iguales entonces tienen que tener el mismo hashcode
- Si dos objetos tienen el mismo hashcode no necesariamente tienen que ser iguales
- Si se sobreescribe el método equals() es obligatorio sobreescribir el método hashCode()

El comportamiento por default de hashcode() es generar un identificador único de tipo entero para cada objeto. Por lo tanto si no se sobreescribe el método hashCode() nunca dos objetos de ese tipo considerados equivalentes van a ser iguales.

El comportamiento por default de equals() es realizar una comparación usando el operador == para determinar la igualdad referencia. Por lo tanto si no se sobreescribe el método equals() nunca dos objetos de la misma clase van a tener la misma dirección de memoria

## Excepciones en Java

- Los métodos en Java usan excepciones para comunicar que algo salió mal, es decir, que hubo una falla.
- El mecanismo de manejo de excepciones de Java se emplea en situaciones excepcionales.
- Si sabemos que podremos obtener una excepción cuando llamamos a un método entonces podemos estar preparados y -tal vez- recuperarnos del error.
- Las Excepciones son objetos de tipo Exception que se dividen en:
  - Checked: Otras excepciones
  - Unchecked: Excepciones de tiempo de ejecución

Los métodos en Java usan excepciones para comunicar que algo salió mal, es decir, que hubo una falla.

El mecanismo de manejo de excepciones de Java se emplea en situaciones excepcionales.

Si sabemos que podremos obtener una excepción cuando llamamos a un método entonces podemos estar preparados y -tal vez- recuperarnos del error.

#### Checked

- Las excepciones chequeadas (también llamadas lógicas) son aquellas de las cuales podríamos recuperarnos.
- Por ejemplo, si quisiéramos comunicarnos con una base de datos que está caída temporalmente, entonces esperamos unos segundo y hacemos el reintento.
- Una exception chequeada es capturada en tiempo de compilación por el compilador y este te obliga a manejar dicha excepción.

#### Unchecked

- Las excepciones no chequeadas (Runtime Exception) son aquellas irrecuperables.
- Al ser en tiempo de ejecución no estamos obligados a manejarlas pero podríamos hacerlo.

- Throwable (Checked)
  - Exception (Checked)
    - Other uncheced exceptions subclasses
  - Error (Unchecked)
    - RunTimeException (Unchecked)
    - Other checked exceptions subclasses

**Ejemplo**

Nuestro método main quiere leer un archivo llamando a un método leerArchivo que primero llama a un método generarArchivo para que cree el archivo y después leerlo.

<code>
public static void main(String[] args) {
   String nombreArchivo = "Archivo inexistente";
   leerArchivo( nombreArchivo);
}

private static void leerArchivo(String nombreArchivo) {
FileInputStream archivoParaLeer = generarArchivo(nombreArchivo);
if(archivoParaLeer == null){
System.out.println("Archivo no encontrado");
}else {
//Se lee el archivo
}
}
private static FileInputStream generarArchivo(String nombreArchivo) {
File archivo = new File(nombreArchivo);
FileInputStream archivoCreado = new FileInputStream(archivo);
return archivoCreado;
}
</code>

El compilador nos avisa que el constructor (que es un método) de la clase FileInputStream lanza una excepción y nos pide que la manejemos.

### Manera de manejar con excepciones

- Usar la cláusula try-catch
- Usar la cláusula throws (en la firma del método)

Una opción es manejar la exception en el mismo método en que se genera usando el bloque try - catch

<code>
private static FileInputStream generarArchivo(String nombreArchivo) {
   File archivo = new File(nombreArchivo);
   FileInputStream archivoCreado = null;
   try {
       archivoCreado = new FileInputStream(archivo);
   } catch (FileNotFoundException e) {
       e.printStackTrace();
   }
   return archivoCreado;
}

</code>

Otra opción es delegar el manejo de la exception en el método que está invocando al que genera la exception usando la declaración throws

De esta manera “tiramos” la exception para arriba, es decir para quién invoca a este método.

<code>
private static FileInputStream generarArchivo(String nombreArchivo) throws FileNotFoundException {
   File archivo = new File(nombreArchivo);
   FileInputStream archivoCreado = null;
   archivoCreado = new FileInputStream(archivo);
   return archivoCreado;
}
</code>

**Veamos más ejemplos**
Nuestro método main llama a un método para realizar un división y pasa cómo parámetros dos números e imprime el resultado por consola

<code>
public static void main(String[] args) {
   int x = 1200;
   int y = 0;
   dividir(x, y);
}

private static void dividir(int x, int y) {
System.out.println( x / y );
}
</code>

Cuando ejecutamos el programa obtenemos una excepción de tipo AritmeticException indicando que no se puede dividir por cero

<code>
Exception in thread "main" java.lang.ArithmeticException: / by zero
	at com.company.Main.dividir(Main.java:14)
	at com.company.Main.main(Main.java:9)
</code>

Cómo podemos ver la definición de la clase es una exception de tipo RuntimeException entonces el compilador nos pide que la manejemos

Se puede capturar la exception con el bloque try - catch

<code>
public static void main(String[] args) {
   int x = 1200;
   int y = 0;
   dividir(x, y);
}

private static void dividir(int x, int y) {
try {
System.out.println( x / y );
} catch ( ArithmeticException e){
System.out.println("No es posible dividir por cero");
}
}

No es posible dividir por cero
</code>

**Control de flujo en Excepciones**
El programa intenta ejecutar el código que está dentro del bloque try.

Si se completa de forma satisfactoria, el flujo de control saltea el contenido del bloque catch y continúa al bloque finally (si existe), cuando el bloque finally finaliza se ejecutan las restantes sentencias del método.
Si hay una excepción dentro del bloque try el control de flujo inmediatamente se mueve al bloque catch, cuando éste completa el control de flujo pasa al finally (si existe).

**Ejemplo**

Cuando se llama a un método que puede arrojar una excepción son viables una de dos opciones:

1. el método se ejecuta satisfactoriamente y el bloque try se completa

<code>
public static void main(String[] args) {
   int pos = 10;
   try {
       int numero = getNumero(pos);
       System.out.println("El núemro en la posición " + pos + " es " + numero);
       System.out.println("El programa ejecutó satisfactoriamente");
   } catch (Exception e) {
       System.out.println("Hubo un error obteniendo el numero en la posición " + pos);
   }
}

private static int getNumero(int posicion){
int[] numeros = {1, 2, 3};
return numeros[posicion];
}

El núemro en la posición 0 es 1
El programa ejecutó satisfactoriamente
</code>

2. O el método falla y lanza una excepción.

En este caso el bloque try se ejecuta pero no se completa y el flujo pasa a ejecutar el bloque catch.

<code>
public static void main(String[] args) {
   int pos = 10;
   try {
       int numero = getNumero(pos);
       System.out.println("El núemro en la posición " + pos + " es " + numero);
       System.out.println("El programa ejecutó satisfactoriamente");
   } catch (Exception e) {
       System.out.println("Hubo un error obteniendo el numero en la posición " + pos);
   }
}

private static int getNumero(int posicion){
int[] numeros = {1, 2, 3};
return numeros[posicion];
}

Hubo un error obteniendo el numero en la posición 10
</code>

**Finally**
La sentencia finally se utiliza en conjunto con el try para ejecutar en ese bloque siempre el código deseado independientemente de cualquier excepción que ocurra.

Por ejemplo: si estamos leyendo un archivo y obtenemos una excepción, en este caso pondríamos en el finally la lógica necesaria para cerrar el archivo.

<code>
public static void main(String[] args) {
   int pos = 10;
   try {
       int numero = getNumero(pos);
       System.out.println("El núemro en la posición " + pos + " es " + numero);
       System.out.println("El programa ejecutó satisfactoriamente");
   } catch (Exception e) {
       System.out.println("Hubo un error obteniendo el numero en la posición " + pos);
   }finally {
       System.out.println("Este bloque de código se ejecuta siempre");
   }
}

private static int getNumero(int posicion){
int[] numeros = {1, 2, 3};
return numeros[posicion];
}

Hubo un error obteniendo el numero en la posición 10
Este bloque de código se ejecuta siempre
</code>

## Constructor

La característica principal de un constructor es que se ejecuta antes que el objeto se asigne a una referencia.
Esto brinda la posibilidad de “pararse” en el medio de la creación del objeto y hacer lo que sea necesario para dejar el objeto listo para ser asignado.

La mayoría de los usos están relacionados a configurar el estado de un objeto, es decir de asignar valores a las variables de instancia.
El constructor es un método que tiene el mismo nombre de la clase pero a diferencia de los otros métodos no define un return type.

**¿Cómo se usa?**
Vamos a modificar el ejemplo de la clase Perro para que los valores de las variables sean asignadas a través del constructor y no usando los getters y setters.

<code>
public Perro(int tamanio, String nombre, String raza) {
   this.tamanio = tamanio;
   this.nombre = nombre;
   this.raza = raza;
}
</code>

Luego vamos a modificar el método main para usar el constructor

<code>
public static void main(String[] args) throws CloneNotSupportedException {
   Perro unPerro = new Perro(2, "Boby", "Callejero");
   System.out.println("El perro " + unPerro.getNombre() + " es un " + unPerro.getRaza() + " de tamanio " + unPerro.getTamanio());
   System.out.println("Cuando el perro ladra dice " + unPerro.ladrar());
}
</code>

- Una opción es escribirlos a mano. ❌
- La otra usar el IDE. ✅

1. Dentro de la clase, botón derecho y cuando aparece el menú se elige Generate.
2. Podemos ver que el menú nos ofrece generar de manera automática Constructor.
3. Seleccionamos las variables que van a ser usadas dentro del constructor. Se pueden seleccionar diferentes variables dependiendo de la necesidad del negocio.
4. Para finalizar vemos el constructor generado en la clase Perro.

<code>
public Perro(int tamanio, String nombre, String raza) {
   this.tamanio = tamanio;
   this.nombre = nombre;
   this.raza = raza;
}
</code>

## Consideraciones

- Se pueden crear tantos constructores cómo se necesiten
- Los constructores no se heredan
- Si no se define un constructor el compilador brinda uno por defecto
- Si se define un constructor con argumentos asegurar definir también un constructor sin argumentos

Object.clone

La clonación de un objeto crea una copia de un objeto existente para modificar o mover el objeto copiado sin afectar el objeto original. En Java, los objetos se manipulan a través de variables de referencia y no existe un operador para copiar un objeto. Recuerde que el operador de asignación duplica la referencia, no el objeto.
