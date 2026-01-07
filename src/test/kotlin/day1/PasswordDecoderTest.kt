package day1

import org.junit.jupiter.api.Nested
import utils.FileUtils.retrieveResourceFile
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith


class PasswordDecoderTest {
    @Nested
    inner class DecodeWith0x434C49434BTest {
        @Test
        fun should_decode_input_final_file() {
            // Given
            val passwordDecoder = PasswordDecoder()
            val file = retrieveResourceFile("day1/finalInput.txt")
            // When
            val password = passwordDecoder.decodeWith0x434C649434B(50, file)
            // Assert
            assertEquals(6295, password)
        }

        @Test
        fun should_return_6_when_decode_input_file() {
            // Given
            val passwordDecoder = PasswordDecoder()
            val file = retrieveResourceFile("day1/input.txt")
            // When
            val password = passwordDecoder.decodeWith0x434C649434B(50, file)
            // Assert
            assertEquals(6, password)
        }

       @Test
       fun should_point_zero_time_at_0_when_rotation_of_R14_starting_5() {
           // Given
           val passwordDecoder = PasswordDecoder()
           // When
           val zeroCounter = passwordDecoder.decodeWith0x434C649434B(5, "R14")
           // Assert
           assertEquals(0, zeroCounter)
       }

        @Test
        fun should_point_zero_time_at_0_when_rotation_of_R14_starting_0() {
            // Given
            val passwordDecoder = PasswordDecoder()
            // When
            val zeroCounter = passwordDecoder.decodeWith0x434C649434B(0, "R14")
            // Assert
            assertEquals(0, zeroCounter)
        }

        @Test
        fun should_point_one_time_at_0_when_rotation_of_R60_starting_95() {
            // Given
            val passwordDecoder = PasswordDecoder()
            // When
            val zeroCounter = passwordDecoder.decodeWith0x434C649434B(95, "R60")
            // Assert
            assertEquals(1, zeroCounter)
        }

        @Test
        fun should_point_one_time_at_0_when_rotation_of_R48_starting_52() {
            // Given
            val passwordDecoder = PasswordDecoder()
            // When
            val zeroCounter = passwordDecoder.decodeWith0x434C649434B(52, "R52")
            // Assert
            assertEquals(1, zeroCounter)
        }

       @Test
       fun should_point_10_time_at_0_when_rotation_of_L1000_starting_0() {
           // Given
           val passwordDecoder = PasswordDecoder()
           // When
           val zeroCounter = passwordDecoder.decodeWith0x434C649434B(0, "L1000")
           // Assert
           assertEquals(10, zeroCounter)
       }

        @Test
        fun should_point_10_time_at_0_when_rotation_of_L1000_starting_50() {
            // Given
            val passwordDecoder = PasswordDecoder()
            // When
            val zeroCounter = passwordDecoder.decodeWith0x434C649434B(50, "L1000")
            // Assert
            assertEquals(10, zeroCounter)
        }

        @Test
        fun should_point_one_time_at_0_when_rotation_of_L82_starting_14() {
            // Given
            val passwordDecoder = PasswordDecoder()
            // When
            val zeroCounter = passwordDecoder.decodeWith0x434C649434B(14, "L82")
            // Assert
            assertEquals(1, zeroCounter)
        }

        @Test
        fun should_point_one_time_at_0_when_rotation_of_L55_starting_55() {
            // Given
            val passwordDecoder = PasswordDecoder()
            // When
            val zeroCounter = passwordDecoder.decodeWith0x434C649434B(55, "L55")
            // Assert
            assertEquals(1, zeroCounter)
        }

        @Test
        fun should_point_zero_time_at_0_when_rotation_of_L5_starting_0() {
            // Given
            val passwordDecoder = PasswordDecoder()
            // When
            val zeroCounter = passwordDecoder.decodeWith0x434C649434B(0, "L5")
            // Assert
            assertEquals(0, zeroCounter)
        }

        @Test
        fun should_point_zero_time_at_0_when_rotation_of_L30_starting_82() {
            // Given
            val passwordDecoder = PasswordDecoder()
            // When
            val zeroCounter = passwordDecoder.decodeWith0x434C649434B(82, "L30")
            // Assert
            assertEquals(0, zeroCounter)
        }

        @Test
        fun should_point_one_time_at_0_when_rotation_of_L68_starting_50() {
            // Given
            val passwordDecoder = PasswordDecoder()
            // When
            val zeroCounter = passwordDecoder.decodeWith0x434C649434B(50, "L68")
            // Assert
            assertEquals(1, zeroCounter)
        }
    }

    @Nested
   inner class DecodeTest {
        @Test
        fun should_decode_input_final_file() {
            // Given
            val passwordDecoder = PasswordDecoder()
            val file = retrieveResourceFile("day1/finalInput.txt")
            // When
            val password = passwordDecoder.decode(50, file)
            // Assert
            assertEquals(1052, password)
        }

        @Test
        fun should_return_3_when_decode_input_file() {
            // Given
            val passwordDecoder = PasswordDecoder()
            val file = retrieveResourceFile("day1/input.txt")
            // When
            val password = passwordDecoder.decode(50, file)
            // Assert
            assertEquals(3, password)
        }

        @Test
        fun should_throws_illegal_operation_when_operation_don_t_start_with_L_or_R() {
            // Given
            val passwordDecoder = PasswordDecoder()
            // Assert
            assertFailsWith(
                exceptionClass = NotRecognizeRotationException::class,
                block = { passwordDecoder.decode(19, "Z19") }
            )
        }

        @Test
        fun should_point_at_5_when_rotation_of_R300_starting_5() {
            // Given
            val passwordDecoder = PasswordDecoder()
            // When
            val position = passwordDecoder.decode(5, "R300")
            // Assert
            assertEquals(5, position)
        }

        @Test
        fun should_point_at_0_when_rotation_of_R300_starting_0() {
            // Given
            val passwordDecoder = PasswordDecoder()
            // When
            val position = passwordDecoder.decode(0, "L300")
            // Assert
            assertEquals(0, position)
        }

        @Test
        fun should_point_at_0_when_rotation_of_R5_starting_95() {
            // Given
            val passwordDecoder = PasswordDecoder()
            // When
            val position = passwordDecoder.decode(95, "R5")
            // Assert
            assertEquals(0, position)
        }

        @Test
        fun should_point_at_95_when_rotation_of_L10_starting_5() {
            // Given
            val passwordDecoder = PasswordDecoder()
            // When
            val position = passwordDecoder.decode(5, "L10")
            // Assert
            assertEquals(95, position)
        }

        @Test
        fun should_point_at_0_when_rotation_of_R1_starting_99() {
            // Given
            val passwordDecoder = PasswordDecoder()
            // When
            val position = passwordDecoder.decode(99, "R1")
            // Assert
            assertEquals(0, position)
        }

        @Test
        fun should_point_at_99_when_rotation_of_L1_starting_0() {
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
}