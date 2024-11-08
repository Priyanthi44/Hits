package com.example.hits

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.hits.repository.HitsRepository
import com.example.hits.screens.home.MainScreenViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@ExperimentalCoroutinesApi
class ExampleUnitTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: MainScreenViewModel
    private val repository = mock(HitsRepository::class.java)

    private val testDispatcher = StandardTestDispatcher()

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        viewModel = MainScreenViewModel(repository)
    }

    @Test
    fun `fetchData should post value to LiveData`(): Unit = runTest {
        // Arrange

//
//        val hits :List<AvailableSize> = ArrayList();
//        hits.plus(hit)
//        `when`(repository.getHits()).thenReturn(
//            DataOrException(data = hits, null, null)
//        )
//
//        // Act
//        viewModel.data
//        advanceUntilIdle() // Ensures coroutines complete execution
//
//        // Assert
//        assertEquals(hit, viewModel.data.value)
    }


    @After
    fun tearDown() {
        Dispatchers.resetMain() // Reset the main dispatcher to avoid leaks
    }
}
