package day2

import utils.FileUtils.retrieveResourceFile
import kotlin.test.Test
import kotlin.test.assertEquals

class ProductIdScannerTest {

    @Test
    fun should_compute_invalid_id_from_input_file() {
        val productIdScanner = ProductIdScanner()
        val file = retrieveResourceFile("day2/input.txt")

        val result = productIdScanner.computeInvalidIds(file)

        assertEquals(52316131093L, result)
    }

    @Test
    fun should_return_1227775554_when_compute_invalid_id_from_example_file() {
        val productIdScanner = ProductIdScanner()
        val file = retrieveResourceFile("day2/example.txt")

        val result = productIdScanner.computeInvalidIds(file)

        assertEquals(1227775554L, result)
    }

    @Test
    fun should_return_empty_set_when_find_invalids_id_from_range_1698522_1698528() {
        val productIdScanner = ProductIdScanner()
        val result = productIdScanner.findInvalidIds(LongRange(1698522,1698528))
        assertEquals(setOf(), result)
    }

    @Test
    fun should_return_set_of_222222_when_find_invalids_id_from_range_222220_222224() {
        val productIdScanner = ProductIdScanner()
        val result = productIdScanner.findInvalidIds(LongRange(222220,222224))
        assertEquals(setOf(222222L), result)
    }

    @Test
    fun should_return_set_of_1010_when_find_invalids_id_from_range_998_1012() {
        val productIdScanner = ProductIdScanner()
        val result = productIdScanner.findInvalidIds(LongRange(998, 1012))
        assertEquals(setOf(1010L), result)
    }

    @Test
    fun should_return_set_of_99_when_find_invalids_id_from_range_95_115() {
        val productIdScanner = ProductIdScanner()
        val result = productIdScanner.findInvalidIds(LongRange(95, 115))
        assertEquals(setOf(99L), result)
    }

    @Test
    fun should_return_set_of_11_and_22_when_find_invalids_id_from_range_11_22() {
        val productIdScanner = ProductIdScanner()
        val result = productIdScanner.findInvalidIds(LongRange(11, 22))
        assertEquals(setOf(11L, 22L), result)
    }

    @Test
    fun should_return_set_of_11_when_find_invalids_id_from_range_1_11() {
        val productIdScanner = ProductIdScanner()
        val result = productIdScanner.findInvalidIds(LongRange(1, 11))
        assertEquals(setOf(11L), result)
    }
}