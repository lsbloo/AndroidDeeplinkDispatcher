package com.student.deeplinkdispatcher.deeplink

import com.google.auto.service.AutoService
import com.google.devtools.ksp.processing.Dependencies
import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.processing.SymbolProcessor
import com.google.devtools.ksp.processing.SymbolProcessorEnvironment
import com.google.devtools.ksp.symbol.KSClassDeclaration
import com.google.devtools.ksp.symbol.KSAnnotated

@AutoService(SymbolProcessor::class)
class DeepLinkProcessor(
    private val environment: SymbolProcessorEnvironment
) : SymbolProcessor {
    override fun process(resolver: Resolver): List<KSAnnotated> {
        val symbols = resolver.getSymbolsWithAnnotation(DeepLink::class.java.name)
        val deepLinkMappings = mutableListOf<String>()
        symbols.forEach { symbol ->
            if (symbol is KSClassDeclaration) {
                val deepLinkAnnotation = symbol.annotations.find {
                    it.annotationType.resolve().toString() == DeepLink::class.java.name
                }
                val url = deepLinkAnnotation?.arguments?.firstOrNull()?.value as? String
                deepLinkMappings.add("$url -> ${symbol.simpleName.asString()}")
                if (url != null) {
                    generateMapping(url, symbol.simpleName.asString())
                }
            }

            if (deepLinkMappings.isNotEmpty()) {
                // Gerar o arquivo Kotlin com o mapeamento
                val fileContent = buildString {
                    appendLine("object DeepLinkMapping {")
                    appendLine("    val urlToClass = mapOf(")
                    deepLinkMappings.forEach {
                        appendLine("        \"$it\",")
                    }
                    appendLine("    )")
                    appendLine("}")
                }

                val generatedFile = environment.codeGenerator.createNewFile(
                    packageName = "com.student.deeplinkdispatcher.deeplink",
                    fileName = "DeepLinkMapping",
                    extensionName = "kt",
                    dependencies = Dependencies(true)
                )
                generatedFile.write(fileContent.toByteArray())
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