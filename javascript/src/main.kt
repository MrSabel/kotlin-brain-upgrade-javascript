import org.w3c.dom.HTMLButtonElement
import org.w3c.dom.HTMLDivElement
import org.w3c.dom.HTMLInputElement
import org.w3c.dom.events.Event
import kotlin.browser.document
import kotlin.js.Date

fun main(args: Array<String>) {
    val message = "Hello JavaScript!"
    println(message)

    /*
    *  Interact with the DOM tree
    */
    val firstName = document.getElementById("firstName") as HTMLInputElement
    val lastName = document.getElementById("lastName") as HTMLInputElement
    val age = document.getElementById("age") as HTMLInputElement
    val submit = document.getElementById("submit") as HTMLButtonElement

    firstName.value = "John"
    lastName.value = "Doe"
    age.value = "50"

    submit.onclick = printUser(age, firstName, lastName)

    /*
    *  Javascript specific methods
    */
    val mousePosition = document.getElementById("mousePosition") as HTMLDivElement
    document.onmousemove = {
        val event = it.asDynamic() // val event: dynamic = it
        mousePosition.innerHTML = "x: ${event.clientX} <br> y: ${event.clientY}"

        it
    }
}

private fun printUser(age: HTMLInputElement, firstName: HTMLInputElement, lastName: dynamic): (Event) -> Unit {
    return {
        val year = age.value.toIntOrNull()?.let {
            // Javascript Date object
            val date = Date()
            // age.value is a String
            date.getFullYear() - age.value.toInt()
        } ?: "Unknown"

        // Printing to console
        println("${firstName.value} ${lastName.value} ($year)")
    }
}
