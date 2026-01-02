package day1

import java.io.File

class PasswordDecoder {
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