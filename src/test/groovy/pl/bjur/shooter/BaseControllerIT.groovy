package pl.bjur.shooter

import com.fasterxml.jackson.databind.ObjectMapper
import groovy.json.JsonSlurper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.context.WebApplicationContext
import spock.lang.Shared
import spock.lang.Specification

@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional
class BaseControllerIT extends Specification {

    @Autowired
    protected WebApplicationContext context

    @Shared
    protected MockMvc mvc

    @Shared
    protected def endpointUrl

    def setup() {
        mvc = MockMvcBuilders.webAppContextSetup(context).build()
    }

    static def fromJson(String content) {
        new JsonSlurper().parseText(content)
    }

    def perform(MockHttpServletRequestBuilder request) {
        mvc.perform(request)
    }

    def perform(MockHttpServletRequestBuilder requestBuilder, content) {
        perform(requestBuilder.contentType(MediaType.APPLICATION_JSON).content(asJsonString(content))).andReturn()
    }

    def random() {
        System.nanoTime() + Math.round(Math.random() * 10000)
    }

    def String asJsonString(final obj) {
        try {
            def mapper = new ObjectMapper()
            mapper.findAndRegisterModules()
            return mapper.writeValueAsString(obj)
        } catch (Exception e) {
            throw new RuntimeException(e)
        }
    }

    def getForDtos() {
        fromJson(perform(MockMvcRequestBuilders.get(endpointUrl), null).response.contentAsString)
    }

    def getForResponse(id) {
        perform(MockMvcRequestBuilders.get(byId(id)), null).response
    }

    def byId(id, url) {
        url + "/" + id
    }

    def byId(id) {
        byId(id, endpointUrl)
    }

    def getForDto(id) {
        fromJson(getForResponse(id).contentAsString)
    }

    def putForResponse(id, content) {
        perform(MockMvcRequestBuilders.put(byId(id)), content).response
    }

    def putForDto(id, content) {
        fromJson(putForResponse(id, content).contentAsString)
    }

    def postForResponse(content) {
        perform(MockMvcRequestBuilders.post(endpointUrl), content).response
    }

    def postForResponse(url, content) {
        perform(MockMvcRequestBuilders.post(url), content).response
    }

    def postForDto(content) {
        fromJson(postForResponse(content).contentAsString)
    }

    def postForDto(url, content) {
        fromJson(postForResponse(url, content).contentAsString)
    }

    def deleteOne(id) {
        perform(MockMvcRequestBuilders.delete(byId(id)), null).response
    }
}
