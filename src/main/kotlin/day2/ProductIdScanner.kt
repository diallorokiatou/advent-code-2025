package day2

import java.io.File

class ProductIdScanner {

    fun computeInvalidIds(file: File) : Long {
        return file.readText().split(",")
            .map {
                val split = it.split("-")
                LongRange(split[0].toLong(), split[1].toLong())
            }.sumOf { validId ->
                findInvalidIds(validId).sumOf { it }
            }
    }

    fun findInvalidIds(range: LongRange) : Set<Long> {
        return range.filter {
            isValidId(it.toString())
        }.toSet()

    }

    fun isValidId(id: String) : Boolean {
        if(id.length.mod(2) != 0) return false
        val midLength = id.length.div(2)
        return  id.substring(0, midLength) == id.substring(midLength, id.length)
    }
}