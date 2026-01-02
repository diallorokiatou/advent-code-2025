package day1

import java.io.File
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith


class PasswordDecoderTest {
   @Test
    fun should_decode_input_final_file(){
        // Given
        val passwordDecoder = PasswordDecoder()
        val file = File(this::class.java.classLoader.getResource("day1/finalInput.txt").file)
        // When
        val password = passwordDecoder.decode(50, file)
        // Assert
        assertEquals(1052, password)
    }

    @Test
    fun should_return_3_when_decode_input_file(){
        // Given
        val passwordDecoder = PasswordDecoder()
        val file = File(this::class.java.classLoader.getResource("day1/input.txt").file)
        // When
        val password = passwordDecoder.decode(50, file)
        // Assert
        assertEquals(3, password)
    }

    @Test
    fun should_throws_illegal_operation_when_operation_don_t_start_with_L_or_R(){
        // Given
        val passwordDecoder = PasswordDecoder()
        // Assert
        assertFailsWith(
            exceptionClass = NotRecognizeRotationException::class,
            block = {passwordDecoder.decode(19, "Z19") }
        )
    }

    @Test
    fun should_point_at_5_when_rotation_of_R300_starting_5(){
        // Given
        val passwordDecoder = PasswordDecoder()
        // When
        val position = passwordDecoder.decode(5, "R300")
        // Assert
        assertEquals(5, position)
    }

    @Test
    fun should_point_at_0_when_rotation_of_R300_starting_0(){
        // Given
        val passwordDecoder = PasswordDecoder()
        // When
        val position = passwordDecoder.decode(0, "L300")
        // Assert
        assertEquals(0, position)
    }

    @Test
    fun should_point_at_0_when_rotation_of_R5_starting_95(){
        // Given
        val passwordDecoder = PasswordDecoder()
        // When
        val position = passwordDecoder.decode(95, "R5")
        // Assert
        assertEquals(0, position)
    }

    @Test
    fun should_point_at_95_when_rotation_of_L10_starting_5(){
        // Given
        val passwordDecoder = PasswordDecoder()
        // When
        val position = passwordDecoder.decode(5, "L10")
        // Assert
        assertEquals(95, position)
    }

    @Test
    fun should_point_at_0_when_rotation_of_R1_starting_99(){
        // Given
        val passwordDecoder = PasswordDecoder()
        // When
        val position = passwordDecoder.decode(99, "R1")
        // Assert
        assertEquals(0, position)
    }

    @Test
    fun should_point_at_99_when_rotation_of_L1_starting_0(){
        // Given
        val passwordDecoder = PasswordDecoder()
        // When
        val position = passwordDecoder.decode(0, "L1")
        // Assert
        assertEquals(99, position)
    }

    @Test
    fun should_point_at_0_when_rotation_of_L19_starting_19() {
        // Given
        val passwordDecoder = PasswordDecoder()
        // When
        val position = passwordDecoder.decode(19, "L19")
        // Assert
        assertEquals(0, position)
    }

    @Test
    fun should_point_at_19_when_rotation_of_R8_starting_11() {
        // Given
        val passwordDecoder = PasswordDecoder()
        // When
        val position = passwordDecoder.decode(11, "R8")
        // Assert
        assertEquals(19, position)
    }

}