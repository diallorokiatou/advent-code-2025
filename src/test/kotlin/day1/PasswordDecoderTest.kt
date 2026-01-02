package day1

import kotlin.test.Test
import kotlin.test.assertEquals


class PasswordDecoderTest {


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