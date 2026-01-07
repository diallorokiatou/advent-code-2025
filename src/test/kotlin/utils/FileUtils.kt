package utils

import java.io.File

object FileUtils {
    fun retrieveResourceFile(fileName: String): File {
        val resource = this::class.java.classLoader.getResource(fileName)
            ?: throw IllegalArgumentException("Resource not found: $fileName")
        return File(resource.toURI())
    }
}