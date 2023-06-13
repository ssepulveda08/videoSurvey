
# Video Survey ▶️

VideoSurvey es una libreria para Android, diseñada en Jetpack Compose y kotlin, te permite reproducir un video con una Url publica y lanzar encuestas de única o múltiple respuesta en un milisegundo específico del video. Proporciona una solución sencilla para integrar la reproducción de video y la interacción con encuestas en tus aplicaciones de Android basadas en Jetpack Compose.


## Features 

- Reproducción de video: la librería facilita la reproducción de videos
- Encuestas de única o múltiple respuesta: puedes mostrar encuestas en momentos específicos del video para interactuar con los usuarios.
- Configuración de tiempo de visualización: puedes establecer el tiempo exacto en milisegundos para mostrar la encuesta durante la reproducción del video.
- Personalización de preguntas y respuestas: puedes personalizar las preguntas y opciones de respuesta para adaptarlas a tus necesidades.
- Gestión de eventos: la librería proporciona métodos para capturar eventos de respuesta de encuesta y controlar la reproducción del video.


## Installation

Puedes agregar esta librería a tu proyecto de Android basado en Jetpack Compose siguiendo estos pasos:

En el archivo *app/build.gradle* agregar la dependencia de la libreria.

```bash
  implementation 'com.ssepulveda.videosurvey:videosurvey:0.0.3'
```

Ahora vamos a configurar GitHub como un repositorio para poder descargar una biblioteca. Para hacer esto, necesitarás tener un nombre de usuario en GitHub y un token con permisos de lectura para github:packages.

Una vez que tengas esos detalles, debes agregar las credenciales en el archivo gradle.properties.

```bash  
    USER_GITHUB = [YOUR_USER_GITHUB]
    TOKEN_GITHUB = [YOUR_TOKEN_GITHUB]
```

Después de agregar tus credenciales, debes configurar el repositorio en el archivo base/setting.gradle del proyecto.

```bash  
   repositories {
        maven {
            url = uri("https://maven.pkg.github.com/ssepulveda08/videoSurvey")
            credentials {
                username = USER_GITHUB
                password = TOKEN_GITHUB
            }
        }

    }
```
 
Por ultimo, sincronizamos el proyecto y todo listo para utilizar esta fabulosa libreria.
    

    
## Uso
A continuación, se muestra un ejemplo básico de cómo usar la librería en tu aplicación de Android basada en Jetpack Compose:

```kotlint  
   repositories {
        setContent {
            PreviewVideosurveyTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    VideoBox(
                        videoUri = "https://storage.googleapis.com/gtv-videos-bucket/sample/ForBiggerJoyrides.mp4",
                        survey = getSurvey(),
                        listener = object : VideoSurveyListener {
                            override fun onCompletedVideo(response: SurveyResponse) {
                                // TODO Add logic to complete the video
                            }
                        }
                    )
                }
            }
        }
    }
```

## PERMISOS
Añade los siguientes permisos en el archivo *AndroidManifest.xml*


```bash  
    <uses-permission android:name="android.permission.INTERNET" />
    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
```

Para utilizar el reproductor de video debes agregar VideoBox a un contenedor composable, este componente recibe la url del video en el siguiente atributo *videoUri*


Asegúrate de proporcionar los permisos necesarios para la reproducción de video en el archivo AndroidManifest.xml de tu aplicación.

## Contribución
Si deseas contribuir a esta librería, puedes seguir los siguientes pasos:

- Realiza un fork de este repositorio.
- Crea una nueva rama con tu función/bugfix: git checkout -b mi-nueva-funcion
- Realiza los cambios y realiza los commits: git commit -am 'Agrega nueva función'