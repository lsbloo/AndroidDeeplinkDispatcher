package com.student.journalapp

import com.student.journalapp.main.data.model.GetAllDeepLinksResponse
import org.junit.Test

import org.junit.Assert.*
import kotlinx.serialization.json.Json
import kotlinx.serialization.decodeFromString


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        val jsonResponse = """
{
    "data": [
        {
            "deeplink": "student://journalapp/uol"
        },
        {
            "deeplink": "student://journalapp/globo"
        },
        {
            "deeplink": "student://journaapp/folhasp"
        }
    ]
}
"""

        val response = Json.decodeFromString<GetAllDeepLinksResponse>(jsonResponse)
        println(response)
    }
}