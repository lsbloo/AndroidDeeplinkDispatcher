package com.student.deeplinkdispatcher.deeplink

import com.google.devtools.ksp.processing.Dependencies
import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.processing.SymbolProcessor
import com.google.devtools.ksp.processing.SymbolProcessorEnvironment
import com.google.devtools.ksp.symbol.KSClassDeclaration
import com.google.devtools.ksp.symbol.KSAnnotated
import com.google.devtools.ksp.symbol.KSFunction
import com.google.devtools.ksp.symbol.KSFunctionDeclaration
import java.io.OutputStream
import kotlin.reflect.KClass

class DeepLinkProcessor(
    private val environment: SymbolProcessorEnvironment
) : SymbolProcessor {
    private var file: OutputStream? = null

    override fun process(resolver: Resolver): List<KSAnnotated> {
        val symbols = resolver.getSymbolsWithAnnotation(DeepLink::class.java.name)
        val mapToClass = mutableListOf<String>()
        val packagesList = mutableListOf<String>()

        // Gera o arquivo Kotlin com o mapeamento
        // Isso aqui é chamado de dynamic code generation (geração dinâmica de código)
        // aprende ai hatake :X
        symbols.forEach { symbol ->
            if (symbol is KSFunctionDeclaration) {
                val deepLinkAnnotation = symbol.annotations.find {
                    it.annotationType.resolve().declaration.qualifiedName?.asString() == DeepLink::class.qualifiedName
                }


                val url = deepLinkAnnotation?.arguments?.firstOrNull()?.value as? String
                val redirectClass =
                    deepLinkAnnotation?.arguments?.get(1)?.value

                val packAge = deepLinkAnnotation?.arguments?.get(2)?.value as? String
                packagesList.add("import ${packAge}.${redirectClass}")
                mapToClass.add("\"$url\" to ${redirectClass}::class,")
            }
        }
        val fileContent2 = buildString {
            appendLine("import com.student.journalapp.JournalAppDeepLinkHandler")
            packagesList.forEach { p -> appendLine(p) }
            appendLine("import kotlin.reflect.KClass")
            appendLine("object DeepLinkMapping {")
            appendLine("    val urlToClass = mapOf(")
            mapToClass.forEach { d -> appendLine(d) }
            appendLine("    )")
            appendLine(
                "fun getDeepLinkClass(url: String): KClass<*>? {" +
                        "return urlToClass[url]" + "}"
            )
            appendLine("}")
        }
        createFileAndWrite(fileContent2)
        return symbols.toList()
    }

    private fun createFileAndWrite(fileContent: String) {
        if (environment.codeGenerator.generatedFile.isEmpty()) {
            try {
                file = environment.codeGenerator.createNewFile(
                    packageName = "com.student.deeplinkdispatcher.deeplink",
                    fileName = "DeepLinkMapping",
                    extensionName = "kt",
                    dependencies = Dependencies(true)
                )
                file?.write(fileContent.toByteArray())
            } catch (e: FileAlreadyExistsException) {
                e.printStackTrace()
            }
        } else {
            file?.write(fileContent.toByteArray())
        }
    }
}