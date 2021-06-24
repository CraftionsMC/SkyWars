package net.craftions.skywars.util

import java.io.File
import java.io.PrintWriter

class PathUtil {

    companion object {

        fun makeRootDirectory(file: File) {
            if (!file.parentFile.isDirectory)
                file.parentFile.mkdirs()
            if (!file.exists())
                file.createNewFile()
        }

        fun setFileContent(file: File, content: String) {
            val writer: PrintWriter = PrintWriter(file);
            writer.write(content)
            writer.close()
        }

    }

}