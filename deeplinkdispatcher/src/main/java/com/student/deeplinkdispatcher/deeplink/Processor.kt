package com.student.deeplinkdispatcher.deeplink

import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.processing.SymbolProcessor
import com.google.devtools.ksp.processing.SymbolProcessorEnvironment
import com.google.devtools.ksp.symbol.KSClassDeclaration
import com.google.devtools.ksp.symbol.KSAnnotated

class DeepLinkProcessor(
    private val environment: SymbolProcessorEnvironment
) : SymbolProcessor {
    override fun process(resolver: Resolver): List<KSAnnotated> {
        val symbols = resolver.getSymbolsWithAnnotation(DeepLink::class.java.name)

        symbols.forEach { symbol ->
            if (symbol is KSClassDeclaration) {
                val deepLinkAnnotation = symbol.annotations.find {
                    it.annotationType.resolve().toString() == DeepLink::class.java.name
                }
                val url = deepLinkAnnotation?.arguments?.firstOrNull()?.value as? String
                if (url != null) {
                    generateMapping(url, symbol.simpleName.asString())
                }
            }
        }
        return symbols.toList()
    }

    private fun generateMapping(url: String, className: String) {
        environment.codeGenerator.generatedFile.forEach {
            it.appendText(
                """
            object DeepLinkMapping {
                val urlToClass = mapOf(
                    "$url" to $className::class.java
                )
            }
        """.trimIndent()
            )
        }
    }
}