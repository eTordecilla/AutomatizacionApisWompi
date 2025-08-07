# 👨‍💻 Autor: Elkin David Tordecilla Avila
[🔗 LinkedIn](https://www.linkedin.com/in/elkin-david-tordecilla-avila-b137ab152/)

---

# 🤖 Automation API - REST WOMPI

---

# 🗂️ Tabla de Contenido

1. [Información General](#1-información-general)
2. [Estructura del Proyecto](#2-estructura-del-proyecto)
3. [Arquitectura de Proyecto de Software - QA Automation](#3-arquitectura-de-proyecto-de-software---qa-automation)
4. [Pre-Requisitos Local](#4-pre-requisitos-local)
5. [Instalación](#5-instalación)
6. [Pasos para la Ejecución](#6-pasos-para-la-ejecución)
7. [¡NOTA!](#7-nota)

---

# 1. 🚀 Información General

- **🌐 URL BASE a consumir:**  
  `https://api-sandbox.co.uat.wompi.dev/v1/merchants`
- **🧰 Frameworks:**
    - Gherkin
    - Cucumber
    - JUnit
    - Serenity-Rest
    - API-REST
- **📦 Frameworks adicionales:** Cucumber for Java
- **💻 Lenguaje:** Java
- **⚙️ Gradle:** 8.10
- **☕️ OPEN_JDK:** 17.0.11
- **🛠️ IDE:** IntelliJ IDEA Community Edition 2025.2
- **🎭 Patrón de diseño:** Screenplay

---

# 2. 📂 Estructura del Proyecto

- 💻 src                      → Código fuente principal del proyecto
    - 🛠️ main                 → Lógica principal y artefactos base
        - 🧑‍💻 java           → Implementación en Java
            - 🛰️ co.wompi     → Paquete raíz del dominio de automatización
                - 🛡️ exceptions          → Manejo de excepciones personalizadas y robustas
                - 🗂️ models              → Definición de modelos de datos y DTOs para la API
                    - 📝 MerchantResponse.java   → Modelo de respuesta del endpoint de Merchant
                - ❓ questions            → Consultas, validaciones y asserts para Screenplay
                    - 📋 MerchantInformation.java   → Validación e interpretación de la información del comercio
                - 🏃‍♂️ tasks              → Tareas/acciones que el actor ejecuta (Screenplay)
                    - 🔎 GetMerchant.java            → Tarea para consultar información válida del comercio
                    - 🛑 GetMerchantWrongEndpoint.java → Tarea para simular error en endpoint
                - 🧰 utils                → Funciones utilitarias y herramientas de apoyo
    - 🧪 test                  → Código y recursos exclusivos para pruebas automatizadas
        - 🧑‍🔬 java           → Paquete de lógica de pruebas
            - 🛰️ co.wompi
                - 🏁 runners             → Ejecutores (runners) de los escenarios de pruebas
                    - 🏆 ApiTestRunner.java   → Clase principal para lanzar pruebas automatizadas
                - 👣 stepdefinitions     → Definición de pasos (steps) Gherkin en Java
                    - 📜 MerchantStepDefinitions.java → Implementación detallada de pasos de merchant
        - 🗄️ resources           → Recursos auxiliares, configuración y features de test
            - 📑 features                → Escenarios escritos en Gherkin para BDD
                - 🗒️ merchant_information.feature → Caso de prueba para consulta de merchant
            - 🧾 logback-test.xml        → Configuración avanzada de logs para pruebas
            - ⚙️ serenity.conf           → Configuración del framework Serenity BDD

---

# 3. 🏗️ Arquitectura de Proyecto de Software - QA Automation

## 👨‍💻 Actor Principal

**QA Automation**  
_Responsable de diseñar, escribir y ejecutar las pruebas automáticas sobre las APIs._

## 🖥️ Herramienta de Desarrollo

**IntelliJ IDEA**  
_Donde se escribe y mantiene el código fuente de automatización._

## 🟧 Control de Versiones

**Git**  
_Gestiona el versionamiento y los cambios realizados al código._

## 🐙 Repositorio Central

**GitHub**  
_Aloja el repositorio de la automatización de APIs, centralizando el código para el equipo._

## 🛠️ Tecnologías Usadas

| 🥒 Cucumber | 🛡️ Serenity BDD | 🔗 REST Assured | 🧪 JUnit | ☕ Java | 🐘 Gradle |
|:-----------:|:---------------:|:--------------:|:--------:|:-------:|:---------:|
| BDD & Features | Gestión y reportes | Test de APIs | Framework de pruebas | Lenguaje base | Gestión de dependencias |

## 📦 Estructura del Código Fuente

### 🎬 **Screenplay**
*Organiza la lógica principal de las pruebas siguiendo el patrón Screenplay.*

- 🏁 **runners** — Lanzadores de los escenarios de prueba automatizados.
- 📝 **features** — Escenarios escritos en Gherkin (BDD).
- 👣 **stepdefinitions** — Implementación en Java de los pasos Gherkin.
- 🏃‍♂️ **tasks** — Acciones y tareas automatizadas ejecutadas por el actor.
- 💬 **interactions** — Interacciones y comandos directos.
- ❓ **questions** — Validaciones y obtención de respuestas de la API.

**Interacción:**
- `runners`, `features` y `stepdefinitions` interactúan **directamente con los casos de prueba automatizados**.
- `tasks`, `interactions` y `questions` gestionan **la comunicación con el protocolo (API response)**.

### 🔄 **Transversal**
*Componentes compartidos y reutilizables en todo el framework.*

- 🗃️ **models** — Modelos de datos (DTOs) para mapear las respuestas de la API.
- 🛡️ **exceptions** — Manejo personalizado de errores y excepciones.
- 🧰 **utils** — Utilidades y helpers comunes.

### ⚙️ **Config**

*Archivos de configuración esenciales para la ejecución y el build del proyecto.*

- 📝 **serenity.conf** — Configuración principal de Serenity BDD.
- 📝 **build.gradle** — Dependencias y tareas de build.
- 📝 **.gitignore** — Control de archivos a ignorar en Git.
- 📝 **settings.gradle** — Configuración de módulos y proyectos.
- 📝 **logback-test.xml** — Configuración de logs en pruebas.

## 🛤️ **Flujo Resumido**

1. **QA Automation** desarrolla en **IntelliJ** 🖥️
2. Realiza control de cambios con **Git** 🟧
3. Sincroniza el repositorio en **GitHub** 🐙
4. El código fuente se divide en:
    - **Screenplay**
    - **Transversal**
    - **Config**
5. **Screenplay** ejecuta pruebas, gestiona interacción y validación con la API (protocolo/response)
6. **Transversal** y **Config** soportan y configuran el proyecto.

---

# 4. 🖥️ Pre-Requisitos Local

- **☕ Java 17 (JDK)**
- **💡 IDE IntelliJ IDEA**
    - **🔌 Plugins requeridos:**
        1. 🥒 Cucumber for Java
        2. 🧩 Gherkin
        3. 🗃️ HOCON
        4. 🐙 Git (GUI/Bash)

---

# 5. 📥 Instalación

- **HTTPS:**  
  `https://github.com/eTordecilla/AutomatizacionApisWompi.git`
- **SSH:**  
  `git@github.com:eTordecilla/AutomatizacionApisWompi.git`
- **🛠️ Abrir proyecto en el IDE (IntelliJ o su preferido)**
- **📦 Gestionar dependencias con Gradle**
    - Limpiar (clean task):  
      `./gradlew clean`

---

# 6. 🏃‍♂️ Pasos para la Ejecución

## 💻 Por Consola

- **Limpiar y ejecutar TODOS los escenarios:**
- `./gradlew clean test`
- **Ejecutar todos los tests con el runner específico:**
- `./gradlew test --tests "co.wompi.runners.ApiTestRunner"`
- **Generar reportes (incluye ruta .html):**
- `./gradlew clean test aggregate`

## 🖥️ Desde el Proyecto Local

- Dirígete a la sección de **runners** en el proyecto
- Elige el runner que más se ajuste a tu necesidad:
- `src/test/java/.../runners`
- Para lanzar un tag específico, busca la carpeta `/features` y ejecuta el tag correspondiente (debes descomentar la línea  `//, @test6`)

---

# 7. ✨ ¡NOTA!

En la ejecución verán el nombre de Alejandra como actor, decidí dejarlo así porque al ejecutar el curl es el nombre que retornaba.
