

imagenes descargar de pexels
iconos descar de flat icons

navgraph
navegación entre pantallas 

Buenas practicas para la creación de componentes
Reutilización de componentes 
Creación de componentes dinamicos

Drawables
Uso de iconos 

Mvvm
patron de diseño mvvm

Daguer Hilt
Para inyección de dependencias

Retrofit
Para petciones http a servidores y api's

Gson
Para modelar  nuestras respuestas a formato json

Manejo de estados
Para la persistencia de datos en pantallas
Buenas practicas

Clase Resource
la clase resource nos sirve para recibir las respuestas de manera generica <T>
y manejar la respuesta del servidor.para evaluar si la respuesta en un succes regresar el modelo de datos. si es failure 
nos regresa una excepcion

Moshi
Nos permite modelar los objetos o respuestas del servidor a un formato json

Data store 
Jetpack DataStore es una solución de almacenamiento de datos que te permite almacenar pares clave-valor
Datastore usa corrutinas y Flow de Kotlin para almacenar datos de manera asíncrona, coherente y transaccional
solo se utiliza para guardar datos muy sencillos

Coil
Biblioteca de carga de imágenes url para Android respaldada por Kotlin Coroutines
Coil realiza una serie de optimizaciones que incluyen almacenamiento en caché de memoria y disco, reducción de resolución de la imagen en la memoria, pausa/cancelación automática de solicitudes

Agregar estos archivos ComposeFileProvider y ResultingActivityHandler en la carpeta util de presentation.util aqui se van a guardar las imagenes mientras se
suben al servidor ademas guardaremos las imagenes de manera momentanea el file_paths hay que agregarlo en el manifest y tambien los permisos
para la camara
ResultingActivityHandler nos permite trabajar con las imagenes en un context de viewmodel

Mappers AdminCategoryUpdateStateMappers convertimos el estado en un modelo categoria 

Agregar la libreria implementation "commons-io:commons-io:2.7" nos sirve para crear archivos a travez  de Uris

Room 
Libreria para sqlite nos permite guardar datos complejos como categorias, productos etc
instalar la libreria configurar los dao y entitys, las entitys nos ayudan adiferenciar el modelode datos local y remoto
primero db luego dao, entity

Comparelist util domain compara las listas para que no liste datos repetidos

Mercado pago
