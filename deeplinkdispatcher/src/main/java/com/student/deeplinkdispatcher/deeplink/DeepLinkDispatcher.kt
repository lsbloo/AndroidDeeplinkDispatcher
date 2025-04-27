package com.student.deeplinkdispatcher.deeplink


/**
object DeepLinkDispatcher {

fun dispatch(context: Context, deepLink: String) {
// Usar o mapeamento gerado para encontrar a classe correspondente
val targetClass = DeepLinkMapping.urlToClass[deepLink]

if (targetClass != null) {
val intent = Intent(context, targetClass)
context.startActivity(intent)
} else {

println("Deeplink não encontrado")
}
}
}

object DeepLinkMapping {
val urlToClass = mapOf()
}
 **/