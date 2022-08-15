package com.anushka.newsapiclient.data.api


import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okio.buffer
import okio.source
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class UsersPostPIServiceTest {

    private lateinit var service: UsersPostPIService
    private lateinit var server: MockWebServer

    @Before
    fun setUp() {
        server = MockWebServer()
        service = Retrofit.Builder()
            .baseUrl(server.url(""))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(UsersPostPIService::class.java)
    }

    private fun enqueueMockResponse(
      fileName:String
    ){
      val inputStream = javaClass.classLoader!!.getResourceAsStream(fileName)
      val source = inputStream.source().buffer()
      val mockResponse = MockResponse()
      mockResponse.setBody(source.readString(Charsets.UTF_8))
      server.enqueue(mockResponse)

    }

    @Test
    fun getUsers_sentRequest_receivedExpected(){
        runBlocking {
            enqueueMockResponse("userresponse.json")
            val responseBody = service.getUsers().body()
            val request = server.takeRequest()
            assertThat(responseBody).isNotNull()
            assertThat(request.path).isEqualTo("users")
        }
    }

    @Test
    fun getUsers_receivedResponse_correctPageSize(){
      runBlocking {
          enqueueMockResponse("userresponse.json")
          val responseBody = service.getUsers().body()
          val articlesList = responseBody!!.toList()
          assertThat(articlesList.size).isEqualTo(20)
      }
    }

    @Test
    fun getPosts_sentRequest_receivedExpected(){
        runBlocking {
            enqueueMockResponse("postsresponse.json")
            val responseBody = service.getUsers().body()
            val request = server.takeRequest()
            assertThat(responseBody).isNotNull()
            assertThat(request.path).isEqualTo("posts")
        }
    }

    @Test
    fun getPosts_receivedResponse_correctPageSize(){
        runBlocking {
            enqueueMockResponse("postsresponse.json")
            val responseBody = service.getUsers().body()
            val articlesList = responseBody!!.toList()
            assertThat(articlesList.size).isEqualTo(20)
        }
    }


    @After
    fun tearDown() {
       server.shutdown()
    }
}