plugins {
  java
  pmd
  jacoco
}       

repositories {
	mavenCentral()
}

dependencies {
  testCompile("org.junit.jupiter:junit-jupiter-api:5.2.0")
  testRuntime("org.junit.jupiter:junit-jupiter-engine:5.2.0")
  testRuntime("org.junit.platform:junit-platform-console:1.2.0")
  testCompile("org.mockito:mockito-core:1.+")
  implementation("com.google.code.gson:gson:2.8.5") 
}
 
sourceSets {
  main {
    java.srcDirs("PriceOptimizer/src")
    resources.srcDirs("PriceOptimizer/src")
  }
  test {
    java.srcDirs("PriceOptimizer/test")
  }
}

val test by tasks.getting(Test::class) {
	useJUnitPlatform {}
}

tasks {
  val treatWarningsAsError =
    listOf("-Xlint:unchecked", "-Xlint:deprecation", "-Werror")

  getByName<JavaCompile>("compileJava") {
    options.compilerArgs = treatWarningsAsError      
  }

  getByName<JavaCompile>("compileTestJava") {
    options.compilerArgs = treatWarningsAsError
  }

}

tasks {
    getByName<JacocoReport>("jacocoTestReport") {
        afterEvaluate {
            setClassDirectories(files(classDirectories.files.map {
                fileTree(it) { exclude("**/ui/**") }
            }))
        }
    }
} 

pmd {
  ruleSets = listOf()
  ruleSetFiles = files("../conf/pmd/ruleset.xml")
}

task("run") {
   dependsOn("runnoerror", "runwitherror")
}

defaultTasks("clean", "test", "jacocoTestReport", "pmdMain")
