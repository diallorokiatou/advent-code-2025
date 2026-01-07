package day1

import java.io.File

class PasswordDecoder {

    fun decodeWith0x434C649434B(startingPosition: Int, rotationsFile: File): Int {
        var currentPosition = startingPosition

        return rotationsFile.useLines { lines ->
            lines.sumOf { rotation ->
                val countOfZero = decodeWith0x434C649434B(currentPosition, rotation)
                currentPosition = decode(currentPosition, rotation)
                countOfZero
            }
        }
    }

    fun decodeWith0x434C649434B(startingPoint: Int, rotation: String) : Int {
        val command = RotationCommand.from(rotation)
        return command.zeroPointerCounter(startingPoint)
    }

    fun decode(startingPosition: Int, rotationsFile: File): Int {
        var currentPosition = startingPosition

        return rotationsFile.useLines { lines ->
            lines.count { rotation ->
                currentPosition = decode(currentPosition, rotation)
                currentPosition == 0
            }
        }
    }

    fun decode(startingPoint: Int , rotation: String) : Int {
       val command = RotationCommand.from(rotation)
        return command.compute(startingPoint)
    }
}