package com.kvertinum01.tools

import java.io.File

private const val RESOURCES_DIR = "src/main/resources"

fun fileExists(path: String): Boolean =
    File("$RESOURCES_DIR$path").exists()

fun getResourcesDir(path: String): File =
    File("$RESOURCES_DIR$path")

fun writeBytes(album: String, name: String, fileBytes: ByteArray) =
    File("$RESOURCES_DIR/images/$album/$name").writeBytes(fileBytes)

fun makeDir(name: String) =
    File("$RESOURCES_DIR/images/$name").mkdir()

fun getListFiles(path: String): List<String> {
    val dir = getResourcesDir(path)
    return if(dir.isDirectory) {
        dir.walk().filter { it.isFile }.map { it.absolutePath }.toList()
    } else {
        error("path must be a directory")
    }
}
