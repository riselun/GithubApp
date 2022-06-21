package io.github.aaron.github.base

import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.koin.standalone.StandAloneContext
import org.koin.test.KoinTest

abstract class BaseTest: KoinTest {

    protected lateinit var mockServer: MockWebServer

    @Before
    open fun setUp(){
        configureMockServer()
    }

    @After
    open fun tearDown(){
        stopMockServer()
        StandAloneContext.stopKoin()
    }

    abstract fun isMockServerEnabled(): Boolean // Because we don't want it always enabled on all tests

    private fun configureMockServer(){
        if (isMockServerEnabled()){
            mockServer = MockWebServer()
            mockServer.start()
        }
    }

    private fun stopMockServer() {
        if (isMockServerEnabled()){
            mockServer.shutdown()
        }
    }

    fun getMockUrl() = mockServer.url("/").toString()

}