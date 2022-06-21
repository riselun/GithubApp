package io.github.aaron.github.repository

import io.github.aaron.github.base.BaseUT
import io.github.aaron.github.di.configureAppComponent
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.koin.standalone.StandAloneContext.startKoin
import org.koin.standalone.inject
import retrofit2.HttpException
import java.net.HttpURLConnection

@RunWith(JUnit4::class)
class RepoRepositoryTest: BaseUT() {

    private val repoRepository by inject<RepoRepository>()

    override fun isMockServerEnabled() = true

    override fun setUp() {
        super.setUp()
        startKoin(configureAppComponent(getMockUrl()))
    }


    @Test
    fun `search repo and succeed`() {
        mockHttpResponse("search_repo.json", HttpURLConnection.HTTP_OK)
        runBlocking {
            val repo = repoRepository.searchRepoWithPagination("FAKE", -1, -1, "FAKE")
            assertEquals(40, repo.total_count)
            assertEquals("https://api.github.com/repos/dtrupenn/Tetris/{archive_format}{/ref}", repo.items[0].archive_url)

        }
    }


}