# 👨‍💻 Autor: Elkin David Tordecilla Avila
[🔗 LinkedIn](https://www.linkedin.com/in/elkin-david-tordecilla-avila-b137ab152/)

---

# 🤖 Automation API - REST WOMPI

---

## 🚀 Información General

- **🌐 URL BASE a consumir:**  
  `https://api-sandbox.co.uat.wompi.dev/v1/merchants`
- **🎭 Patrón de diseño:** Screenplay
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

---

## ✅ Todos los casos de prueba cumplen con cada criterio solicitado

---

# 🖥️ Pre-Requisitos Local

- **☕ Java 17 (JDK)**
- **💡 IDE IntelliJ IDEA**
    - **🔌 Plugins requeridos:**
        1. 🥒 Cucumber for Java
        2. 🧩 Gherkin
        3. 🗃️ HOCON
        4. 🐙 Git (GUI/Bash)

---

# 📥 Instalación

- **HTTPS:**  
  `https://github.com/eTordecilla/AutomatizacionApisWompi.git`
- **SSH:**  
  `git@github.com:eTordecilla/AutomatizacionApisWompi.git`
- **🛠️ Abrir proyecto en el IDE (IntelliJ o su preferido)**
- **📦 Gestionar dependencias con Gradle**
    - Limpiar (clean task):  
      `./gradlew clean`

---

# 🏃‍♂️ Pasos para la Ejecución

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

> ✨ **¡NOTA!** En la ejecución verán el nombre de Alejandra como actor, decidí dejarlo así porque al ejecutar el curl es el nombre que sale .  

