Participante.

Prueba de salida, Full Stack Java Trainee, Bootcamp Awakelab a través de Talento Digital.

Link repositorio Luis Reyes Miranda. https://github.com/LuisGReyesM/Restaurant

Pendientes por realizar
Casos de prueba.
Security (aunque el ejercicio no lo pide)
Se utiliza js con fecth para la lectura de los archivos Json.


Comentarios generales.

Para realizar la búsqueda, se debe elegir uno de los campos por medio de los option
buttons.

Luego se presiona sobre el boton buscar y despliega los datos solicitados.



1. Se trabaja con BD de datos entregada para el ejercicio, alojada en mysql.
2. Se utiliza Spring Security aplicando diferentes perfiles de acuerdo a las necesidades de cada usuario, así solo se visualiza la información útil para cada uno.
3. Todas las páginas mantienen el mismo estilo y capacidad de responsividad.
4. Cada página trabaja con su propio JS para mejorar su funcionalidad.
5. El proyecto ha sido creado en IntelliJIdea, utilizando Spring Framework.



Detalle de la prueba de salida

Examen de Certificación
Plan Formativo: Desarrollador de Aplicaciones web Full Stack Java Trainee
Caso de Prueba
Gestor de Inscripción y Datos de personas
El restaurant “X” ha tenido un crecimiento en cuanto a los comensales que se
acercan a su local a degustar de sus platos, este crecimiento le ha traído como
consecuencia el descontrol en las cobranzas de las mesas, a que garzón le
corresponde la comisión por propina, y otra serie de malestares operacionales, por
tanto, solicita a la empresa en la que trabajas realizar una aplicación web para la
gestión de su atención, mesas, pedidos y garzones.
Requisitos del Proyecto
 Se necesita desarrollar una aplicación web para administrar las operaciones de un
restaurant. Esta debe ser construida en Spring Boot y utilizando las herramientas
necesarias para establecer la comunicación con la Base de Datos en MySQL.
Requisitos técnicos
 Utiliza el framework Spring Boot MVC para el desarrollo de la aplicación.
 Utiliza una base de datos MySQL para almacenar la información utilizando el código
sql proporcionado.
 Utiliza el patrón de diseño MVC para organizar tu código de manera adecuada.
 Implementa controladores, servicios y repositorios necesarios para manejar las
operaciones mencionadas anteriormente.
 La aplicación debo contar con una API Rest.
 Configura la conexión a la base de datos MySQL y utiliza JPA (Java Persistence API) u
otra que estimes conveniente para interactuar con ella.
 Utiliza Thymeleaf o JSTL como motor de plantillas para renderizar las vistas HTML o
JSP.
 Utilizar Bootstrap para el desarrollo de la interfaz de la Aplicación.
 Todas las vistas deben ser responsivas aplicables a tres pantallas de tamaños
distintos.
 El trabajo debe ser realizado en un Repositorio Público Personal con Git (GitHub,
GitLab u otro), realizando commit’s durante el proceso de trabajo.

Diagrama de Clases

Instrucciones
Actividad 1: Consultas a la base de datos
Antes de proceder a armar la aplicación, debes validar que la base de datos se encuentra en
condiciones de ser utilizada, es por esto que se te solicitan realizar las siguientes consultas
en lenguaje SQL, las cuales debes agregar en el proyecto dentro de un Package con el
nombre de consultas.
Consulta 1
Se solicita mostrar los nombres y cantidades solicitadas de los platos en el pedido de id 1.
Consulta 2
Se solicita una lista con la cantidad de pedidos que recibido cada mesa
Consulta 3
Se solicita una lista con el monto de ventas de cada camarero, ordenados alfabéticamente
de forma descendente, agrupados por el nombre del camarero.
Consulta 4
Se solicita mostrar el plato más solicitado y la cantidad correspondiente de solicitudes.
Consulta 5
Se solicita una lista con los platos vendidos y el valor total que se ha obtenido por cada plato,
agrupados por el nombre del plato y ordenados de forma ascendente.

Actividad 2: Algoritmo y Pruebas Unitarias
Dentro de las posibles soluciones en la aplicación se está buscando mejorar el manejo del
cobro y los descuentos a cada cliente. Existirán dos formas para aplicar los diferentes
descuentos una que considera la cantidad de platos solicitados y la otra que considera la
cantidad de platos y la capacidad de la mesa. Por tanto, el arquitecto del proyecto te solicita
definir una interfaz para poder llevar a cabo ambas estrategias.

Según el diagrama, debes implementar un método que recibe una lista de detalle y retorna
el porcentaje de descuento en valor decimal.
Para el cálculo según edad, debes cumplir con el siguiente detalle:
 Si se piden hasta 5 platos no aplicará descuento
 Si se piden más de 5 platos y menos de 10 tiene un 3% de descuento
 Si se solicitan entre 10 y 15 platos se aplicará un 5% de descuento.
 Si se piden más de 15 platos se le aplica un 30% de descuento.
Para el cálculo según cantidad de platos y capacidad de la mesa, se debe cumplir con el
siguiente detalle:
 Si se solicitan más de 5 platos y tiene capacidad de menos de 4 personas en la mesa,
tiene un 15% de descuento.
 Si se solicitan entre 5 y 15 platos y la mesa tiene capacidad entre 4 y 6 personas se
aplica un 20% de descuento
 Si la mesa tiene capacidad mayor a 6 personas y se piden más de 15 platos, se aplica
un 30% de descuento.
 Si la mesa es para 2 personas, y se solicitan más de 5 platos tendrá un 15% de
descuento.
 Si la mesa tiene capacidad de 4 personas o menos, y solicitan menos de 5 platos no
hay descuentos.

Debes construir la clase main para ejecutar y probar estos cálculos.
Además debes construir las clases de prueba en Java, que permita validar el correcto
funcionamiento de estos algoritmos. Para ello, debes considerar la creación de los siguientes
test:
 Test de pruebas en condiciones normales
 Test de pruebas en condiciones de borde
Actividad 3: API Rest
En este momento, debes construir la aplicación web con Spring, deberás crear las clases y
objetos correspondientes, los servicios, implementaciones y controladores (Rest)
necesarios para que esta aplicación pueda realizar un CRUD (Crear, Editar, Leer y Eliminar)
de platos.
Implementa los endpoints correspondientes para cada una de estas acciones.
Actividad 4: Web Dinámica
Para esta parte, utiliza el proyecto realizado anteriormente y construye los controladores
que permitan la integración con el front-end, puedes utilizar cualquiera de las herramientas
vistas en clases, JSP o Thymeleaf.
La vista debe mostrar el historial de pedidos, en específico;
 Buscador de Pedidos: Debe tener una barra de búsqueda, que permita buscar un
pedido por Id o por cualquier otro parámetro. Al realizar la búsqueda debe aparecer
una lista de todos los pedidos que coinciden con el parámetro de búsqueda. Y el
usuario podrá seleccionar un pedido para ver su detalle.
Podría ser un selector o un combobox.
 Detalle: En el centro de la página y luego del buscador, debe aparecer una lista con
todos los detalles de los pedidos con los datos correspondientes: Mesa, Camarero,
Fecha y Total.
 Botones de acción: A un costado de los datos de la visita, debe haber un botón, editar


